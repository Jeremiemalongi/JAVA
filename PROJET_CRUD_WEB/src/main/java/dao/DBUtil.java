package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static final String URL =
        "jdbc:sqlserver://localhost:1433;"
      + "databaseName=StudentDB;"
      + "encrypt=true;"
      + "trustServerCertificate=true;";

    // ✅ UTILISE student_user (PAS sa)
    private static final String USER = "student_user";
    private static final String PASS = "Student@123";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("SQL Server JDBC Driver introuvable", e);
        }

        return DriverManager.getConnection(URL, USER, PASS);
    }
}


