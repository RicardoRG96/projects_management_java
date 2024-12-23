package cl.ricardo.projectManagement.dataAccess.dao.mysql;

import cl.ricardo.projectManagement.dataAccess.User;
import cl.ricardo.projectManagement.dataAccess.dao.DAOException;
import cl.ricardo.projectManagement.dataAccess.dao.DAOManager;
import cl.ricardo.projectManagement.dataAccess.dao.ProjectDAO;
import cl.ricardo.projectManagement.dataAccess.dao.ProjectMemberDAO;
import cl.ricardo.projectManagement.dataAccess.dao.TaskDAO;
import cl.ricardo.projectManagement.dataAccess.dao.UserDAO;
import cl.ricardo.projectManagement.dataAccess.dao.WorkGroupDAO;
import cl.ricardo.projectManagement.dataAccess.dao.WorkGroupMemberDAO;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.List;

public class MySQLDaoManager implements DAOManager {
    
    private Connection conn;
    
    private UserDAO users = null;
    
    private ProjectDAO projects = null;
    
    private WorkGroupDAO workGroups = null;
    
    private ProjectMemberDAO projectMembers = null;
    
    private WorkGroupMemberDAO workGroupMembers = null;
    
    private TaskDAO tasks = null;
    
    public MySQLDaoManager(String host, String database, String username, String password) throws SQLException {
        conn = DriverManager
                .getConnection("jdbc:mysql://" + host + "/" + database + "?serverTimezone=UTC", username, password);
    }

    @Override
    public UserDAO getUserDAO() {
        if (users == null) {
            users = new MySQLUserDAO(conn);
        }
        return users;
    }

    @Override
    public ProjectDAO getProjectDAO() {
        if (projects == null) {
            projects = new MySQLProjectDAO(conn);
        }
        return projects;
    }
    
    @Override
    public WorkGroupDAO getWorkGroupDAO() {
        if (workGroups == null) {
            workGroups = new MySQLWorkGroupDAO(conn);
        }
        return workGroups;
    }
    
    @Override
    public ProjectMemberDAO getProjectMemberDAO() {
        if (projectMembers == null) {
            projectMembers = new MySQLProjectMemeberDAO(conn);
        }
        return projectMembers;
    }

    @Override
    public WorkGroupMemberDAO getWorkGroupMemberDAO() {
        if (workGroupMembers == null) {
            workGroupMembers = new MySQLWorkGroupMemberDAO(conn);
        }
        return workGroupMembers;
    }
    
    @Override
    public TaskDAO getTaskDAO() {
        if (tasks == null) {
            tasks = new MySQLTaskDAO(conn);
        }
        return tasks;
    }
    
    public static void main(String[] args) throws SQLException, DAOException {
        MySQLDaoManager daoManager = new MySQLDaoManager("localhost", "project_management_system", "root", "");
        List<User> users = daoManager.getUserDAO().getAll();
        System.out.println(users);
    }

}
