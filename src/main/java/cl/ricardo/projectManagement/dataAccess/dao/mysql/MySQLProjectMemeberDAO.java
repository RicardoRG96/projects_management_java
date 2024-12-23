package cl.ricardo.projectManagement.dataAccess.dao.mysql;

import cl.ricardo.projectManagement.dataAccess.ProjectMember;
import cl.ricardo.projectManagement.dataAccess.dao.DAOException;
import cl.ricardo.projectManagement.dataAccess.dao.ProjectMemberDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLProjectMemeberDAO implements ProjectMemberDAO {
    final String INSERT = "INSERT INTO project_members (project_id, user_id, role) VALUES (?, ?, ?)";
    final String UPDATE = "UPDATE project_members SET project_id = ?, user_id = ? WHERE id = ?";
    final String DELETE = "DELETE FROM project_members WHERE id = ?";
    final String GETALL = "SELECT * FROM project_members";
    final String GETONE = "SELECT * FROM project_members WHERE id = ?";
    final String GET_ONE_BY_PROJECT_ID = "SELECT * FROM project_members WHERE project_id = ?";
    final String DELETE_BY_USER_ID_AND_PROJECT_ID = 
            "DELETE FROM project_members WHERE user_id = ? AND project_id = ?";
    final String DELETE_BY_PROJECT_ID = "DELETE FROM project_members WHERE project_id = ?";
    final String DELETE_BY_USER_ID = "DELETE FROM project_members WHERE user_id = ?";
    final String GET_BY_USER_ID = "SELECT * FROM project_members WHERE user_id = ?";
    final String GET_BY_PROJECT_AND_USER_ID = 
            "SELECT * FROM project_members WHERE project_id = ? AND user_id = ?";
    final String UPDATE_BY_USER_AND_PROJECT_ID = 
            "UPDATE project_members SET project_id = ? WHERE user_id = ? AND project_id = ?";
    
    private Connection conn;
    
    public MySQLProjectMemeberDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(ProjectMember member) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(INSERT);
            statement.setInt(1, member.getProjectId());
            statement.setInt(2, member.getUserId());
            statement.setString(3, member.getRole());
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
    public void update(ProjectMember member) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(UPDATE);
            statement.setInt(1, member.getProjectId());
            statement.setInt(2, member.getUserId());
            statement.setInt(3, member.getId());
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
    
    private ProjectMember convert(ResultSet resultSet) throws SQLException {
        String role = resultSet.getString("role");
        ProjectMember member = new ProjectMember(role);
        int projectId = resultSet.getInt("project_id");
        int userId = resultSet.getInt("user_id");
        member.setId(resultSet.getInt("id"));
        member.setProjectId(projectId);
        member.setUserId(userId);
        member.setJoinedAt(resultSet.getDate("joined_at").toString());
        return member;
    }

    @Override
    public List<ProjectMember> getAll() throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<ProjectMember> projectMemberList = new ArrayList<>();
        try {
            statement = conn.prepareStatement(GETALL);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                projectMemberList.add(convert(resultSet));
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
        return projectMemberList;
    }

    @Override
    public ProjectMember getElement(int id) throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ProjectMember member = null;
        try {
            statement = conn.prepareStatement(GETONE);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                member = convert(resultSet);
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
        return member;
    }

    @Override
    public List<ProjectMember> getMembersByProjectId(int projectId) throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<ProjectMember> members = new ArrayList<>();
        try {
            statement = conn.prepareStatement(GET_ONE_BY_PROJECT_ID);
            statement.setInt(1, projectId);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                members.add(convert(resultSet));
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
        return members;
    }

    @Override
    public void deleteByUserIdAndProjectId(int userId, int projectId) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(DELETE_BY_USER_ID_AND_PROJECT_ID);
            statement.setInt(1, userId);
            statement.setInt(2, projectId);
            if (statement.executeUpdate() == 0) {
                throw new DAOException("Posiblemente no se eliminó el registro");
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
    
    @Override
    public void deleteByProjectId(int projectId) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(DELETE_BY_PROJECT_ID);
            statement.setInt(1, projectId);
            if (statement.executeUpdate() == 0) {
                throw new DAOException("Posiblemente no se eliminó el registro");
//                throw new SQLException();
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
    
    @Override
    public void deleteByUserId(int userId) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(DELETE_BY_USER_ID);
            statement.setInt(1, userId);
            if (statement.executeUpdate() == 0) {
                throw new DAOException("Posiblemente no se eliminó el registro");
//                throw new SQLException();
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
    
    @Override
    public List<ProjectMember> getMembersByUserId(int userId) throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<ProjectMember> members = new ArrayList<>();
        try {
            statement = conn.prepareStatement(GET_BY_USER_ID);
            statement.setInt(1, userId);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                members.add(convert(resultSet));
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
        return members;
    }
    
    @Override
    public List<ProjectMember> getMemberByProjectAndUserId(int projectId, int userId) throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<ProjectMember> projectMember = new ArrayList<>();
        try {
            statement = conn.prepareStatement(GET_BY_PROJECT_AND_USER_ID);
            statement.setInt(1, projectId);
            statement.setInt(2, userId);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                projectMember.add(convert(resultSet));
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
        return projectMember;
    }
    
    @Override
    public void updateByUserIdAndProjectId(int userId, int previousProjectId, int currentProjectId) 
            throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(UPDATE_BY_USER_AND_PROJECT_ID);
            statement.setInt(1, currentProjectId);
            statement.setInt(2, userId);
            statement.setInt(3, previousProjectId);
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
    
}
