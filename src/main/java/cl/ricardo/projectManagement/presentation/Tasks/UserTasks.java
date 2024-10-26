package cl.ricardo.projectManagement.presentation.Tasks;

import cl.ricardo.projectManagement.dataAccess.Task;
import cl.ricardo.projectManagement.dataAccess.dao.DAOException;
import cl.ricardo.projectManagement.dataAccess.dao.DAOManager;
import cl.ricardo.projectManagement.presentation.MainScreen;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class UserTasks extends javax.swing.JFrame {
    
    private DAOManager manager;
    
    private Task task;
    
    private MainScreen mainScreen;
    
    private UserTasksTableModel userTasksTableModel;
    
    private int userId;
    
    public UserTasks(DAOManager manager, MainScreen mainScreen, int userId) throws DAOException {
        initComponents();
        this.manager = manager;
        this.task = new Task();
        this.mainScreen = mainScreen;
        this.userId = userId;
        this.userTasksTableModel = new UserTasksTableModel(
                manager.getTaskDAO(), 
                manager.getProjectDAO(), 
                manager.getWorkGroupDAO(), 
                manager.getUserDAO(),
                userId
        );
        userTasksTableModel.updateModel();
        userTasksTable.setModel(userTasksTableModel);
        loadTableElementsCount();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                userTasksTable.setEnabled(true);
            }
        });
        txtUserName.setText(
                manager.getUserDAO().getElement(userId).getUserName()
        );
    }

    public UserTasks() {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                userTasksTable.setEnabled(true);
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userTasksTable = new javax.swing.JTable();
        txtUserTasksElementsCount = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(245, 237, 237));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Tareas asignadas al usuario:");

        txtUserName.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        txtUserName.setForeground(new java.awt.Color(51, 51, 51));

        jScrollPane1.setBackground(new java.awt.Color(245, 237, 237));
        jScrollPane1.setForeground(new java.awt.Color(51, 51, 51));

        userTasksTable.setBackground(new java.awt.Color(245, 237, 237));
        userTasksTable.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        userTasksTable.setForeground(new java.awt.Color(51, 51, 51));
        userTasksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "PROYECTO", "EQUIPO", "NOMBRE", "DESCRIPCION", "ESTADO", "PRIORIDAD", "FECHA LIMITE", "FECHA CREACION", "FECHA ACTUALIZACION ESTADO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        userTasksTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(userTasksTable);
        if (userTasksTable.getColumnModel().getColumnCount() > 0) {
            userTasksTable.getColumnModel().getColumn(0).setPreferredWidth(10);
            userTasksTable.getColumnModel().getColumn(1).setPreferredWidth(30);
            userTasksTable.getColumnModel().getColumn(2).setPreferredWidth(30);
            userTasksTable.getColumnModel().getColumn(3).setPreferredWidth(30);
            userTasksTable.getColumnModel().getColumn(4).setPreferredWidth(30);
            userTasksTable.getColumnModel().getColumn(5).setPreferredWidth(30);
            userTasksTable.getColumnModel().getColumn(6).setPreferredWidth(30);
            userTasksTable.getColumnModel().getColumn(7).setPreferredWidth(30);
            userTasksTable.getColumnModel().getColumn(8).setPreferredWidth(30);
            userTasksTable.getColumnModel().getColumn(9).setPreferredWidth(30);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUserTasksElementsCount, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUserTasksElementsCount, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
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

    private void loadTableElementsCount() {
        txtUserTasksElementsCount.setText(
                String.valueOf(userTasksTable.getRowCount() + " Registros.")
        );
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel txtUserName;
    private javax.swing.JLabel txtUserTasksElementsCount;
    private javax.swing.JTable userTasksTable;
    // End of variables declaration//GEN-END:variables
}
