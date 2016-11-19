package app.terminal;

import app.domain.User;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.List;

@Component
public class Terminal implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Override
    public void run(String... strings) throws Exception {
        User user = new User();
        user.setUserName("gosho");
        user.setEmail("gosho@abv.bg");
        user.setPassword("Aa#242dsa34");
        user.setRegisteredOn(new Date());
        user.setLastTimeLoggedIn(new Date());
        user.setIsDeleted(false);
        user.setAge(22);

        File picture = new File("res/smallpic.jpg");
        byte[] pictureBytes = new byte[(int) picture.length()];
        FileInputStream fis = new FileInputStream(picture);
        fis.read(pictureBytes);
        fis.close();
        user.setProfilePicture(pictureBytes);

        user.setIsDeleted(true);
        userService.createUser(user);

        List<User> users = userService.findUsersByEmail("gosho@abv.bg");
        for (User u : users) {
            System.out.println(u.getEmail());
        }

        int count = userService.countOfBigPictures(new byte[100]);
        System.out.println(count);
    }
}
