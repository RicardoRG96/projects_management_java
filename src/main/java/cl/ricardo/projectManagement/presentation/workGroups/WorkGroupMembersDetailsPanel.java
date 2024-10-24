package cl.ricardo.projectManagement.presentation.workGroups;

import cl.ricardo.projectManagement.dataAccess.ProjectMember;
import cl.ricardo.projectManagement.dataAccess.User;
import cl.ricardo.projectManagement.dataAccess.WorkGroupMember;
import cl.ricardo.projectManagement.dataAccess.dao.DAOException;
import cl.ricardo.projectManagement.dataAccess.dao.DAOManager;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

public class WorkGroupMembersDetailsPanel extends javax.swing.JFrame {
    
    private DAOManager manager;
    
    private WorkGroupMember workGroupMember;
    
    private WorkGroupMembersTableModel wgMembersTableModel;
    
    private int workGroupId;
    
    private int projectId;

    public WorkGroupMembersDetailsPanel(
            DAOManager manager, 
            WorkGroupMember workGroupMember, 
            WorkGroupMembersTableModel wgMembersTableModel,
            int workGroupId,
            int projectId
    ) throws DAOException {
        initComponents();
        this.manager = manager;
        this.workGroupMember = workGroupMember;
        this.wgMembersTableModel = wgMembersTableModel;
        this.workGroupId = workGroupId;
        this.projectId = projectId;
        this.listAllUsers();
        this.listGroupName();
        this.loadData();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    private void loadData() throws DAOException {
        Object workGroupName = (Object) manager.getWorkGroupDAO().getElement(this.workGroupId).getName();
        cbxMemberName.setSelectedItem(null);
        cbxWorkGroupName.setSelectedItem(workGroupName);
    }
    
    private void listGroupName() throws DAOException {
        String workGroupName = manager.getWorkGroupDAO().getElement(this.workGroupId).getName();
        cbxWorkGroupName.addItem(workGroupName);
    }
    
    private void listAllUsers() throws DAOException {
        List<User> users = manager.getUserDAO().getAll();
        List<String> usersName = users
                .stream()
                .map(user -> user.getUserName())
                .collect(Collectors.toList());
        usersName.stream().forEach(userName -> cbxMemberName.addItem(userName));
    }
    
    private void saveData() throws DAOException {
        String userName = cbxMemberName.getSelectedItem().toString();
        int userId = manager.getUserDAO().getUserIdByUserName(userName);
        String workGroupName = cbxWorkGroupName.getSelectedItem().toString();
        int workGroupId = manager.getWorkGroupDAO().getWorkGroupIdByName(workGroupName);
        
        workGroupMember.setUserId(userId);
        workGroupMember.setWorkGroupId(workGroupId);
        manager.getWorkGroupMemberDAO().insert(workGroupMember);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cbxWorkGroupName = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbxMemberName = new javax.swing.JComboBox<>();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(430, 317));

        jPanel1.setBackground(new java.awt.Color(245, 237, 237));

        jLabel4.setBackground(new java.awt.Color(245, 237, 237));
        jLabel4.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Detalles del integrante");

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Grupo:");

        cbxWorkGroupName.setBackground(new java.awt.Color(245, 237, 237));
        cbxWorkGroupName.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        cbxWorkGroupName.setForeground(new java.awt.Color(51, 51, 51));
        cbxWorkGroupName.setMaximumRowCount(30);
        cbxWorkGroupName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxWorkGroupNameActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Nombre integrante:");

        cbxMemberName.setBackground(new java.awt.Color(245, 237, 237));
        cbxMemberName.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        cbxMemberName.setForeground(new java.awt.Color(51, 51, 51));
        cbxMemberName.setMaximumRowCount(50);
        cbxMemberName.setToolTipText("");
        cbxMemberName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMemberNameActionPerformed(evt);
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
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxWorkGroupName, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxMemberName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addComponent(btnSave)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(cbxMemberName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbxWorkGroupName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(btnSave)
                .addGap(18, 18, 18))
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

    private void cbxWorkGroupNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxWorkGroupNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxWorkGroupNameActionPerformed

    private void cbxMemberNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMemberNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxMemberNameActionPerformed

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        if (cbxMemberName.getSelectedItem() != null &&
            cbxWorkGroupName.getSelectedItem() != null
        ) {
            try {
                int question = JOptionPane.showConfirmDialog(null,
                    "¿Está seguro que los datos están correctos?");
                if (question == 0) {
                    String userName = cbxMemberName.getSelectedItem().toString();
                    int userId = manager.getUserDAO().getUserIdByUserName(userName);
                    List<ProjectMember> projectMembers = manager
                            .getProjectMemberDAO()
                            .getMemberByProjectAndUserId(projectId, userId);
                    List<WorkGroupMember> wgMembers = manager
                            .getWorkGroupMemberDAO()
                            .getMembersByWorkGroupAndUserId(workGroupId, userId);
                    if (projectMembers.isEmpty() && wgMembers.isEmpty()) {
                        saveData();
                        updateProjectMembers();
                        wgMembersTableModel.updateModel(workGroupId);
                        wgMembersTableModel.fireTableDataChanged();
                        JOptionPane.showMessageDialog(null, "Datos guardados con éxito");
                        setVisible(false);
                    } else if (projectMembers.isEmpty() && !wgMembers.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Usuario ya existente en este equipo");
                        updateProjectMembers();
                    } else if (!projectMembers.isEmpty() && wgMembers.isEmpty()) {
                        saveData();
                        wgMembersTableModel.updateModel(workGroupId);
                        wgMembersTableModel.fireTableDataChanged();
                        JOptionPane.showMessageDialog(null, "Datos guardados con éxito");
                        setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario ya existente en este equipo");
                    }
                }
            } catch (DAOException ex) {
                System.out.println(ex.toString());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos");
        }
    }//GEN-LAST:event_btnSaveMouseClicked
    
    private void updateProjectMembers() throws DAOException {
        String userName = cbxMemberName.getSelectedItem().toString();
        int userId = manager.getUserDAO().getUserIdByUserName(userName);
        String userRole = manager
                .getUserDAO()
                .getElement(userId)
                .getRole();
        ProjectMember projectMember = new ProjectMember(userRole);
        projectMember.setUserId(userId);
        projectMember.setProjectId(projectId);
        manager.getProjectMemberDAO().insert(projectMember);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbxMemberName;
    private javax.swing.JComboBox<String> cbxWorkGroupName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
