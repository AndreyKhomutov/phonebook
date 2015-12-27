package com.getjavajob.training.web06.khomutova.datebaseclasses.daoClasses;

import com.getjavajob.training.web06.khomutova.datebaseclasses.connectClasses.ConnectionPool;
import com.getjavajob.training.web06.khomutova.phonebookclasses.BaseEntity;
import com.getjavajob.training.web06.khomutova.phonebookclasses.EntityType;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class GenericDao<T extends BaseEntity> implements CrudDao<T> {

    protected abstract String getTableName();

    protected abstract String getInsertStatement();

    protected abstract String getUpdateByIdStatement();

    protected abstract T createInstanceFromResult(ResultSet resultSet) throws SQLException;

    @Override
    public void add(T entity) {
        Connection connection = ConnectionPool.POOL.getConnection();
        Class<?> clazz = entity.getClass();
        Field[] fields = clazz.getDeclaredFields();
        try (PreparedStatement prepareStatement = connection.prepareStatement(getInsertStatement())) {
            for (int i = 0; i < fields.length; i++) {
                Method getMethod = null;
                Object fieldValue;
                try {
                    getMethod = clazz.getMethod("get" + capitalizeFirstLetter(fields[i].getName()));
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
                Object newValue = null;
                try {
                    if (getMethod != null) {
                        fieldValue = getMethod.invoke(entity);
                        if (!fields[i].getType().isPrimitive() && !(fields[i].getType() == String.class)
                                && !(fields[i].getType().isEnum()) && !(fields[i].getType() == Date.class) && !(fields[i].getType() == ArrayList.class)) {
                            newValue = ((BaseEntity) fieldValue).getId();
                        } else if (fields[i].getType().isEnum()) {
                            newValue = ((java.lang.Enum) fieldValue).ordinal() + 1;
                        } else if (fields[i].getType() == ArrayList.class) {
                            int lenght = ((ArrayList) fieldValue).size();
                            StringBuilder stringBuilder = new StringBuilder();
                            for (int j = 0; j < lenght; j++) {
                                stringBuilder.append(((ArrayList<T>) fieldValue).get(j).getId() + " ");
                            }
                            newValue = stringBuilder.toString();
                        } else {
                            newValue = fieldValue;
                        }
                    }
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
                prepareStatement.setObject(i + 1, newValue);
            }
            prepareStatement.executeUpdate();
            connection.setAutoCommit(false);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        ConnectionPool.POOL.release();
        entity.setId(getMaxId());
    }

    @Override
    public void update(T entity) {
        int id = entity.getId();
        Class<?> clazz = entity.getClass();
        Field[] fields = clazz.getDeclaredFields();
        List<Object> values = new ArrayList<>(fields.length);
        for (int i = 0; i < fields.length; i++) {
            Method getMethod = null;
            try {
                getMethod = clazz.getMethod("get" + capitalizeFirstLetter(fields[i].getName()));
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            try {
                if (getMethod != null) {
                    Object fieldValue = getMethod.invoke(entity);
                    Object newValue;
                    if (!fields[i].getType().isPrimitive() && !(fields[i].getType() == String.class)
                            && !(fields[i].getType().isEnum()) && !(fields[i].getType() == Date.class)
                            && !(fields[i].getType() == ArrayList.class)) {
                        newValue = ((BaseEntity) fieldValue).getId();
                    } else if ((fields[i].getType() == ArrayList.class)) {
                        int lenght = ((ArrayList) fieldValue).size();
                        StringBuilder stringBuilder = new StringBuilder();
                        for (int j = 0; j < lenght; j++) {
                            stringBuilder.append(((ArrayList<T>) fieldValue).get(j).getId() + " ");
                        }
                        newValue = stringBuilder.toString();
                    } else if (fields[i].getType().isEnum()) {
                        newValue = ((java.lang.Enum) fieldValue).ordinal() + 1;
                    } else {
                        newValue = fieldValue;
                    }
                    values.add(newValue);
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        updateField(values, id);
    }

    private void updateField(List<Object> values, int id) {
        Connection connection = ConnectionPool.POOL.getConnection();
        int fieldsQty = values.size();
        try (PreparedStatement prepareStatement = connection.prepareStatement(getUpdateByIdStatement())) {
            for (int i = 0; i < values.size(); i++) {
                prepareStatement.setObject(i + 1, values.get(i));
            }
            prepareStatement.setObject(fieldsQty + 1, id);
            prepareStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        ConnectionPool.POOL.release();
    }

    @Override
    public void delete(int id) {
        Connection connection = ConnectionPool.POOL.getConnection();
        try (PreparedStatement prepareStatement = connection.prepareStatement(getDeleteByIdStatement())) {
            prepareStatement.setInt(1, id);
            prepareStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        ConnectionPool.POOL.release();
    }

    @Override
    public T get(int id) {
        Connection connection = null;
        try {
            connection = ConnectionPool.POOL.getConnection();
            try (PreparedStatement prepareStatement = connection.prepareStatement(getSelectByIdStatement())) {
                prepareStatement.setInt(1, id);
                try (ResultSet resultSet = prepareStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return createInstanceFromResult(resultSet);
                    }
                }
                {
                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            ConnectionPool.POOL.release();
        }
    }

    public List<T> getAll() {
        Connection connection = null;
        try {
            connection = ConnectionPool.POOL.getConnection();
            try (ResultSet resultSet = connection.createStatement().executeQuery(getSelectAllStatement())) {
                List<T> resultList = new ArrayList<>();
                while (resultSet.next()) {
                    resultList.add(createInstanceFromResult(resultSet));
                }
                return resultList;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            ConnectionPool.POOL.release();
        }
    }

    public int getMaxId() {
        Connection connection = ConnectionPool.POOL.getConnection();
        String query = "SELECT MAX(id) FROM " + getTableName();
        try (ResultSet resultSet = connection.createStatement().executeQuery(query)) {
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        ConnectionPool.POOL.release();
        return 0;
    }

    protected String getSelectAllStatement() {
        return "SELECT * FROM " + getTableName();
    }

    protected EntityType getType(String type) {
        if (type.equals("home")) {
            return EntityType.home;
        } else return EntityType.job;
    }

    protected String getSelectByIdStatement() {
        return getSelectAllStatement() + " WHERE id = ?";
    }

    protected String getDeleteByIdStatement() {
        return "DELETE FROM " + getTableName() + " WHERE id = ?";
    }

    private String capitalizeFirstLetter(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
