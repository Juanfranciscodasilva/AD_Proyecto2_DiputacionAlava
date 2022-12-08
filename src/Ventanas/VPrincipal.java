
package Ventanas;

import diputacionAlava.Main;
import javax.swing.JOptionPane;


public class VPrincipal extends javax.swing.JFrame {

    public VPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Salir = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        NuevoCampamento = new javax.swing.JMenuItem();
        EliminarCampamento = new javax.swing.JMenuItem();
        ModificarCampamento = new javax.swing.JMenuItem();
        VerCampamentos = new javax.swing.JMenuItem();
        VerListaPersonasEnCampamento = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        RegistrarPersona = new javax.swing.JMenuItem();
        Inscribir = new javax.swing.JMenuItem();
        Retirar = new javax.swing.JMenuItem();
        VerInscripciones = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel1.setText("de Álava");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel2.setText("Diputación Foral ");

        Salir.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButton3.setText("Cerrar Sesión");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jMenu1.setText("Campamentos");

        NuevoCampamento.setText("Nuevo campamento");
        NuevoCampamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoCampamentoActionPerformed(evt);
            }
        });
        jMenu1.add(NuevoCampamento);

        EliminarCampamento.setText("Eliminar campamento");
        EliminarCampamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarCampamentoActionPerformed(evt);
            }
        });
        jMenu1.add(EliminarCampamento);

        ModificarCampamento.setText("Modificar campamento");
        ModificarCampamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarCampamentoActionPerformed(evt);
            }
        });
        jMenu1.add(ModificarCampamento);

        VerCampamentos.setText("Ver campamentos");
        VerCampamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerCampamentosActionPerformed(evt);
            }
        });
        jMenu1.add(VerCampamentos);

        VerListaPersonasEnCampamento.setText("Ver personas inscritas");
        VerListaPersonasEnCampamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerListaPersonasEnCampamentoActionPerformed(evt);
            }
        });
        jMenu1.add(VerListaPersonasEnCampamento);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Personas");

        RegistrarPersona.setText("Registrar persona");
        RegistrarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarPersonaActionPerformed(evt);
            }
        });
        jMenu2.add(RegistrarPersona);

        Inscribir.setText("Inscribir");
        Inscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InscribirActionPerformed(evt);
            }
        });
        jMenu2.add(Inscribir);

        Retirar.setText("Retirar");
        Retirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RetirarActionPerformed(evt);
            }
        });
        jMenu2.add(Retirar);

        VerInscripciones.setText("Ver inscripciones");
        VerInscripciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerInscripcionesActionPerformed(evt);
            }
        });
        jMenu2.add(VerInscripciones);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Salir");

        jMenuItem1.setText("Cerrar sesión");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem2.setText("Salir");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(153, 153, 153)
                                .addComponent(jLabel1)))
                        .addGap(0, 22, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Salir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        Main.CerrarPrograma();
    }//GEN-LAST:event_SalirActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Main.CerrarSesion();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void ModificarCampamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarCampamentoActionPerformed
        Main.entrarVerModificarEliminarCamp(1);
    }//GEN-LAST:event_ModificarCampamentoActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Main.CerrarPrograma();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Main.CerrarSesion();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void NuevoCampamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoCampamentoActionPerformed
        Main.entrarACreacionDeCampamento();
    }//GEN-LAST:event_NuevoCampamentoActionPerformed

    private void EliminarCampamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarCampamentoActionPerformed
        Main.entrarVerModificarEliminarCamp(0);
    }//GEN-LAST:event_EliminarCampamentoActionPerformed

    private void VerCampamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerCampamentosActionPerformed
       Main.entrarVerModificarEliminarCamp(2);
    }//GEN-LAST:event_VerCampamentosActionPerformed

    private void InscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InscribirActionPerformed
        Main.entrarInscribirPersona();
    }//GEN-LAST:event_InscribirActionPerformed

    private void RetirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RetirarActionPerformed
        Main.entrarRetirarPersona(1);
    }//GEN-LAST:event_RetirarActionPerformed

    private void VerInscripcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerInscripcionesActionPerformed
        Main.entrarRetirarPersona(0);
    }//GEN-LAST:event_VerInscripcionesActionPerformed

    private void VerListaPersonasEnCampamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerListaPersonasEnCampamentoActionPerformed
       // Main.AbrirGenteInscrita();
    }//GEN-LAST:event_VerListaPersonasEnCampamentoActionPerformed

    private void RegistrarPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarPersonaActionPerformed
        Main.entrarCrearPersona();
    }//GEN-LAST:event_RegistrarPersonaActionPerformed

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
            java.util.logging.Logger.getLogger(VPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem EliminarCampamento;
    private javax.swing.JMenuItem Inscribir;
    private javax.swing.JMenuItem ModificarCampamento;
    private javax.swing.JMenuItem NuevoCampamento;
    private javax.swing.JMenuItem RegistrarPersona;
    private javax.swing.JMenuItem Retirar;
    private javax.swing.JButton Salir;
    private javax.swing.JMenuItem VerCampamentos;
    private javax.swing.JMenuItem VerInscripciones;
    private javax.swing.JMenuItem VerListaPersonasEnCampamento;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    // End of variables declaration//GEN-END:variables

    public void NoCampamentos() {
        JOptionPane.showMessageDialog(this,"No hay campamentos","", JOptionPane.WARNING_MESSAGE);
    }
    
    public void NoPersonas() {
        JOptionPane.showMessageDialog(this,"No hay personas registradas","", JOptionPane.WARNING_MESSAGE);
    }
}
