package cl.ricardo.projectManagement.dataAccess.dao;

public interface DAOManager {
    
    UserDAO getUserDAO();
    
    ProjectDAO getProjectDAO();
    
    WorkGroupDAO getWorkGroupDAO();
    
    ProjectMemberDAO getProjectMemberDAO();
    
    WorkGroupMemberDAO getWorkGroupMemberDAO();
    
    TaskDAO getTaskDAO();
    
}
