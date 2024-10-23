package cl.ricardo.projectManagement.dataAccess.dao.mysql;

import cl.ricardo.projectManagement.dataAccess.Project;
import cl.ricardo.projectManagement.dataAccess.dao.DAOException;
import cl.ricardo.projectManagement.dataAccess.dao.ProjectDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLProjectDAO implements ProjectDAO {
    
    final String INSERT = "INSERT INTO projects (name, description, owner_id) VALUES (?, ?, ?)";
    final String UPDATE = "UPDATE projects SET name = ?, description = ?, owner_id = ? WHERE id = ?";
    final String DELETE = "DELETE FROM projects WHERE id = ?";
    final String GETALL = "SELECT * FROM projects";
    final String GETONE = "SELECT * FROM projects WHERE id = ?";
    final String GET_ID_BY_PROJECTNAME = "SELECT id FROM projects WHERE name = ?";
    
    private Connection conn;
    
    public MySQLProjectDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Project project) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(INSERT);
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setInt(3, project.getOwnerId());
            if (statement.executeUpdate() == 0) {
                throw new DAOException("Posiblemente la información no fue guardada");
            }
        } catch(SQLException ex) {
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
    public void update(Project project) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(UPDATE);
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setInt(3, project.getOwnerId());
            statement.setInt(4, project.getId());
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
//            throw new DAOException("Error en SQL", ex);
            System.out.println(ex.toString());
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
    
    private Project convert(ResultSet resultSet) throws SQLException {
        String name = resultSet.getString("name");
        String description = resultSet.getString("description");
        int ownerId = resultSet.getInt("owner_id");
        Project project = new Project(name, description, ownerId);
        project.setId(resultSet.getInt("id"));
        project.setCreatedAt(resultSet.getDate("created_at").toString());
        return project;
    }

    @Override
    public List<Project> getAll() throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Project> projectsList = new ArrayList<>();
        try {
            statement = conn.prepareStatement(GETALL);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                projectsList.add(convert(resultSet));
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
        return projectsList;
    }

    @Override
    public Project getElement(int id) throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Project project = null;
        try {
            statement = conn.prepareStatement(GETONE);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                project = convert(resultSet);
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
        return project;
    }
    
    @Override
    public int getProjectIdByProjectName(String projectName) throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Integer projectId = null;
        try {
            statement = conn.prepareStatement(GET_ID_BY_PROJECTNAME);
            statement.setString(1, projectName);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                projectId = resultSet.getInt("id");
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
                    throw new DAOException("Error en SQL cerrar statement", ex);
                }
            }
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL cerrar resultSet", ex);
                }
            }
        }
        return projectId;
    }
    
    public static void main(String[] args) throws SQLException, DAOException {
        Connection conn = null;
        try {
            String db = "jdbc:mysql://localhost:3306/project_management_system?serverTimezone=UTC";
            conn = DriverManager.getConnection(db, "root", "");
            ProjectDAO projectDAO = new MySQLProjectDAO(conn);
            List<Project> projects = projectDAO.getAll();
            for (Project project : projects) {
                System.out.println(project.toString());
            }
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }
    
}
