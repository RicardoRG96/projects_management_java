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
    
    List<ProjectMember> getMembersByProjectId(int projectId) throws DAOException;
    
    void deleteByUserIdAndProjectId(int userId, int projectId) throws DAOException;
    
    void deleteByProjectId(int projectId) throws DAOException;
    
    void deleteByUserId(int userId) throws DAOException;
    
    List<ProjectMember> getMembersByUserId(int userId) throws DAOException;
    
    List<ProjectMember> getMemberByProjectAndUserId(int projectId, int userId) throws DAOException;
    
    void updateByUserIdAndProjectId(int userId, int previousProjectId, int currentProjectId) throws DAOException;
    
}
