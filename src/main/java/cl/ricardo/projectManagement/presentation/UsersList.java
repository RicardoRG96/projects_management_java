package cl.ricardo.projectManagement.presentation;

import cl.ricardo.projectManagement.dataAccess.dao.DAOException;
import cl.ricardo.projectManagement.dataAccess.dao.DAOManager;
import cl.ricardo.projectManagement.dataAccess.dao.mysql.MySQLDaoManager;
import java.sql.SQLException;

public class UsersList extends javax.swing.JFrame {
    
    private DAOManager manager;
    
    private UsersTableModel model;
    
    public UsersList(DAOManager manager) throws DAOException {
        initComponents();
        this.manager = manager;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        usersTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(245, 237, 237));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Lista de usuarios");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 170, 20));

        jPanel2.setBackground(new java.awt.Color(245, 237, 237));

        btnDeleteUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar_usuario.png"))); // NOI18N
        btnDeleteUser.setBorder(null);
        btnDeleteUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnEditUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        btnEditUser.setBorder(null);
        btnEditUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(150, Short.MAX_VALUE)
                .addComponent(btnDeleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnEditUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(209, 209, 209))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnDeleteUser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnEditUser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 470, 40));

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
                false, false, false, false
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
    
    public static void main(String args[]) throws SQLException {
        DAOManager manager = new MySQLDaoManager("localhost", "project_management_system", "root", "");
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new UsersList(manager).setVisible(true);
            } catch (DAOException ex) {
                System.out.println(ex.toString());
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteUser;
    private javax.swing.JButton btnEditUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable usersTable;
    // End of variables declaration//GEN-END:variables
}
