package cl.ricardo.projectManagement.dataAccess.dao;

import cl.ricardo.projectManagement.dataAccess.Project;
import java.util.List;

public interface ProjectDAO extends DAO<Project, Integer> {
 
    @Override
    public void insert(Project project) throws DAOException;

    @Override
    public void update(Project project) throws DAOException;

    @Override
    public void delete(int id) throws DAOException;

    @Override
    public List<Project> getAll() throws DAOException;

    @Override
    public Project getElement(int id) throws DAOException;
    
}
