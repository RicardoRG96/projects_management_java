package cl.ricardo.projectManagement.dataAccess.dao;

import cl.ricardo.projectManagement.dataAccess.ProjectMember;
import java.util.List;

public interface ProjectMemberDAO extends DAO<ProjectMember, Integer> {
    
    @Override
    void insert(ProjectMember member) throws DAOException;
    
    @Override
    void update(ProjectMember member) throws DAOException;
    
    @Override
    void delete(int id) throws DAOException;
    
    @Override
    List<ProjectMember> getAll() throws DAOException;
    
    @Override
    ProjectMember getElement(int id) throws DAOException;
    
    ProjectMember getMemberByUserId(int userId) throws DAOException;
    
}
