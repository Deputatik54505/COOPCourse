package org.example.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.util.Properties;

public class Connector implements IConnector{

    private DataSource ds;
    public DataSource dataSource() {
        if (this.ds == null) {
            Properties props = new Properties();
            props.setProperty("dataSourceClassName", "org.postgresql.ds.PGSimpleDataSource");
            props.setProperty("dataSource.user", "postgres");
            props.setProperty("dataSource.password", "vJGj9uL2$d{wNc$");


            HikariConfig config = new HikariConfig(props);
            config.setJdbcUrl("jdbc:postgresql://db.wfbsubesqynyfvpisvtv.supabase.co:5432/crm");
            this.ds = new HikariDataSource(config);

        }
        return ds;
    }
}
