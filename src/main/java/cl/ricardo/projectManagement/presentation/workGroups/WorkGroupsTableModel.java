package cl.ricardo.projectManagement.presentation.workGroups;

import cl.ricardo.projectManagement.dataAccess.WorkGroup;
import cl.ricardo.projectManagement.dataAccess.dao.DAOException;
import cl.ricardo.projectManagement.dataAccess.dao.ProjectDAO;
import cl.ricardo.projectManagement.dataAccess.dao.UserDAO;
import cl.ricardo.projectManagement.dataAccess.dao.WorkGroupDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

class WorkGroupsTableModel extends AbstractTableModel {

    private WorkGroupDAO workGroups;
    
    private ProjectDAO projects;
    
    private UserDAO users;
    
    private List<WorkGroup> data = new ArrayList<>();
    
    public WorkGroupsTableModel(WorkGroupDAO workGroups, ProjectDAO projects, UserDAO users) 
            throws DAOException {
        this.workGroups = workGroups;
        this.projects = projects;
        this.users = users;
    }
    
    public void updateModel(String action, int projectId) throws DAOException {
        switch (action) {
            case "ALL":
                data = workGroups.getAll();
            case "BY_PROJECT":
                data = workGroups.getGroupsByProject(projectId);
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 -> "ID";
            case 1 -> "NOMBRE PROYECTO";
            case 2 -> "NOMBRE EQUIPO";
            case 3 -> "LIDER";
            case 4 -> "FECHA CREACION";
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
        WorkGroup asked = data.get(rowIndex);
        int projectId = asked.getProjectId();
        int leaderId = asked.getLeaderId();
        try {
            return switch (columnIndex) {
                case 0 -> asked.getId();
                case 1 -> projects.getElement(projectId).getName();
                case 2 -> asked.getName();
                case 3 -> users.getElement(leaderId).getUserName();
                case 4 -> asked.getCreatedAt();
                default -> "";
            };
        } catch (DAOException ex) {
            System.out.println(ex.toString());
            return "null";
        }
    }
    
}
