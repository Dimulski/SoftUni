package app.service;

import app.domain.dtos.UserJsonDto;
import app.domain.models.Product;
import app.domain.models.User;
import app.domain.queryDtos.ProductBuyerNamesDto;
import app.domain.queryDtos.SellerProductsDto;
import app.repositories.UserRepository;
import app.service.contracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void create(UserJsonDto userJsonDto) {
        User user = this.convertToEntity(userJsonDto);
        this.userRepository.saveAndFlush(user);
    }

    @Override
    public UserJsonDto findById(long id) {
        User user = this.userRepository.findOne(id);
        UserJsonDto userJsonDto = this.convertToDto(user);
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

    private UserJsonDto convertToDto(User user) {
        UserJsonDto userJsonDto = new UserJsonDto();
        userJsonDto.setFirstName(user.getFirstName());
        userJsonDto.setLastName(user.getLastName());
        userJsonDto.setAge(user.getAge());

        return userJsonDto;
    }

    private User convertToEntity(UserJsonDto userJsonDto) {
        User user = new User();
        user.setFirstName(userJsonDto.getFirstName());
        user.setLastName(userJsonDto.getLastName());
        user.setAge(userJsonDto.getAge());

        return user;
    }
}
