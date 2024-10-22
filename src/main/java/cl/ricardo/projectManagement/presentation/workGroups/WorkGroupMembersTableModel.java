package cl.ricardo.projectManagement.presentation.workGroups;

import cl.ricardo.projectManagement.dataAccess.WorkGroupMember;
import cl.ricardo.projectManagement.dataAccess.dao.DAOException;
import cl.ricardo.projectManagement.dataAccess.dao.UserDAO;
import cl.ricardo.projectManagement.dataAccess.dao.WorkGroupDAO;
import cl.ricardo.projectManagement.dataAccess.dao.WorkGroupMemberDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class WorkGroupMembersTableModel extends AbstractTableModel {
    
    private WorkGroupMemberDAO wgMembers;
    
    private UserDAO users;
    
    private WorkGroupDAO workGroups;
    
    private List<WorkGroupMember> data = new ArrayList<>();
    
    public WorkGroupMembersTableModel(
            WorkGroupMemberDAO wgMembers,
            WorkGroupDAO workGroups,
            UserDAO users
    ) {
        this.wgMembers = wgMembers;
        this.workGroups = workGroups;
        this.users = users;
    }
    
    public void updateModel(int workGroupId) throws DAOException {
        data = wgMembers.getMembersByWorkGroupId(workGroupId);
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 -> "ID";
            case 1 -> "NOMBRE INTEGRANTE";
            case 2 -> "NOMBRE GRUPO";
            case 3 -> "FECHA INTEGRACION";
            default -> "[no]";
        };
    }
    
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        WorkGroupMember asked = data.get(rowIndex);
        int userId = asked.getUserId();
        int workGroupId = asked.getWorkGroupId();
        try {
            return switch (columnIndex) {
                case 0 -> asked.getId();
                case 1 -> users.getElement(userId).getUserName();
                case 2 -> workGroups.getElement(workGroupId).getName();
                case 3 -> "FECHA INTEGRACION";
                default -> "";
            };
        } catch (DAOException ex) {
            System.out.println(ex.toString());
            return "null";
        }
    }
    
}
