/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package descCalendar.vista;

/**
 *
 * 
 */
import javax.swing.DefaultListModel;
import desCalendar.controlador.*;
import descCalendar.modelo.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MostrarGrupos extends javax.swing.JPanel implements ActionListener{

    /**
     * Creates new form MostrarGrupos
     */
    DefaultListModel nomGrupos;
    Coordinador coordinador;
    
    public MostrarGrupos() {
        
        initComponents();
        jBVolver.addActionListener(this);
        nomGrupos = new DefaultListModel();
        jListaGrupos.setModel(nomGrupos);
        jTextDetGrupo.setEditable(false);
    }
    
    public void actualizarLNombresGrupos(Coordinador coor){
        nomGrupos.removeAllElements();
        if(coor.getLogica().getGrupos()!=null){
            for(int i=0;i+1<=coor.getLogica().getGrupos().tamanio();i++){
                nomGrupos.addElement(coor.getLogica().getGrupos().accederPos(i).getNombre());
            }
            jListaGrupos.setModel(nomGrupos);
        }
    }
    
    private void mostrar(){
        jTextDetGrupo.setText("");
        if(coordinador.getLogica().getGrupos().tamanio()!=0&&!jListaGrupos.isSelectionEmpty()){
            int pos = jListaGrupos.getSelectedIndex();
            jTextDetGrupo.setText(coordinador.getLogica().getGrupos().accederPos(pos).toString());
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLGrupos = new javax.swing.JLabel();
        jBMostrarD = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListaGrupos = new javax.swing.JList<>();
        jLSelecGrupo = new javax.swing.JLabel();
        jLDetGrupo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextDetGrupo = new javax.swing.JTextArea();
        jBVolver = new javax.swing.JButton();
        jLBuscarGrupo = new javax.swing.JLabel();
        jRBMiembro = new javax.swing.JRadioButton();
        jRBNomGrupo = new javax.swing.JRadioButton();
        jTextBusqueda = new javax.swing.JTextField();
        jBBuscar = new javax.swing.JButton();

        jLGrupos.setText("Grupos:");

        jBMostrarD.setText("Mostrar Detalles");
        jBMostrarD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBMostrarDActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jListaGrupos);

        jLSelecGrupo.setText("Seleccione un Grupo:");

        jLDetGrupo.setText("Detalles de Grupo:");

        jTextDetGrupo.setColumns(20);
        jTextDetGrupo.setRows(5);
        jScrollPane2.setViewportView(jTextDetGrupo);

        jBVolver.setText("Volver");
        jBVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVolverActionPerformed(evt);
            }
        });

        jLBuscarGrupo.setText("Buscar Grupo por nombre:");

        jRBMiembro.setText("Usuario");
        jRBMiembro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBMiembroActionPerformed(evt);
            }
        });

        jRBNomGrupo.setText("Grupo");
        jRBNomGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBNomGrupoActionPerformed(evt);
            }
        });

        jBBuscar.setText("Buscar");
        jBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarActionPerformed(evt);
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
                        .addGap(236, 236, 236)
                        .addComponent(jLGrupos))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLDetGrupo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jBMostrarD)
                                    .addComponent(jLBuscarGrupo)
                                    .addComponent(jLSelecGrupo)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jRBMiembro)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jRBNomGrupo))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jBBuscar))))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(147, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBVolver)
                    .addComponent(jLGrupos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLSelecGrupo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBMostrarD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLBuscarGrupo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRBMiembro)
                            .addComponent(jRBNomGrupo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBBuscar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLDetGrupo)))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBMostrarDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBMostrarDActionPerformed
        mostrar();
    }//GEN-LAST:event_jBMostrarDActionPerformed

    private void jBVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVolverActionPerformed
        coordinador.cargarPanel(1,null);
    }//GEN-LAST:event_jBVolverActionPerformed

    private void jRBMiembroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBMiembroActionPerformed
        if(jRBMiembro.isSelected()){
            jRBNomGrupo.setSelected(false);
        }
    }//GEN-LAST:event_jRBMiembroActionPerformed

    private void jRBNomGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBNomGrupoActionPerformed
        if(jRBNomGrupo.isSelected()){
            jRBMiembro.setSelected(false);
        }
    }//GEN-LAST:event_jRBNomGrupoActionPerformed

    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed
        String nombre = jTextBusqueda.getText();
            Buscar(nombre);
    }//GEN-LAST:event_jBBuscarActionPerformed

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }
    
    private void Buscar(String nom){
        boolean nada = true;
        jTextDetGrupo.setText("");
        if(jRBNomGrupo.isSelected()&&coordinador.getLogica().getGrupos().acceder(nom)!=null){
            jTextDetGrupo.setText(coordinador.getLogica().getGrupos().acceder(nom).toString());
            nada = false;
        }else{
            for(int i=0;i+1<=coordinador.getLogica().getGrupos().tamanio();i++){
                if(nom.equals(coordinador.getLogica().getGrupos().accederPos(i).getLider().getUserName())){
                    jTextDetGrupo.setText(coordinador.getLogica().getGrupos().accederPos(i).toString());
                    nada = false;
                }
            }
            if(coordinador.getLogica().getUsuarios().existe(nom)){
                if(jRBMiembro.isSelected()&&coordinador.getLogica().getGrupos().accederM(coordinador.getLogica().getUsuarios().acceder(nom))!=null){
                    jTextDetGrupo.setText(coordinador.getLogica().getGrupos().accederM(coordinador.getLogica().getUsuarios().acceder(nom)).toString());
                    nada = false;
                }
                
            }
        }
        if(nada){
            jTextDetGrupo.setText("Ningun Resultado Coincidente");
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jBMostrarD;
    private javax.swing.JButton jBVolver;
    private javax.swing.JLabel jLBuscarGrupo;
    private javax.swing.JLabel jLDetGrupo;
    private javax.swing.JLabel jLGrupos;
    private javax.swing.JLabel jLSelecGrupo;
    private javax.swing.JList<String> jListaGrupos;
    private javax.swing.JRadioButton jRBMiembro;
    private javax.swing.JRadioButton jRBNomGrupo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextBusqueda;
    private javax.swing.JTextArea jTextDetGrupo;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object evt = ae.getSource();
        if(evt.equals(jBMostrarD)){
            mostrar();
        }
        if(evt.equals(jBVolver)){
            jTextDetGrupo.setText("");
            coordinador.cargarPanel(1,null);
        }
        if(evt.equals(jBBuscar)){
            String nombre = jTextBusqueda.getText();
            Buscar(nombre);
        }
    }
        
}
