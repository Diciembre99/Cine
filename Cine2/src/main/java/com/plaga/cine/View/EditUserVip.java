/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.plaga.cine.View;

import com.plaga.cine.FilesManage.RandomFilesFunction;
import com.plaga.cine.Modules.Client;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author KRene
 */
public class EditUserVip extends javax.swing.JFrame {

    /**
     * Creates new form EditUserVip
     */
    public EditUserVip() {
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int height = pantalla.height;
        int width = pantalla.width;
        setSize(width / 2, height / 2);
        setLocationRelativeTo(null);
        initComponents();
        File file = new File(".\\ClientesVip\\ClientesVip.txt");
        List<Client> userVips = RandomFilesFunction.ReadFile(file);
        for (Client vip : userVips) {
            cbVips.addItem(vip.getNombre());
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbVips = new javax.swing.JComboBox<>();
        txtName = new javax.swing.JTextField();
        txtDNI = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cbVips.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbVipsActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre");

        jLabel2.setText("DNI");

        jLabel3.setText("Edad");

        btnDelete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBack.setText("Terminar");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEdit.setText("Editar");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addComponent(cbVips, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3))
                                                .addGap(21, 21, 21)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(txtDNI, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                                                        .addComponent(txtName)
                                                        .addComponent(txtAge))))
                                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cbVips, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                                        .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Muestra la informacion del usuario en los TextBox correspondientes
     *
     * @param evt
     */
    private void cbVipsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbVipsActionPerformed
        File file = new File(".\\ClientesVip\\ClientesVip.txt");
        List<Client> userVips = RandomFilesFunction.ReadFile(file);
        if (cbVips.getItemCount() != 0) {
            txtName.setText(userVips.get(cbVips.getSelectedIndex()).getNombre());
            txtAge.setText(String.valueOf(userVips.get(cbVips.getSelectedIndex()).getEdad()));
            txtDNI.setText(userVips.get(cbVips.getSelectedIndex()).getDni());
        }

    }//GEN-LAST:event_cbVipsActionPerformed

    /**
     * Boton que elimina un usuario especifico
     *
     * @param evt
     */
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        File file = new File(".\\ClientesVip\\ClientesVip.txt");
        List<Client> userVips = RandomFilesFunction.ReadFile(file);
        int index = cbVips.getSelectedIndex();
        try {
            RandomFilesFunction.DeleteUser(file, index);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (cbVips.getItemCount() <= 1) {
            JOptionPane.showMessageDialog(null, "No quedan mas usuarios en la lista", "INFO", JOptionPane.INFORMATION_MESSAGE);
            this.setVisible(false);
            new UserVip().setVisible(true);
        } else {
            cbVips.removeItemAt(index);
        }


    }//GEN-LAST:event_btnDeleteActionPerformed

    /**
     * Boton para volver a la pagina de usuarios Vip
     *
     * @param evt
     */
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.setVisible(false);
        new UserVip().setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        String regex = "^(\\d{8})([A-HJ-NP-TV-Z])$"; //REGEX del DNI
        Pattern pattern = Pattern.compile(regex);
        int index = cbVips.getSelectedIndex();
        String name = txtName.getText();
        String DNI = txtDNI.getText();
        Matcher matcher = pattern.matcher(DNI);
        int age = Integer.parseInt(txtAge.getText());
        //Construimos un objeto apartir de los datos de los campos de textos
        Client userVip = new Client(name, DNI, age);
        File file = new File(".\\ClientesVip\\ClientesVip.txt");
        //Verificamos que los datos estan completos correctamente
        if (matcher.matches()&& !name.isBlank() && age > 0 && age<100) {
            RandomFilesFunction.EdirUserVip(userVip, file, index);
            List<Client> userVips = RandomFilesFunction.ReadFile(file);
            //Actualizamos la lista con los nuevos datos
            cbVips.removeAllItems();
            for (Client vip : userVips) {
                cbVips.addItem(vip.getNombre());
            }
        }else{
            JOptionPane.showMessageDialog(null, "Debes completar los campos correctamente", "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnEditActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JComboBox<String> cbVips;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
