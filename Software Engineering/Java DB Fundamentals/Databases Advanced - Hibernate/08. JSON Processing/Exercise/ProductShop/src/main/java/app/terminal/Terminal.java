package app.terminal;

import app.domain.dtos.CategoryJsonDto;
import app.domain.dtos.ProductJsonDto;
import app.domain.dtos.UserJsonDto;
import app.domain.queryDtos.CategoryStatsDto;
import app.domain.queryDtos.ProductSellerDto;
import app.domain.queryDtos.SellerProductsDto;
import app.domain.queryDtos.UsersProductsDto;
import app.io.JSONParser;
import app.service.contracts.CategoryService;
import app.service.contracts.ProductService;
import app.service.contracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Terminal implements CommandLineRunner {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @Autowired
    private JSONParser jsonParser;

    @Override
    public void run(String... strings) throws Exception {
//        this.importCategories();
//        this.importUsers();
//        this.importProducts();
//        this.exportProductsInRange();
//        this.exportUsersWithSoldItemAndBuyer();
//        this.exportCategoryStats();
        this.exportUsersProducts();
    }

    private void exportUsersProducts() {
        UsersProductsDto usersProductsDtos = this.userService.getUsersProducts();
        try {
            this.jsonParser.write(usersProductsDtos,
                    "src/main/resources/files/output/json/users-and-products.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void exportCategoryStats() {
        List<CategoryStatsDto> categoryStatsDtos = this.categoryService.getCategoryStats();
        try {
            this.jsonParser.write(categoryStatsDtos,
                    "src/main/resources/files/output/json/categories-by-products.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void exportUsersWithSoldItemAndBuyer() {
        List<SellerProductsDto> usersWithSoldItemAndBuyer = this.userService.findUsersWithSoldItemAndBuyer();
        try {
            this.jsonParser.write(usersWithSoldItemAndBuyer,
                    "src/main/resources/files/output/json/users-sold-products.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void exportProductsInRange() {
        List<ProductSellerDto> productsInRange = this.productService.getProductsInRangeWithoutBuyer();
        try {
            this.jsonParser.write(productsInRange, "src/main/resources/files/output/json/products-in-range.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void importCategories() {
        try {
            CategoryJsonDto[] categoryJsonDtos = this.jsonParser
                    .read(CategoryJsonDto[].class, "/files/input/json/categories.json");
            for (CategoryJsonDto categoryJsonDto : categoryJsonDtos) {
                this.categoryService.create(categoryJsonDto);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void importProducts() {
        try {
            ProductJsonDto[] productJsonDtos = this.jsonParser
                    .read(ProductJsonDto[].class, "/files/input/json/products.json");
            for (ProductJsonDto productJsonDto : productJsonDtos) {
                this.productService.create(productJsonDto);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void importUsers() {
        try {
            UserJsonDto[] userJsonDtos = this.jsonParser
                    .read(UserJsonDto[].class, "/files/input/json/users.json");
            for (UserJsonDto userJsonDto : userJsonDtos) {
                this.userService.create(userJsonDto);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
