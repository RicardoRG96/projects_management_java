package cl.ricardo.projectManagement.dataAccess.dao.mysql;

import cl.ricardo.projectManagement.dataAccess.WorkGroup;
import cl.ricardo.projectManagement.dataAccess.dao.DAOException;
import cl.ricardo.projectManagement.dataAccess.dao.WorkGroupDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLWorkGroupDAO implements WorkGroupDAO {
    
    final String INSERT = "INSERT INTO workgroups (project_id, name, leader_id) VALUES (?, ?, ?)";
    final String UPDATE = "UPDATE workgroups SET project_id = ?, name = ?, leader_id = ? WHERE id = ?";
    final String DELETE = "DELETE FROM workgroups WHERE id = ?";
    final String GETALL = "SELECT * FROM workgroups";
    final String GETONE = "SELECT * FROM workgroups WHERE id = ?";
    
    private Connection conn;
    
    public MySQLWorkGroupDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(WorkGroup workGroup) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(INSERT);
            statement.setInt(1, workGroup.getProjectId());
            statement.setString(2, workGroup.getName());
            statement.setInt(3, workGroup.getLeaderId());
            if (statement.executeUpdate() == 0) {
                throw new DAOException("Posiblemente el registro no se insertó");
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
    public void update(WorkGroup workGroup) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(UPDATE);
            statement.setInt(1, workGroup.getProjectId());
            statement.setString(2, workGroup.getName());
            statement.setInt(3, workGroup.getLeaderId());
            statement.setInt(4, workGroup.getId());
            if (statement.executeUpdate() == 0) {
                throw new DAOException("Posiblemente el registro no se actualizó");
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
                throw new DAOException("Posiblemente el registro no se eliminó");
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
    public List<WorkGroup> getAll() throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<WorkGroup> workGroupsList = new ArrayList<>();
        try {
            statement = conn.prepareStatement(GETALL);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                workGroupsList.add(convert(resultSet));
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
        return workGroupsList;
    }
    
    private WorkGroup convert(ResultSet resultSet) throws SQLException {
        int projectId = resultSet.getInt("project_id");
        String name = resultSet.getString("name");
        int leaderId = resultSet.getInt("leader_id");
        WorkGroup workGroup = new WorkGroup(projectId, name, leaderId);
        workGroup.setId(resultSet.getInt("id"));
        workGroup.setCreatedAt(resultSet.getDate("created_at").toString());
        return workGroup;
    }
    
    @Override
    public WorkGroup getElement(int id) throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        WorkGroup workGroup = null;
        try {
            statement = conn.prepareStatement(GETONE);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                workGroup = convert(resultSet);
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
        return workGroup;
    }
    
}
