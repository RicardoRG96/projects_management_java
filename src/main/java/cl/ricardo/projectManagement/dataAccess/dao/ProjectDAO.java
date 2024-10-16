package cl.ricardo.projectManagement.dataAccess.dao;

import cl.ricardo.projectManagement.dataAccess.Project;
import java.util.List;

public interface ProjectDAO extends DAO<Project, Integer> {
 
    @Override
    public void insert(Project item);

    @Override
    public void update(Project item);

    @Override
    public void delete(int id);

    @Override
    public List<Project> getAll();

    @Override
    public Project getElement(int id);
    
}
