package cl.ricardo.projectManagement.dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    
    private Connection conn;
    
    public Connection getConnection() {
        try {
            String db = "jdbc:mysql://localhost:3306/project_management_system?serverTimezone=UTC";
            conn = DriverManager.getConnection(db, "root", "");
            return conn;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return null;
    }
}
