package org.example.tables;

import org.example.entities.user.User;
import org.example.validation.exceptions.NotFoundException;

import java.util.ArrayList;

public class Users {
    private final ArrayList<User> list;
    public Users() {
        this.list = new ArrayList<>();
    }
    public void addUser(User user) {
        this.list.add(user);
    }
    public void removeUser(User user) {
        this.list.remove(user);
    }
    public User findUser(String mail) throws Exception {
        for (User user : this.list) {
            if (user.isFind(mail)) {
                return user;
            }
        }
        throw new NotFoundException();
    }
}
