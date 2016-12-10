package app.service;

import app.domain.dtos.ProductDto;
import app.domain.dtos.UserDto;
import app.domain.models.Product;
import app.domain.models.User;
import app.domain.queryDtos.ProductBuyerNamesDto;
import app.domain.queryDtos.SellerProductsDto;
import app.domain.queryDtos.UsersProductsDto;
import app.repositories.UserRepository;
import app.service.contracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void create(UserDto userJsonDto) {
        User user = this.convertToEntity(userJsonDto);
        this.userRepository.saveAndFlush(user);
    }

    @Override
    public UserDto findById(long id) {
        User user = this.userRepository.findOne(id);
        UserDto userJsonDto = this.convertToDto(user);
        return userJsonDto;
    }

    @Override
    public List<SellerProductsDto> findUsersWithSoldItemAndBuyer() {
        List<SellerProductsDto> validSellerProductDtos = new ArrayList<>();
        List<User> users = this.userRepository.findUsersWithAtLeastOneSellItem();
        for (User user : users) {
            SellerProductsDto sellerProductsDto = new SellerProductsDto();
            sellerProductsDto.setFirstName(user.getFirstName());
            sellerProductsDto.setLastName(user.getLastName());

            for (Product product : user.getSellProducts()) {
                if (product.getBuyer() != null) {
                    ProductBuyerNamesDto productBuyerNamesDto = new ProductBuyerNamesDto();
                    productBuyerNamesDto.setName(product.getName());
                    productBuyerNamesDto.setPrice(product.getPrice());
                    productBuyerNamesDto.setBuyerFirstName(product.getBuyer().getFirstName());
                    productBuyerNamesDto.setBuyerLastName(product.getBuyer().getLastName());
                    sellerProductsDto.getSoldProducts().add(productBuyerNamesDto);
                }
            }

            if (sellerProductsDto.getSoldProducts().size() >= 1) {
                validSellerProductDtos.add(sellerProductsDto);
            }
        }

        return validSellerProductDtos;
    }

    @Override
    public UsersProductsDto getUsersProducts() { // automap needed
        UsersProductsDto usersProductsDto = new UsersProductsDto();
        Set<UserDto> users = new HashSet<>();
        List<Object[]> usersProducts = this.userRepository.findUsersProducts();
        usersProductsDto.setUsersCount(usersProducts.size());
        for (Object[] userProducts : usersProducts) {
            UserDto userJsonDto = new UserDto();
            userJsonDto.setFirstName((String) userProducts[0]);
            userJsonDto.setLastName((String) userProducts[1]);
            userJsonDto.setAge((Integer) userProducts[2]);
            User user = (User) userProducts[3];
            Set<Product> products = user.getSellProducts();
            Set<ProductDto> productJsonDtos = new HashSet<>();
            for (Product product : products) {
                ProductDto productJsonDto = new ProductDto();
                productJsonDto.setName(product.getName());
                productJsonDto.setPrice(product.getPrice());
                productJsonDtos.add(productJsonDto);
            }
            userJsonDto.setSellProducts(productJsonDtos);
            users.add(userJsonDto);
        }
        usersProductsDto.setUsers(users);

        return usersProductsDto;
    }

    private UserDto convertToDto(User user) {
        UserDto userJsonDto = new UserDto();
        userJsonDto.setFirstName(user.getFirstName());
        userJsonDto.setLastName(user.getLastName());
        userJsonDto.setAge(user.getAge());

        return userJsonDto;
    }

    private User convertToEntity(UserDto userJsonDto) {
        User user = new User();
        user.setFirstName(userJsonDto.getFirstName());
        user.setLastName(userJsonDto.getLastName());
        user.setAge(userJsonDto.getAge());

        return user;
    }
}
