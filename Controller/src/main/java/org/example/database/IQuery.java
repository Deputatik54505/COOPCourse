package org.example.database;

import java.sql.ResultSet;

public interface IQuery {
    ResultSet executeQuery(String query);

    void executeWithoutResponse(String format);
}
