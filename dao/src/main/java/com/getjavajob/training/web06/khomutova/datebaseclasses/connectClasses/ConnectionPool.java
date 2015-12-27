package com.getjavajob.training.web06.khomutova.datebaseclasses.connectClasses;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConnectionPool {

    public static final ConnectionPool POOL = new ConnectionPool();
    private static final int CONNECTIONS_SIZE = 10;
    private static final int IZOLATION_LEVEL = Connection.TRANSACTION_READ_COMMITTED;
    private static boolean autocommit;
    private static String uri;
    private static String user;
    private static String password;
    private BlockingQueue<Connection> pool = new LinkedBlockingQueue<>();
    private ThreadLocal<ConnectionHolder> connectionHolders = new ThreadLocal<ConnectionHolder>() {
        protected ConnectionHolder initialValue() {
            return new ConnectionHolder();
        }
    };


    public ConnectionPool() {
        Properties properties = new Properties();
        try {
            properties.load(ConnectionPool.class.getClassLoader().getResourceAsStream("phonebook.properties"));
            uri = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            autocommit = Boolean.parseBoolean(properties.getProperty("autocommit"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < CONNECTIONS_SIZE; i++) {
            pool.add(makeConnection());
        }
    }

    public Connection getConnection() {
        ConnectionHolder connectionHolder = connectionHolders.get();
        if (connectionHolder.getConnection() == null) {
            try {
                connectionHolder.setConnection(pool.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return connectionHolder.incremAndGet();
    }

    private Connection makeConnection() {
        Connection connection = null;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            connection = DriverManager.getConnection(uri, user, password);
            connection.setAutoCommit(autocommit);
            connection.setTransactionIsolation(IZOLATION_LEVEL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (connection == null) {
            throw new NullPointerException();
        }
        return connection;
    }

    public void release() {
        ConnectionHolder connectionHolder = connectionHolders.get();
        connectionHolder.release();
        if (connectionHolder.getEqualsRelease()) {
            pool.add(connectionHolder.getConnection());
            connectionHolder.setConnection(null);
        }
    }
}