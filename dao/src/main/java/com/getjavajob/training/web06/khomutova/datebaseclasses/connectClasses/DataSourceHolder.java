package com.getjavajob.training.web06.khomutova.datebaseclasses.connectClasses;

import javax.sql.DataSource;

public class DataSourceHolder {

    private static DataSource dataSource;

    public static DataSource getDataSource() {
        return dataSource;
    }

    public static void setDataSource(DataSource dataSource) {
        DataSourceHolder.dataSource = dataSource;
    }
}
