package app.service.contracts;

import app.domain.dtos.UserJsonDto;
import app.domain.queryDtos.SellerProductsDto;
import app.domain.queryDtos.UsersProductsDto;

import java.util.List;

public interface UserService {

    void create(UserJsonDto userJsonDto);

    UserJsonDto findById(long id);

    List<SellerProductsDto> findUsersWithSoldItemAndBuyer();

    UsersProductsDto getUsersProducts();
}
