package app.service.contracts;

import app.domain.dtos.UserDto;
import app.domain.queryDtos.SellerProductsDto;
import app.domain.queryDtos.UsersProductsDto;

import java.util.List;

public interface UserService {

    void create(UserDto userJsonDto);

    UserDto findById(long id);

    List<SellerProductsDto> findUsersWithSoldItemAndBuyer();

    UsersProductsDto getUsersProducts();
}
