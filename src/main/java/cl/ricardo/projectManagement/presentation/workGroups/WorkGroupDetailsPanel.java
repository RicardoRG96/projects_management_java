package cl.ricardo.projectManagement.presentation.workGroups;

import cl.ricardo.projectManagement.dataAccess.Project;
import cl.ricardo.projectManagement.dataAccess.ProjectMember;
import cl.ricardo.projectManagement.dataAccess.User;
import cl.ricardo.projectManagement.dataAccess.WorkGroup;
import cl.ricardo.projectManagement.dataAccess.WorkGroupMember;
import cl.ricardo.projectManagement.dataAccess.dao.DAOException;
import cl.ricardo.projectManagement.dataAccess.dao.DAOManager;
import cl.ricardo.projectManagement.dataAccess.dao.ProjectDAO;
import cl.ricardo.projectManagement.dataAccess.dao.UserDAO;
import cl.ricardo.projectManagement.dataAccess.dao.WorkGroupDAO;
import cl.ricardo.projectManagement.presentation.MainScreen;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

public class WorkGroupDetailsPanel extends javax.swing.JFrame {
    
    private String action;
    
    private WorkGroup workGroup;
    
    private DAOManager manager;
    
    private MainScreen mainScreen;

    public WorkGroupDetailsPanel(String action, WorkGroup workGroup, DAOManager manager, MainScreen mainScreen) throws DAOException {
        initComponents();
        this.action = action;
        this.workGroup = workGroup;
        this.manager = manager;
        this.mainScreen = mainScreen;
        listAllProjects();
        listAllUsers();
        loadData();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mainScreen.getWorkGroupsTable().setEnabled(true);
            }
        });
    }
    
    private void loadData() throws DAOException {
        if (this.action.equals("ADD")) {
                cbxProject.setSelectedItem(null);
                txtWorkGroupName.setText("");
                cbxLeader.setSelectedItem(null);
            } else if (this.action.equals("MODIFY")) {
                String projectName = manager
                        .getProjectDAO()
                        .getElement(workGroup.getProjectId())
                        .getName();
                String workGroupName = workGroup.getName();
                String leaderName = manager
                        .getUserDAO()
                        .getElement(workGroup.getLeaderId())
                        .getUserName();

                cbxProject.setSelectedItem(projectName);
                txtWorkGroupName.setText(workGroupName);
                cbxLeader.setSelectedItem(leaderName);
            }
    }
    
    private void listAllUsers() throws DAOException {
        List<User> users = manager.getUserDAO().getAll();
        List<String> usersName = users
                .stream()
                .map(user -> user.getUserName())
                .collect(Collectors.toList());
        usersName
                .stream()
                .forEach(user -> cbxLeader.addItem(user));
    }
    
    private void listAllProjects() throws DAOException {
        List<Project> projects = manager.getProjectDAO().getAll();
        List<String> projectsName = projects
                .stream()
                .map(project -> project.getName())
                .collect(Collectors.toList());
        projectsName
                .stream()
                .forEach(project -> cbxProject.addItem(project));
    }
    
    private void saveData() throws DAOException {
        WorkGroupDAO workGroupDao = manager.getWorkGroupDAO();
        
        String projectName = cbxProject.getSelectedItem().toString();
        String workGroupName = txtWorkGroupName.getText();
        String leaderName = cbxLeader.getSelectedItem().toString();
        int projectId = manager.getProjectDAO().getProjectIdByProjectName(projectName);
        int leaderId = manager.getUserDAO().getUserIdByUserName(leaderName);
        
        workGroup.setProjectId(projectId);
        workGroup.setName(workGroupName);
        workGroup.setLeaderId(leaderId);
        
        if (this.action.equals("ADD")) {
            workGroupDao.insert(workGroup);
        }
        else if (this.action.equals("MODIFY")) {
            workGroupDao.update(workGroup);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbxProject = new javax.swing.JComboBox<>();
        txtWorkGroupName = new javax.swing.JTextField();
        cbxLeader = new javax.swing.JComboBox<>();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(245, 237, 237));

        jLabel4.setBackground(new java.awt.Color(245, 237, 237));
        jLabel4.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Detalles del Equipo");

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Proyecto asignado:");

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Nombre equipo:");

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Lider:");

        cbxProject.setBackground(new java.awt.Color(245, 237, 237));
        cbxProject.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        cbxProject.setForeground(new java.awt.Color(51, 51, 51));
        cbxProject.setMaximumRowCount(30);
        cbxProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProjectActionPerformed(evt);
            }
        });

        txtWorkGroupName.setBackground(new java.awt.Color(245, 237, 237));
        txtWorkGroupName.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        cbxLeader.setBackground(new java.awt.Color(245, 237, 237));
        cbxLeader.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        cbxLeader.setForeground(new java.awt.Color(51, 51, 51));
        cbxLeader.setMaximumRowCount(50);
        cbxLeader.setToolTipText("");
        cbxLeader.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxLeaderActionPerformed(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(245, 237, 237));
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/guardar.png"))); // NOI18N
        btnSave.setBorder(null);
        btnSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSaveMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxProject, 0, 230, Short.MAX_VALUE)
                            .addComponent(txtWorkGroupName)
                            .addComponent(cbxLeader, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(btnSave)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 131, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel4)
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbxProject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtWorkGroupName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(cbxLeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(btnSave)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxProjectActionPerformed

    private void cbxLeaderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxLeaderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxLeaderActionPerformed

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        if (!"".equals(txtWorkGroupName.getText()) &&
            cbxProject.getSelectedItem() != null &&
            cbxLeader.getSelectedItem() != null
        ) {
            try {
                int question = JOptionPane.showConfirmDialog(null,
                    "¿Está seguro que los datos están correctos?");
                if (question == 0) {
                    String workGroupName = txtWorkGroupName.getText();
                    String projectName = cbxProject.getSelectedItem().toString();
                    int projectId = manager.getProjectDAO().getProjectIdByProjectName(projectName);
                    List<WorkGroup> workGroups = manager
                            .getWorkGroupDAO()
                            .getGroupsByNameAndProjectId(workGroupName, projectId);
                    if (workGroups.isEmpty()) {
                        deletePreviousLeaderFromWorkGroupsMembers();
                        deletePreviousLeaderFromProjectMembers();
                        saveData();
                        addAllWorkGroupMembersToProjectMembers();
                        addWorkGroupLeaderToWorkGroupMembers(workGroupName);
                        addWorkGroupLeaderToProjectsMembers();
                        mainScreen.getWorkGroupsTableModel().updateModel();
                        mainScreen.getWorkGroupsTableModel().fireTableDataChanged();
                        JOptionPane.showMessageDialog(null, "Datos guardados con éxito");
                        mainScreen.loadTablesElementsCount();
                        setVisible(false);
                        mainScreen.getWorkGroupsTable().setEnabled(true);
                    } else {
                        int confirmation = JOptionPane.showConfirmDialog(null, 
                                "Este nombre de equipo ya existe en el proyecto seleccionado, ¿Está seguro que desea guardar?");
                        if (confirmation == 0) {
                            deletePreviousLeaderFromWorkGroupsMembers();
                            deletePreviousLeaderFromProjectMembers();
                            saveData();
                            addAllWorkGroupMembersToProjectMembers();
                            addWorkGroupLeaderToWorkGroupMembers(workGroupName);
                            addWorkGroupLeaderToProjectsMembers();
                            mainScreen.getWorkGroupsTableModel().updateModel();
                            mainScreen.getWorkGroupsTableModel().fireTableDataChanged();
                            JOptionPane.showMessageDialog(null, "Datos guardados con éxito");
                            mainScreen.loadTablesElementsCount();
                            setVisible(false);
                            mainScreen.getWorkGroupsTable().setEnabled(true);
                        }
                    }
                }
                mainScreen.getWorkGroupsTable().setEnabled(true);
            } catch (DAOException ex) {
                System.out.println(ex.toString());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos");
        }
    }//GEN-LAST:event_btnSaveMouseClicked

    private void deletePreviousLeaderFromWorkGroupsMembers() throws DAOException {
        int selectedRow = mainScreen.getWorkGroupsTable().getSelectedRow();
        String leaderName = mainScreen.getWorkGroupsTable().getValueAt(selectedRow, 3).toString();
        int leaderId = manager.getUserDAO().getUserIdByUserName(leaderName);
        int workgroupId = Integer.parseInt(mainScreen.getWorkGroupsTable().getValueAt(selectedRow, 0).toString());
        
        manager.getWorkGroupMemberDAO().deleteByUserIdAndWorkGroupId(leaderId, workgroupId);
    }
    
    private void deletePreviousLeaderFromProjectMembers() throws DAOException {
        int selectedRow = mainScreen.getWorkGroupsTable().getSelectedRow();
        String leaderName = mainScreen.getWorkGroupsTable().getValueAt(selectedRow, 3).toString();
        int leaderId = manager.getUserDAO().getUserIdByUserName(leaderName);
        String projectName = mainScreen.getWorkGroupsTable().getValueAt(selectedRow, 1).toString();
        int projectId = manager.getProjectDAO().getProjectIdByProjectName(projectName);
        
        manager.getProjectMemberDAO().deleteByUserIdAndProjectId(leaderId, projectId);
    }
    
    private void addAllWorkGroupMembersToProjectMembers() throws DAOException {
        String selectedProjectName = cbxProject.getSelectedItem().toString();
        int selectedProjectId = manager.getProjectDAO().getProjectIdByProjectName(selectedProjectName);
        int selectedRow = mainScreen.getWorkGroupsTable().getSelectedRow();
        String previousProjectName = mainScreen.getWorkGroupsTable().getValueAt(selectedRow, 1).toString();
        int previousProjectId = manager.getProjectDAO().getProjectIdByProjectName(previousProjectName);
        
        if (selectedProjectId != previousProjectId) {
            int workGroupId = 
                    Integer.parseInt(mainScreen.getWorkGroupsTable().getValueAt(selectedRow, 0).toString());
            List<Integer> usersId = manager
                    .getWorkGroupMemberDAO()
                    .getMembersByWorkGroupId(workGroupId)
                    .stream()
                    .map(member -> member.getUserId())
                    .collect(Collectors.toList());
            for (int userId : usersId) {
                manager
                    .getProjectMemberDAO()
                    .updateByUserIdAndProjectId(userId, previousProjectId, selectedProjectId);
            }
        }
    }
    
    private void addWorkGroupLeaderToWorkGroupMembers(String workGroupName) throws DAOException {
        String leaderName = cbxLeader.getSelectedItem().toString();
        int leaderId = manager.getUserDAO().getUserIdByUserName(leaderName);
        int workGroupId = manager.getWorkGroupDAO().getWorkGroupIdByName(workGroupName);
        
        boolean validateIfLeaderDoesNotExistsInWorkGroupsMembers = 
                manager.getWorkGroupMemberDAO().getMembersByWorkGroupAndUserId(workGroupId, leaderId).isEmpty();
        
        if (validateIfLeaderDoesNotExistsInWorkGroupsMembers) {
            WorkGroupMember member = new WorkGroupMember();
            member.setUserId(leaderId);
            member.setWorkGroupId(workGroupId);
            manager.getWorkGroupMemberDAO().insert(member);
        }
    }
    
    private void addWorkGroupLeaderToProjectsMembers() throws DAOException {
        String projectName = cbxProject.getSelectedItem().toString();
        String leaderName = cbxLeader.getSelectedItem().toString();
        int leaderId = manager.getUserDAO().getUserIdByUserName(leaderName);
        int projectId = manager.getProjectDAO().getProjectIdByProjectName(projectName);
        
        boolean validateIfLeaderDoesNotExistsInProjectMembers = 
                manager.getProjectMemberDAO().getMemberByProjectAndUserId(projectId, leaderId).isEmpty();
        
        if (validateIfLeaderDoesNotExistsInProjectMembers) {
            String leaderRole = manager.getUserDAO().getElement(leaderId).getRole();
            ProjectMember member = new ProjectMember(leaderRole);
            member.setUserId(leaderId);
            member.setProjectId(projectId);
            manager.getProjectMemberDAO().insert(member);
        }
    }
    
    private void btnSaveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveMouseEntered

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbxLeader;
    private javax.swing.JComboBox<String> cbxProject;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtWorkGroupName;
    // End of variables declaration//GEN-END:variables
}
