package com.csci5308.group7.database;

import java.sql.Connection;

public interface IDBConnection {
    public java.sql.Connection createConnection();
    public void close(Connection connection);
}
