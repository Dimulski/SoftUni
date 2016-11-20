package app.service.contracts;

import app.domain.User;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public interface UserService {

    void create(User user);

    List<User> getUsersByEmailProvider(String emailProvider);

    int getCountOfPicturesWithWidthAbove(int width) throws IOException;

    void setDeletedTrueIfInactive(Date date);

    int deleteMarkedUsers();
}
