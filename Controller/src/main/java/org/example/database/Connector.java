package org.example.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.example.utils.PropertiesUtils;

import javax.sql.DataSource;

public class Connector implements IConnector{
    private DataSource ds;
    public DataSource dataSource() {
        if (this.ds == null) {
            var config = new HikariConfig();
            var properties = new PropertiesUtils();
            config.setUsername(properties.getUsername());
            config.setPassword(properties.getPassword());
            config.setJdbcUrl(properties.getUrl());
            this.ds = new HikariDataSource(config);
        }
        return ds;
    }
}
