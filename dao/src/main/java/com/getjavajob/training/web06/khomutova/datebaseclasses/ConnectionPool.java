package com.getjavajob.training.web06.khomutova.datebaseclasses;


import org.apache.commons.dbcp2.*;
import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionPool {

    private static Connection connection;

    static {
        try {
            Properties properties = new Properties();
            properties.load(ConnectionPool.class.getClassLoader().getResourceAsStream("phonebook.properties"));
            String uri = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            String driver = properties.getProperty("driver");
            Class.forName(driver);
            ConnectionFactory connectionFactory = getConnectionFactory(uri, user, password);
            PoolableConnectionFactory poolFactory = new PoolableConnectionFactory(connectionFactory, null);
            ObjectPool<PoolableConnection> connectionPool = new GenericObjectPool<>(poolFactory);
            poolFactory.setPool(connectionPool);
            PoolingDriver dbcpDriver = getDBCPDriver();
            dbcpDriver.registerPool("shop_connection", connectionPool);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    private static ConnectionFactory getConnectionFactory(String uri, String user, String password) {
        return new DriverManagerConnectionFactory(
                uri, user, password);
    }

    private static PoolingDriver getDBCPDriver() {
        PoolingDriver driver = null;
        try {
            Class.forName("org.apache.commons.dbcp2.PoolingDriver");
            driver = (PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return driver;
    }

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:apache:commons:dbcp:shop_connection");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void releaseConnection(Connection con) {
        Utils.closeQuietly(con);
    }
}