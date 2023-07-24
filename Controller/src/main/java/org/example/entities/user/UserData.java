package org.example.entities.user;

import org.example.database.IQuery;
import org.example.database.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserData {
    private final IQuery query;
    private int id;
    private String email;

    public UserData() {
        this.query = new Query();
    }

    public void load(String email) {
        try (var resultSet = query.executeQuery(
                String.format("select id from \"userTable\" where email='%s'; ", email))) {
            if (resultSet.next())
                id = resultSet.getInt("id");
            else
                throw new RuntimeException("user was not register");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.email = email;
    }

    /**
     * Method for representing essential information about user
     *
     * @return list with 3 strings.
     * At index 0 firstname
     * At index 1 surname
     * At index 2 birthdate
     */
    public List<String> represent() {
        try (var resultSet = query.executeQuery(
                String.format("Select * from \"account\" where userId=%d", id))) {
            ArrayList<String> data = new ArrayList<>();
            if (resultSet.next()) {
                data.add(resultSet.getString("firstname"));
                data.add(resultSet.getString("surname"));
                data.add(resultSet.getDate("birthdate").toString());
            }
            return data;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String email() {
        return email;
    }
}
