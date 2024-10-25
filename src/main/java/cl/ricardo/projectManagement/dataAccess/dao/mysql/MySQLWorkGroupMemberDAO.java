package cl.ricardo.projectManagement.dataAccess.dao.mysql;

import cl.ricardo.projectManagement.dataAccess.WorkGroupMember;
import cl.ricardo.projectManagement.dataAccess.dao.DAOException;
import cl.ricardo.projectManagement.dataAccess.dao.WorkGroupMemberDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLWorkGroupMemberDAO implements WorkGroupMemberDAO {
    
    final String INSERT = "INSERT INTO workgroups_members (user_id, workgroup_id) VALUES (?, ?)";
    final String UPDATE = "UPDATE workgroups_members SET user_id = ?, workgroup_id = ? WHERE id = ?";
    final String DELETE = "DELETE FROM workgroups_members WHERE id = ?";
    final String GETALL = "SELECT * FROM workgroups_members";
    final String GETONE = "SELECT * FROM workgroups_members WHERE id = ?";
    final String GET_ONE_BY_PROJECT_ID = "SELECT * FROM workgroups_members WHERE workgroup_id = ?";
    final String DELETE_BY_WORKGROUP_ID = "DELETE FROM workgroups_members WHERE workgroup_id = ?";
    final String DELETE_BY_USER_ID = "DELETE FROM workgroups_members WHERE user_id = ?";
    final String DELETE_BY_USER_AND_WORKGROUP_ID = 
            "DELETE FROM workgroups_members WHERE user_id = ? AND workgroup_id = ?";
    final String GET_BY_USER_ID = "SELECT * FROM workgroups_members WHERE user_id = ?";
    final String GET_BY_WORKGROUP_AND_USER_ID = 
            "SELECT * FROM workgroups_members WHERE workgroup_id = ? AND user_id = ?";
    
    private Connection conn;
    
    public MySQLWorkGroupMemberDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(WorkGroupMember wgMember) throws DAOException {
       PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(INSERT);
            statement.setInt(1, wgMember.getUserId());
            statement.setInt(2, wgMember.getWorkGroupId());
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
    public void update(WorkGroupMember wgMember) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(UPDATE);
            statement.setInt(1, wgMember.getUserId());
            statement.setInt(2, wgMember.getWorkGroupId());
            statement.setInt(3, wgMember.getId());
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
    public void deleteByWorkGroupId(int workGroupId) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(DELETE_BY_WORKGROUP_ID);
            statement.setInt(1, workGroupId);
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
    public void deleteByUserId(int userId) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(DELETE_BY_USER_ID);
            statement.setInt(1, userId);
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
    public void deleteByUserIdAndWorkGroupId(int userId, int workGroupId) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(DELETE_BY_USER_AND_WORKGROUP_ID);
            statement.setInt(1, userId);
            statement.setInt(2, workGroupId);
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
    
    private WorkGroupMember convert(ResultSet resultSet) throws SQLException {
        WorkGroupMember wgMember = new WorkGroupMember();
        int userId = resultSet.getInt("user_id");
        int workGroupId = resultSet.getInt("workgroup_id");
        wgMember.setId(resultSet.getInt("id"));
        wgMember.setUserId(userId);
        wgMember.setWorkGroupId(workGroupId);
        wgMember.setJoinedAt(resultSet.getDate("joined_at").toString());
        return wgMember;
    }
    
    @Override
    public List<WorkGroupMember> getAll() throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<WorkGroupMember> workGroupMemberList = new ArrayList<>();
        try {
            statement = conn.prepareStatement(GETALL);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                workGroupMemberList.add(convert(resultSet));
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
        return workGroupMemberList;
    }

    @Override
    public WorkGroupMember getElement(int id) throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        WorkGroupMember wgMember = null;
        try {
            statement = conn.prepareStatement(GETONE);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                wgMember = convert(resultSet);
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
        return wgMember;
    }

    @Override
    public List<WorkGroupMember> getMembersByWorkGroupId(int workGroupId) throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<WorkGroupMember> wgMembers = new ArrayList<>();
        try {
            statement = conn.prepareStatement(GET_ONE_BY_PROJECT_ID);
            statement.setInt(1, workGroupId);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                wgMembers.add(convert(resultSet));
            }
        } catch (SQLException ex) {
            throw new DAOException("Error en SQL aqui", ex);
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
        return wgMembers;
    }
    
    @Override
    public List<WorkGroupMember> getMembersByUserId(int userId) throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<WorkGroupMember> wgMembers = new ArrayList<>();
        try {
            statement = conn.prepareStatement(GET_BY_USER_ID);
            statement.setInt(1, userId);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                wgMembers.add(convert(resultSet));
            }
        } catch (SQLException ex) {
            throw new DAOException("Error en SQL aqui", ex);
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
        return wgMembers;
    }
    
    @Override
    public List<WorkGroupMember> getMembersByWorkGroupAndUserId(int workGroupId, int userId) 
            throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<WorkGroupMember> wgMembers = new ArrayList<>();
        try {
            statement = conn.prepareStatement(GET_BY_WORKGROUP_AND_USER_ID);
            statement.setInt(1, workGroupId);
            statement.setInt(2, userId);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                wgMembers.add(convert(resultSet));
            }
        } catch (SQLException ex) {
            throw new DAOException("Error en SQL aqui", ex);
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
        return wgMembers;
    }
    
}
