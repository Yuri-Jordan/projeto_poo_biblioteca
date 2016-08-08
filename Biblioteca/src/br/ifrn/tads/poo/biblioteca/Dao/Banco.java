package br.ifrn.tads.poo.biblioteca.Dao;

import java.sql.*;

public class Banco {
    private static final String dataBaseUrl = "jdbc:postgresql://localhost:5432/";
    private static final String banco = "biblioteca";
    private static final String username = "postgres";
    private static final String password = "15147";
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
        String[] sqls = new String[8];
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
                + "nome VARCHAR(255) NOT NULL,"
                + "senha VARCHAR(255) NOT NULL,"
                + "endereco TEXT,"
                + "cpf VARCHAR(11),"
                + "role VARCHAR(10) NOT NULL,"
                + "CONSTRAINT biblioteca_usuarios_id FOREIGN KEY (bibliotecas_id) REFERENCES bibliotecas (id)"
                + ")";
        //Tabela itens do acervo
        sqls[2] = "CREATE TABLE IF NOT EXISTS itemAcervos("
                + "id SERIAL PRIMARY KEY NOT NULL,"                
                + "bibliotecas_id INT NOT NULL,"
                + "custo DECIMAL NOT NULL,"                
                + "codigoItem INT NOT NULL,"                
                + "especifico JSON NOT NULL DEFAULT '{}',"
                + "CONSTRAINT biblioteca_acervo_id FOREIGN KEY (bibliotecas_id) REFERENCES bibliotecas (id)"
                + ")";
        //Tabela Alugados
        sqls[3] = "CREATE TABLE IF NOT EXISTS alugado("
                + "id SERIAL PRIMARY KEY NOT NULL,"
                + "user_id INT NOT NULL,"
                + "itemAcervo_id INT NOT NULL,"
                + "dataAluguel TIMESTAMP WITHOUT TIME ZONE,"
                + "dataDevolucao TIMESTAMP WITHOUT TIME ZONE,"
                + "pago BOOLEAN,"
                + "devolvido BOOLEAN NOT NULL DEFAULT TRUE,"
                + "CONSTRAINT user_id FOREIGN KEY (user_id) REFERENCES usuarios (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE,"
                + "CONSTRAINT itemAcervo_id FOREIGN KEY (itemAcervo_id) REFERENCES itemAcervos (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE"
                + ");";
        sqls[4] = "INSERT INTO bibliotecas (nome) SELECT 'central' WHERE NOT EXISTS ( SELECT id from bibliotecas where nome like 'central')";
        sqls[5] = "INSERT INTO usuarios (bibliotecas_id,nome,senha,endereco,cpf,role) "
                + " SELECT (SELECT id FROM bibliotecas WHERE nome like 'central'),'admin','senha','user padrao','00000000000','admin' "
                + "     WHERE NOT EXISTS (SELECT id FROM usuarios WHERE nome like 'admin')";
        sqls[6] = "CREATE OR REPLACE VIEW itemAcervo_all AS "
                + "SELECT  i.id, i.bibliotecas_id,a.user_id, i.custo, i.codigoitem, i.especifico,a.dataaluguel, a.datadevolucao, a.pago,a.devolvido,a.id as idalugado,a.itemacervo_id "
                + "FROM itemacervos as i LEFT JOIN alugado as a ON a.id = (SELECT p.id from alugado p where p.itemacervo_id = i.id ORDER BY p.id DESC LIMIT 1) ";
        sqls[7] = "CREATE OR REPLACE RULE itemacervo_all_UPDATE AS ON UPDATE TO itemacervo_all DO INSTEAD ( "
                + "UPDATE itemacervos SET bibliotecas_id=NEW.bibliotecas_id, custo=NEW.custo,codigoitem=NEW.codigoitem,especifico=NEW.especifico WHERE id=OLD.id;"
                + "UPDATE alugado SET dataaluguel=NEW.dataaluguel, datadevolucao=NEW.datadevolucao,pago=NEW.pago,devolvido=NEW.devolvido,user_id=NEW.user_id,itemacervo_id=NEW.itemacervo_id WHERE id=OLD.idalugado);";
        
        for(String s: sqls){
            try {
                stmt.executeUpdate(s);
            } catch (SQLException e) {                
                System.err.println(e.getClass().getName()+": "+e.getMessage());
                System.exit(0);
            }
        }
        System.out.println("Todas as tabelas foram montadas...");
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
