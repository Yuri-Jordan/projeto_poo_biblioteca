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
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author yuri
 */
public class RUDitem extends javax.swing.JFrame {
    private Object[][] obj;
    private int number;
    private ArrayList<ItemAcervo> itens;

    /**
     * Creates new form RUDitem
     */
    public RUDitem() {
        AcervoController aController = new AcervoController();
        
        //Codigo para gerar o conteudo da tabela dinamicamente
        Date date = new Date(); //Uso para saber se o item pode ser alugado
        itens = aController.findAll();
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
            obj[i][4] = itens.get(i).getDataAluguel() != null && date.compareTo(itens.get(i).getDataDevolucao()) < 0 ? "Sim" : "Não";            
        }                        
        initComponents();
        
        //Adiciona um event listener para a tabela
        //Aqui seria um exemplo de listener. Não achei muito usual
        ListSelectionModel cellSelectionModel = jTable1.getSelectionModel();
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
          cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {                
                number = jTable1.getSelectedRow();       
            }
          });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            this.obj,
            new String [] {
                "Tipo", "Codigo", "Titulo/Autor", "Custo","Pode Alugar?"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 60, 700, 460);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Clique no ítem que deseja modificar");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(250, 20, 260, 17);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifrn/tads/poo/biblioteca/imagens/fundoTelaPrincipal.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 770, 600);

        jButton1.setText("jButton1");
        getContentPane().add(jButton1);
        jButton1.setBounds(20, 100, 73, 23);

        setSize(new java.awt.Dimension(753, 573));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if(itens.get(number) instanceof Livro){ //é um livro? 
            
            EditarLivro eLivro = new EditarLivro(itens.get(number));
            eLivro.setVisible(true);
            
        } else if(itens.get(number) instanceof Apostila){ //é uma apostila?            
            
            EditarApostila eApostila = new EditarApostila(itens.get(number));
            eApostila.setVisible(true);
            
        } else { // ou é um simples texto?
            
            EditarTexto eTexto = new EditarTexto(itens.get(number));
            eTexto.setVisible(true);
            
        }
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(RUDitem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RUDitem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RUDitem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RUDitem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RUDitem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
