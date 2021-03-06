/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifrn.tads.poo.biblioteca.view;

import br.ifrn.tads.poo.biblioteca.controller.UsuarioController;
import br.ifrn.tads.poo.biblioteca.usuario.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author yuri
 */
public class EditarUser extends javax.swing.JFrame {
    
    private Usuario user;
    private UsuarioController userController;
    
    /**
     * Creates new form TelaPrincipal
     */
    public EditarUser(){}
    
    public EditarUser(Usuario user) {
        //Recebe o usuario que deseja editar
        this.user = user;
        //Controller
        userController = new UsuarioController();
        
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

        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldCpf = new javax.swing.JTextField();
        jTextFieldNome = new javax.swing.JTextField();
        jTextFieldSenha = new javax.swing.JTextField();
        jTextFieldEndereco = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jLabelFundoTelaPrincipal = new javax.swing.JLabel();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Editar Perfil", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Symbol", 1, 18), new java.awt.Color(255, 153, 0))); // NOI18N
        jPanel2.setLayout(null);

        jLabel1.setText("cpf");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(20, 160, 70, 16);

        jLabel2.setText("Nome");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(20, 40, 80, 16);

        jLabel3.setText("Password");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(20, 80, 90, 16);

        jLabel4.setText("Endereço");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(20, 120, 70, 16);

        jTextFieldCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCpfActionPerformed(evt);
            }
        });
        jPanel2.add(jTextFieldCpf);
        jTextFieldCpf.setBounds(130, 160, 310, 28);
        jTextFieldCpf.setText(user.getCpf());

        jTextFieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeActionPerformed(evt);
            }
        });
        jPanel2.add(jTextFieldNome);
        jTextFieldNome.setBounds(130, 40, 310, 28);
        jTextFieldNome.setText(user.getNome());

        jTextFieldSenha.setText("****");
        jTextFieldSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSenhaActionPerformed(evt);
            }
        });
        jPanel2.add(jTextFieldSenha);
        jTextFieldSenha.setBounds(130, 80, 310, 28);

        jTextFieldEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEnderecoActionPerformed(evt);
            }
        });
        jPanel2.add(jTextFieldEndereco);
        jTextFieldEndereco.setBounds(130, 120, 310, 28);
        jTextFieldEndereco.setText(user.getEndereco());

        jButton1.setText("Enviar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(20, 220, 100, 28);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(20, 10, 450, 270);
        jPanel2.getAccessibleContext().setAccessibleName("EditarPerfil");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Deletar Usuário", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Symbol", 1, 18), new java.awt.Color(255, 153, 0))); // NOI18N
        jPanel3.setLayout(null);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifrn/tads/poo/biblioteca/imagens/usu.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3);
        jButton3.setBounds(20, 70, 270, 100);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(470, 10, 310, 270);

        jLabelFundoTelaPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifrn/tads/poo/biblioteca/imagens/fundoTelaPrincipal.png"))); // NOI18N
        getContentPane().add(jLabelFundoTelaPrincipal);
        jLabelFundoTelaPrincipal.setBounds(0, 0, 800, 290);

        setSize(new java.awt.Dimension(816, 326));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCpfActionPerformed
       
    }//GEN-LAST:event_jTextFieldCpfActionPerformed

    private void jTextFieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeActionPerformed

    private void jTextFieldSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSenhaActionPerformed

    private void jTextFieldEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEnderecoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Setando o usuario com as novas informações
        user.setNome(jTextFieldNome.getText());
        user.setSenha(jTextFieldSenha.getText());
        user.setEndereco(jTextFieldEndereco.getText());
        user.setCpf(jTextFieldCpf.getText());
        userController.editar(user);    //Editando 
            
            dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        userController.deletar(user);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(EditarUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelFundoTelaPrincipal;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextFieldCpf;
    private javax.swing.JTextField jTextFieldEndereco;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldSenha;
    // End of variables declaration//GEN-END:variables
}
