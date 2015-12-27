package com.getjavajob.training.web06.khomutova.datebaseclasses.connectClasses;

import java.sql.Connection;

public class ConnectionHolder {
    private Connection connection;
    private int getCounter;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Connection incremAndGet() {
        getCounter++;
        return connection;
    }

    public void release() {
        getCounter--;
    }

    public boolean getEqualsRelease() {
        return getCounter == 0;
    }
}
