package cl.ricardo.projectManagement.dataAccess.dao.mysql;

import cl.ricardo.projectManagement.dataAccess.User;
import cl.ricardo.projectManagement.dataAccess.dao.DAOException;
import cl.ricardo.projectManagement.dataAccess.dao.UserDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLUserDAO implements UserDAO {
    
    final String INSERT = "INSERT INTO users (username, email, password, role) VALUES (?, ?, ?, ?)";
    final String UPDATE = "UPDATE users SET username = ?, email = ?, password = ?, role = ? WHERE id = ?";
    final String DELETE = "DELETE FROM users WHERE id = ?";
    final String GETALL = "SELECT * FROM users";
    final String GETONE = "SELECT * FROM users WHERE id = ?";
    final String GET_ID_BY_USERNAME = "SELECT id FROM users WHERE username = ?";
    final String GETONE_BY_USERNAME_OR_EMAIL = "SELECT * FROM users WHERE username = ? OR email = ?";
    
    private Connection conn;
    
    public MySQLUserDAO(Connection conn) {
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
    
    private User convert(ResultSet resultSet) throws SQLException {
        String username = resultSet.getString("username");
        String email = resultSet.getString("email");
        String password = resultSet.getString("password");
        String role = resultSet.getString("role");
        User user = new User(username, email, password, role);
        int id = resultSet.getInt("id");
        user.setId(id);
        return user;
    }

    @Override
    public List<User> getAll() throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<User> userList = new ArrayList<>();
        try {
            statement = conn.prepareStatement(GETALL);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                userList.add(convert(resultSet));
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
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL", ex);
                }
            }
        }
        return userList;
    }

    @Override
    public User getElement(int id) throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User user = null;
        try {
            statement = conn.prepareStatement(GETONE);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = convert(resultSet);
            } else {
                throw new DAOException("No se ha encontrado el registro");
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
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL", ex);
                }
            }
        }
        return user;
    }
    
    @Override
    public User getUserByEmailOrUserName(String userInfo) throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User user = null;
        try {
            statement = conn.prepareStatement(GETONE_BY_USERNAME_OR_EMAIL);
            statement.setString(1, userInfo);
            statement.setString(2, userInfo);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = convert(resultSet);
            } else {
                throw new DAOException("No se ha encontrado el registro");
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
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL", ex);
                }
            }
        }
        return user;
    }
    
    @Override
    public int getUserIdByUserName(String userName) throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Integer userId = null;
        try {
            statement = conn.prepareStatement(GET_ID_BY_USERNAME);
            statement.setString(1, userName);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                userId = resultSet.getInt("id");
            } else {
                throw new DAOException("No se ha encontrado el registro");
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
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL", ex);
                }
            }
        }
        return userId;
    }
    
    public static void main(String[] args) throws SQLException, DAOException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_management_system?serverTimezone=UTC", "root", "");
            UserDAO userDao = new MySQLUserDAO(conn);
            List<User> users = userDao.getAll();
            for (User user : users) {
                System.out.println(user);
            }
        } finally {
            if (conn != null) {
                conn.close();
            }
        } 
    }
}