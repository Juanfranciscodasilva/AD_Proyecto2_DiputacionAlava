package Ventanas;

import Clases.Response;
import Clases.Usuario;
import diputacionAlava.Main;
import javax.swing.JOptionPane;

public class RegistrarUsuario extends javax.swing.JFrame {

    public RegistrarUsuario() {
        initComponents();
        setLocationRelativeTo(null);
        errorUsuario.setVisible(false);
        errorPass.setVisible(false);
        //TO DO VALIDACIONES DE REGISTRO DE NUEVO USUARIO , POSIBLE IMPLEMENTAR DAR PERMISO ADMIN A OTRO USUARIO
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tUsuario1 = new javax.swing.JTextField();
        tUsuario2 = new javax.swing.JTextField();
        tPass1 = new javax.swing.JPasswordField();
        tPass2 = new javax.swing.JPasswordField();
        errorUsuario = new javax.swing.JLabel();
        errorPass = new javax.swing.JLabel();
        Registrar = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registrar Nuevo Usuario");

        jLabel2.setText("Usuario:");

        jLabel3.setText("Confirmar Usuario:");

        jLabel4.setText("Contraseña:");

        jLabel5.setText("Confirmar Contraseña:");

        errorUsuario.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        errorUsuario.setForeground(new java.awt.Color(255, 0, 0));
        errorUsuario.setText("*Los usuarios no coinciden");

        errorPass.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        errorPass.setForeground(new java.awt.Color(255, 0, 0));
        errorPass.setText("*Las contraseñas no coinciden");

        Registrar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Registrar.setText("Registrar");
        Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarActionPerformed(evt);
            }
        });

        Cancelar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Cancelar.setText("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(errorUsuario)
                                    .addComponent(tUsuario2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tUsuario1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tPass1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(errorPass)
                                    .addComponent(tPass2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(Registrar)
                        .addGap(65, 65, 65)
                        .addComponent(Cancelar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tUsuario2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorUsuario)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tPass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tPass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorPass)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Registrar)
                    .addComponent(Cancelar))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        Main.volverAlLogin();
    }//GEN-LAST:event_CancelarActionPerformed

    private void RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarActionPerformed
        errorUsuario.setVisible(false);
        errorPass.setVisible(false);
        
        if(ValidarDatos()){
            try{
                Usuario u = new Usuario(tUsuario1.getText(), tPass1.getText());
                Response respuesta = Main.insertarUsuario(u);
                if(respuesta.isCorrecto()){
                    JOptionPane.showMessageDialog(this, "Nuevo usuario creado con éxito");
                    Main.volverAlLoginConUsuario(u);
                }else{
                    errorUsuario.setText(respuesta.mensajeError);
                    errorUsuario.setVisible(true);
                }
            }
            catch(Exception e){
                System.out.println("Ha ocurrido un error al intentar crear otro usuario"+e.getMessage());
            }
        }
    }//GEN-LAST:event_RegistrarActionPerformed

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
            java.util.logging.Logger.getLogger(RegistrarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarUsuario().setVisible(true);
            }
        });
    }
    
    public boolean ValidarDatos(){
        String usuario1 = tUsuario1.getText().trim();
        String usuario2 = tUsuario2.getText().trim();
        String pass1 = tPass1.getText().trim();
        String pass2 = tPass2.getText().trim();
        
        if(usuario1.isEmpty() || usuario2.isEmpty()){
            errorUsuario.setText("*El usuario no puede estár vacío.");
            errorUsuario.setVisible(true);
        }else if(!usuario1.equals(usuario2)){
            errorUsuario.setText("*Los usuarios no coinciden.");
            errorUsuario.setVisible(true);
        }
        
        if(pass1.isEmpty() || pass2.isEmpty()){
            errorPass.setText("*La contraseña no puede estár vacía.");
            errorPass.setVisible(true);
        }else if(!pass1.equals(pass2)){
            errorPass.setText("*Las contraseñas no coinciden.");
            errorPass.setVisible(true);
        }
        
        return (!errorUsuario.isVisible() && !errorPass.isVisible());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancelar;
    private javax.swing.JButton Registrar;
    private javax.swing.JLabel errorPass;
    private javax.swing.JLabel errorUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField tPass1;
    private javax.swing.JPasswordField tPass2;
    private javax.swing.JTextField tUsuario1;
    private javax.swing.JTextField tUsuario2;
    // End of variables declaration//GEN-END:variables
}
