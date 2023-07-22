package org.example.forms.sign;

import org.example.database.Query;
import org.example.entities.user.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SignVerification {
    private final Query query;
    private User user;

    public SignVerification() {
        query = new Query();
    }

    public void verifyUser(String email, String password) {

        try (ResultSet resultSet = query.executeQuery(
                String.format("Select password from \"userTable\" where email='%s'", email))) {
            if (resultSet.next()) {
                if (!password.equals(resultSet.getString("password"))) {
                    throw new IllegalArgumentException("password and email does not matches");
                }
            } else {
                throw new IllegalArgumentException("no user with such email in db");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        this.user = this.users.findUser(email);
//        this.user.isEqual(password);
    }
}
