package org.example.database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Query implements IQuery {
    private final IConnector connector;

    public Query() {
        connector = new Connector();
    }

    public Query(IConnector connector) {
        this.connector = connector;
    }

    public ResultSet executeQuery(String query) {
        var dataSource = connector.dataSource();
        ResultSet resultSet;
        try (var connection =  DriverManager.getConnection(
                "jdbc:postgresql://db.wfbsubesqynyfvpisvtv.supabase.co:5432/crm", "postgres", "vJGj9uL2$d{wNc$");) {
            var queryStatement = connection.prepareStatement(query);
            resultSet = queryStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultSet;
    }
}
