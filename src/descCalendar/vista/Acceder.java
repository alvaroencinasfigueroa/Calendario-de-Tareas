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
public class Acceder extends javax.swing.JPanel {

    Coordinador coordinador;

    public Acceder() {
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

        jLAcceder = new javax.swing.JLabel();
        jLUserName = new javax.swing.JLabel();
        jLContra = new javax.swing.JLabel();
        jTxtUserName = new javax.swing.JTextField();
        jPContra = new javax.swing.JPasswordField();
        jBVolver = new javax.swing.JButton();
        jBAceptar = new javax.swing.JButton();

        jLAcceder.setText("Acceder");

        jLUserName.setText("Nombre de usuario:");

        jLContra.setText("Contraseña:");

        jBVolver.setText("Volver");
        jBVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVolverActionPerformed(evt);
            }
        });

        jBAceptar.setText("Aceptar");
        jBAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBVolver)
                        .addGap(249, 249, 249)
                        .addComponent(jLAcceder))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLContra)
                            .addComponent(jLUserName))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPContra, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBAceptar))))
                .addContainerGap(247, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBVolver)
                    .addComponent(jLAcceder))
                .addGap(92, 92, 92)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLUserName)
                    .addComponent(jTxtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLContra)
                    .addComponent(jPContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                .addComponent(jBAceptar)
                .addGap(120, 120, 120))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVolverActionPerformed
        coordinador.cargarPanel(1, null);
    }//GEN-LAST:event_jBVolverActionPerformed

    private String nomGrupo(Usuario lider) {
        String nombre = "";
        try {
            while (nombre.equals("")) {
                nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del grupo");
            }
        } catch (Exception e) {
            nombre = nomGrupo(lider);
        }
        if (coordinador.getLogica().validarGrupo(nombre, lider)) {
            return nombre;
        } else {
            JOptionPane.showMessageDialog(null, "El Nombre ya existe, ingrese otro");
            return nomGrupo(lider);
        }

    }

    private void jBAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAceptarActionPerformed
        if (coordinador.getLogica().validarUsuario(jTxtUserName.getText(), jPContra.getText())) {
            Usuario s = coordinador.getLogica().getUsuarios().acceder(jTxtUserName.getText());
            if (s.getLider()) {
                if (!s.getEstado()) {
                    String nombre = nomGrupo(s);
                    coordinador.getLogica().crearGrupo(nombre, s);
                    s.setEstado(true);
                    coordinador.getLogica().escribirListas();
                }
                limpiar();
                coordinador.cargarPanel(4, s);
            } else {
                limpiar();
                if (s.getEstado()) {
                    coordinador.cargarPanel(5, s);
                } else {
                    coordinador.cargarPanel(15, s);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Los datos ingresados son incorrectos");
            limpiar();
        }
    }//GEN-LAST:event_jBAceptarActionPerformed

    private void limpiar() {
        jTxtUserName.setText("");
        jPContra.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAceptar;
    private javax.swing.JButton jBVolver;
    private javax.swing.JLabel jLAcceder;
    private javax.swing.JLabel jLContra;
    private javax.swing.JLabel jLUserName;
    private javax.swing.JPasswordField jPContra;
    private javax.swing.JTextField jTxtUserName;
    // End of variables declaration//GEN-END:variables

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }
}
