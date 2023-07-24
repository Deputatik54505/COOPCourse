package org.example.forms.sign;

import org.example.database.Query;
import org.example.validation.exceptions.UnequalPasswordExc;
import org.example.validation.exceptions.UserNotFoundExc;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SignVerification {
    private final Query query;

    public SignVerification() {
        query = new Query();
    }

    public void verifyUser(String email, String password) throws UnequalPasswordExc, UserNotFoundExc {

        try (ResultSet resultSet = query.executeQuery(
                String.format("Select password from \"userTable\" where email='%s'", email))) {
            if (resultSet.next()) {
                if (!password.equals(resultSet.getString(1))) {
                    throw new UnequalPasswordExc();
                }
            } else {
                throw new UserNotFoundExc();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
