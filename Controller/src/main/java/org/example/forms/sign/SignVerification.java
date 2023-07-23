package org.example.forms.sign;

import org.example.database.Query;
import org.example.entities.user.User;
import org.example.validation.exceptions.UnequalPasswordExc;
import org.example.validation.exceptions.UserNotFoundExc;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SignVerification {
    private final Query query;
    private User user;

    public SignVerification() {
        query = new Query();
    }

    public void verifyUser(String email, String password) throws SQLException, UnequalPasswordExc, UserNotFoundExc {

        try (ResultSet resultSet = query.executeQuery(
                String.format("Select password from \"userTable\" where email='%s'", email))) {
            if (resultSet.next()) {
                if (!password.equals(resultSet.getString("password"))) {
                    throw new UnequalPasswordExc();
                }
            } else {
                throw new UserNotFoundExc();
            }
        } catch (SQLException | UserNotFoundExc | UnequalPasswordExc e) {
            throw e;
        }
    }
}
