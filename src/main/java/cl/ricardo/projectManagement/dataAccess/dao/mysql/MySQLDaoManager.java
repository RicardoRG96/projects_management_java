package cl.ricardo.projectManagement.dataAccess.dao.mysql;

import cl.ricardo.projectManagement.dataAccess.User;
import cl.ricardo.projectManagement.dataAccess.dao.DAOException;
import cl.ricardo.projectManagement.dataAccess.dao.DAOManager;
import cl.ricardo.projectManagement.dataAccess.dao.ProjectDAO;
import cl.ricardo.projectManagement.dataAccess.dao.ProjectMemberDAO;
import cl.ricardo.projectManagement.dataAccess.dao.UserDAO;
import cl.ricardo.projectManagement.dataAccess.dao.WorkGroupDAO;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.List;

public class MySQLDaoManager implements DAOManager {
    
    private Connection conn;
    
    private UserDAO users = null;
    
    private ProjectDAO projects = null;
    
    private WorkGroupDAO workGroups = null;
    
    private ProjectMemberDAO projectMemebers = null;
    
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
    
    public static void main(String[] args) throws SQLException, DAOException {
        MySQLDaoManager daoManager = new MySQLDaoManager("localhost", "project_management_system", "root", "");
        List<User> users = daoManager.getUserDAO().getAll();
        System.out.println(users);
    }

    @Override
    public ProjectMemberDAO getProjectMemberDAO() {
        if (projectMemebers == null) {
            projectMemebers = new MySQLProjectMemeberDAO(conn);
        }
        return projectMemebers;
    }

}
