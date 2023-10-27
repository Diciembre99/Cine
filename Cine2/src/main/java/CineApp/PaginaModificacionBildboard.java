/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package CineApp;

import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import com.toedter.calendar.*;
import static CineApp.EscribirSecuencial.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Jose Vicente Vargas Mestanza <jvsonic9@gmail.com>
 */
public class PaginaModificacionBildboard extends javax.swing.JFrame {

    private LinkedList<Billboard> billboard;
    private ArrayList<String> nombres = new ArrayList();
    private boolean eliminiados = false;
    private JFrame jFrame = new JFrame();

    /**
     *
     * @author JoseVi
     */
    public PaginaModificacionBildboard(LinkedList<Billboard> billboard) {
        this.billboard = billboard;
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int height = pantalla.height;
        ZoneId defaultZoneId = ZoneId.systemDefault();
        int width = pantalla.width;
        setSize(width / 2, height / 2);
        setLocationRelativeTo(null);

        for (Billboard b : billboard) {
            nombres.add(b.getPelicula());
        }
        initComponents();
        jlErrorDatos.setVisible(false);
        jtfTitulo.setText(this.billboard.get(jcPeliculas.getSelectedIndex()).getPelicula());
        jdFInicio.setDate(Date.from(this.billboard.get(jcPeliculas.getSelectedIndex()).getInicio().atStartOfDay(defaultZoneId).toInstant()));
        jdFFin.setDate(Date.from(this.billboard.get(jcPeliculas.getSelectedIndex()).getFinalizacion().atStartOfDay(defaultZoneId).toInstant()));
        jcGenero.setSelectedItem(this.billboard.get(jcPeliculas.getSelectedIndex()).getGenero());
        jcEdad.setSelectedItem(this.billboard.get(jcPeliculas.getSelectedIndex()).getPegi());
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
        jcGenero = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfTitulo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jcEdad = new javax.swing.JComboBox<>();
        btnVolver = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jcPeliculas = new javax.swing.JComboBox<>();
        jcModificar = new javax.swing.JCheckBox();
        jlErrorDatos = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        jcbEliminar = new javax.swing.JCheckBox();
        jdFInicio = new com.toedter.calendar.JDateChooser();
        jdFFin = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setToolTipText("");

        jcGenero.setBackground(new java.awt.Color(204, 204, 204));
        jcGenero.setModel(new DefaultComboBoxModel(Gender.values()));
        jcGenero.setEnabled(false);

        jLabel1.setText("Genero");

        jLabel2.setText("Visualizacion/Modifica de Cartelera");

        jLabel3.setText("Fecha Fin");

        jLabel4.setText("Fecha inicio");

        jLabel5.setText("Titulo");

        jtfTitulo.setBackground(new java.awt.Color(204, 204, 204));
        jtfTitulo.setEnabled(false);

        jLabel6.setText("Restriccion edad");

        jcEdad.setBackground(new java.awt.Color(204, 204, 204));
        jcEdad.setModel(new DefaultComboBoxModel(AgeCategory.values()));
        jcEdad.setEnabled(false);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnGuardar.setText("Modificar");
        btnGuardar.setEnabled(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel7.setText("Selecciona pelicula");

        jcPeliculas.setBackground(new java.awt.Color(204, 204, 204));
        jcPeliculas.setModel(new DefaultComboBoxModel(nombres.toArray()));
        jcPeliculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcPeliculasActionPerformed(evt);
            }
        });

        jcModificar.setText("Modificar ?");
        jcModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificar(evt);
            }
        });

        jlErrorDatos.setForeground(new java.awt.Color(255, 0, 0));
        jlErrorDatos.setText("Faltan datos por introducir");

        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jcbEliminar.setText("Eliminar ?");
        jcbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEliminarActionPerformed(evt);
            }
        });

        jdFInicio.setEnabled(false);

        jdFFin.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnVolver)
                        .addGap(53, 53, 53)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcPeliculas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcModificar)
                            .addComponent(jcbEliminar)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcEdad, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jtfTitulo)
                                    .addComponent(jcGenero, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jdFFin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jdFInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addGap(20, 20, 20))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlErrorDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbEliminar))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jcPeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcModificar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(17, 17, 17)
                        .addComponent(jLabel4)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(34, 34, 34))
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jtfTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30))
                            .addComponent(jdFInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addComponent(jdFFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jlErrorDatos)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVolver)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar))
                .addGap(14, 14, 14))
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
    /**
     *
     * @author JoseVi
     */
    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        if(this.eliminiados){
            realizarCopia();
        }
        escribirSecuencialLista(this.billboard);
        this.setVisible(false);
        new PaginaPrincipal(this.billboard).setVisible(true);
    }//GEN-LAST:event_btnVolverActionPerformed
    /**
     *
     * @author JoseVi
     */
    private void jcPeliculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcPeliculasActionPerformed
        seleccionado();
    }//GEN-LAST:event_jcPeliculasActionPerformed
    /**
     *
     * @author JoseVi
     */
    private void modificar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificar
        boolean seleccionado = jcModificar.isSelected();

        jdFFin.setEnabled(seleccionado);
        jdFInicio.setEnabled(seleccionado);
        jcEdad.setEnabled(seleccionado);
        jtfTitulo.setEnabled(seleccionado);
        jcGenero.setEnabled(seleccionado);
        btnGuardar.setEnabled(seleccionado);
    }//GEN-LAST:event_modificar
    /**
     *
     * @author JoseVi
     */
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String titulo = jtfTitulo.getText(), error = "";
        Instant instant, instant2;
        ZonedDateTime zdt, zdt2;
        Billboard aux;
        LocalDate date, date2;
        Gender genero = (Gender) jcGenero.getSelectedItem();
        AgeCategory edad = (AgeCategory) jcEdad.getSelectedItem();
        LocalDate fIni = null, fFin = null;

        boolean validacion = true, repetido = false;
        jlErrorDatos.setVisible(false);
        if (titulo.isBlank()) {
            validacion = false;
            error = "El titulo no puede estar vacio.\n";
        }

        try {
            instant = jdFInicio.getDate().toInstant();
            zdt = instant.atZone(ZoneId.systemDefault());
            date = zdt.toLocalDate();
            fIni = date;
            instant2 = jdFFin.getDate().toInstant();
            zdt2 = instant2.atZone(ZoneId.systemDefault());
            date2 = zdt2.toLocalDate();
            fFin = date2;
            if(fFin.isBefore(LocalDate.now())){
                validacion = false;
                error += "No puede ser ninguna de las fechas menores que la actual.\n";
            }else if (jdFInicio.getDate().after(jdFFin.getDate())) {
                validacion = false;
                error += "No puede ser menor la fecha de fin que la inicias.\n";
            }
        } catch (NullPointerException npe) {
            validacion = false;
            error += "No pueden estar vacias las fechas.\n";
        }
        
        

        if (validacion) {
            aux = new Billboard(titulo, fIni, fFin, genero, edad);
            for(Billboard b: this.billboard){
                if(b.equals(aux)){
                    repetido=true;
                }
            }
            if (!repetido) {
                this.billboard.set(jcPeliculas.getSelectedIndex(),aux);
                jlErrorDatos.setText("Se ha modificado correctamente la cartelera: " + titulo);
                jlErrorDatos.setVisible(true);
                jlErrorDatos.setForeground(Color.blue);
            }else{
                jlErrorDatos.setText("Ya existe esta cartelera");
                jlErrorDatos.setVisible(true);
                jlErrorDatos.setForeground(Color.red);
            }
            
        } else {
            jlErrorDatos.setForeground(Color.red);
            jlErrorDatos.setText(error);
            jlErrorDatos.setVisible(true);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed
    /**
     *
     * @author JoseVi
     */
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
        this.billboard.remove(jcPeliculas.getSelectedIndex());
        this.eliminiados = true;
        

        if (!this.billboard.isEmpty()) {
            jlErrorDatos.setText("Se ha eliminado la cartelera: " + this.nombres.get(jcPeliculas.getSelectedIndex()));
            jlErrorDatos.setVisible(true);
            jlErrorDatos.setForeground(Color.blue);
            this.nombres.remove(jcPeliculas.getSelectedIndex());
            jcPeliculas.setModel(new DefaultComboBoxModel(nombres.toArray()));

            seleccionado();
        } else {
            realizarCopia();
            this.setVisible(false);
            new PaginaPrincipal(this.billboard).setVisible(true);
        }

    }//GEN-LAST:event_btnEliminarActionPerformed
    /**%
     *
     * @author JoseVi
     */
    private void jcbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbEliminarActionPerformed
        boolean seleccionado = jcbEliminar.isSelected();
        btnEliminar.setEnabled(seleccionado);
    }//GEN-LAST:event_jcbEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> jcEdad;
    private javax.swing.JComboBox<String> jcGenero;
    private javax.swing.JCheckBox jcModificar;
    private javax.swing.JComboBox<String> jcPeliculas;
    private javax.swing.JCheckBox jcbEliminar;
    private com.toedter.calendar.JDateChooser jdFFin;
    private com.toedter.calendar.JDateChooser jdFInicio;
    private javax.swing.JLabel jlErrorDatos;
    private javax.swing.JTextField jtfTitulo;
    // End of variables declaration//GEN-END:variables

    public void seleccionado() {
        ZoneId defaultZoneId = ZoneId.systemDefault();
        jtfTitulo.setText(this.billboard.get(jcPeliculas.getSelectedIndex()).getPelicula());
        jdFInicio.setDate(Date.from(this.billboard.get(jcPeliculas.getSelectedIndex()).getInicio().atStartOfDay(defaultZoneId).toInstant()));
        jdFFin.setDate(Date.from(this.billboard.get(jcPeliculas.getSelectedIndex()).getFinalizacion().atStartOfDay(defaultZoneId).toInstant()));
        jcGenero.setSelectedItem(this.billboard.get(jcPeliculas.getSelectedIndex()).getGenero());
        jcEdad.setSelectedItem(this.billboard.get(jcPeliculas.getSelectedIndex()).getPegi());
        jcModificar.setSelected(false);
        jcbEliminar.setSelected(false);
        btnEliminar.setEnabled(false);
        btnGuardar.setEnabled(false);
    }
    
    public void realizarCopia(){
        int opcionFrame;
        Path origen = FileSystems.getDefault().getPath(".\\Peliculas\\ListadoPeliculas.txt");
        Path destino = FileSystems.getDefault().getPath(".\\CopiaPeliculas\\ListadoPeliculas"+LocalDate.now().toString()+"_"+LocalTime.now().getHour()+"_"+LocalTime.now().getMinute()+"_"+LocalTime.now().getSecond()+".txt");
        opcionFrame = JOptionPane.showOptionDialog(this.jFrame, "Ha eliminado una o varias carteleras, quiere crear una copia de seguridad?", "Elementos eliminados", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, new Object[]{"Si", "No"}, "Si");

            if (opcionFrame == 0) {
                try {
                    Files.move(origen, destino, StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    System.err.println(e);
                }
            }
    }
}
