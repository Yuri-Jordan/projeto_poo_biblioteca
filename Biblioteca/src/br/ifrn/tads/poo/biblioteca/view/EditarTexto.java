/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifrn.tads.poo.biblioteca.view;

import br.ifrn.tads.poo.biblioteca.acervo.ItemAcervo;
import br.ifrn.tads.poo.biblioteca.acervo.Texto;
import br.ifrn.tads.poo.biblioteca.controller.AcervoController;
import br.ifrn.tads.poo.biblioteca.controller.UsuarioController;
import br.ifrn.tads.poo.biblioteca.usuario.Usuario;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author yuri
 */
public class EditarTexto extends javax.swing.JFrame {
    
    private Texto item;
    private AcervoController aController;
    private UsuarioController uController;
    private String[] userComponent;
    private ArrayList<Usuario> usuarios;
    private int userId;
    private Date data;
    private DateFormat dFormat;
    
    /**
     * Creates new form TelaPrincipal
     */
    public EditarTexto(ItemAcervo item) {
        //Recebe o usuario que deseja editar
        this.item = (Texto)item;
        //Controllers
        aController = new AcervoController();
        uController = new UsuarioController();
        //classe para formatar datas
        dFormat = DateFormat.getDateInstance();
        
        //Preenchendo a lista para o item de selection
        usuarios = uController.findAll();
        userComponent = new String[usuarios.size()];
        int i=0;
        for(Usuario u: usuarios){
            userComponent[i] = u.getNome();
            i++;
        }
        
        
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
        jLabel3 = new javax.swing.JLabel();
        jTextFieldCusto = new javax.swing.JTextField();
        jTextFieldAutor = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jFormattedTextFieldDfim = new javax.swing.JFormattedTextField();
        jFormattedTextFieldDInicio = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListUserName = new javax.swing.JList<>();
        jLabelFundoTelaPrincipal = new javax.swing.JLabel();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Editar Informações", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Symbol", 1, 18), new java.awt.Color(255, 153, 0))); // NOI18N
        jPanel2.setLayout(null);

        jLabel3.setText("Autor");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(20, 50, 70, 16);

        jTextFieldCusto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCustoActionPerformed(evt);
            }
        });
        jPanel2.add(jTextFieldCusto);
        jTextFieldCusto.setBounds(130, 140, 310, 28);
        jTextFieldCusto.setText(String.valueOf(item.getCusto()));

        jTextFieldAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAutorActionPerformed(evt);
            }
        });
        jPanel2.add(jTextFieldAutor);
        jTextFieldAutor.setBounds(130, 50, 310, 28);
        jTextFieldAutor.setText(item.getAutor());

        jButton1.setText("Enviar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(10, 190, 90, 28);

        jLabel8.setText("Custo");
        jPanel2.add(jLabel8);
<<<<<<< HEAD
        jLabel8.setBounds(20, 140, 80, 14);

        jLabel9.setText("Codigo");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(20, 90, 70, 14);
=======
        jLabel8.setBounds(10, 140, 80, 16);

        jLabel9.setText("Codigo");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(10, 90, 70, 16);
>>>>>>> 48c7491a0e1288e343c1031ad51715344d4f30c7

        jTextFieldCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCodigoActionPerformed(evt);
            }
        });
        jPanel2.add(jTextFieldCodigo);
        jTextFieldCodigo.setBounds(130, 90, 310, 28);
        jTextFieldCodigo.setText(Integer.toString(item.getCodigoItem()));

        getContentPane().add(jPanel2);
        jPanel2.setBounds(20, 10, 450, 270);
        jPanel2.getAccessibleContext().setAccessibleName("EditarPerfil");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Deletar Texto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Symbol", 1, 18), new java.awt.Color(255, 153, 0))); // NOI18N
        jPanel3.setLayout(null);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifrn/tads/poo/biblioteca/imagens/icon_livroDel.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton7);
        jButton7.setBounds(70, 60, 190, 140);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(470, 10, 310, 270);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Status e Locação do Item", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Symbol", 1, 18), new java.awt.Color(255, 153, 0))); // NOI18N
        jPanel4.setLayout(null);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifrn/tads/poo/biblioteca/imagens/pay.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton6);
        jButton6.setBounds(420, 60, 220, 170);
        //Caso a data de devolução ja tenha passado e o item nao foi entregue aparece o botão para pagar a multa
        jButton6.setVisible(false);
        data = new Date();
        if(item.getDataDevolucao() != null && data.compareTo(item.getDataDevolucao()) > 0 && !item.isDevolvido()){
            jButton6.setVisible(true);
        }

<<<<<<< HEAD
        jLabel10.setText("Aqui seria alugar/devolver");
        jPanel4.add(jLabel10);
        jLabel10.setBounds(40, 30, 180, 14);

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifrn/tads/poo/biblioteca/imagens/livro-green.png"))); // NOI18N
=======
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifrn/tads/poo/biblioteca/imagens/icon_livro.png"))); // NOI18N
>>>>>>> 48c7491a0e1288e343c1031ad51715344d4f30c7
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton8);
        jButton8.setBounds(20, 60, 220, 170);
        if(item.isDevolvido() || item.getDataDevolucao() == null){
            jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifrn/tads/poo/biblioteca/imagens/livro-green.png")));
        } else {
            jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifrn/tads/poo/biblioteca/imagens/livro-red.png")));
        }

        if(jButton6.isVisible())
        jButton8.setEnabled(false);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Alugar Texto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Symbol", 1, 18), new java.awt.Color(255, 153, 0))); // NOI18N
        jPanel5.setLayout(null);

        jLabel14.setText("Data Fim");
        jPanel5.add(jLabel14);
        jLabel14.setBounds(20, 70, 80, 16);

        jLabel15.setText("Data Inicio");
        jPanel5.add(jLabel15);
        jLabel15.setBounds(20, 30, 80, 16);

        jFormattedTextFieldDfim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        jPanel5.add(jFormattedTextFieldDfim);
        jFormattedTextFieldDfim.setBounds(130, 70, 120, 28);

        jFormattedTextFieldDInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        jPanel5.add(jFormattedTextFieldDInicio);
        jFormattedTextFieldDInicio.setBounds(130, 30, 120, 28);

        jLabel13.setText("Nome Usuario");
        jPanel5.add(jLabel13);
        jLabel13.setBounds(320, 20, 100, 16);

        jListUserName.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = userComponent;
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListUserName.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListUserNameValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jListUserName);

        jPanel5.add(jScrollPane1);
        jScrollPane1.setBounds(300, 40, 140, 130);

        jPanel4.add(jPanel5);
        jPanel5.setBounds(300, 50, 460, 190);
        //Caso o botão para pagar multa nao esteja visivel aparece para alugar
        jPanel5.setVisible(false);
        data = new Date();
        if(item.getDataDevolucao() == null || item.isDevolvido()){
            jPanel5.setVisible(true);
        }

        getContentPane().add(jPanel4);
        jPanel4.setBounds(20, 310, 760, 270);

        jLabelFundoTelaPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifrn/tads/poo/biblioteca/imagens/fundoTelaPrincipal.png"))); // NOI18N
        jLabelFundoTelaPrincipal.setMaximumSize(new java.awt.Dimension(800, 2000));
        jLabelFundoTelaPrincipal.setMinimumSize(new java.awt.Dimension(800, 1200));
        getContentPane().add(jLabelFundoTelaPrincipal);
        jLabelFundoTelaPrincipal.setBounds(0, 0, 800, 610);

        setSize(new java.awt.Dimension(816, 638));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        //Seta o item para pago quando estiver com multa a ser paga
        item.setPago(true);
        aController.editar(item);
        jButton8.setEnabled(true);
        jButton6.setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTextFieldCustoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCustoActionPerformed
       
    }//GEN-LAST:event_jTextFieldCustoActionPerformed

    private void jTextFieldAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAutorActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Atualiza os dados com as novas informações        
        item.setAutor(jTextFieldAutor.getText());
        item.setCodigoItem(Integer.parseInt(jTextFieldCodigo.getText()));
        item.setCusto(Double.parseDouble(jTextFieldCusto.getText()));
        aController.editar(item);   //Manda o item editado pro banco
        
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        //Deletando item
        aController.delete(item);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTextFieldCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCodigoActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        
        if(item.isDevolvido() || item.getDataAluguel()==null){ //vai alugar o item?
            try {
            item.setDataAluguel(dFormat.parse(jFormattedTextFieldDInicio.getText()));
            item.setDataDevolucao(dFormat.parse(jFormattedTextFieldDfim.getText()));   
            item.setUserId(usuarios.get(userId).getId());
            item.setDevolvido(false);
            item.setPago(false);
            aController.alugarDevolver(item);
            } catch (ParseException ex) {   //Yuri, aqui vc deve manda uma pop-up dizendo que a data esta em formato invalido. Aqui é tratamento de formato de data
<<<<<<< HEAD
                Logger.getLogger(EditarTexto.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Por favor digite corretamete as datas. Ex.: 00/00/0000.","Atençao!",JOptionPane.INFORMATION_MESSAGE);
=======
                JOptionPane.showMessageDialog(null, "Data em Formato Inválido.","Erro",JOptionPane.ERROR_MESSAGE);
>>>>>>> 48c7491a0e1288e343c1031ad51715344d4f30c7
            }
        } else {    //Ou o item esta sendo devolvido agora?
            item.setDevolvido(true);
            item.setPago(true);
            aController.alugarDevolver(item);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jListUserNameValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListUserNameValueChanged
        userId = jListUserName.getSelectedIndex();
    }//GEN-LAST:event_jListUserNameValueChanged

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
            java.util.logging.Logger.getLogger(EditarTexto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarTexto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarTexto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarTexto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JFormattedTextField jFormattedTextFieldDInicio;
    private javax.swing.JFormattedTextField jFormattedTextFieldDfim;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelFundoTelaPrincipal;
    private javax.swing.JList<String> jListUserName;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldAutor;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldCusto;
    // End of variables declaration//GEN-END:variables
}
