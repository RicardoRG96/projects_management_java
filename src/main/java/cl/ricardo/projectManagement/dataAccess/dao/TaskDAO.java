package cl.ricardo.projectManagement.dataAccess.dao;

import cl.ricardo.projectManagement.dataAccess.Task;
import java.util.List;

public interface TaskDAO extends DAO<Task, Integer> {
    
    @Override
    void insert(Task task) throws DAOException;
    
    @Override
    void update(Task task) throws DAOException;
    
    @Override
    void delete(int id) throws DAOException;
    
    @Override
    List<Task> getAll() throws DAOException;
    
    @Override
    Task getElement(int id) throws DAOException;
    
}
