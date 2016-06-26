package br.ifrn.tads.poo.biblioteca.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbstractModels {
    protected String table;
    
    public ResultSet read() throws SQLException{           
        ResultSet rs = Banco.getStmt().executeQuery("SELECT * FROM "+table);
        return rs;
    }
    
    public ResultSet read(String[] fields) throws SQLException{    
        String campos = montarFields(fields);
        ResultSet rs = Banco.getStmt().executeQuery("SELECT "+campos+" FROM "+table);
        return rs;
    }
    
    public ResultSet read(String[] fields,String[] options) throws SQLException{    
        String campos = montarFields(fields);   //String contendo os campos a serem pesquisados
        String opcoes = montarOptions(options); //String contendo as opcoes sql (ex: order by, group by, limit e etc)
        ResultSet rs = Banco.getStmt().executeQuery("SELECT "+campos+" FROM "+table+" "+opcoes);
        return rs;
    }
    
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
    
    protected String montarOptions(String[] options){
        StringBuffer campos = new StringBuffer();
        
        for(int i=0;i<options.length;i++){            
                campos.append(options[i]).append(" ");            
        }
        return campos.toString();
    }
}
