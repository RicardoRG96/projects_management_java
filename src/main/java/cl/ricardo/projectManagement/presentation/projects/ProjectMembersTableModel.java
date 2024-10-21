package cl.ricardo.projectManagement.presentation.projects;

import cl.ricardo.projectManagement.dataAccess.ProjectMember;
import cl.ricardo.projectManagement.dataAccess.dao.DAOException;
import cl.ricardo.projectManagement.dataAccess.dao.ProjectDAO;
import cl.ricardo.projectManagement.dataAccess.dao.ProjectMemberDAO;
import cl.ricardo.projectManagement.dataAccess.dao.UserDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ProjectMembersTableModel extends AbstractTableModel {
    
    private ProjectMemberDAO projectMembers;
    
    private UserDAO users;
    
    private ProjectDAO projects;
    
    private List<ProjectMember> data = new ArrayList<>();
    
    public ProjectMembersTableModel(ProjectMemberDAO projectMembers, UserDAO users, ProjectDAO projects) {
        this.projectMembers = projectMembers;
        this.users = users;
        this.projects = projects;
    }
    
    public void updateModel(int projectId) throws DAOException {
        data = projectMembers.getMembersByProjectId(projectId);
    }
    
    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 -> "ID";
            case 1 -> "Nombre Proyecto";
            case 2 -> "Nombre Usuario";
            case 3 -> "Rol";
            case 4 -> "Fecha Integración";
            default -> "[no]";
        };
    }
    
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ProjectMember askedMember = data.get(rowIndex);
        int projectId = askedMember.getProjectId();
        int userId = askedMember.getUserId();
        try {
            return switch (columnIndex) {
                case 0 -> askedMember.getId();
                case 1 -> projects.getElement(projectId).getName();
                case 2 -> users.getElement(userId).getUserName();
                case 3 -> askedMember.getRole();
                case 4 -> askedMember.getJoinedAt();
                default -> "";
            };
        } catch (DAOException ex) {
            System.out.println(ex.toString());
            return "null";
        }
    }
}
