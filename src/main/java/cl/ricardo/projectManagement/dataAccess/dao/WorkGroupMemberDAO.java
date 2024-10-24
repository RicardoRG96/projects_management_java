package cl.ricardo.projectManagement.dataAccess.dao;

import cl.ricardo.projectManagement.dataAccess.WorkGroupMember;
import java.util.List;

public interface WorkGroupMemberDAO extends DAO<WorkGroupMember, Integer> {
    
    @Override
    void insert(WorkGroupMember wgMember) throws DAOException;
    
    @Override
    void update(WorkGroupMember wgMember) throws DAOException;
    
    @Override
    void delete(int id) throws DAOException;
    
    @Override
    List<WorkGroupMember> getAll() throws DAOException;
    
    @Override
    WorkGroupMember getElement(int id) throws DAOException;
    
    List<WorkGroupMember> getMembersByWorkGroupId(int workGroupId) throws DAOException;
    
    void deleteByWorkGroupId(int workGroupID) throws DAOException;
    
    void deleteByUserId(int userId) throws DAOException;
    
    List<WorkGroupMember> getMembersByUserId(int userId) throws DAOException;
    
}
