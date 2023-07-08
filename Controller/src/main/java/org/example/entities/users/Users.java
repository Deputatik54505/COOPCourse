package org.example.entities.users;

import org.example.entities.user.User;
import org.example.validation.exceptions.NotFoundException;

import java.util.ArrayList;

public class Users {
    ArrayList<User> list;
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
        for (int i = 0; i < this.list.size(); i++) {
            if (this.list.get(i).isFind(mail)) {
                return this.list.get(i);
            }
        }
        throw new NotFoundException();
    }
}
