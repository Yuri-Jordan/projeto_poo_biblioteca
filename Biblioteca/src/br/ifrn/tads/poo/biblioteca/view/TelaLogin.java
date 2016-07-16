
package br.ifrn.tads.poo.biblioteca.view;

import br.ifrn.tads.poo.biblioteca.Dao.UsuarioDao;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import jdk.nashorn.internal.scripts.JO;

public class TelaLogin extends javax.swing.JFrame {
    private UsuarioDao user;
    private ArrayList usuarios;
    
    public TelaLogin() {
        initComponents();
        user = new UsuarioDao();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonLogin = new javax.swing.JButton();
        jLabelIconeTelaLogin = new javax.swing.JLabel();
        jLabelUserLogin = new javax.swing.JLabel();
        jLabelSenha = new javax.swing.JLabel();
        jPasswordFieldSenha = new javax.swing.JPasswordField();
        jTextFieldUserLogin = new javax.swing.JTextField();
        jLabelFundoTelaLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jButtonLogin.setBackground(new java.awt.Color(204, 204, 255));
        jButtonLogin.setText("Entrar");
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLogin);
        jButtonLogin.setBounds(220, 310, 80, 23);

        jLabelIconeTelaLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifrn/tads/poo/biblioteca/imagens/iconeLogin.png"))); // NOI18N
        getContentPane().add(jLabelIconeTelaLogin);
        jLabelIconeTelaLogin.setBounds(120, -40, 260, 250);

        jLabelUserLogin.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        jLabelUserLogin.setForeground(new java.awt.Color(255, 153, 51));
        jLabelUserLogin.setText("Login :");
        getContentPane().add(jLabelUserLogin);
        jLabelUserLogin.setBounds(120, 230, 60, 30);

        jLabelSenha.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        jLabelSenha.setForeground(new java.awt.Color(255, 153, 51));
        jLabelSenha.setText("Senha :");
        getContentPane().add(jLabelSenha);
        jLabelSenha.setBounds(120, 260, 50, 30);
        getContentPane().add(jPasswordFieldSenha);
        jPasswordFieldSenha.setBounds(170, 260, 180, 30);

        jTextFieldUserLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUserLoginActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldUserLogin);
        jTextFieldUserLogin.setBounds(170, 230, 180, 30);

        jLabelFundoTelaLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifrn/tads/poo/biblioteca/imagens/telaLogin.jpg"))); // NOI18N
        getContentPane().add(jLabelFundoTelaLogin);
        jLabelFundoTelaLogin.setBounds(-8, 0, 510, 371);

        setSize(new java.awt.Dimension(518, 410));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldUserLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUserLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldUserLoginActionPerformed
    // Testa se login e senha nos campo são válidos,se sim,abre tela principal se ñ, exibe um pop up com erro!
    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        
        if (jTextFieldUserLogin.getText().equals("admin") && jPasswordFieldSenha.getText().equals("123")){
            TelaPrincipal telaPrincipal = new TelaPrincipal();
            telaPrincipal.setVisible(true);
            dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Login ou Senha inválido.","Erro",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonLoginActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JLabel jLabelFundoTelaLogin;
    private javax.swing.JLabel jLabelIconeTelaLogin;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JLabel jLabelUserLogin;
    private javax.swing.JPasswordField jPasswordFieldSenha;
    private javax.swing.JTextField jTextFieldUserLogin;
    // End of variables declaration//GEN-END:variables
}