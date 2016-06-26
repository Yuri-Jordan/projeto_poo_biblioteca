package br.ifrn.tads.poo.biblioteca.model;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.postgresql.util.PSQLException;

public class Banco {
    private static final String dataBaseUrl = "jdbc:postgresql://localhost:5432/";
    private static final String banco = "biblioteca";
    private static final String username = "postgres";
    private static final String password = "postgres";
    private static final String drive = "org.postgresql.Driver";
    private static Statement stmt;
    private static Connection c;
    
    public static void conectarBanco(){            
        try {
            Class.forName(drive);
            c = DriverManager.getConnection(dataBaseUrl+banco, username, password);
            stmt = c.createStatement();            
        }catch(SQLException e){            
            criarBanco();                        
        }catch(Exception e){
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Conexão com o banco estabelecida com sucesso...");
        montarEstrutura();
    }
    
    public static void montarEstrutura(){
        String[] sqls = new String[3];
        System.out.print("Verificando se é necessário montar as Tabelas...");
        //Tabela Bibliotecas
        sqls[0] = "CREATE TABLE IF NOT EXISTS bibliotecas("
                + "id SERIAL PRIMARY KEY NOT NULL,"
                + "nome VARCHAR(255) NOT NULL"
                + ")";
        //Tabela usuarios
        sqls[1] = "CREATE TABLE IF NOT EXISTS usuarios("
                + "id SERIAL PRIMARY KEY NOT NULL,"
                + "bibliotecas_id INT NOT NULL,"
                + "codUsuario INT NOT NULL,"
                + "nome VARCHAR(255) NOT NULL,"
                + "endereco TEXT NOT NULL,"
                + "cpf VARCHAR(11),"
                + "role VARCHAR(10) NOT NULL,"
                + "CONSTRAINT biblioteca_usuarios_id FOREIGN KEY (bibliotecas_id) REFERENCES bibliotecas (id)"
                + ")";
        //Tabela itens do acervo
        sqls[2] = "CREATE TABLE IF NOT EXISTS itemAcervos("
                + "id SERIAL PRIMARY KEY NOT NULL,"
                + "usuarios_id INT NOT NULL,"
                + "bibliotecas_id INT NOT NULL,"
                + "custo DECIMAL NOT NULL,"
                + "dataAluguel TIMESTAMP WITHOUT TIME ZONE,"
                + "dataDevolucao TIMESTAMP WITHOUT TIME ZONE,"
                + "codigoItem INT NOT NULL,"
                + "pago BOOLEAN NOT NULL,"
                + "especifico JSON NOT NULL DEFAULT '{}',"
                + "CONSTRAINT usuario_id FOREIGN KEY (usuarios_id) REFERENCES usuarios (id),"
                + "CONSTRAINT biblioteca_acervo_id FOREIGN KEY (bibliotecas_id) REFERENCES bibliotecas (id)"
                + ")";                
        
        for(String s: sqls){
            try {
                stmt.executeUpdate(s);
            } catch (SQLException e) {                
                System.err.println(e.getClass().getName()+": "+e.getMessage());
                System.exit(0);
            }
        }
        System.out.println("Todas as tabelas foram montada...");
    }
    
    private static void criarBanco(){
        try {
            System.out.println("Banco não existe. Criando banco de dados: "+banco);
            
            //Conecta ao banco para criar o database biblioteca
            c = DriverManager.getConnection(dataBaseUrl, username, password);
            stmt = c.createStatement();
            stmt.executeUpdate("CREATE DATABASE "+ banco);
            System.out.println("Banco criado com sucesso...");            
            stmt.close();
            
            //Refaz a conexão para o banco biblioteca especificamente
            c = DriverManager.getConnection(dataBaseUrl+banco, username, password);
            stmt = c.createStatement(); //recriamos nosso statement para utiliza-lo            
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    } 

    public static Statement getStmt() {
        return stmt;
    }
        
}
