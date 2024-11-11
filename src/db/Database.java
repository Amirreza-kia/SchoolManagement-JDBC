package db;

import java.sql.*;

public class Database {

    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/schoolsystemmanagment";
    private static final String DATABASE_USER = "postgres";
    private static final String DATABASE_PASSWORD = "09059228271";



    public Connection getDatabaseConnection()  throws SQLException {
        return DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
    }

    public Statement getSQLStatement() throws SQLException {
        return this.getDatabaseConnection().createStatement();
    }
    public PreparedStatement getPreparedStatement(String sql) throws SQLException {
        return this.getDatabaseConnection().prepareStatement(sql);

    }



}
