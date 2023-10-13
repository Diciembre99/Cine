/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package CineApp;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.LinkedList;

/**
 *
 * @author Jose Vicente Vargas Mestanza <jvsonic9@gmail.com>
 */
public class PaginaPrincipal extends javax.swing.JFrame {

    private LinkedList<Billboard> bildboard = new LinkedList();

    /**
     * Creates new form Prueba
     */
    public PaginaPrincipal() {
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int height = pantalla.height;
        int width = pantalla.width;
        setSize(width / 2, height / 2);
        setLocationRelativeTo(null);
        initComponents();
        jlError.setVisible(false);

    }

    public PaginaPrincipal(LinkedList<Billboard> bildboard) {
        this.bildboard = bildboard;
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int height = pantalla.height;
        int width = pantalla.width;
        setSize(width / 2, height / 2);
        setLocationRelativeTo(null);

        initComponents();
        jlError.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnCambiarCartelera = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnCambiarProgramacion = new javax.swing.JButton();
        btnNuevaPelicula = new javax.swing.JButton();
        btnNuevaFuncion = new javax.swing.JButton();
        jlError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnCambiarCartelera.setText("Cambiar cartelera");
        btnCambiarCartelera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarCarteleraActionPerformed(evt);
            }
        });

        jLabel1.setText("Bienvenido a la gestion de funciones y cartelera del cine \"La Plaga\"");

        jLabel2.setText("Opciones Cartelera");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Opciones Funciones");

        btnCambiarProgramacion.setText("Cambiar programacion Funcion");
        btnCambiarProgramacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarProgramacionActionPerformed(evt);
            }
        });

        btnNuevaPelicula.setText("Nueva cartelera");
        btnNuevaPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaPeliculaActionPerformed(evt);
            }
        });

        btnNuevaFuncion.setText("Crear Nueva Funcion");
        btnNuevaFuncion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaFuncionActionPerformed(evt);
            }
        });

        jlError.setForeground(new java.awt.Color(255, 0, 0));
        jlError.setText("No hay ninguna cartelera disponible");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(14, 14, 14))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2)
                                .addComponent(btnCambiarCartelera)
                                .addComponent(btnCambiarProgramacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnNuevaPelicula)
                                .addComponent(btnNuevaFuncion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jlError, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCambiarCartelera)
                .addGap(12, 12, 12)
                .addComponent(btnNuevaPelicula)
                .addGap(11, 11, 11)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(btnCambiarProgramacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNuevaFuncion)
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCambiarCarteleraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarCarteleraActionPerformed
        if (!this.bildboard.isEmpty()) {
            this.setVisible(false);
            new PaginaModificacionBildboard(this.bildboard).setVisible(true);
        } else {
            jlError.setVisible(true);
        }
    }//GEN-LAST:event_btnCambiarCarteleraActionPerformed

    private void btnNuevaPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaPeliculaActionPerformed
        this.setVisible(false);
        new PaginaCreacionBildboard(this.bildboard).setVisible(true);
    }//GEN-LAST:event_btnNuevaPeliculaActionPerformed

    private void btnCambiarProgramacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarProgramacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCambiarProgramacionActionPerformed

    private void btnNuevaFuncionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaFuncionActionPerformed

    }//GEN-LAST:event_btnNuevaFuncionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PaginaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaginaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaginaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaginaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaginaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiarCartelera;
    private javax.swing.JButton btnCambiarProgramacion;
    private javax.swing.JButton btnNuevaFuncion;
    private javax.swing.JButton btnNuevaPelicula;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlError;
    // End of variables declaration//GEN-END:variables
}