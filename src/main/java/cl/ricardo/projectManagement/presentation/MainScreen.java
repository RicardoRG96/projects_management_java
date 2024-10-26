package cl.ricardo.projectManagement.presentation;

import cl.ricardo.projectManagement.presentation.projects.ProjectsTableModel;
import cl.ricardo.projectManagement.presentation.projects.ProjectDetailsPanel;
import cl.ricardo.projectManagement.presentation.users.UsersList;
import cl.ricardo.projectManagement.dataAccess.Project;
import cl.ricardo.projectManagement.dataAccess.ProjectMember;
import cl.ricardo.projectManagement.dataAccess.Task;
import cl.ricardo.projectManagement.dataAccess.User;
import cl.ricardo.projectManagement.dataAccess.WorkGroup;
import cl.ricardo.projectManagement.dataAccess.WorkGroupMember;
import cl.ricardo.projectManagement.dataAccess.dao.DAOException;
import cl.ricardo.projectManagement.dataAccess.dao.DAOManager;
import cl.ricardo.projectManagement.dataAccess.dao.mysql.MySQLDaoManager;
import cl.ricardo.projectManagement.presentation.Tasks.TasksDetailsPanel;
import cl.ricardo.projectManagement.presentation.Tasks.TasksTableModel;
import cl.ricardo.projectManagement.presentation.projects.ProjectMembersList;
import cl.ricardo.projectManagement.presentation.workGroups.WorkGroupDetailsPanel;
import cl.ricardo.projectManagement.presentation.workGroups.WorkGroupsMembersList;
import cl.ricardo.projectManagement.presentation.workGroups.WorkGroupsTableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class MainScreen extends javax.swing.JFrame {
    
    private DAOManager manager;
    
    private User user;
    
    private Project project;
    
    private ProjectMember projectMember;
    
    private WorkGroup workGroup;
    
    private WorkGroupMember workGroupMember;
    
    private Task task;
    
    private ProjectsTableModel projectsTableModel;
    
    private WorkGroupsTableModel workGroupsTableModel;
    
    private TasksTableModel tasksTableModel;

    public MainScreen(
            DAOManager manager, 
            User user, 
            Project project, 
            ProjectMember projectMember,
            WorkGroup workGroup,
            WorkGroupMember workGroupMember,
            Task task
    ) throws DAOException {
        initComponents();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        this.manager = manager;
        this.user = user;
        this.project = project;
        this.projectMember = projectMember;
        this.workGroup = workGroup;
        this.workGroupMember = workGroupMember;
        this.task = task;
        this.projectsTableModel = new ProjectsTableModel(manager.getProjectDAO(), manager.getUserDAO());
        this.workGroupsTableModel = new WorkGroupsTableModel(
                manager.getWorkGroupDAO(), 
                manager.getProjectDAO(), 
                manager.getUserDAO()
        );
        this.tasksTableModel = new TasksTableModel(
                manager.getTaskDAO(),
                manager.getProjectDAO(),
                manager.getWorkGroupDAO(),
                manager.getUserDAO()
        );
        projectsTableModel.updateModel();
        projectsTable.setModel(projectsTableModel);
        workGroupsTableModel.updateModel();
        workGroupsTable.setModel(workGroupsTableModel);
        tasksTableModel.updateModel();
        tasksTable.setModel(tasksTableModel);
        loadTablesElementsCount();
         addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                handleClosing();
            }
        });
    }
    
    public MainScreen() {
        initComponents();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        loadTablesElementsCount();
        
         addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                handleClosing();
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        notificationsTab = new javax.swing.JPanel();
        JLabel1 = new javax.swing.JLabel();
        usersTab = new javax.swing.JPanel();
        JLabel2 = new javax.swing.JLabel();
        projectsTab = new javax.swing.JPanel();
        JLabel3 = new javax.swing.JLabel();
        workGroupsTab = new javax.swing.JPanel();
        JLabel4 = new javax.swing.JLabel();
        tasksTab = new javax.swing.JPanel();
        JLabel5 = new javax.swing.JLabel();
        configTab = new javax.swing.JPanel();
        JLabel6 = new javax.swing.JLabel();
        reportsTab = new javax.swing.JPanel();
        JLabel7 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtCurrentUser = new javax.swing.JLabel();
        txtCurrentUserRole = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnRegisterUserAccess = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JPanel = new javax.swing.JPanel();
        btnListAllUsers = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        btnAddProject = new javax.swing.JButton();
        btnEditProject = new javax.swing.JButton();
        btnDeleteProject = new javax.swing.JButton();
        btnSeeTeams = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        projectsTable = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtProjectsTableElementsCount = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        btnAddWorkGroup = new javax.swing.JButton();
        btnEditWorkgroup = new javax.swing.JButton();
        btnDeleteWorkGroup = new javax.swing.JButton();
        btnSeeMembers = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        workGroupsTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtWorkGroupsTableElementsCount = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        btnAddTask = new javax.swing.JButton();
        btnEditTask = new javax.swing.JButton();
        btnDeleteTask = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tasksTable = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtTasksTableElementsCount = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(100, 130, 173));

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 507));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(100, 130, 173));
        jPanel2.setForeground(new java.awt.Color(245, 237, 237));

        notificationsTab.setBackground(new java.awt.Color(100, 130, 173));
        notificationsTab.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        notificationsTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                notificationsTabMouseClicked(evt);
            }
        });

        JLabel1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        JLabel1.setForeground(new java.awt.Color(245, 237, 237));
        JLabel1.setText("Notificaciones");

        javax.swing.GroupLayout notificationsTabLayout = new javax.swing.GroupLayout(notificationsTab);
        notificationsTab.setLayout(notificationsTabLayout);
        notificationsTabLayout.setHorizontalGroup(
            notificationsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(notificationsTabLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(JLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        notificationsTabLayout.setVerticalGroup(
            notificationsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        usersTab.setBackground(new java.awt.Color(100, 130, 173));
        usersTab.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        usersTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usersTabMouseClicked(evt);
            }
        });

        JLabel2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        JLabel2.setForeground(new java.awt.Color(245, 237, 237));
        JLabel2.setText("Usuarios");

        javax.swing.GroupLayout usersTabLayout = new javax.swing.GroupLayout(usersTab);
        usersTab.setLayout(usersTabLayout);
        usersTabLayout.setHorizontalGroup(
            usersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usersTabLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(JLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        usersTabLayout.setVerticalGroup(
            usersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        projectsTab.setBackground(new java.awt.Color(100, 130, 173));
        projectsTab.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        projectsTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                projectsTabMouseClicked(evt);
            }
        });

        JLabel3.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        JLabel3.setForeground(new java.awt.Color(245, 237, 237));
        JLabel3.setText("Proyectos");

        javax.swing.GroupLayout projectsTabLayout = new javax.swing.GroupLayout(projectsTab);
        projectsTab.setLayout(projectsTabLayout);
        projectsTabLayout.setHorizontalGroup(
            projectsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(projectsTabLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(JLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        projectsTabLayout.setVerticalGroup(
            projectsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        workGroupsTab.setBackground(new java.awt.Color(100, 130, 173));
        workGroupsTab.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        workGroupsTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                workGroupsTabMouseClicked(evt);
            }
        });

        JLabel4.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        JLabel4.setForeground(new java.awt.Color(245, 237, 237));
        JLabel4.setText("Equipos");

        javax.swing.GroupLayout workGroupsTabLayout = new javax.swing.GroupLayout(workGroupsTab);
        workGroupsTab.setLayout(workGroupsTabLayout);
        workGroupsTabLayout.setHorizontalGroup(
            workGroupsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(workGroupsTabLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(JLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        workGroupsTabLayout.setVerticalGroup(
            workGroupsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        tasksTab.setBackground(new java.awt.Color(100, 130, 173));
        tasksTab.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tasksTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tasksTabMouseClicked(evt);
            }
        });

        JLabel5.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        JLabel5.setForeground(new java.awt.Color(245, 237, 237));
        JLabel5.setText("Tareas");
        JLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JLabel5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout tasksTabLayout = new javax.swing.GroupLayout(tasksTab);
        tasksTab.setLayout(tasksTabLayout);
        tasksTabLayout.setHorizontalGroup(
            tasksTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tasksTabLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(JLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tasksTabLayout.setVerticalGroup(
            tasksTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        configTab.setBackground(new java.awt.Color(100, 130, 173));
        configTab.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        configTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                configTabMouseClicked(evt);
            }
        });

        JLabel6.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        JLabel6.setForeground(new java.awt.Color(245, 237, 237));
        JLabel6.setText("Configuración");

        javax.swing.GroupLayout configTabLayout = new javax.swing.GroupLayout(configTab);
        configTab.setLayout(configTabLayout);
        configTabLayout.setHorizontalGroup(
            configTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(configTabLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(JLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        configTabLayout.setVerticalGroup(
            configTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        reportsTab.setBackground(new java.awt.Color(100, 130, 173));
        reportsTab.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reportsTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reportsTabMouseClicked(evt);
            }
        });

        JLabel7.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        JLabel7.setForeground(new java.awt.Color(245, 237, 237));
        JLabel7.setText("Reportes");

        javax.swing.GroupLayout reportsTabLayout = new javax.swing.GroupLayout(reportsTab);
        reportsTab.setLayout(reportsTabLayout);
        reportsTabLayout.setHorizontalGroup(
            reportsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reportsTabLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(JLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        reportsTabLayout.setVerticalGroup(
            reportsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        jPanel11.setBackground(new java.awt.Color(127, 161, 195));

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(245, 237, 237));
        jLabel8.setText("Bienvenido ");

        txtCurrentUser.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txtCurrentUser.setForeground(new java.awt.Color(245, 237, 237));
        txtCurrentUser.setText("Ricardo Retamal");

        txtCurrentUserRole.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCurrentUserRole.setForeground(new java.awt.Color(245, 237, 237));
        txtCurrentUserRole.setText("Admin");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCurrentUser, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(txtCurrentUserRole, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCurrentUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCurrentUserRole, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(notificationsTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(projectsTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(workGroupsTab, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tasksTab, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(configTab, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(reportsTab, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(usersTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(notificationsTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usersTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(projectsTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(workGroupsTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tasksTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(configTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reportsTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 493));

        jTabbedPane1.setBackground(new java.awt.Color(245, 237, 237));
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 455, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab1", jPanel3);

        jPanel4.setBackground(new java.awt.Color(245, 237, 237));

        jLabel1.setBackground(new java.awt.Color(245, 237, 237));
        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Registrar Usuario");

        btnRegisterUserAccess.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegisterUserAccess.setPreferredSize(new java.awt.Dimension(120, 120));
        btnRegisterUserAccess.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegisterUserAccessMouseClicked(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(245, 237, 237));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar_usuario.png"))); // NOI18N

        javax.swing.GroupLayout btnRegisterUserAccessLayout = new javax.swing.GroupLayout(btnRegisterUserAccess);
        btnRegisterUserAccess.setLayout(btnRegisterUserAccessLayout);
        btnRegisterUserAccessLayout.setHorizontalGroup(
            btnRegisterUserAccessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btnRegisterUserAccessLayout.setVerticalGroup(
            btnRegisterUserAccessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel3.setBackground(new java.awt.Color(245, 237, 237));
        jLabel3.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Listar todos los Usuarios");

        JPanel.setBackground(new java.awt.Color(245, 237, 237));
        JPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JPanel.setPreferredSize(new java.awt.Dimension(120, 120));
        JPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JPanelMouseClicked(evt);
            }
        });

        btnListAllUsers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/listar_usuarios.png"))); // NOI18N
        btnListAllUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnListAllUsersMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout JPanelLayout = new javax.swing.GroupLayout(JPanel);
        JPanel.setLayout(JPanelLayout);
        JPanelLayout.setHorizontalGroup(
            JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnListAllUsers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JPanelLayout.setVerticalGroup(
            JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnListAllUsers, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(btnRegisterUserAccess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(JPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegisterUserAccess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(264, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab2", jPanel4);

        jPanel5.setBackground(new java.awt.Color(245, 237, 237));

        jPanel10.setBackground(new java.awt.Color(247, 249, 242));

        btnAddProject.setBackground(new java.awt.Color(245, 237, 237));
        btnAddProject.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar.png"))); // NOI18N
        btnAddProject.setBorder(null);
        btnAddProject.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddProject.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAddProject.setPreferredSize(new java.awt.Dimension(50, 50));
        btnAddProject.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAddProject.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddProjectMouseClicked(evt);
            }
        });
        btnAddProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProjectActionPerformed(evt);
            }
        });

        btnEditProject.setBackground(new java.awt.Color(245, 237, 237));
        btnEditProject.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        btnEditProject.setBorder(null);
        btnEditProject.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditProject.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditProject.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditProject.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditProjectMouseClicked(evt);
            }
        });

        btnDeleteProject.setBackground(new java.awt.Color(245, 237, 237));
        btnDeleteProject.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar_usuario.png"))); // NOI18N
        btnDeleteProject.setBorder(null);
        btnDeleteProject.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteProject.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDeleteProject.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDeleteProject.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteProjectMouseClicked(evt);
            }
        });

        btnSeeTeams.setBackground(new java.awt.Color(245, 237, 237));
        btnSeeTeams.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/grupos.png"))); // NOI18N
        btnSeeTeams.setBorder(null);
        btnSeeTeams.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSeeTeams.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSeeTeams.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSeeTeams.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSeeTeamsMouseClicked(evt);
            }
        });
        btnSeeTeams.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeeTeamsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnAddProject, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnEditProject, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnDeleteProject, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnSeeTeams, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEditProject, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeeTeams, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteProject, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddProject, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        projectsTable.setBackground(new java.awt.Color(245, 237, 237));
        projectsTable.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        projectsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "NOMBRE", "DESCRIPCIÓN", "MANAGER", "FECHA DE CREACION"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        projectsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(projectsTable);
        if (projectsTable.getColumnModel().getColumnCount() > 0) {
            projectsTable.getColumnModel().getColumn(0).setPreferredWidth(5);
            projectsTable.getColumnModel().getColumn(1).setPreferredWidth(40);
            projectsTable.getColumnModel().getColumn(2).setPreferredWidth(80);
            projectsTable.getColumnModel().getColumn(3).setPreferredWidth(30);
            projectsTable.getColumnModel().getColumn(4).setPreferredWidth(40);
        }

        jLabel9.setBackground(new java.awt.Color(245, 237, 237));
        jLabel9.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Agregar");

        jLabel10.setBackground(new java.awt.Color(245, 237, 237));
        jLabel10.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Editar");

        jLabel11.setBackground(new java.awt.Color(245, 237, 237));
        jLabel11.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Eliminar");

        jLabel12.setBackground(new java.awt.Color(245, 237, 237));
        jLabel12.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Ver integrantes");

        txtProjectsTableElementsCount.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(179, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)))
                .addGap(144, 144, 144))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(txtProjectsTableElementsCount, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtProjectsTableElementsCount, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab3", jPanel5);

        jPanel6.setBackground(new java.awt.Color(245, 237, 237));

        jPanel12.setBackground(new java.awt.Color(247, 249, 242));

        btnAddWorkGroup.setBackground(new java.awt.Color(245, 237, 237));
        btnAddWorkGroup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar.png"))); // NOI18N
        btnAddWorkGroup.setBorder(null);
        btnAddWorkGroup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddWorkGroup.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAddWorkGroup.setPreferredSize(new java.awt.Dimension(50, 50));
        btnAddWorkGroup.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAddWorkGroup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddWorkGroupMouseClicked(evt);
            }
        });
        btnAddWorkGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddWorkGroupActionPerformed(evt);
            }
        });

        btnEditWorkgroup.setBackground(new java.awt.Color(245, 237, 237));
        btnEditWorkgroup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        btnEditWorkgroup.setBorder(null);
        btnEditWorkgroup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditWorkgroup.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditWorkgroup.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditWorkgroup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditWorkgroupMouseClicked(evt);
            }
        });

        btnDeleteWorkGroup.setBackground(new java.awt.Color(245, 237, 237));
        btnDeleteWorkGroup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar_usuario.png"))); // NOI18N
        btnDeleteWorkGroup.setBorder(null);
        btnDeleteWorkGroup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteWorkGroup.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDeleteWorkGroup.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDeleteWorkGroup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteWorkGroupMouseClicked(evt);
            }
        });

        btnSeeMembers.setBackground(new java.awt.Color(245, 237, 237));
        btnSeeMembers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/grupos.png"))); // NOI18N
        btnSeeMembers.setBorder(null);
        btnSeeMembers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSeeMembers.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSeeMembers.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSeeMembers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSeeMembersMouseClicked(evt);
            }
        });
        btnSeeMembers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeeMembersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnAddWorkGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnEditWorkgroup, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(btnDeleteWorkGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnSeeMembers, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEditWorkgroup, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeeMembers, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteWorkGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddWorkGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jScrollPane2.setBackground(new java.awt.Color(245, 237, 237));
        jScrollPane2.setForeground(new java.awt.Color(51, 51, 51));

        workGroupsTable.setBackground(new java.awt.Color(245, 237, 237));
        workGroupsTable.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        workGroupsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "PROYECTO ASIGNADO", "NOMBRE EQUIPO", "LIDER", "FECHA CREACION"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        workGroupsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(workGroupsTable);
        if (workGroupsTable.getColumnModel().getColumnCount() > 0) {
            workGroupsTable.getColumnModel().getColumn(0).setPreferredWidth(10);
            workGroupsTable.getColumnModel().getColumn(1).setPreferredWidth(60);
            workGroupsTable.getColumnModel().getColumn(2).setPreferredWidth(60);
            workGroupsTable.getColumnModel().getColumn(3).setPreferredWidth(50);
            workGroupsTable.getColumnModel().getColumn(4).setPreferredWidth(50);
        }

        jLabel4.setBackground(new java.awt.Color(245, 237, 237));
        jLabel4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Agregar");

        jLabel5.setBackground(new java.awt.Color(245, 237, 237));
        jLabel5.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Editar");

        jLabel6.setBackground(new java.awt.Color(245, 237, 237));
        jLabel6.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Eliminar");

        jLabel7.setBackground(new java.awt.Color(245, 237, 237));
        jLabel7.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Ver integrantes");

        txtWorkGroupsTableElementsCount.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel4)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7))
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtWorkGroupsTableElementsCount, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtWorkGroupsTableElementsCount, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        jTabbedPane1.addTab("tab4", jPanel6);

        jPanel7.setBackground(new java.awt.Color(245, 237, 237));

        jPanel13.setBackground(new java.awt.Color(247, 249, 242));

        btnAddTask.setBackground(new java.awt.Color(245, 237, 237));
        btnAddTask.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar.png"))); // NOI18N
        btnAddTask.setBorder(null);
        btnAddTask.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddTask.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAddTask.setPreferredSize(new java.awt.Dimension(50, 50));
        btnAddTask.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAddTask.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddTaskMouseClicked(evt);
            }
        });
        btnAddTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTaskActionPerformed(evt);
            }
        });

        btnEditTask.setBackground(new java.awt.Color(245, 237, 237));
        btnEditTask.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        btnEditTask.setBorder(null);
        btnEditTask.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditTask.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditTask.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditTask.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditTaskMouseClicked(evt);
            }
        });

        btnDeleteTask.setBackground(new java.awt.Color(245, 237, 237));
        btnDeleteTask.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar_usuario.png"))); // NOI18N
        btnDeleteTask.setBorder(null);
        btnDeleteTask.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteTask.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDeleteTask.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDeleteTask.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteTaskMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnAddTask, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnEditTask, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(btnDeleteTask, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEditTask, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteTask, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddTask, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jScrollPane3.setBackground(new java.awt.Color(245, 237, 237));

        tasksTable.setBackground(new java.awt.Color(245, 237, 237));
        tasksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "PROYECTO", "EQUIPO", "NOMBRE", "DESCRIPCION", "STATUS", "PRIORIDAD", "FECHA LIMITE", "ASIGNADO A", "FECHA CREACION", "FECHA ACTUALIZACION"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tasksTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tasksTable);
        if (tasksTable.getColumnModel().getColumnCount() > 0) {
            tasksTable.getColumnModel().getColumn(0).setPreferredWidth(10);
            tasksTable.getColumnModel().getColumn(1).setPreferredWidth(25);
            tasksTable.getColumnModel().getColumn(2).setPreferredWidth(25);
            tasksTable.getColumnModel().getColumn(3).setPreferredWidth(30);
            tasksTable.getColumnModel().getColumn(4).setPreferredWidth(30);
            tasksTable.getColumnModel().getColumn(5).setPreferredWidth(30);
            tasksTable.getColumnModel().getColumn(6).setPreferredWidth(30);
            tasksTable.getColumnModel().getColumn(7).setPreferredWidth(30);
            tasksTable.getColumnModel().getColumn(8).setPreferredWidth(30);
            tasksTable.getColumnModel().getColumn(9).setPreferredWidth(25);
            tasksTable.getColumnModel().getColumn(10).setPreferredWidth(25);
        }

        jLabel13.setBackground(new java.awt.Color(245, 237, 237));
        jLabel13.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Agregar");

        jLabel14.setBackground(new java.awt.Color(245, 237, 237));
        jLabel14.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Editar");

        jLabel15.setBackground(new java.awt.Color(245, 237, 237));
        jLabel15.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Eliminar");

        txtTasksTableElementsCount.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel13)
                            .addGap(31, 31, 31)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(37, 37, 37)
                            .addComponent(jLabel15))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                            .addGap(192, 192, 192)
                            .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTasksTableElementsCount, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTasksTableElementsCount, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab5", jPanel7);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 455, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab6", jPanel8);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 455, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab7", jPanel9);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 0, 610, 490));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 823, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void notificationsTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notificationsTabMouseClicked
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_notificationsTabMouseClicked

    private void usersTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usersTabMouseClicked
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_usersTabMouseClicked

    private void projectsTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_projectsTabMouseClicked
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_projectsTabMouseClicked

    private void workGroupsTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_workGroupsTabMouseClicked
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_workGroupsTabMouseClicked

    private void tasksTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tasksTabMouseClicked
        jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_tasksTabMouseClicked

    private void configTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_configTabMouseClicked
        jTabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_configTabMouseClicked

    private void reportsTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportsTabMouseClicked
        jTabbedPane1.setSelectedIndex(6);
    }//GEN-LAST:event_reportsTabMouseClicked

    private void btnRegisterUserAccessMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegisterUserAccessMouseClicked
        Register register = new Register(manager, user);
        register.setVisible(true);
    }//GEN-LAST:event_btnRegisterUserAccessMouseClicked

    private void JPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPanelMouseClicked

    }//GEN-LAST:event_JPanelMouseClicked

    private void btnListAllUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListAllUsersMouseClicked
        UsersList usersList;
        try {
            usersList = new UsersList(manager, user);
            usersList.setVisible(true);
        } catch (DAOException ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_btnListAllUsersMouseClicked

    private void btnAddProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddProjectActionPerformed

    private void btnAddProjectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddProjectMouseClicked
        ProjectDetailsPanel projectDetails;
        try {
            projectDetails = new ProjectDetailsPanel("ADD", project, manager, this);
            projectDetails.setVisible(true);
            projectDetails.setLocationRelativeTo(null);
        } catch (DAOException | SQLException ex) {
                System.out.println(ex.toString());
        }
    }//GEN-LAST:event_btnAddProjectMouseClicked

    private void btnEditProjectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditProjectMouseClicked
        ProjectDetailsPanel projectDetails;
        try {
            if (projectsTable.getSelectedRow() >= 0) {
                setDataFromSelectedProjectsTableItem();
                projectDetails = new ProjectDetailsPanel("MODIFY", project, manager, this);
                projectDetails.setVisible(true);
                projectDetails.setLocationRelativeTo(null);
                projectsTable.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un elemento de la tabla");
            }
        } catch (DAOException | SQLException ex) {
                System.out.println(ex.toString());
        }
    }//GEN-LAST:event_btnEditProjectMouseClicked

    private void setDataFromSelectedProjectsTableItem() throws DAOException {
        int selectedRow = projectsTable.getSelectedRow();
        int ownerId = manager
                .getUserDAO()
                .getUserIdByUserName(String.valueOf(projectsTable.getValueAt(selectedRow, 3)));
        project.setId((Integer)projectsTable.getValueAt(selectedRow, 0));
        project.setName(String.valueOf(projectsTable.getValueAt(selectedRow, 1)));
        project.setDescription(String.valueOf(projectsTable.getValueAt(selectedRow, 2)));
        project.setOwnerId(ownerId);
        project.setCreatedAt(String.valueOf(projectsTable.getValueAt(selectedRow, 4)));
    }
    
    private void btnDeleteProjectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteProjectMouseClicked
        int selectedRow = projectsTable.getSelectedRow();
        if (selectedRow >= 0) {
            try {
                int question =JOptionPane.showConfirmDialog(null, 
                                "¿Está seguro que desea eliminar el elemento seleccionado?");
                if (question == 0) {
                    int projectId = Integer.parseInt(projectsTable.getValueAt(selectedRow, 0).toString());
                    List<ProjectMember> projectMembers = manager
                            .getProjectMemberDAO()
                            .getMembersByProjectId(projectId);
                    List<WorkGroup> wgMembers = manager
                            .getWorkGroupDAO()
                            .getGroupsByProject(projectId);
                    if (projectMembers.isEmpty() && wgMembers.isEmpty()) {
                        deleteProject();
                    } else if (!projectMembers.isEmpty() && wgMembers.isEmpty()) {
                        deleteProjectMembers();
                        deleteProject();
                    } else if (projectMembers.isEmpty() && !wgMembers.isEmpty()) {
                        deleteWorkGroupInAProject();
                        deleteProject();
                    } else {
                        deleteProjectMembers();
                        deleteWorkGroupInAProject();
                        deleteProject();
                    }
                    JOptionPane.showMessageDialog(null, "Eliminado con éxito");
                    projectsTableModel.updateModel();
                    projectsTableModel.fireTableDataChanged();
                    workGroupsTableModel.updateModel(); 
                    workGroupsTableModel.fireTableDataChanged();
                    loadTablesElementsCount();
                }
            } catch (DAOException ex) {
                System.out.println(ex.toString());
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un elemento");
        }
    }//GEN-LAST:event_btnDeleteProjectMouseClicked

    private void deleteProjectMembers() throws DAOException {
        int selectedRow = projectsTable.getSelectedRow();
        int projectId = (int)projectsTable.getValueAt(selectedRow, 0);
        manager.getProjectMemberDAO().deleteByProjectId(projectId);
    }
    
    private void deleteWorkGroupInAProject() throws DAOException {
        int selectedRow = projectsTable.getSelectedRow();
        int projectId = Integer.parseInt(projectsTable.getValueAt(selectedRow, 0).toString());
        manager.getWorkGroupDAO().deleteByProjectId(projectId);
    }
    
    private void deleteProject() throws DAOException {
        int selectedRow = projectsTable.getSelectedRow();
        int projectId = (int)projectsTable.getValueAt(selectedRow, 0);
        manager.getProjectDAO().delete(projectId);
    }
    
    private void btnSeeTeamsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSeeTeamsMouseClicked
        if (projectsTable.getSelectedRow() >= 0) {
            ProjectMembersList membersList;
            try {
                int currentSelectedRow = projectsTable.getSelectedRow();
                int projectId = (int) projectsTable.getValueAt(currentSelectedRow, 0);
                membersList = new ProjectMembersList(manager, projectMember, projectId);
                membersList.setVisible(true);
                membersList.setLocationRelativeTo(null);
            } catch (DAOException ex) {
                System.out.println(ex.toString());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }
    }//GEN-LAST:event_btnSeeTeamsMouseClicked

    private void btnSeeTeamsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeeTeamsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSeeTeamsActionPerformed

    private void btnAddWorkGroupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddWorkGroupMouseClicked
        WorkGroupDetailsPanel workGroupsDetails;
        try {
            workGroupsDetails = new WorkGroupDetailsPanel("ADD", workGroup, manager, this);
            workGroupsDetails.setVisible(true);
            workGroupsDetails.setLocationRelativeTo(null);
        } catch (DAOException ex) {
                System.out.println(ex.toString());
        }
    }//GEN-LAST:event_btnAddWorkGroupMouseClicked

    private void btnAddWorkGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddWorkGroupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddWorkGroupActionPerformed

    private void btnEditWorkgroupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditWorkgroupMouseClicked
        if (workGroupsTable.getSelectedRow() >= 0) {
            WorkGroupDetailsPanel workGroupDetailsPanel;
                try {
                    setDataFromSelectedWorkGroupsTableItem();
                    workGroupDetailsPanel = new WorkGroupDetailsPanel(
                            "MODIFY", 
                            workGroup, 
                            manager, 
                            this
                    );
                    workGroupDetailsPanel.setVisible(true);
                    workGroupDetailsPanel.setLocationRelativeTo(null);
                    workGroupsTable.setEnabled(false);
                } catch (DAOException ex) {
                    System.out.println(ex.toString());
                }
            } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
        }
    }//GEN-LAST:event_btnEditWorkgroupMouseClicked

    private void setDataFromSelectedWorkGroupsTableItem() throws DAOException {
        int selectedRow = workGroupsTable.getSelectedRow();
        int workGroupId = Integer.parseInt(workGroupsTable.getValueAt(selectedRow, 0).toString());
        workGroup = manager.getWorkGroupDAO().getElement(workGroupId);
    }
    
    private void btnDeleteWorkGroupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteWorkGroupMouseClicked
        int selectedRow = workGroupsTable.getSelectedRow();
        if (selectedRow >= 0) {
            try {
                int question = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar?");
                if (question == 0) {
                    String projectName = workGroupsTable.getValueAt(selectedRow, 1).toString();
                    int projectId = manager.getProjectDAO().getProjectIdByProjectName(projectName);
                    int workGroupId = Integer.parseInt(workGroupsTable.getValueAt(selectedRow, 0).toString());
                    List<ProjectMember> projectMembers = manager
                            .getProjectMemberDAO()
                            .getMembersByProjectId(projectId);
                    List<WorkGroupMember> wgMembers = manager
                            .getWorkGroupMemberDAO()
                            .getMembersByWorkGroupId(workGroupId);
                    if (projectMembers.isEmpty() && wgMembers.isEmpty()) {
                        deleteWorkGroup();
                    } else if (!projectMembers.isEmpty() && wgMembers.isEmpty()) {
                        deleteWorkGroupMembersInProjectMembers();
                        deleteWorkGroup();
                    } else if (projectMembers.isEmpty() && !wgMembers.isEmpty()) {
                        deleteWorkGroupMembers();
                        deleteWorkGroup();
                    } else {
                        deleteWorkGroupMembersInProjectMembers();
                        deleteWorkGroupMembers();
                        deleteWorkGroup();
                    }
                    JOptionPane.showMessageDialog(null, "Eliminado con éxito");
                    workGroupsTableModel.updateModel();
                    workGroupsTableModel.fireTableDataChanged();
                    loadTablesElementsCount();
                }
            } catch (DAOException ex) {
                System.out.println(ex.toString());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
        }
    }//GEN-LAST:event_btnDeleteWorkGroupMouseClicked

    private void deleteWorkGroup() throws DAOException {
        int selectedRow = workGroupsTable.getSelectedRow();
        int workGroupId = (int) workGroupsTable.getValueAt(selectedRow, 0);
        manager.getWorkGroupDAO().delete(workGroupId);
    }
    
    private void deleteWorkGroupMembersInProjectMembers() throws DAOException {
        int selectedRow = workGroupsTable.getSelectedRow();
        String projectName = workGroupsTable.getValueAt(selectedRow, 1).toString();
        int projectId = manager.getProjectDAO().getProjectIdByProjectName(projectName);
        int workGroupId = Integer.parseInt(workGroupsTable.getValueAt(selectedRow, 0).toString());
        List<Integer> usersId = manager
                .getWorkGroupMemberDAO()
                .getMembersByWorkGroupId(workGroupId)
                .stream()
                .map(member -> member.getUserId())
                .collect(Collectors.toList());
      
        for (Integer userId : usersId) {
            manager.getProjectMemberDAO().deleteByUserIdAndProjectId(userId, projectId);
        }
    }
    
    private void deleteWorkGroupMembers() throws DAOException {
        int selectedRow = workGroupsTable.getSelectedRow();
        int workGroupId = Integer.parseInt(workGroupsTable.getValueAt(selectedRow, 0).toString());
        manager.getWorkGroupMemberDAO().deleteByWorkGroupId(workGroupId);
    }
    
    private void btnSeeMembersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSeeMembersMouseClicked
        if (workGroupsTable.getSelectedRow() >= 0) {
            WorkGroupsMembersList wgMembersList;
            try {
                int selectedRow = workGroupsTable.getSelectedRow();
                int workGroupId = (int) workGroupsTable.getValueAt(selectedRow, 0);
                String projectName = workGroupsTable.getValueAt(selectedRow, 1).toString();
                int projectId = manager
                        .getProjectDAO()
                        .getProjectIdByProjectName(projectName);
                wgMembersList = new WorkGroupsMembersList(
                        manager,
                        workGroupMember,
                        workGroupId,
                        projectId
                );
                wgMembersList.setVisible(true);
                wgMembersList.setLocationRelativeTo(null);
            } catch (DAOException ex) {
                System.out.println(ex.toString());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
        }
    }//GEN-LAST:event_btnSeeMembersMouseClicked

    private void btnSeeMembersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeeMembersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSeeMembersActionPerformed

    private void btnAddTaskMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddTaskMouseClicked
        TasksDetailsPanel tasksDetailsPanel;
        try {
            tasksDetailsPanel = new TasksDetailsPanel("ADD", task, manager, this);
            tasksDetailsPanel.setVisible(true);
            tasksDetailsPanel.setLocationRelativeTo(null);
            tasksTable.setEnabled(false);
        } catch (DAOException ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_btnAddTaskMouseClicked

    private void btnAddTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTaskActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddTaskActionPerformed

    private void btnEditTaskMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditTaskMouseClicked
        if (tasksTable.getSelectedRow() >= 0) {
            TasksDetailsPanel tasksDetailsPanel;
            try {
                setDataFromSelectedTasksTableItem();
                tasksDetailsPanel = new TasksDetailsPanel("MODIFY", task, manager, this);
                tasksDetailsPanel.setVisible(true);
                tasksDetailsPanel.setLocationRelativeTo(null);
                tasksTable.setEnabled(false);
            } catch (DAOException ex) {
                System.out.println(ex.toString());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
        }
    }//GEN-LAST:event_btnEditTaskMouseClicked

    private void setDataFromSelectedTasksTableItem() throws DAOException {
        int selectedRow = tasksTable.getSelectedRow();
        int taskId = Integer.parseInt(tasksTable.getValueAt(selectedRow, 0).toString());
        task = manager.getTaskDAO().getElement(taskId);
    }
    
    private void btnDeleteTaskMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteTaskMouseClicked
        if (tasksTable.getSelectedRow() >= 0) {
            try {
                int question = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar?");
                if (question == 0) {
                    deleteTask();
                    JOptionPane.showMessageDialog(null, "Eliminado con éxito");
                    tasksTableModel.updateModel();
                    tasksTableModel.fireTableDataChanged();
                    loadTablesElementsCount();
                }
            } catch (DAOException ex) {
                System.out.println(ex.toString());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
        }
    }//GEN-LAST:event_btnDeleteTaskMouseClicked

    private void JLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLabel5MouseClicked
        jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_JLabel5MouseClicked

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1MouseClicked
    
    private void deleteTask() throws DAOException {
        int selectedRow = tasksTable.getSelectedRow();
        int taskId = Integer.parseInt(tasksTable.getValueAt(selectedRow, 0).toString());
        manager.getTaskDAO().delete(taskId);
    }
    
    private void handleClosing() {
        if (hasUnsaveData()) {
            int answer = showWarningMessage();
             
            switch (answer) {
                case JOptionPane.YES_OPTION -> {
                    System.out.println("Guardar y salir");
                    dispose();
                }
                     
                case JOptionPane.NO_OPTION -> {
                    System.out.println("No guardar y salir");
                    dispose();
                }
                     
                case JOptionPane.CANCEL_OPTION -> System.out.println("No salir");
            }
        } else {
            dispose();
        }      
    }
    
    private int showWarningMessage() {
        String[] buttonLabels = new String[] {"Si", "No", "Cancelar"};
        String defaultOption = buttonLabels[0];
        Icon icon = null;
         
        return JOptionPane.showOptionDialog(this,
                "Aún hay trabajo sin guardar.\n" +
                "¿Desea guardarlo antes de salir?",
                "Advertencia",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.WARNING_MESSAGE,
                icon,
                buttonLabels,
                defaultOption);    
    }
    
    private boolean hasUnsaveData() {
        // checks if there's still something unsaved
        // this method always return true for demo purpose
        return true;
    }
    
    public void loadTablesElementsCount() {
        txtProjectsTableElementsCount.setText(
                String.valueOf(projectsTable.getRowCount()) + " Registros"
        );
        txtWorkGroupsTableElementsCount.setText(
                String.valueOf(workGroupsTable.getRowCount()) + " Registros"
        );
        txtTasksTableElementsCount.setText(
                String.valueOf(tasksTable.getRowCount() + " Registros")
        );
    }

    public JTable getProjectsTable() {
        return projectsTable;
    }

    public void setProjectsTable(JTable projectsTable) {
        this.projectsTable = projectsTable;
    }

    public ProjectsTableModel getProjectsTableModel() {
        return projectsTableModel;
    }

    public void setProjectsTableModel(ProjectsTableModel projectsTableModel) {
        this.projectsTableModel = projectsTableModel;
    }

    public WorkGroupsTableModel getWorkGroupsTableModel() {
        return workGroupsTableModel;
    }

    public void setWorkGroupsTableModel(WorkGroupsTableModel workGroupsTableModel) {
        this.workGroupsTableModel = workGroupsTableModel;
    }

    public JTable getWorkGroupsTable() {
        return workGroupsTable;
    }

    public void setWorkGroupsTable(JTable workGroupsTable) {
        this.workGroupsTable = workGroupsTable;
    }

    public JTable getTasksTable() {
        return tasksTable;
    }

    public void setTasksTable(JTable tasksTable) {
        this.tasksTable = tasksTable;
    }

    public TasksTableModel getTasksTableModel() {
        return tasksTableModel;
    }

    public void setTasksTableModel(TasksTableModel tasksTableModel) {
        this.tasksTableModel = tasksTableModel;
    } 
    
    public static void main(String args[]) throws SQLException {
        DAOManager manager = new MySQLDaoManager("localhost", "project_management_system", "root", "");
        User user = new User();
        Project project = new Project();
        ProjectMember projectMember = new ProjectMember();
        WorkGroup workGroup = new WorkGroup();
        WorkGroupMember workGroupMember = new WorkGroupMember();
        Task task = new Task();
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new MainScreen(
                        manager, 
                        user, 
                        project, 
                        projectMember, 
                        workGroup, 
                        workGroupMember,
                        task
                    ).setVisible(true);
            } catch (DAOException ex) {
                System.out.println(ex.toString());
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabel1;
    private javax.swing.JLabel JLabel2;
    private javax.swing.JLabel JLabel3;
    private javax.swing.JLabel JLabel4;
    private javax.swing.JLabel JLabel5;
    private javax.swing.JLabel JLabel6;
    private javax.swing.JLabel JLabel7;
    private javax.swing.JPanel JPanel;
    private javax.swing.JButton btnAddProject;
    private javax.swing.JButton btnAddTask;
    private javax.swing.JButton btnAddWorkGroup;
    private javax.swing.JButton btnDeleteProject;
    private javax.swing.JButton btnDeleteTask;
    private javax.swing.JButton btnDeleteWorkGroup;
    private javax.swing.JButton btnEditProject;
    private javax.swing.JButton btnEditTask;
    private javax.swing.JButton btnEditWorkgroup;
    private javax.swing.JLabel btnListAllUsers;
    private javax.swing.JPanel btnRegisterUserAccess;
    private javax.swing.JButton btnSeeMembers;
    private javax.swing.JButton btnSeeTeams;
    private javax.swing.JPanel configTab;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel notificationsTab;
    private javax.swing.JPanel projectsTab;
    private javax.swing.JTable projectsTable;
    private javax.swing.JPanel reportsTab;
    private javax.swing.JPanel tasksTab;
    private javax.swing.JTable tasksTable;
    private javax.swing.JLabel txtCurrentUser;
    private javax.swing.JLabel txtCurrentUserRole;
    private javax.swing.JLabel txtProjectsTableElementsCount;
    private javax.swing.JLabel txtTasksTableElementsCount;
    private javax.swing.JLabel txtWorkGroupsTableElementsCount;
    private javax.swing.JPanel usersTab;
    private javax.swing.JPanel workGroupsTab;
    private javax.swing.JTable workGroupsTable;
    // End of variables declaration//GEN-END:variables
}
