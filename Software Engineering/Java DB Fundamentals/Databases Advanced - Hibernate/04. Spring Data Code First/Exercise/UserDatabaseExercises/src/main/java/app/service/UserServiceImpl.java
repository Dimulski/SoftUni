package app.service;

import app.domain.User;
import app.repositories.UserRepository;
import app.service.contracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void create(User user) {
        this.userRepository.saveAndFlush(user);
    }

    @Override
    public List<User> getUsersByEmailProvider(String emailProvider) {
        List<User> users = this.userRepository.findAll();
        List<User> results = new LinkedList<>();
        for (User user : users) {
            String email = user.getEmail();
            String ep = email.substring(email.indexOf("@") + 1);
            if (ep.equals(emailProvider)) {
                results.add(user);
            }
        }

        return results;
    }

    @Override
    public void setDeletedTrueIfInactive(Date date) {
        List<User> inactive = this.userRepository.findByLastTimeLoggedInAfter(date);
        for (User user : inactive) {
            user.setIsDeleted(true);
        }
    }

    @Override
    public int deleteMarkedUsers() {
        return this.userRepository.removeByDeletedTrue();
    }

    public int getCountOfPicturesWithWidthAbove(int width) throws IOException {
        List<User> users = this.userRepository.findAll();
        int count = 0;
        for (User user : users) {
            int picWidth = getPictureWidth(user);
            count = picWidth > width ? count + 1 : count;
        }

        return count;
    }

    private int getPictureWidth(User user) throws IOException {
        byte[] currentPic = user.getProfilePicture();
        InputStream in = new ByteArrayInputStream(currentPic);
        BufferedImage buf = ImageIO.read(in);
        return buf.getWidth();
    }
}
