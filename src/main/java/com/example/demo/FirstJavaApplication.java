package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class FirstJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstJavaApplication.class, args);
	}

	@Bean
public CommandLineRunner createTableAndSeedDataOnStartup() {
    return args -> {
        String url = "jdbc:sqlserver://localhost:1433;encrypt=true;trustServerCertificate=true;databaseName=JavaDemo";
        String username = "sa";
        String password = "MSSQL@5175";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to DB: " + conn.getCatalog());

            String sql = "CREATE TABLE Users (" +
                         "id INT PRIMARY KEY, " +
                         "username NVARCHAR(50), " +
                         "email NVARCHAR(100), " +
                         "phonenumber NVARCHAR(15))";

            try (Statement stmt = conn.createStatement()) {
                stmt.execute(sql);
                System.out.println("Table 'Users' created successfully!");

                // Seed sample data
                String insertSql = "INSERT INTO Users (id, username, email, phonenumber) VALUES " +
                                   "(1, 'alice', 'alice@example.com', '1234567890'), " +
                                   "(2, 'bob', 'bob@example.com', '0987654321'), " +
                                   "(3, 'charlie', 'charlie@example.com', '5555555555')";
                stmt.executeUpdate(insertSql);
                System.out.println("Sample data inserted successfully!");
            }
        } catch (SQLException e) {
            if (e.getMessage().contains("There is already an object named")) {
                System.out.println("Table 'Users' already exists.");
            } else {
                System.err.println("SQL error: " + e.getMessage());
                e.printStackTrace();
            }
        }
    };
}

}
