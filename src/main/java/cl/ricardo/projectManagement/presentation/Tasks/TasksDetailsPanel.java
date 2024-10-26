package cl.ricardo.projectManagement.presentation.Tasks;

import cl.ricardo.projectManagement.dataAccess.Project;
import cl.ricardo.projectManagement.dataAccess.Task;
import cl.ricardo.projectManagement.dataAccess.User;
import cl.ricardo.projectManagement.dataAccess.WorkGroup;
import cl.ricardo.projectManagement.dataAccess.dao.DAOException;
import cl.ricardo.projectManagement.dataAccess.dao.DAOManager;
import cl.ricardo.projectManagement.presentation.MainScreen;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class TasksDetailsPanel extends javax.swing.JFrame {
    
    private String action;
    
    private Task task;
    
    private DAOManager manager;
    
    private MainScreen mainScreen;
    
    public TasksDetailsPanel(String action, Task task, DAOManager manager, MainScreen mainScreen) 
            throws DAOException {
        initComponents();
        this.action = action;
        this.task = task;
        this.manager = manager;
        this.mainScreen = mainScreen;
        this.listAllProjects();
        this.listAllWorkGroups();
        this.listAllUsers();
        this.loadData();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mainScreen.getTasksTable().setEnabled(true);
            }
        });
    }   
    
    public TasksDetailsPanel() {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mainScreen.getTasksTable().setEnabled(true);
            }
        });
    }
    
    private void loadData() throws DAOException {
        if (this.action.equals("ADD")) {
            cbxProject.setSelectedItem(null);
            cbxTeam.setSelectedItem(null);
            txtTaskName.setText("");
            txtTaskDescription.setText("");
            cbxStatus.setSelectedItem(null);
            jDateChooserDueDate.setDate(new Date());
            cbxAssignedTo.setSelectedItem(null);
        } else if (this.action.equals("MODIFY")) {
            Object projectName = task.getProjectId() == null 
                    ? "No asignado" 
                    : (Object) manager
                        .getProjectDAO()
                        .getElement(task.getProjectId())
                        .getName();
            Object workGroupName = task.getWorkGroupId() == null 
                    ? "No asignado" 
                    : (Object) manager
                        .getWorkGroupDAO()
                        .getElement(task.getWorkGroupId())
                        .getName();
            String taskName = task.getTitle();
            String taskDescription = task.getDescription();
            Object taskStatus = (Object) task.getStatus();
            Object taskPriority = (Object) task.getPriority();
            ZoneId defaultZoneId = ZoneId.systemDefault();
            LocalDate taskDueDate = task.getDueDate();
            Date formatedDueDate = Date.from(taskDueDate.atStartOfDay(defaultZoneId).toInstant());
            Object assignedTo = task.getAssignedTo() == null 
                    ? "No asignado" 
                    : (Object) manager
                        .getUserDAO()
                        .getElement(task.getAssignedTo())
                        .getUserName();
            
            cbxProject.setSelectedItem(projectName);
            cbxTeam.setSelectedItem(workGroupName);
            txtTaskName.setText(taskName);
            txtTaskDescription.setText(taskDescription);
            cbxStatus.setSelectedItem(taskStatus);
            cbxPriority.setSelectedItem(taskPriority);
            jDateChooserDueDate.setDate(formatedDueDate);
            cbxAssignedTo.setSelectedItem(assignedTo);
        }
    }
    
    private void listAllProjects() throws DAOException {
        List<Project> projects = manager.getProjectDAO().getAll();
        cbxProject.addItem("No asignado");
        projects
                .stream()
                .forEach(project -> cbxProject.addItem(project.getName()));
    }
    
    private void listAllWorkGroups() throws DAOException {
        List<WorkGroup> workGroups = manager.getWorkGroupDAO().getAll();
        cbxTeam.addItem("No asignado");
        workGroups
                .stream()
                .forEach(workGroup -> cbxTeam.addItem(workGroup.getName()));
    }
    
    private void listAllUsers() throws DAOException {
        List<User> users = manager.getUserDAO().getAll();
        cbxAssignedTo.addItem("No asignado");
        users
            .stream()
            .forEach(user -> cbxAssignedTo.addItem(user.getUserName()));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        cbxProject = new javax.swing.JComboBox<>();
        cbxTeam = new javax.swing.JComboBox<>();
        txtTaskName = new javax.swing.JTextField();
        txtTaskDescription = new javax.swing.JTextField();
        cbxStatus = new javax.swing.JComboBox<>();
        cbxPriority = new javax.swing.JComboBox<>();
        cbxAssignedTo = new javax.swing.JComboBox<>();
        jDateChooserDueDate = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(245, 237, 237));

        jLabel1.setBackground(new java.awt.Color(245, 237, 237));
        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Detalles de Tarea");

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Proyecto:");

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Equipo:");

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Nombre: ");

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Descripcion: ");

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Estado:");

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Prioridad: ");

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Fecha Límite:");

        jLabel9.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Asignado a:");

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/guardar.png"))); // NOI18N
        btnSave.setBorder(null);
        btnSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
        });

        cbxProject.setBackground(new java.awt.Color(255, 255, 255));
        cbxProject.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        cbxProject.setForeground(new java.awt.Color(51, 51, 51));
        cbxProject.setBorder(null);

        cbxTeam.setBackground(new java.awt.Color(255, 255, 255));
        cbxTeam.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        cbxTeam.setForeground(new java.awt.Color(51, 51, 51));

        txtTaskName.setBackground(new java.awt.Color(255, 255, 255));
        txtTaskName.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtTaskName.setForeground(new java.awt.Color(51, 51, 51));
        txtTaskName.setBorder(null);

        txtTaskDescription.setBackground(new java.awt.Color(255, 255, 255));
        txtTaskDescription.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtTaskDescription.setForeground(new java.awt.Color(51, 51, 51));
        txtTaskDescription.setBorder(null);

        cbxStatus.setBackground(new java.awt.Color(255, 255, 255));
        cbxStatus.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        cbxStatus.setForeground(new java.awt.Color(51, 51, 51));
        cbxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendiente", "En Progreso", "Terminada" }));

        cbxPriority.setBackground(new java.awt.Color(255, 255, 255));
        cbxPriority.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        cbxPriority.setForeground(new java.awt.Color(51, 51, 51));
        cbxPriority.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alta", "Media", "Baja" }));

        cbxAssignedTo.setBackground(new java.awt.Color(255, 255, 255));
        cbxAssignedTo.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        cbxAssignedTo.setForeground(new java.awt.Color(51, 51, 51));

        jDateChooserDueDate.setBackground(new java.awt.Color(245, 237, 237));
        jDateChooserDueDate.setForeground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxProject, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxTeam, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTaskName)
                    .addComponent(txtTaskDescription)
                    .addComponent(cbxStatus, 0, 344, Short.MAX_VALUE)
                    .addComponent(cbxPriority, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxAssignedTo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooserDueDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(205, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(187, 187, 187))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addGap(248, 248, 248))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(cbxProject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addComponent(jLabel3))
                            .addComponent(cbxTeam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtTaskName, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtTaskDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cbxPriority, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(jLabel8))
                    .addComponent(jDateChooserDueDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cbxAssignedTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(btnSave)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        if (checkIfAllFieldsWereFilled()) {
            try {
                int question = JOptionPane.showConfirmDialog(null, "¿Está seguro que los datos están correctos?");
                if (question == 0) {
                    saveData();
                    mainScreen.getTasksTableModel().updateModel();
                    mainScreen.getTasksTableModel().fireTableDataChanged();
                    JOptionPane.showMessageDialog(null, "Datos guardados con éxito");
                    setVisible(false);
                }
                mainScreen.getTasksTable().setEnabled(true);
            } catch (DAOException ex) {
                System.out.println(ex.toString());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos");
        }
    }//GEN-LAST:event_btnSaveMouseClicked

    private boolean checkIfAllFieldsWereFilled() {
        return cbxProject.getSelectedItem() != null &&
                cbxTeam.getSelectedItem() != null &&
                !txtTaskName.getText().equals("") &&
                !txtTaskDescription.getText().equals("") &&
                cbxStatus.getSelectedItem() != null &&
                cbxPriority.getSelectedItem() != null &&
                jDateChooserDueDate.getDate() != null &&
                cbxAssignedTo.getSelectedItem() != null;
    }
    
    private void saveData() throws DAOException {
        int selectedRow = mainScreen.getTasksTable().getSelectedRow();
        int taskId = Integer.parseInt(mainScreen.getTasksTable().getValueAt(selectedRow, 0).toString());
        String projectName = cbxProject.getSelectedItem().toString();
        int projectId = manager.getProjectDAO().getProjectIdByProjectName(projectName);
        String workGroupName = cbxTeam.getSelectedItem().toString();
        int workGroupId = manager.getWorkGroupDAO().getWorkGroupIdByName(workGroupName);
        String taskTitle = txtTaskName.getText();
        String taskDescription = txtTaskDescription.getText();
        String taskStatus = cbxStatus.getSelectedItem().toString();
        String priority = cbxPriority.getSelectedItem().toString();
        LocalDate taskDueDate = jDateChooserDueDate
                        .getDate()
                        .toInstant()
                        .atZone(ZoneId.of("America/Santiago"))
                        .toLocalDate();
        String userName = cbxAssignedTo.getSelectedItem().toString();
        int userId = manager.getUserDAO().getUserIdByUserName(userName);
        
        task.setId(taskId);
        task.setProjectId(projectId);
        task.setWorkGroupId(workGroupId);
        task.setTitle(taskTitle);
        task.setDescription(taskDescription);
        task.setStatus(taskStatus);
        task.setPriority(priority);
        task.setDueDate(taskDueDate);
        task.setAssignedTo(userId);
        
        if (this.action.equals("ADD")) {
            manager.getTaskDAO().insert(task);
        } else if (this.action.equals("MODIFY")) {
            manager.getTaskDAO().update(task);
        }
    }
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TasksDetailsPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbxAssignedTo;
    private javax.swing.JComboBox<String> cbxPriority;
    private javax.swing.JComboBox<String> cbxProject;
    private javax.swing.JComboBox<String> cbxStatus;
    private javax.swing.JComboBox<String> cbxTeam;
    private com.toedter.calendar.JDateChooser jDateChooserDueDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtTaskDescription;
    private javax.swing.JTextField txtTaskName;
    // End of variables declaration//GEN-END:variables
}
