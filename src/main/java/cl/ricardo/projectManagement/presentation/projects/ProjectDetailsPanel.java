package cl.ricardo.projectManagement.presentation.projects;

import cl.ricardo.projectManagement.dataAccess.Project;
import cl.ricardo.projectManagement.dataAccess.ProjectMember;
import cl.ricardo.projectManagement.dataAccess.User;
import cl.ricardo.projectManagement.dataAccess.dao.DAOException;
import cl.ricardo.projectManagement.dataAccess.dao.DAOManager;
import cl.ricardo.projectManagement.dataAccess.dao.ProjectDAO;
import cl.ricardo.projectManagement.presentation.MainScreen;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class ProjectDetailsPanel extends javax.swing.JFrame {

    private String action;
    
    private Project project;
    
    private DAOManager manager;
    
    private MainScreen mainScreen;
    
    public ProjectDetailsPanel(String action, Project project, DAOManager manager, MainScreen mainScreen) 
            throws SQLException, DAOException {
        initComponents();
        this.action = action;
        this.project = project;
        this.manager = manager;
        this.mainScreen = mainScreen;
        this.listAllUsers();
        this.loadData();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
    
    private void loadData() throws DAOException {
        if (this.action.equals("ADD")) {
            txtName.setText("");
            txtDescription.setText("");
            cbxManager.setSelectedItem(null);
        } else if (this.action.equals("MODIFY")){
            String projectName = project.getName();
            String projectDescription = project.getDescription();
            Object projectManagerName =
                    (Object) manager.getUserDAO().getElement(project.getOwnerId()).getUserName();
            txtName.setText(projectName);
            txtDescription.setText(projectDescription);
            cbxManager.setSelectedItem(projectManagerName);
        }
    }
    
    private void listAllUsers() throws DAOException {
        List<User> usersList = manager.getUserDAO().getAll();
        List<String> usersName = usersList
                .stream()
                .map(user -> user.getUserName())
                .collect(Collectors.toList());
        usersName
                .stream()
                .forEach(name -> cbxManager.addItem(name));
    }
    
    public void saveData() throws DAOException {
        ProjectDAO projectDao = manager.getProjectDAO();
        String projectName = txtName.getText();
        String projectDescription = txtDescription.getText();
        String projectManagerName = String.valueOf(cbxManager.getSelectedItem());
        int projectManagerId = manager.getUserDAO().getUserIdByUserName(projectManagerName);
        
        project.setName(projectName);
        project.setDescription(projectDescription);
        project.setOwnerId(projectManagerId);
        
        if (this.action.equals("ADD")) {
            projectDao.insert(project);
        } else if (this.action.equals("MODIFY")) {
            projectDao.update(project);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtDescription = new javax.swing.JTextField();
        cbxManager = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(245, 237, 237));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Nombre:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 84, 67, -1));

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Descripción:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 133, 90, -1));

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Manager:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 180, 65, -1));

        txtName.setBackground(new java.awt.Color(245, 237, 237));
        txtName.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 82, 197, -1));

        txtDescription.setBackground(new java.awt.Color(245, 237, 237));
        txtDescription.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel1.add(txtDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 131, 197, -1));

        cbxManager.setBackground(new java.awt.Color(245, 237, 237));
        cbxManager.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        cbxManager.setForeground(new java.awt.Color(51, 51, 51));
        cbxManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxManagerActionPerformed(evt);
            }
        });
        jPanel1.add(cbxManager, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 178, 197, -1));

        jLabel4.setBackground(new java.awt.Color(245, 237, 237));
        jLabel4.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Detalles de proyecto");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 178, -1));

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
        jPanel1.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxManagerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxManagerActionPerformed

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        if (!"".equals(txtName.getText()) &&
            !"".equals(txtDescription.getText()) &&
            cbxManager.getSelectedItem() != null
        ) {
            try {
                int question = JOptionPane.showConfirmDialog(null, 
                                "¿Está seguro que los datos están correctos?");
                if (question == 0) {
                    String projectName = txtName.getText();
                    List<Project> projects = manager.getProjectDAO().getProjectsByName(projectName);
                    if (projects.isEmpty()) {
                        saveData();
                        addProjectOwnerToProjectsMembers(projectName);
                        mainScreen.getProjectsTableModel().updateModel();
                        mainScreen.getProjectsTableModel().fireTableDataChanged();
                        JOptionPane.showMessageDialog(null, "Datos guardados con éxito");
                        mainScreen.loadTablesElementsCount();
                        setVisible(false);
                    } else {
                        int confirm = JOptionPane.showConfirmDialog(null, 
                                "Este nombre de proyecto ya existe, ¿está seguro que desea guardar?");
                        if (confirm == 0) {
                            saveData();
                            addProjectOwnerToProjectsMembers(projectName);
                            mainScreen.getProjectsTableModel().updateModel();
                            mainScreen.getProjectsTableModel().fireTableDataChanged();
                            JOptionPane.showMessageDialog(null, "Datos guardados con éxito");
                            mainScreen.loadTablesElementsCount();
                            setVisible(false);
                        }
                    }
                }
            } catch (DAOException ex) {
                System.out.println(ex.toString());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos");
        }
    }//GEN-LAST:event_btnSaveMouseClicked

    private void addProjectOwnerToProjectsMembers(String projectName) throws DAOException {
        String ownerName = cbxManager.getSelectedItem().toString();
        int ownerId = manager.getUserDAO().getUserIdByUserName(ownerName);
        String ownerRole = manager.getUserDAO().getElement(ownerId).getRole();
        int projectId = manager.getProjectDAO().getProjectIdByProjectName(projectName);
        ProjectMember member = new ProjectMember(ownerRole);
        member.setUserId(ownerId);
        member.setProjectId(projectId);
        manager.getProjectMemberDAO().insert(member);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbxManager;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
