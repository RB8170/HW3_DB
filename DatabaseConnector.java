// === DatabaseConnector.java ===
import java.sql.*;

public class DatabaseConnector {
    private static final String URL = "jdbc:postgresql://localhost:5432/car_parking";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
