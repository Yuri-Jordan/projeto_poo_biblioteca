/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifrn.tads.poo.biblioteca.view;

import br.ifrn.tads.poo.biblioteca.acervo.Apostila;
import br.ifrn.tads.poo.biblioteca.acervo.ItemAcervo;
import br.ifrn.tads.poo.biblioteca.acervo.Livro;
import br.ifrn.tads.poo.biblioteca.acervo.Texto;
import br.ifrn.tads.poo.biblioteca.controller.AcervoController;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author yuri
 */
public class RUDitemPadrao extends javax.swing.JFrame {
    private Object[][] obj;

    /**
     * Creates new form RUDitem
     */
    public RUDitemPadrao() {
        AcervoController aController = new AcervoController();
        
        //Codigo para gerar o conteudo da tabela dinamicamente
        Date date = new Date(); //Uso para saber se o item pode ser alugado
        ArrayList<ItemAcervo> itens = aController.findAll();
        obj = new Object[itens.size()][5];        
        for(int i=0;i<obj.length;i++){
            if(itens.get(i) instanceof Livro){ //é um livro?
                obj[i][0] = "Livro";
                obj[i][2] = ((Livro)itens.get(i)).getTitulo();
            } else if(itens.get(i) instanceof Apostila){ //é uma apostila?            
                obj[i][0] = "Apostila";
                obj[i][2] = ((Apostila)itens.get(i)).getTitulo();
            } else { // ou é um simples texto?
                obj[i][0] = "Texto";
                obj[i][2] = ((Texto)itens.get(i)).getAutor();
            }
            obj[i][1] = itens.get(i).getCodigoItem();            
            obj[i][3] = itens.get(i).getCusto();
            //Verifica se a data é nula o se já esta alugado. Caso possa esta alugado coloca sim caso contrario não
            obj[i][4] = itens.get(i).getDataAluguel() != null && !itens.get(i).isDevolvido() ? "Não" : "Sim";            
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

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jButton1.setText("Pesquisar");
        getContentPane().add(jButton1);
        jButton1.setBounds(400, 50, 130, 30);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(190, 50, 190, 30);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            this.obj,
            new String [] {
                "Tipo", "Codigo", "Titulo/Autor", "Custo","Pode Alugar?"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(120, 90, 600, 430);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Título :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(120, 60, 60, 17);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifrn/tads/poo/biblioteca/imagens/fundoTelaPrincipal.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 770, 600);

        setSize(new java.awt.Dimension(753, 573));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(RUDitemPadrao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RUDitemPadrao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RUDitemPadrao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RUDitemPadrao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RUDitemPadrao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
