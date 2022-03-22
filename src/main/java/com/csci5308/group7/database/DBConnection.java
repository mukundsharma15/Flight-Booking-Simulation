package com.csci5308.group7.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection implements IDBConnection {

    private static DBConnection existingConnection = null;

    public static IDBConnection instance()
    {
        if(existingConnection == null){
            existingConnection = new DBConnection();
        }
        return existingConnection;
    }

    @Override
    public java.sql.Connection createConnection() {
        Connection connection = null;
        try
        {
            DBConfig config = new DBConfig();
            config.loadApplicationProperties();
            Class.forName(config.getDriver());
            connection = DriverManager.getConnection(config.getDatabase(), config.getUsername(), config.getPassword());
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void close(Connection connection) {
        try
        {
            if(connection != null)
            {
                connection.close();
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
