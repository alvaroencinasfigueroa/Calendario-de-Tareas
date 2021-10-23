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
import javax.swing.JTextField;

/**
 *
 * 
 */
public class Registro extends javax.swing.JPanel implements ActionListener {

    private Coordinador coordinador;

    public Registro() {
        initComponents();
        jBVolver.addActionListener(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLRegistro = new javax.swing.JLabel();
        jLNombre = new javax.swing.JLabel();
        jLApellido = new javax.swing.JLabel();
        jLUserName = new javax.swing.JLabel();
        jLDir = new javax.swing.JLabel();
        jLCorreo = new javax.swing.JLabel();
        jLContra = new javax.swing.JLabel();
        jLTelf = new javax.swing.JLabel();
        jBGuardar = new javax.swing.JButton();
        jBLimpiar = new javax.swing.JButton();
        jCBLider = new javax.swing.JCheckBox();
        jTxtNombre = new javax.swing.JTextField();
        jTxtApellido = new javax.swing.JTextField();
        jTxtUserName = new javax.swing.JTextField();
        jTxtDir = new javax.swing.JTextField();
        jTxtCorreo = new javax.swing.JTextField();
        jPContra = new javax.swing.JPasswordField();
        jTxtTelf = new javax.swing.JTextField();
        jBVolver = new javax.swing.JButton();

        jLRegistro.setText("Registro");

        jLNombre.setText("Nombre:");

        jLApellido.setText("Apellido:");

        jLUserName.setText("Nombre de usuario:");

        jLDir.setText("Dirección:");

        jLCorreo.setText("Correo:");

        jLContra.setText("Contraseña:");

        jLTelf.setText("Celular:");

        jBGuardar.setText("Guardar");
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });

        jBLimpiar.setText("Limpiar");
        jBLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimpiarActionPerformed(evt);
            }
        });

        jCBLider.setText("Lider");

        jTxtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtNombreKeyTyped(evt);
            }
        });

        jTxtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtApellidoKeyTyped(evt);
            }
        });

        jTxtTelf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtTelfKeyTyped(evt);
            }
        });

        jBVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/descCalendar/vista/volver.png"))); // NOI18N
        jBVolver.setText("Volver");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBVolver)
                .addGap(112, 112, 112)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLUserName)
                            .addComponent(jLDir)
                            .addComponent(jLCorreo)
                            .addComponent(jLContra)
                            .addComponent(jLTelf))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTxtUserName)
                            .addComponent(jTxtDir)
                            .addComponent(jTxtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPContra, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtTelf, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLRegistro)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLApellido)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBGuardar)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jCBLider))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(jBLimpiar)))
                        .addGap(82, 82, 82)))
                .addContainerGap(155, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBVolver)
                    .addComponent(jLRegistro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNombre)
                    .addComponent(jLApellido)
                    .addComponent(jTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLUserName)
                    .addComponent(jTxtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLDir)
                    .addComponent(jTxtDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLCorreo)
                    .addComponent(jTxtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLContra)
                    .addComponent(jPContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLTelf)
                    .addComponent(jTxtTelf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addComponent(jCBLider)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBGuardar)
                    .addComponent(jBLimpiar))
                .addGap(46, 46, 46))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
        if (jTxtNombre.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese el nombre");
        } else if (jTxtApellido.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese el apellido");
        } else if (jTxtUserName.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese el nombre de usuario");
        } else if (jTxtCorreo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese el correo");
        } else if (jPContra.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese la contraseña");
        } else if (jTxtTelf.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese el número de celular");
        } else if (!coordinador.getLogica().validarCorreo(jTxtCorreo.getText())) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese un correo válido");
        } else if (!coordinador.getLogica().validarTelf(Integer.parseInt(jTxtTelf.getText()))) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese un celular válido");
        } else if (!coordinador.getLogica().validarContra(jPContra.getText())) {
            JOptionPane.showMessageDialog(null, "Por favor ingresa una contraseña de tamaño mayor a 4 caracteres, que no contenga simbolos");
        } else if (!coordinador.getLogica().validarNombreUsuario(jTxtUserName.getText())) {
            JOptionPane.showMessageDialog(null, "El nombre de usuario ya existe, ingresa otro");
        } else {
            String nombre = jTxtNombre.getText();
            String ap = jTxtApellido.getText();
            String uN = jTxtUserName.getText();
            String dir = jTxtDir.getText();
            String correo = jTxtCorreo.getText();
            String contra = jPContra.getText();
            String telf = jTxtTelf.getText();
            if (jCBLider.isSelected()) {
                Usuario u = new Usuario(nombre, ap, uN, dir, correo, contra, Integer.parseInt(telf));
                u.setLider(true);
                coordinador.getLogica().guardarUsuario(u);
            } else {
                Usuario u = new Usuario(nombre, ap, uN, dir, correo, contra, Integer.parseInt(telf));
                coordinador.getLogica().guardarUsuario(u);
            }
            limpiar();
            JOptionPane.showMessageDialog(null, "Creado con éxito");
            coordinador.getLogica().escribirListas();
        }


    }//GEN-LAST:event_jBGuardarActionPerformed

    private void jTxtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtNombreKeyTyped
        char caracter = evt.getKeyChar();
        if (!Character.isLetter(caracter) && !Character.isSpaceChar(caracter)) {
            evt.consume();
        }
    }//GEN-LAST:event_jTxtNombreKeyTyped

    private void jTxtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtApellidoKeyTyped
        char caracter = evt.getKeyChar();
        if (!Character.isLetter(caracter) && !Character.isSpaceChar(caracter)) {
            evt.consume();
        }
    }//GEN-LAST:event_jTxtApellidoKeyTyped

    private void jTxtTelfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtTelfKeyTyped
        char caracter = evt.getKeyChar();
        if (!Character.isDigit(caracter)) {
            evt.consume();
        }
    }//GEN-LAST:event_jTxtTelfKeyTyped

    private void jBLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_jBLimpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBLimpiar;
    private javax.swing.JButton jBVolver;
    private javax.swing.JCheckBox jCBLider;
    private javax.swing.JLabel jLApellido;
    private javax.swing.JLabel jLContra;
    private javax.swing.JLabel jLCorreo;
    private javax.swing.JLabel jLDir;
    private javax.swing.JLabel jLNombre;
    private javax.swing.JLabel jLRegistro;
    private javax.swing.JLabel jLTelf;
    private javax.swing.JLabel jLUserName;
    private javax.swing.JPasswordField jPContra;
    private javax.swing.JTextField jTxtApellido;
    private javax.swing.JTextField jTxtCorreo;
    private javax.swing.JTextField jTxtDir;
    private javax.swing.JTextField jTxtNombre;
    private javax.swing.JTextField jTxtTelf;
    private javax.swing.JTextField jTxtUserName;
    // End of variables declaration//GEN-END:variables

    public void limpiar() {
        jTxtNombre.setText("");
        jTxtApellido.setText("");
        jTxtUserName.setText("");
        jTxtDir.setText("");
        jTxtCorreo.setText("");
        jTxtTelf.setText("");
        jPContra.setText("");
        jCBLider.setSelected(false);
    }

    public void setCoordinador(Coordinador c) {
        coordinador = c;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object evt = e.getSource();
        if (evt.equals(jBVolver)) {
            coordinador.cargarPanel(1, null);
        }
    }
}
