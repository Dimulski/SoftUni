package javache.repositories;

import java.io.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import javache.User;

import static javache.WebConstants.DB_FILE;

public class UserRepositoryImpl implements UserRepository<User> {

    @Override
    public User getById(String id) {
        Optional<User> first = this.getAll().stream().filter(u -> u.getId().equals(id)).findFirst();
        if (first.isPresent()) {
            return first.get();
        }
        return null;
    }

    @Override
    public void add(User user) {
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            String line = user.getId() + "|" + user.getName() + "|" + user.getPassword() + "\r\n";
            File database = new File(DB_FILE);
            fw = new FileWriter(database.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            bw.write(line);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public Set<User> getAll() {
        Scanner scanner;
        Set<User> allUsers = new HashSet<>();
        try {
            scanner = new Scanner(new File(DB_FILE));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] userData = line.split("\\|");
                allUsers.add(new User(userData[0], userData[1], userData[2]));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return allUsers;
    }

    @Override
    public boolean exists(User user) {
        return this.findByEmail(user.getName()) != null;
    }

    @Override
    public User findByEmail(String email) {
        Optional<User> first = this.getAll().stream().filter(u -> u.getName().equals(email)).findFirst();
        return first.orElse(null);
    }
}
