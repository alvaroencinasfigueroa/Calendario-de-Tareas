/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package descCalendar.vista;

import desCalendar.controlador.Coordinador;
import descCalendar.modelo.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * 
 */
public class MenuMiembro extends javax.swing.JPanel implements ActionListener {

    Coordinador coordinador;
    Usuario miembro;

    public MenuMiembro() {
        initComponents();
        jBVolver.addActionListener(this);
    }

    public void setMiembro(Usuario l) {
        this.miembro = l;
        jLBienvenida.setText("Bienvenido " + l.getNombre());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLBienvenida = new javax.swing.JLabel();
        jBVolver = new javax.swing.JButton();
        jBTareasPendientes = new javax.swing.JButton();
        jBHistorial = new javax.swing.JButton();
        jBMiPerfil = new javax.swing.JButton();
        jBMostrarMiembros = new javax.swing.JButton();
        jBSalirG = new javax.swing.JButton();

        jLBienvenida.setText("Bienvenido");

        jBVolver.setText("Volver");

        jBTareasPendientes.setText("Tareas pendientes");
        jBTareasPendientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTareasPendientesActionPerformed(evt);
            }
        });

        jBHistorial.setText("Tareas realizadas");
        jBHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBHistorialActionPerformed(evt);
            }
        });

        jBMiPerfil.setText("Mi perfil");
        jBMiPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBMiPerfilActionPerformed(evt);
            }
        });

        jBMostrarMiembros.setText("Mostrar miembros");
        jBMostrarMiembros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBMostrarMiembrosActionPerformed(evt);
            }
        });

        jBSalirG.setText("Salir del grupo");
        jBSalirG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirGActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBVolver)
                .addGap(227, 227, 227)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBSalirG)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLBienvenida)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 279, Short.MAX_VALUE)
                        .addComponent(jBMiPerfil)
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBMostrarMiembros)
                            .addComponent(jBHistorial)
                            .addComponent(jBTareasPendientes))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBVolver)
                    .addComponent(jBMiPerfil)
                    .addComponent(jLBienvenida, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(146, 146, 146)
                .addComponent(jBTareasPendientes)
                .addGap(18, 18, 18)
                .addComponent(jBHistorial)
                .addGap(18, 18, 18)
                .addComponent(jBMostrarMiembros)
                .addGap(18, 18, 18)
                .addComponent(jBSalirG)
                .addContainerGap(154, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBMiPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBMiPerfilActionPerformed
        coordinador.cargarPanel(7, miembro);
    }//GEN-LAST:event_jBMiPerfilActionPerformed

    private void jBTareasPendientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTareasPendientesActionPerformed
        coordinador.cargarPanel(10, miembro);
    }//GEN-LAST:event_jBTareasPendientesActionPerformed

    private void jBHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBHistorialActionPerformed
        coordinador.cargarPanel(12, miembro);
    }//GEN-LAST:event_jBHistorialActionPerformed

    private void jBMostrarMiembrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBMostrarMiembrosActionPerformed
        this.coordinador.cargarPanel(13, miembro);
    }//GEN-LAST:event_jBMostrarMiembrosActionPerformed

    private void jBSalirGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirGActionPerformed
        int res = JOptionPane.showConfirmDialog(null, "¿Seguro quiere salir de este grupo?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (res == JOptionPane.YES_OPTION) {
            Grupo g = coordinador.getLogica().getGrupos().accederM(miembro);
            g.getListIntegrantes().eliminar2(miembro.getUserName());
            miembro.setEstado(false);
            coordinador.getLogica().escribirListas();
            JOptionPane.showMessageDialog(null, "Salio del grupo " + g.getNombre() + "con exito");
            coordinador.cargarPanel(1, miembro);
        }
    }//GEN-LAST:event_jBSalirGActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBHistorial;
    private javax.swing.JButton jBMiPerfil;
    private javax.swing.JButton jBMostrarMiembros;
    private javax.swing.JButton jBSalirG;
    private javax.swing.JButton jBTareasPendientes;
    private javax.swing.JButton jBVolver;
    private javax.swing.JLabel jLBienvenida;
    // End of variables declaration//GEN-END:variables

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object evt = e.getSource();
        if (evt.equals(jBVolver)) {
            coordinador.cargarPanel(1, null);
        }
    }
}
