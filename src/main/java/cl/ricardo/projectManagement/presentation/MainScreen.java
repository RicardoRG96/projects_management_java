package cl.ricardo.projectManagement.presentation;

import cl.ricardo.projectManagement.dataAccess.User;
import cl.ricardo.projectManagement.dataAccess.dao.DAOException;
import cl.ricardo.projectManagement.dataAccess.dao.DAOManager;
import cl.ricardo.projectManagement.dataAccess.dao.mysql.MySQLDaoManager;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainScreen extends javax.swing.JFrame {
    
    private DAOManager manager;
    
    private User user;

    public MainScreen(DAOManager manager, User user) {
        this.manager = manager;
        this.user = user;
        initComponents();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
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
        jButton5 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
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

        btnAddProject.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/guardar.png"))); // NOI18N
        btnAddProject.setBorder(null);
        btnAddProject.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddProject.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAddProject.setPreferredSize(new java.awt.Dimension(50, 50));
        btnAddProject.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAddProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProjectActionPerformed(evt);
            }
        });

        btnEditProject.setBorder(null);
        btnEditProject.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditProject.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditProject.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnDeleteProject.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDeleteProject.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnSeeTeams.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSeeTeams.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnAddProject, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnEditProject, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnDeleteProject, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnSeeTeams, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEditProject, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSeeTeams, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDeleteProject, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddProject, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(146, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(402, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab3", jPanel5);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 455, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab4", jPanel6);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 455, Short.MAX_VALUE)
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
            usersList = new UsersList(manager);
            usersList.setVisible(true);
        } catch (DAOException ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_btnListAllUsersMouseClicked

    private void btnAddProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddProjectActionPerformed

    private void handleClosing() {
        if (hasUnsaveData()) {
            int answer = showWarningMessage();
             
            switch (answer) {
                case JOptionPane.YES_OPTION:
                    System.out.println("Guardar y salir");
                    dispose();
                    break;
                     
                case JOptionPane.NO_OPTION:
                    System.out.println("No guardar y salir");
                    dispose();
                    break;
                     
                case JOptionPane.CANCEL_OPTION:
                    System.out.println("No salir");
                    break;
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
    
    public static void main(String args[]) throws SQLException {
        DAOManager manager = new MySQLDaoManager("localhost", "project_management_system", "root", "");
        User user = new User();
        java.awt.EventQueue.invokeLater(() -> {
            new MainScreen(manager, user).setVisible(true);
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
    private javax.swing.JButton btnDeleteProject;
    private javax.swing.JButton btnEditProject;
    private javax.swing.JLabel btnListAllUsers;
    private javax.swing.JPanel btnRegisterUserAccess;
    private javax.swing.JButton btnSeeTeams;
    private javax.swing.JPanel configTab;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel notificationsTab;
    private javax.swing.JPanel projectsTab;
    private javax.swing.JPanel reportsTab;
    private javax.swing.JPanel tasksTab;
    private javax.swing.JLabel txtCurrentUser;
    private javax.swing.JLabel txtCurrentUserRole;
    private javax.swing.JPanel usersTab;
    private javax.swing.JPanel workGroupsTab;
    // End of variables declaration//GEN-END:variables
}
