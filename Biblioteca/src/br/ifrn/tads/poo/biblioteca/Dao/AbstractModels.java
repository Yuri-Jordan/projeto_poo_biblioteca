package br.ifrn.tads.poo.biblioteca.Dao;

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
    protected Object read(){           
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
     * @param options Recebe uma strings.(ex: where,order by, limit e etc.)
     * @return ResultSet rs Retorna um objeto do tipo result set que contem as row da consulta especificada
     */
    protected Object read(String options){    
        ResultSet rs;
        String SQL = "SELECT * FROM "+table+" "+options;        
        if(SQL.trim().endsWith("AND")){
            SQL = SQL.substring(0, SQL.length()-4);
        }        
        try {
            rs = Banco.getStmt().executeQuery(SQL);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(AbstractModels.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
            
    /**
     * Delete um registro no banco especificado nas options
     * @param id o id da linha que deseja apagar
     */
    protected void delete(int id){        
        if(id>0){
            String SQL = "DELETE FROM "+table+" WHERE id="+id;
            try {
                Banco.getStmt().executeUpdate(SQL);
            } catch (SQLException ex) {
                Logger.getLogger(AbstractModels.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Nenhum parametro passado... Esse tipo de query irá apagar todos os dados da tabela... Query bloqueada...");
        }        
    }
    
    /**
     * Cria um registro na tabela. Este metodo deve receber os elementos na sequencia correta, todos eles devem ser inseridos menos o 'id' - autoincrement.
     * @param values Recebe uma string contendo o valor a ser inserido na query. OBS, strings sql devem ser colocadas entre '' ex:" 'teste' ".
     */
    protected void create(String values){        
        
        try {
            Banco.getStmt().executeUpdate("INSERT INTO "+table+" VALUES(default,"+values+")");
            System.out.println("Row criada com sucesso no banco...");
        } catch (SQLException ex) {
            Logger.getLogger(AbstractModels.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Faz a atualização pelo id, recebendo a string de updates
     * @param id um inteiro que representa o identificador da linha a ser modificada
     * @param updates Uma string no formato aceito pelos update sql. Usa os metodos .toStringUpdate()
     */
    protected void update(int id,String updates){
        try {            
            Banco.getStmt().executeUpdate("UPDATE "+table+" SET "+updates+" WHERE id="+id);
        } catch (SQLException ex) {
            Logger.getLogger(AbstractModels.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
