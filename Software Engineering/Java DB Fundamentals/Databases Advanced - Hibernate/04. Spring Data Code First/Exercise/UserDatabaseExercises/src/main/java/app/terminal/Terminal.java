package app.terminal;

import app.domain.User;
import app.service.contracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;

@Component
public class Terminal implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Override
    public void run(String... strings) throws Exception {

        User pesho = new User();
        pesho.setUserName("pesho");
        pesho.setPassword("Fxp2JLfR#");
        pesho.setEmail("pesho@abv.bg");
        File picture = new File("res/smallPicture.jpg");
        byte[] smallPictureByes = new byte[(int) picture.length()];
        FileInputStream fis = new FileInputStream(picture);
        fis.read(smallPictureByes);
        pesho.setProfilePicture(smallPictureByes);
        pesho.setRegisteredOn(new Date());
        pesho.setLastTimeLoggedIn(new Date());
        pesho.setAge(19);
        pesho.setIsDeleted(false);
        userService.createUser(pesho);

        // Throws exceptions for password and profile picture as expected
        User gosho = new User();
        gosho.setUserName("gosho");
        gosho.setPassword("kxG76YdM");
        gosho.setEmail("gosho@gmail.com");
        picture = new File("res/bigPicture.jpg");
        byte[] bigPictureBytes = new byte[(int) picture.length()];
        fis = new FileInputStream(picture);
        fis.read(bigPictureBytes);
        fis.close();
        gosho.setProfilePicture(bigPictureBytes);
        gosho.setRegisteredOn(new Date());
        gosho.setLastTimeLoggedIn(new Date());
        gosho.setAge(20);
        gosho.setIsDeleted(false);
        userService.createUser(gosho);
    }
}
