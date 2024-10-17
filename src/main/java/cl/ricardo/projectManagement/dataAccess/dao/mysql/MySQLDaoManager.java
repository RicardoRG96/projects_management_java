package cl.ricardo.projectManagement.dataAccess.dao.mysql;

import cl.ricardo.projectManagement.dataAccess.dao.DAOManager;
import cl.ricardo.projectManagement.dataAccess.dao.ProjectDAO;
import cl.ricardo.projectManagement.dataAccess.dao.UserDAO;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class MySQLDaoManager implements DAOManager {
    
    private Connection conn;
    
    private UserDAO users = null;
    
    private ProjectDAO projects = null;
    
    public MySQLDaoManager(String host, String database, String username, String password) throws SQLException {
        conn = DriverManager
                .getConnection("jdbc:mysql://" + host + "/" + database + "?serverTimezone=UTC", username, password);
    }

    @Override
    public UserDAO getUserDAO() {
        if (users == null) {
            users = new MySQLUserDAO(conn);
        }
        return users;
    }

    @Override
    public ProjectDAO getProjectDAO() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
