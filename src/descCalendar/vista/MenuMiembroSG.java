/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package descCalendar.vista;

import desCalendar.controlador.*;
import descCalendar.modelo.*;
import javax.swing.JOptionPane;

/**
 *
 * @author 
 */
public class MenuMiembroSG extends javax.swing.JPanel {

    /**
     * Creates new form MenuMiembroSG
     */
    Coordinador coordinador;
    Usuario miembro;

    public MenuMiembroSG() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBMiPerfil = new javax.swing.JButton();
        jLBienvenida = new javax.swing.JLabel();
        jBVolver = new javax.swing.JButton();
        jCBInvitaciones = new javax.swing.JComboBox<>();
        jBAceptar = new javax.swing.JButton();
        jBRechazar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextInvitacion = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        jBMiPerfil.setText("Mi perfil");
        jBMiPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBMiPerfilActionPerformed(evt);
            }
        });

        jLBienvenida.setText("Bienvenido");

        jBVolver.setText("Volver");
        jBVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVolverActionPerformed(evt);
            }
        });

        jCBInvitaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBInvitacionesActionPerformed(evt);
            }
        });

        jBAceptar.setText("Aceptar");
        jBAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAceptarActionPerformed(evt);
            }
        });

        jBRechazar.setText("Rechazar");
        jBRechazar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRechazarActionPerformed(evt);
            }
        });

        jTextInvitacion.setColumns(20);
        jTextInvitacion.setRows(5);
        jScrollPane1.setViewportView(jTextInvitacion);

        jLabel1.setText("Grupos que te invitaron");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBVolver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLBienvenida)
                                .addGap(33, 33, 33))
                            .addComponent(jLabel1)
                            .addComponent(jCBInvitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(161, 161, 161))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(jBMiPerfil)
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBAceptar)
                .addGap(38, 38, 38)
                .addComponent(jBRechazar)
                .addGap(252, 252, 252))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBVolver)
                    .addComponent(jLBienvenida)
                    .addComponent(jBMiPerfil))
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCBInvitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBRechazar)
                    .addComponent(jBAceptar))
                .addContainerGap(104, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBMiPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBMiPerfilActionPerformed
        coordinador.cargarPanel(7, miembro);
    }//GEN-LAST:event_jBMiPerfilActionPerformed

    private void jBRechazarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRechazarActionPerformed
        if (jCBInvitaciones.getSelectedItem() != null) {
            Invitacion i =  miembro.getInvitaciones().acceder(jCBInvitaciones.getSelectedItem().toString());
            miembro.getInvitaciones().eliminar(jCBInvitaciones.getSelectedItem().toString());
            llenarJCBInvitaciones(coordinador, miembro);
        }
    }//GEN-LAST:event_jBRechazarActionPerformed

    private void jBVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVolverActionPerformed
        coordinador.cargarPanel(1, miembro);
    }//GEN-LAST:event_jBVolverActionPerformed

    private void jCBInvitacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBInvitacionesActionPerformed
        
        if (jCBInvitaciones.getSelectedItem() != null) {
            Invitacion i =  miembro.getInvitaciones().acceder(jCBInvitaciones.getSelectedItem().toString());
            jTextInvitacion.setText(i.getMensaje());
        }
    }//GEN-LAST:event_jCBInvitacionesActionPerformed

    private void jBAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAceptarActionPerformed
        if (jCBInvitaciones.getSelectedItem() != null) {
            Grupo g = coordinador.getLogica().getGrupos().acceder(jCBInvitaciones.getSelectedItem().toString());
            g.getListIntegrantes().agregar(miembro);
            miembro.setEstado(true);
            g.getListIntegrantes().acceder(miembro.getUserName()).getInvitaciones().vaciar();
            coordinador.getLogica().getUsuarios().acceder(miembro.getUserName()).getInvitaciones().vaciar();
            miembro.getInvitaciones().vaciar();
            JOptionPane.showMessageDialog(null, "Bienvenido al grupo "+g.getNombre());
            coordinador.getLogica().escribirListas();
            coordinador.cargarPanel(5, miembro);
        }
    }//GEN-LAST:event_jBAceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAceptar;
    private javax.swing.JButton jBMiPerfil;
    private javax.swing.JButton jBRechazar;
    private javax.swing.JButton jBVolver;
    private javax.swing.JComboBox<String> jCBInvitaciones;
    private javax.swing.JLabel jLBienvenida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextInvitacion;
    // End of variables declaration//GEN-END:variables

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    public void setMiembro(Usuario l) {
        this.miembro = l;
    }
    
    public void reinicio(){
        jTextInvitacion.setText("");
        jCBInvitaciones.removeAllItems();
    }

    public void llenarJCBInvitaciones(Coordinador c, Usuario l) {
        jCBInvitaciones.removeAllItems();

        int i = 0;
        while (l.getInvitaciones().acceder(i) != null) {
            jCBInvitaciones.addItem(l.getInvitaciones().acceder(i).getGrupo().getNombre());
            i++;
        }
    }
}
