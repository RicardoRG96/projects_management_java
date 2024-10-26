package cl.ricardo.projectManagement.presentation.Tasks;

import cl.ricardo.projectManagement.dataAccess.Task;
import cl.ricardo.projectManagement.dataAccess.dao.DAOException;
import cl.ricardo.projectManagement.dataAccess.dao.ProjectDAO;
import cl.ricardo.projectManagement.dataAccess.dao.TaskDAO;
import cl.ricardo.projectManagement.dataAccess.dao.UserDAO;
import cl.ricardo.projectManagement.dataAccess.dao.WorkGroupDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class UserTasksTableModel extends AbstractTableModel {
    
    private TaskDAO Tasks;
    
    private ProjectDAO projects;
    
    private WorkGroupDAO workGroups;
    
    private UserDAO users;
    
    private int userId;
    
    private List<Task> data = new ArrayList<>();
    
    public UserTasksTableModel(
            TaskDAO tasks, 
            ProjectDAO projects, 
            WorkGroupDAO workGroups, 
            UserDAO users, 
            int userId
    ) {
        this.Tasks = tasks;
        this.projects = projects;
        this.workGroups = workGroups;
        this.users = users;
        this.userId = userId;
    }

    public void updateModel() throws DAOException {
        data = Tasks.getUserTasks(userId);
    }
    
    @Override
    public String getColumnName(int column) {
        return switch(column) {
            case 0 -> "ID";
            case 1 -> "PROYECTO";
            case 2 -> "EQUIPO";
            case 3 -> "NOMBRE";
            case 4 -> "DESCRIPCION";
            case 5 -> "STATUS";
            case 6 -> "PRIORIDAD";
            case 7 -> "FECHA LIMITE";
            case 8 -> "ASIGNADO A";
            case 9 -> "FECHA CREACION";
            case 10 -> "FECHA ACTUALIZACION";
            default -> "[no]";
        };
    }
    
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 11;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            Task asked = data.get(rowIndex);
            Integer projectId = asked.getProjectId();
            Integer workGroupId = asked.getWorkGroupId();
            Integer userId = asked.getAssignedTo();
            return switch(columnIndex) {
                case 0 -> asked.getId();
                case 1 -> projectId == null ? "No asignado" : projects.getElement(projectId).getName();
                case 2 -> workGroupId == null ? "No asignado" : workGroups.getElement(workGroupId).getName();
                case 3 -> asked.getTitle();
                case 4 -> asked.getDescription();
                case 5 -> asked.getStatus();
                case 6 -> asked.getPriority();
                case 7 -> asked.getDueDate().toString();
                case 8 -> userId == null ? "No asignado" : users.getElement(userId).getUserName();
                case 9 -> asked.getCreatedAt();
                case 10 -> asked.getUpdatedAt();
                default -> "";
            };
        } catch (DAOException ex) {
            System.out.println(ex.toString());
            return "null";
        }
    }
}
