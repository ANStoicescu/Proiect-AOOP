package config;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection;

    public static Connection getInstance() throws SQLException {
        if(connection == null) {
            String url = "jdbc:mysql://localhost:3307/PCshop";
            String username = "root";
            String password = "root";
            connection = DriverManager.getConnection(url, username, password);
        }
        return connection;
    }
}
