package cl.ricardo.projectManagement.presentation.users;

import cl.ricardo.projectManagement.dataAccess.ProjectMember;
import cl.ricardo.projectManagement.dataAccess.User;
import cl.ricardo.projectManagement.dataAccess.WorkGroupMember;
import cl.ricardo.projectManagement.dataAccess.dao.DAOException;
import cl.ricardo.projectManagement.dataAccess.dao.DAOManager;
import cl.ricardo.projectManagement.presentation.MainScreen;
import cl.ricardo.projectManagement.presentation.Tasks.UserTasks;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UsersList extends javax.swing.JFrame {
    
    private DAOManager manager;
    
    private User user;
    
    private UsersTableModel model;
    
    private MainScreen mainScreen;
    
    public UsersList(DAOManager manager, User user, MainScreen mainScreen) throws DAOException {
        initComponents();
        this.manager = manager;
        this.user = user;
        this.mainScreen = mainScreen;
        this.model = new UsersTableModel(manager.getUserDAO());
        this.model.updateModel();
        this.usersTable.setModel(model);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    public UsersList() {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnDeleteUser = new javax.swing.JButton();
        btnEditUser = new javax.swing.JButton();
        btnTasks = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        usersTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(245, 237, 237));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Lista de usuarios");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 170, 20));

        jPanel2.setBackground(new java.awt.Color(245, 237, 237));

        btnDeleteUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar_usuario.png"))); // NOI18N
        btnDeleteUser.setBorder(null);
        btnDeleteUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteUserMouseClicked(evt);
            }
        });

        btnEditUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        btnEditUser.setBorder(null);
        btnEditUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditUserMouseClicked(evt);
            }
        });

        btnTasks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tareas.png"))); // NOI18N
        btnTasks.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTasks.setPreferredSize(new java.awt.Dimension(35, 35));
        btnTasks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTasksMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEditUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btnDeleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(btnTasks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnDeleteUser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnEditUser, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(btnTasks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 220, 40));

        jScrollPane1.setBackground(new java.awt.Color(245, 237, 237));
        jScrollPane1.setForeground(new java.awt.Color(51, 51, 51));

        usersTable.setBackground(new java.awt.Color(245, 237, 237));
        usersTable.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        usersTable.setForeground(new java.awt.Color(51, 51, 51));
        usersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Email", "Rol"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        usersTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(usersTable);
        if (usersTable.getColumnModel().getColumnCount() > 0) {
            usersTable.getColumnModel().getColumn(0).setPreferredWidth(10);
            usersTable.getColumnModel().getColumn(1).setPreferredWidth(90);
            usersTable.getColumnModel().getColumn(2).setPreferredWidth(90);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 710, 350));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Editar");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 50, -1));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Eliminar");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, -1, -1));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Ver Tareas");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditUserMouseClicked
        if (usersTable.getSelectedRow() >= 0) {
            try {
                editUser();
                UserEdition userEditionScreen = new UserEdition(manager, user, model);
                userEditionScreen.setVisible(true);
                userEditionScreen.setLocationRelativeTo(null);
            } catch (DAOException ex) {
                System.out.println(ex.toString());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
        }
    }//GEN-LAST:event_btnEditUserMouseClicked

    private void editUser() throws DAOException {
        int currentSelectedRow = usersTable.getSelectedRow();
        int userId = (int) usersTable.getValueAt(currentSelectedRow, 0);
        String name = String.valueOf(usersTable.getValueAt(currentSelectedRow, 1));
        String email = String.valueOf(usersTable.getValueAt(currentSelectedRow, 2));
        String role = String.valueOf(usersTable.getValueAt(currentSelectedRow, 3));
        user.setId(userId);
        user.setUserName(name);
        user.setEmail(email);
        user.setRole(role);
    }
    
    private void btnDeleteUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteUserMouseClicked
        int selectedRow = usersTable.getSelectedRow();
        if (selectedRow >= 0) {
            int question = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar este usuario?");
            if (question == 0) {
                try {
                    int userId = Integer.parseInt(usersTable.getValueAt(selectedRow, 0).toString());
                    List<WorkGroupMember> wgMembers = manager.getWorkGroupMemberDAO().getMembersByUserId(userId);
                    List<ProjectMember> projectMembers = manager.getProjectMemberDAO().getMembersByUserId(userId);
                    if (wgMembers.isEmpty() && projectMembers.isEmpty()) {
                        deleteUser();
                    } else if (wgMembers.isEmpty() && !projectMembers.isEmpty()) {
                        deleteUserOnProjectsMembers();
                        deleteUser();
                    } else if (!wgMembers.isEmpty() && projectMembers.isEmpty()) {
                        deleteUserOnWorkgroupsMembers();
                        deleteUser();
                    } else {
                        deleteUserOnWorkgroupsMembers();
                        deleteUserOnProjectsMembers();
                        deleteUser();
                    }
                    JOptionPane.showMessageDialog(null, "Usuario eliminado con éxito");
                    model.updateModel();
                    model.fireTableDataChanged();
                } catch (DAOException ex) {
                    System.out.println(ex.toString());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
        }
    }//GEN-LAST:event_btnDeleteUserMouseClicked

    private void deleteUserOnWorkgroupsMembers() throws DAOException {
        int selectedRow = usersTable.getSelectedRow();
        int userId = Integer.parseInt(usersTable.getValueAt(selectedRow, 0).toString());
        manager.getWorkGroupMemberDAO().deleteByUserId(userId);
    }
    
    private void deleteUserOnProjectsMembers() throws DAOException {
        int selectedRow = usersTable.getSelectedRow();
        int userId = Integer.parseInt(usersTable.getValueAt(selectedRow, 0).toString());
        manager.getProjectMemberDAO().deleteByUserId(userId);
    }
    
    private void deleteUser() throws DAOException {
        int currentSelectedRow = usersTable.getSelectedRow();
        int userId = (int) usersTable.getValueAt(currentSelectedRow, 0);
        manager.getUserDAO().delete(userId);
    }
    
    private void btnTasksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTasksMouseClicked
        int selectedRow = usersTable.getSelectedRow();
        int userId = Integer.parseInt(usersTable.getValueAt(selectedRow, 0).toString());
        UserTasks userTasks;
        try {
            userTasks = new UserTasks(manager, mainScreen, userId);
            userTasks.setVisible(true);
            userTasks.setLocationRelativeTo(null);
        } catch (DAOException ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_btnTasksMouseClicked
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteUser;
    private javax.swing.JButton btnEditUser;
    private javax.swing.JButton btnTasks;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable usersTable;
    // End of variables declaration//GEN-END:variables
}
