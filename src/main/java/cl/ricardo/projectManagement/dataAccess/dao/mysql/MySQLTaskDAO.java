package cl.ricardo.projectManagement.dataAccess.dao.mysql;

import cl.ricardo.projectManagement.dataAccess.Task;
import cl.ricardo.projectManagement.dataAccess.dao.DAOException;
import cl.ricardo.projectManagement.dataAccess.dao.TaskDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class MySQLTaskDAO implements TaskDAO {
    final String INSERT = 
            "INSERT INTO tasks (project_id, workgroup_id, title, description, status, priority, due_date, assigned_to) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    final String UPDATE = 
            "UPDATE tasks SET project_id = ?, workgroup_id = ?, title = ?, description = ?, status = ?, priority = ?, due_date = ?, assigned_to = ? WHERE id = ?";
    final String DELETE = "DELETE FROM tasks WHERE id = ?";
    final String GETALL = "SELECT * FROM tasks";
    final String GETONE = "SELECT * FROM tasks WHERE id = ?";
    
    private Connection conn;
    
    public MySQLTaskDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Task task) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(INSERT);  
            statement.setInt(1, task.getProjectId());
            statement.setInt(2, task.getWorkGroupId());
            statement.setString(3, task.getTitle());
            statement.setString(4, task.getDescription());
            statement.setString(5, task.getStatus());
            statement.setString(6, task.getPriority());
            statement.setDate(7, Date.valueOf(task.getDueDate()));
            statement.setInt(8, task.getAssignedTo());
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
    public void update(Task task) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(UPDATE);
            statement.setInt(1, task.getProjectId());
            statement.setInt(2, task.getWorkGroupId());
            statement.setString(3, task.getTitle());
            statement.setString(4, task.getDescription());
            statement.setString(5, task.getStatus());
            statement.setString(6, task.getPriority());
            statement.setDate(7, Date.valueOf(task.getDueDate()));
            statement.setInt(8, task.getAssignedTo());
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
    public List<Task> getAll() throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Task> tasksList = new ArrayList<>();
        try {
            statement = conn.prepareStatement(GETALL);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                tasksList.add(convert(resultSet));
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
        return tasksList;
    }

    private Task convert(ResultSet resultSet) throws SQLException {
        String title = resultSet.getString("title");
        String description = resultSet.getString("description");
        String status = resultSet.getString("status");
        String priority = resultSet.getString("priority");
        LocalDate dueDate = LocalDate.parse(resultSet.getDate("due_date").toString());
        
        Task task = new Task(title, description, status, priority, dueDate);
        int taskId = resultSet.getInt("id");
        int projectId = resultSet.getInt("project_id");
        int workGroupId = resultSet.getInt("workgroup_id");
        int assignedTo = resultSet.getInt("assigned_to");
        String createdAt = resultSet.getString("created_at");
        String updatedAt = resultSet.getString("updated_at");
        
        task.setId(taskId);
        task.setProjectId(projectId);
        task.setWorkGroupId(workGroupId);
        task.setAssignedTo(assignedTo);
        task.setCreatedAt(createdAt);
        task.setUpdatedAt(updatedAt);
        return task;
    }
    
    @Override
    public Task getElement(int id) throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Task task = null;
        try {
            statement = conn.prepareStatement(GETONE);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                task = convert(resultSet);
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
        return task;
    }
    
}
