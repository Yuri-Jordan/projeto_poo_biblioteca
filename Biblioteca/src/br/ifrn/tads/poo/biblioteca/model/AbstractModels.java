package br.ifrn.tads.poo.biblioteca.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Ricardo Luiz
 */
public abstract class AbstractModels {
    protected String table;
    
    /**
     * Realiza um select no banco de dados     
     * @return ResultSet rs Retorna um objeto do tipo result set que contem as row da consulta especificada
     */
    public ResultSet read(){           
        ResultSet rs;
        try {
            rs = Banco.getStmt().executeQuery("SELECT * FROM "+table);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(AbstractModels.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    /**
     * Realiza um select no banco de dados     
     * @param fields Recebe um array de strings. Cara valor dos index representa um campo a ser pesquisado no banco de dados
     * @return ResultSet rs Retorna um objeto do tipo result set que contem as row da consulta especificada
     */
    public ResultSet read(String[] fields){    
        String campos = montarFields(fields);
        ResultSet rs;
        try {
            rs = Banco.getStmt().executeQuery("SELECT "+campos+" FROM "+table);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(AbstractModels.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * Realiza um select no banco de dados     
     * @param fields Recebe um array de strings. Cara valor dos index representa um campo a ser pesquisado no banco de dados
     * @param options Recebe um array de strings. Cara valor dos index representa uma opcao sql (ex: where,order by, limit e etc.)
     * @return ResultSet rs Retorna um objeto do tipo result set que contem as row da consulta especificada
     */
    public ResultSet read(String[] fields,String[] options){    
        String campos = montarFields(fields);   //String contendo os campos a serem pesquisados
        String opcoes = montarOptions(options); //String contendo as opcoes sql (ex: order by, group by, limit e etc)
        ResultSet rs;
        try {
            rs = Banco.getStmt().executeQuery("SELECT "+campos+" FROM "+table+" "+opcoes);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(AbstractModels.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * Monta uma String formatada para o formato sql para query limitado pelos campos
     * @param fields Recebe um array de strings. Cara valor dos index representa um campo a ser pesquisado no banco de dados
     */
    protected String montarFields(String[] fields){
        StringBuffer campos = new StringBuffer();
        
        for(int i=0;i<fields.length;i++){
            if(i<fields.length-1){
                campos.append(fields[i]).append(",");
            } else {
                campos.append(fields[i]);
            }
        }
        return campos.toString();
    }
    
    /**
     * Monta uma String formatada para o formato sql para query limitado pelas opções
     * @param options Recebe um array de strings. Cara valor dos index representa uma opcao sql (ex: where,order by, limit e etc.)
     */
    protected String montarOptions(String[] options){
        StringBuffer campos = new StringBuffer();
        
        for(int i=0;i<options.length;i++){            
                campos.append(options[i]).append(" ");            
        }
        return campos.toString();
    }
    
    /**
     * Delete um registro no banco especificado nas options
     * @param options Recebe um array de strings. Cara valor dos index representa uma opcao sql (ex: where,order by, limit e etc.)
     */
    public void delete(String[] options){                
        if(options.length > 0){
            String opcoes = montarOptions(options); //String contendo as opcoes sql (ex: order by, group by, limit e etc)
            try {
                Banco.getStmt().executeUpdate("DELETE FROM "+table+" "+opcoes);
            } catch (SQLException ex) {
                Logger.getLogger(AbstractModels.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Nenhum parametro passado... Esse tipo de query irá apagar todos os dados da tabela... Query bloqueada...");
        }        
    }
    
    /**
     * Cria um registro na tabela. Este metodo deve receber os elementos na sequencia correta, todos eles devem ser inseridos menos o 'id' - autoincrement.
     * @param values Recebe um Array de string contendo em cada index o valor a ser inserido na query. OBS, strings sql devem ser colocadas entre '' ex:" 'teste' ".
     */
    public void create(String[] values){
        String valores = montarFields(values);
        try {
            Banco.getStmt().executeUpdate("INSERT INTO "+table+" VALUES(default,"+valores+")");
        } catch (SQLException ex) {
            Logger.getLogger(AbstractModels.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Cria um registro na tabela. Este metodo deve receber os elementos na sequencia correta, todos eles devem ser inseridos menos o 'id' - autoincrement.
     * @param fields Recebe um Array de string contendo em cada index o campos a ser usado no insert sql. Deve ter pelo menos 1 campo especificado e a lista de valores deve ser igual a quantidade de campos
     * @param values Recebe um Array de string contendo em cada index o valor a ser inserido na query. OBS, strings sql devem ser colocadas entre '' ex:" 'teste' ".
     */
    public void create(String[] fields, String[] values){
        String campos = montarFields(fields);
        String valores = montarFields(values);
        //Se for especificado algum campo e se tem a mesma quantidade de valores
        if(fields.length>0 && fields.length==values.length){
            try {
                Banco.getStmt().executeUpdate("INSERT INTO "+table+"("+campos+") VALUES("+valores+")");
            } catch (SQLException ex) {
                Logger.getLogger(AbstractModels.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Quantidade de campos/valores informados invalida");
        }
    }
}
