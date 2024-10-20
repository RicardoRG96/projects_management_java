package cl.ricardo.projectManagement.dataAccess.dao;

import cl.ricardo.projectManagement.dataAccess.WorkGroup;
import java.util.List;

public interface WorkGroupDAO extends DAO<WorkGroup, Integer> {
    
    void insert(WorkGroup workGroup) throws DAOException;
    
    void update(WorkGroup workGroup) throws DAOException;
    
    void delete(int id) throws DAOException;
    
    List<WorkGroup> getAll() throws DAOException;
    
    WorkGroup getElement(int id) throws DAOException;
}
