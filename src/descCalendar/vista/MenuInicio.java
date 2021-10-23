/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package descCalendar.vista;

import desCalendar.controlador.Coordinador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author 
 */
public class MenuInicio extends javax.swing.JPanel implements ActionListener{

    private Coordinador coordinador;
    //Creditos creditos = new Creditos();

    public MenuInicio() {
        initComponents();
        
        jBRegistrarse.addActionListener(this);
        jBAcceder.addActionListener(this);
        jBMostrarGrupos.addActionListener(this);
        credito.addActionListener(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jBMostrarGrupos = new javax.swing.JButton();
        jBAcceder = new javax.swing.JButton();
        jBRegistrarse = new javax.swing.JButton();
        credito = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 102, 102));
        setPreferredSize(new java.awt.Dimension(720, 480));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("DescCalendar V2.9");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));

        jBMostrarGrupos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/descCalendar/vista/mostrarGrupos.png"))); // NOI18N
        jBMostrarGrupos.setText("MOSTRAR GRUPOS");
        jBMostrarGrupos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBMostrarGruposActionPerformed(evt);
            }
        });
        add(jBMostrarGrupos, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, 220, -1));

        jBAcceder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/descCalendar/vista/acceder.png"))); // NOI18N
        jBAcceder.setText("ACCEDER");
        add(jBAcceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 220, -1));

        jBRegistrarse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/descCalendar/vista/registrarse1.png"))); // NOI18N
        jBRegistrarse.setText("REGISTRARSE");
        add(jBRegistrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 220, -1));

        credito.setText("CREDITOS");
        credito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creditoActionPerformed(evt);
            }
        });
        add(credito, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 420, 130, -1));

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setText("SALIR DE LA APLICACION");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jBMostrarGruposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBMostrarGruposActionPerformed

    }//GEN-LAST:event_jBMostrarGruposActionPerformed

    private void creditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creditoActionPerformed
        //Creditos cr = new Creditos();
        //creditos.setVisible(true);
    }//GEN-LAST:event_creditoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton credito;
    private javax.swing.JButton jBAcceder;
    private javax.swing.JButton jBMostrarGrupos;
    private javax.swing.JButton jBRegistrarse;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object evt = e.getSource();
        if(evt.equals(jBRegistrarse)){
            coordinador.cargarPanel(2,null);
        }
        if(evt.equals(jBAcceder)){
            coordinador.cargarPanel(3,null);
        }
        if(evt.equals(jBMostrarGrupos)){
            coordinador.cargarPanel(6,null);
        }
        if(evt.equals(credito)){
            coordinador.cargarPanel(16, null);
        }
    }
}