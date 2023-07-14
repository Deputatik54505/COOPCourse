package org.example.database;

import javax.sql.DataSource;

public interface IConnector {
    DataSource dataSource();
}
