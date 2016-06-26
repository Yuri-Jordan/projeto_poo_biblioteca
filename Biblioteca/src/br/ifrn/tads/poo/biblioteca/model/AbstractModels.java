package br.ifrn.tads.poo.biblioteca.model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Ricardo Luiz
 */
public abstract class AbstractModels {
    protected String table;
    
    /**
     * Realiza um select no banco de dados     
     * @return ResultSet rs Retorna um objeto do tipo result set que contem as row da consulta especificada
     */
    public ResultSet read() throws SQLException{           
        ResultSet rs = Banco.getStmt().executeQuery("SELECT * FROM "+table);
        return rs;
    }
    /**
     * Realiza um select no banco de dados     
     * @param fields Recebe um array de strings. Cara valor dos index representa um campo a ser pesquisado no banco de dados
     * @return ResultSet rs Retorna um objeto do tipo result set que contem as row da consulta especificada
     */
    public ResultSet read(String[] fields) throws SQLException{    
        String campos = montarFields(fields);
        ResultSet rs = Banco.getStmt().executeQuery("SELECT "+campos+" FROM "+table);
        return rs;
    }
    
    /**
     * Realiza um select no banco de dados     
     * @param fields Recebe um array de strings. Cara valor dos index representa um campo a ser pesquisado no banco de dados
     * @param options Recebe um array de strings. Cara valor dos index representa uma opcao sql (ex: where,order by, limit e etc.)
     * @return ResultSet rs Retorna um objeto do tipo result set que contem as row da consulta especificada
     */
    public ResultSet read(String[] fields,String[] options) throws SQLException{    
        String campos = montarFields(fields);   //String contendo os campos a serem pesquisados
        String opcoes = montarOptions(options); //String contendo as opcoes sql (ex: order by, group by, limit e etc)
        ResultSet rs = Banco.getStmt().executeQuery("SELECT "+campos+" FROM "+table+" "+opcoes);
        return rs;
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
    public void delete(String[] options) throws SQLException{                
        if(options.length > 0){
            String opcoes = montarOptions(options); //String contendo as opcoes sql (ex: order by, group by, limit e etc)
            Banco.getStmt().executeUpdate("DELETE FROM "+table+" "+opcoes);
        } else {
            System.out.println("Nenhum parametro passado... Esse tipo de query irá apagar todos os dados da tabela... Query bloqueada...");
        }        
    }
}
