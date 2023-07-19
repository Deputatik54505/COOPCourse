package org.example.database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Query implements IQuery{
    private final IConnector connector;
    public Query(){
        connector = new Connector();
    }
    public Query(IConnector connector){
        this.connector = connector;
    }
    public ResultSet executeQuery(String query) {
        var dataSource = connector.dataSource();
        ResultSet resultSet;
        try (var connection = dataSource.getConnection();
             var useStatement = connection.prepareStatement("use crm;");
             var queryStatement = connection.prepareStatement(query)) {

            useStatement.execute();
            resultSet = queryStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultSet;
    }
}
