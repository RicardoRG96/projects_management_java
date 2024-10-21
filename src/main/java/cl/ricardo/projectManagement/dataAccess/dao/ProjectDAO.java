package cl.ricardo.projectManagement.dataAccess.dao;

import cl.ricardo.projectManagement.dataAccess.Project;
import java.util.List;

public interface ProjectDAO extends DAO<Project, Integer> {
 
    @Override
    void insert(Project project) throws DAOException;

    @Override
    void update(Project project) throws DAOException;

    @Override
    void delete(int id) throws DAOException;

    @Override
    List<Project> getAll() throws DAOException;

    @Override
    Project getElement(int id) throws DAOException;
    
    int getProjectIdByProjectName(String projectName) throws DAOException;
    
}
