/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package CineApp;

import static CineApp.EscribirSecuencial.escribirSecuencialLista;
import static CineApp.LeerSecuencial.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Jose Vicente Vargas Mestanza <jvsonic9@gmail.com>
 */
public class PaginaPrincipal extends javax.swing.JFrame {

    private LinkedList<Billboard> bildboard = new LinkedList();

    /**
     *
     * @author JoseVi
     */
    public PaginaPrincipal() {
        File carpetasFunciones = new File(".\\Funciones");
        String[] fechasFunciones = carpetasFunciones.list();
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int height = pantalla.height;
        int width = pantalla.width;
        setSize(width / 2, height / 2);
        setLocationRelativeTo(null);

        initComponents();
        jlError.setVisible(false);
        this.bildboard = leerSecuencial();
        for (String s : fechasFunciones) {
            if (LocalDate.parse(s).isBefore(LocalDate.now())) {
                moverCarpetasObsoletas(s);
            }
        }

    }

    /**
     *
     * @author JoseVi
     * @param bildboard
     */
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
        btnImportar = new javax.swing.JButton();
        btnExportar = new javax.swing.JButton();
        btnImportarSax = new javax.swing.JButton();

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

        btnImportar.setText("Importar XML");
        btnImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportarActionPerformed(evt);
            }
        });

        btnExportar.setText("Exportar XML");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        btnImportarSax.setText("Importar XML(SAX)");
        btnImportarSax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportarSaxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlError, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnCambiarProgramacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnNuevaFuncion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel2)
                            .addComponent(btnImportar))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCambiarCartelera)
                                    .addComponent(btnNuevaPelicula))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnImportarSax, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnExportar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(14, 14, 14))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlError)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(73, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCambiarCartelera)
                            .addComponent(btnExportar))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNuevaPelicula)
                            .addComponent(btnImportarSax))))
                .addGap(12, 12, 12)
                .addComponent(btnImportar)
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
    /**
     *
     * @author JoseVi
     */
    private void btnCambiarCarteleraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarCarteleraActionPerformed
        if (!this.bildboard.isEmpty()) {
            this.setVisible(false);
            new PaginaModificacionBildboard(this.bildboard).setVisible(true);
        } else {
            jlError.setVisible(true);
        }
    }//GEN-LAST:event_btnCambiarCarteleraActionPerformed
    /**
     *
     * @author JoseVi
     */
    private void btnNuevaPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaPeliculaActionPerformed
        this.setVisible(false);
        new PaginaCreacionBildboard(this.bildboard).setVisible(true);
    }//GEN-LAST:event_btnNuevaPeliculaActionPerformed
    /**
     *
     * @author JoseVi
     */
    private void btnCambiarProgramacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarProgramacionActionPerformed
        this.setVisible(false);
        new PaginaModificaionFunctions(this.bildboard).setVisible(true);
    }//GEN-LAST:event_btnCambiarProgramacionActionPerformed
    /**
     *
     * @author JoseVi
     */
    private void btnNuevaFuncionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaFuncionActionPerformed
        if (!this.bildboard.isEmpty()) {
            this.setVisible(false);
            new PaginaCreacionFunctions(this.bildboard).setVisible(true);
        } else {
            jlError.setVisible(true);
        }
    }//GEN-LAST:event_btnNuevaFuncionActionPerformed

    private void btnImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportarActionPerformed
        JFileChooser fileChooser = new JFileChooser(".\\DOM");
        File ruta;
        boolean agregar;
        int contAgre = 0;
        int contDesc = 0;
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo XML", "xml");

        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setDialogTitle("Selecciona un archivo tipo xml");
        fileChooser.setMultiSelectionEnabled(false);
        fileChooser.setFileFilter(filter);
        if (fileChooser.showOpenDialog(this) != JFileChooser.CANCEL_OPTION) {
            ruta = fileChooser.getSelectedFile().getAbsoluteFile();
            //ReaderDom.leerBillboard(ruta);
            for (Billboard b : ReaderDom.leerBillboard(ruta)) {
                agregar = true;
                for (Billboard b2 : this.bildboard) {
                    if (b.equals(b2)) {
                        agregar = false;
                    }
                }
                if (agregar) {
                    this.bildboard.add(b);
                    contAgre++;
                } else {
                    contDesc++;
                }
            }
            escribirSecuencialLista(this.bildboard);
            JOptionPane.showMessageDialog(rootPane, "Se han guardado "+contAgre+" carteleras\n Se han descartado "+contDesc+" carteleras");

        }

    }//GEN-LAST:event_btnImportarActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        JFileChooser fileChooser = new JFileChooser(".\\DOM");
        File ruta;

        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setDialogTitle("Selecciona un archivo tipo xml");
        fileChooser.setMultiSelectionEnabled(false);
        if (fileChooser.showOpenDialog(this) != JFileChooser.CANCEL_OPTION) {
            ruta = fileChooser.getSelectedFile().getAbsoluteFile();
            ReaderDom.escribirBillboard(this.bildboard, ruta);

        }
    }//GEN-LAST:event_btnExportarActionPerformed

    private void btnImportarSaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportarSaxActionPerformed
        JFileChooser fileChooser = new JFileChooser(".\\DOM");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo XML", "xml");
        File ruta;

        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setDialogTitle("Selecciona un archivo tipo xml");
        fileChooser.setMultiSelectionEnabled(false);
        fileChooser.setFileFilter(filter);
        if (fileChooser.showOpenDialog(this) != JFileChooser.CANCEL_OPTION) {

            ruta = fileChooser.getSelectedFile().getAbsoluteFile();
            JOptionPane.showMessageDialog(rootPane, "Se ha importado correctamente");
        }
    }//GEN-LAST:event_btnImportarSaxActionPerformed

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

    private void moverCarpetasObsoletas(String fecha) {
        File from = new File(".\\Funciones\\" + fecha);
        File to = new File(".\\FuncionesAntiguas\\" + fecha);

        try {
            Files.move(from.toPath(), to.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiarCartelera;
    private javax.swing.JButton btnCambiarProgramacion;
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton btnImportar;
    private javax.swing.JButton btnImportarSax;
    private javax.swing.JButton btnNuevaFuncion;
    private javax.swing.JButton btnNuevaPelicula;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlError;
    // End of variables declaration//GEN-END:variables
}
