package cl.ricardo.projectManagement.presentation.projects;

import cl.ricardo.projectManagement.dataAccess.ProjectMember;
import cl.ricardo.projectManagement.dataAccess.dao.DAOException;
import cl.ricardo.projectManagement.dataAccess.dao.DAOManager;

public class ProjectMembersList extends javax.swing.JFrame {
    
    private DAOManager manager;
    
    private ProjectMember member;
    
    private ProjectMembersTableModel model;

    private int projectId;
    
    public ProjectMembersList(DAOManager manager, ProjectMember member, int projectId) throws DAOException {
        initComponents();
        this.manager = manager;
        this.member = member;
        this.projectId = projectId;
        this.model = new ProjectMembersTableModel(
                manager.getProjectMemberDAO(), 
                manager.getUserDAO(), 
                manager.getProjectDAO()
        );
        this.model.updateModel(projectId);
        this.projectMembersTable.setModel(model);
        loadTablesElementsCount();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void loadTablesElementsCount() {
        txtProjectMembersListElementsCount.setText(
                String.valueOf(projectMembersTable.getRowCount() + " Registros.")
        );
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        projectMembersTable = new javax.swing.JTable();
        txtProjectMembersListElementsCount = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(245, 237, 237));
        jPanel1.setForeground(new java.awt.Color(51, 51, 51));

        jLabel1.setBackground(new java.awt.Color(245, 237, 237));
        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Integrantes del proyecto");

        projectMembersTable.setBackground(new java.awt.Color(245, 237, 237));
        projectMembersTable.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        projectMembersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE PROYECTO", "NOMBRE USUARIO", "ROL", "FECHA DE INTEGRACION"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        projectMembersTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(projectMembersTable);
        if (projectMembersTable.getColumnModel().getColumnCount() > 0) {
            projectMembersTable.getColumnModel().getColumn(0).setPreferredWidth(10);
            projectMembersTable.getColumnModel().getColumn(1).setPreferredWidth(50);
            projectMembersTable.getColumnModel().getColumn(2).setPreferredWidth(50);
            projectMembersTable.getColumnModel().getColumn(3).setPreferredWidth(30);
            projectMembersTable.getColumnModel().getColumn(4).setPreferredWidth(50);
        }

        txtProjectMembersListElementsCount.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtProjectMembersListElementsCount.setForeground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtProjectMembersListElementsCount, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 752, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(296, 296, 296)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtProjectMembersListElementsCount, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable projectMembersTable;
    private javax.swing.JLabel txtProjectMembersListElementsCount;
    // End of variables declaration//GEN-END:variables
}
