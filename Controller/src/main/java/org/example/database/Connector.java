package org.example.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import org.postgresql.ds.PGPoolingDataSource;
import org.postgresql.ds.PGSimpleDataSource;

public class Connector implements IConnector {

    private DataSource ds;

    public DataSource dataSource() {
        if (this.ds == null) {
//            var properties = new Properties();
//            properties.setProperty("dataSourceClassName","org.postgresql.ds.PGPoolingDataSource");
//            properties.setProperty("dataSource.user", "postgres");
//            properties.setProperty("dataSource.password", "vJGj9uL2$d{wNc$");
//            properties.setProperty("dataSource.databaseName", "crm");

//            var config = new HikariConfig(properties);
//            config.setJdbcUrl("jdbc:postgresql://db.wfbsubesqynyfvpisvtv.supabase.co:5432/crm");
//            config.setPassword("vJGj9uL2$d{wNc$");
//            config.setUsername("postgres");
//            this.ds = new HikariDataSource(config);


            var ds = new PGSimpleDataSource();
            ds.setServerName("db.wfbsubesqynyfvpisvtv.supabase.co:5432");
            ds.setDatabaseName("crm");
            ds.setUser("postgres");
            ds.setPassword("vJGj9uL2$d{wNc$");
        }
        return ds;
    }
}
