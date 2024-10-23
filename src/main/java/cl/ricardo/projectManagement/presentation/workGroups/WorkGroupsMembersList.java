package cl.ricardo.projectManagement.presentation.workGroups;

import cl.ricardo.projectManagement.dataAccess.WorkGroupMember;
import cl.ricardo.projectManagement.dataAccess.dao.DAOException;
import cl.ricardo.projectManagement.dataAccess.dao.DAOManager;
import javax.swing.JOptionPane;

public class WorkGroupsMembersList extends javax.swing.JFrame {
    
    private DAOManager manager;
    
    private WorkGroupMember workGroupMember;
    
    private WorkGroupMembersTableModel wgMembersTableModel;
    
    private int workGroupId;

    public WorkGroupsMembersList(
            DAOManager manager, 
            WorkGroupMember workGroupMember, 
            int workGroupId
    ) throws DAOException {
        initComponents();
        this.manager = manager;
        this.workGroupMember = workGroupMember;
        this.workGroupId = workGroupId;
        this.wgMembersTableModel = new WorkGroupMembersTableModel(
            manager.getWorkGroupMemberDAO(),
            manager.getWorkGroupDAO(),
            manager.getUserDAO()
        );
        this.wgMembersTableModel.updateModel(workGroupId);
        workGroupsMembersTable.setModel(wgMembersTableModel);
        loadTablesElementsCount();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        workGroupsMembersTable = new javax.swing.JTable();
        txtWorkGroupMembersTableElementsCount = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        btnAddProject = new javax.swing.JButton();
        btnDeleteProject = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(245, 237, 237));

        jLabel1.setBackground(new java.awt.Color(245, 237, 237));
        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Integrantes");

        jScrollPane1.setBackground(new java.awt.Color(245, 237, 237));
        jScrollPane1.setForeground(new java.awt.Color(51, 51, 51));
        jScrollPane1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N

        workGroupsMembersTable.setBackground(new java.awt.Color(245, 237, 237));
        workGroupsMembersTable.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        workGroupsMembersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE INTEGRANTE", "NOMBRE GRUPO", "FECHA INTEGRACION"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        workGroupsMembersTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(workGroupsMembersTable);
        if (workGroupsMembersTable.getColumnModel().getColumnCount() > 0) {
            workGroupsMembersTable.getColumnModel().getColumn(0).setPreferredWidth(10);
            workGroupsMembersTable.getColumnModel().getColumn(1).setPreferredWidth(80);
            workGroupsMembersTable.getColumnModel().getColumn(2).setPreferredWidth(80);
            workGroupsMembersTable.getColumnModel().getColumn(3).setPreferredWidth(80);
        }

        txtWorkGroupMembersTableElementsCount.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtWorkGroupMembersTableElementsCount.setForeground(new java.awt.Color(51, 51, 51));

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

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(btnAddProject, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(btnDeleteProject, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnDeleteProject, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddProject, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Agregar");

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Eliminar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(345, 345, 345))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(290, 290, 290))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(335, 335, 335)
                .addComponent(jLabel2)
                .addGap(38, 38, 38)
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtWorkGroupMembersTableElementsCount, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtWorkGroupMembersTableElementsCount, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddProjectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddProjectMouseClicked
        WorkGroupMembersDetailsPanel workGroupMembersDetailsPanel;
        try {
            workGroupMembersDetailsPanel = new WorkGroupMembersDetailsPanel(
                    manager, 
                    workGroupMember, 
                    wgMembersTableModel,
                    workGroupId
            );
            workGroupMembersDetailsPanel.setVisible(true);
            workGroupMembersDetailsPanel.setLocationRelativeTo(null);
        } catch (DAOException ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_btnAddProjectMouseClicked

    private void btnAddProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddProjectActionPerformed

    private void btnDeleteProjectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteProjectMouseClicked
        if (workGroupsMembersTable.getSelectedRow() >= 0) {
            try {
                int question = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar?");
                if (question == 0) {
                    int selectedRow = workGroupsMembersTable.getSelectedRow();
                    int workGroupMemberId = (int) workGroupsMembersTable.getValueAt(selectedRow, 0);
                    manager.getWorkGroupMemberDAO().delete(workGroupMemberId);
                    JOptionPane.showMessageDialog(null, "Eliminado con éxito");
                    wgMembersTableModel.updateModel(workGroupId);
                    wgMembersTableModel.fireTableDataChanged();
                }
            } catch (DAOException ex) {
                System.out.println(ex.toString());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
        }
    }//GEN-LAST:event_btnDeleteProjectMouseClicked

    private void loadTablesElementsCount() {
        txtWorkGroupMembersTableElementsCount.setText(
            String.valueOf(workGroupsMembersTable.getRowCount()) + " Registros"
        );
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddProject;
    private javax.swing.JButton btnDeleteProject;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel txtWorkGroupMembersTableElementsCount;
    private javax.swing.JTable workGroupsMembersTable;
    // End of variables declaration//GEN-END:variables
}
