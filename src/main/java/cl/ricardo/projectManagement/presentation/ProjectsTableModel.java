package cl.ricardo.projectManagement.presentation;

import cl.ricardo.projectManagement.dataAccess.Project;
import cl.ricardo.projectManagement.dataAccess.dao.DAOException;
import cl.ricardo.projectManagement.dataAccess.dao.ProjectDAO;
import cl.ricardo.projectManagement.dataAccess.dao.UserDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ProjectsTableModel extends AbstractTableModel {
    
    private ProjectDAO projects;
    
    private UserDAO users;
    
    private List<Project> data = new ArrayList<>();
    
    public ProjectsTableModel(ProjectDAO projects, UserDAO users) {
        this.projects = projects;
        this.users = users;
    }
    
    public void updateModel() throws DAOException {
        data = projects.getAll();
    }
    
    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 -> "ID";
            case 1 -> "Nombre";
            case 2 -> "Descripción";
            case 3 -> "Manager";
            case 4 -> "Fecha de creación";
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
        Project askedProject = data.get(rowIndex);
        int managerId = askedProject.getOwnerId();
        try {
            return switch (columnIndex) {
                case 0 -> askedProject.getId();
                case 1 -> askedProject.getName();
                case 2 -> askedProject.getDescription();
                case 3 -> users.getElement(managerId).getUserName();
                case 4 -> askedProject.getCreatedAt();
                default -> "";
            };
        } catch (DAOException ex) {
            System.out.println(ex.toString());
            return "null";
        }
    }
    
}
