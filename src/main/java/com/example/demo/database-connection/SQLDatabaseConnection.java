import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLDatabaseConnection {

    public static void main(String[] args) {
        String url = "jdbc:sqlserver://NARINE\\SQLEXPRESS:1433;encrypt=true;trustServerCertificate=true;databaseName=JavaDemo";
        String username = "sa";
        String password = "MSSQL@5175";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            conn.setAutoCommit(true);

            System.out.println("Connected to DB: " + conn.getCatalog());

            String createTableSQL = "CREATE TABLE DemoUsers2 (" +
                    "ID INT PRIMARY KEY, " +
                    "Name NVARCHAR(50), " +
                    "Email NVARCHAR(50))";

            try (Statement stmt = conn.createStatement()) {
                stmt.execute(createTableSQL);
                System.out.println("Table created successfully!");
            }

        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        }
    }
}
