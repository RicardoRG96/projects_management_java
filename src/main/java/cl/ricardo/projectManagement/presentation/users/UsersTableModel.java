package cl.ricardo.projectManagement.presentation.users;

import cl.ricardo.projectManagement.dataAccess.User;
import cl.ricardo.projectManagement.dataAccess.dao.DAOException;
import cl.ricardo.projectManagement.dataAccess.dao.UserDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class UsersTableModel extends AbstractTableModel {
    
    private UserDAO users;
    
    private List<User> data = new ArrayList<>();
    
    public UsersTableModel(UserDAO users) {
        this.users = users;
    }

    public void updateModel() throws DAOException {
        data = users.getAll();
    }
    
    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 -> "ID";
            case 1 -> "Name";
            case 2 -> "Email";
            case 3 -> "Rol";
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
        User userAsked = data.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> userAsked.getId();
            case 1 -> userAsked.getUserName();
            case 2 -> userAsked.getEmail();
            case 3 -> userAsked.getRole();
            default -> "";
        };
 
    }
    
}
