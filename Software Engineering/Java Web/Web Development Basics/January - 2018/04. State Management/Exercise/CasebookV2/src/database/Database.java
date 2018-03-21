package database;

import io.Reader;
import models.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import static utils.WebConstants.PROJECT_DIR;

public class Database {

    private static String DATABASE_FILE_PATH = PROJECT_DIR + "/src/database/database.text";

    public static void save(User user) {
        try {
            Files.write(Paths.get(DATABASE_FILE_PATH),
                    (user.toString() + System.lineSeparator()).getBytes(),
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static User find(String email) {
        try {
            String data = Reader.readAllLines(new FileInputStream(DATABASE_FILE_PATH));
            String[] lines = data.split(System.lineSeparator());
            for (String line : lines) {
                String[] userInfo = line.split("\\|");
                if (userInfo[2].equals(email)) {
                    return new User(userInfo[0], userInfo[1], userInfo[2], userInfo[3]);
                }
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static User find(String username, String password) {
        try {
            String data = Reader.readAllLines(new FileInputStream(DATABASE_FILE_PATH));
            String[] lines = data.split("\n");
            for (String line : lines) {
                String[] userInfo = line.split("\\|");
                if (userInfo[1].equals(username) && userInfo[2].equals(password)) {
                    return new User(userInfo[0], userInfo[1], userInfo[2], userInfo[3]);
                }
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static User find(String id, boolean full) {
        try {
            String data = Reader.readAllLines(new FileInputStream(DATABASE_FILE_PATH));
            String[] lines = data.split("\n");
            for (String line : lines) {
                String[] userInfo = line.split("\\|");
                if (userInfo[0].equals(id)) {
                    return new User(userInfo[0], userInfo[1], userInfo[2], userInfo[3]);
                }
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<String> getOtherUsers(String currentUserId) {
        try {
            List<String> usernames = new ArrayList<>();
            String data = Reader.readAllLines(new FileInputStream(DATABASE_FILE_PATH));
            String[] lines = data.split("\n");
            for (String line : lines) {
                String[] userInfo = line.split("\\|");
                if (!userInfo[0].equals(currentUserId)) {
                    usernames.add(userInfo[1]);
                }
            }
            return usernames;
        } catch (IOException e) {
            e.printStackTrace();
            return null; // #
        }
    }
}
