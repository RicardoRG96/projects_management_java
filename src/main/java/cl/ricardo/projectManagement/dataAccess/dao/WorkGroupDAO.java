package cl.ricardo.projectManagement.dataAccess.dao;

import cl.ricardo.projectManagement.dataAccess.WorkGroup;
import java.util.List;

public interface WorkGroupDAO extends DAO<WorkGroup, Integer> {
    
    @Override
    void insert(WorkGroup workGroup) throws DAOException;
    
    @Override
    void update(WorkGroup workGroup) throws DAOException;
    
    @Override
    void delete(int id) throws DAOException;
    
    @Override
    List<WorkGroup> getAll() throws DAOException;
    
    @Override
    WorkGroup getElement(int id) throws DAOException;
    
    List<WorkGroup> getGroupsByProject(int projectId) throws DAOException;
    
    int getWorkGroupIdByName(String workGroupName) throws DAOException;
    
    void deleteByProjectId(int projectId) throws DAOException;
    
}
