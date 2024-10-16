package cl.ricardo.projectManagement.dataAccess.dao.mysql;

import cl.ricardo.projectManagement.dataAccess.User;
import cl.ricardo.projectManagement.dataAccess.dao.DAOException;
import cl.ricardo.projectManagement.dataAccess.dao.UserDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class mySQLUserDAO implements UserDAO {
    
    final String INSERT = "INSERT INTO users (username, email, password, role) VALUES (?, ?, ?, ?, ?)";
    final String UPDATE = "UPDATE users SET username = ?, email = ?. password = ?, role = ? WHERE id = ?";
    final String DELETE = "DELETE FROM users WHERE id = ?";
    final String GETALL = "SELECT * FROM users";
    final String GETONE = "SELECT * FROM users WHERE id = ?";
    
    private Connection conn;
    
    public mySQLUserDAO(Connection conn) {
        this.conn = conn;
    }
    
    @Override
    public void insert(User user) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(INSERT);
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getRole());
            if (statement.executeUpdate() == 0) {
                throw new DAOException("Posiblemente la información no fue guardada");
            }
        } catch (SQLException ex) {
            throw new DAOException("Error en SQL", ex);
        } finally {
            if (statement != null) {
                try {
                statement.close();
            } catch (SQLException ex) {
                throw new DAOException("Error en SQL", ex);
            }
            }
        }
    }

    @Override
    public void update(User user) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(UPDATE);
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getRole());
            statement.setInt(5, user.getId());
            if (statement.executeUpdate() == 0) {
                throw new DAOException("Posiblemente la información no fue actualizada");
            }
        } catch (SQLException ex) {
            throw new DAOException("Error en SQL", ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL", ex);
                }
            }
        }
    }

    @Override
    public void delete(int id) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(DELETE);
            statement.setInt(1, id);
            if (statement.executeUpdate() == 0) {
                throw new DAOException("Posiblemente el elemento no fue eliminado");
            }
        } catch (SQLException ex) {
            throw new DAOException("Error en SQL", ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL", ex);
                }
            }
        }
    }

    @Override
    public List<User> getAll(String table) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public User getElement(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
