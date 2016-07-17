package br.ifrn.tads.poo.biblioteca.Dao;

import br.ifrn.tads.poo.biblioteca.acervo.Apostila;
import br.ifrn.tads.poo.biblioteca.acervo.ItemAcervo;
import br.ifrn.tads.poo.biblioteca.acervo.Livro;
import br.ifrn.tads.poo.biblioteca.acervo.Texto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class ItemAcervoDao extends AbstractModels{
    private ArrayList<ItemAcervo> itensAcervo;
    private ResultSet rs;
    
    public ItemAcervoDao() {
        table = "itemAcervo_all";   //Usamos a view inicialmente para inserirmos e recuperarmos dados
        itensAcervo = new ArrayList<ItemAcervo>();
    }
    
    @Override
    public ArrayList<ItemAcervo> read() {                
        rs = (ResultSet)super.read();         
        popularLista(rs);
        return itensAcervo;
    }
        
    public ArrayList<ItemAcervo> read(ItemAcervo itemAcervo) {
        rs = (ResultSet)super.read(itemAcervo.toStringSelect());
        popularLista(rs);
        return itensAcervo;
    }
    
    public void create(ItemAcervo itemAcervo) {   
        table = "itemacervos";
        super.create(itemAcervo.toStringCreate());
        table = "itemAcervo_all";
    }
    
    public void delete(ItemAcervo itemAcervo) {
        table = "itemacervos";
        super.delete(itemAcervo.getId());
        table = "itemAcervo_all";
    }
    
    public void update(ItemAcervo itemAcervo) {       
        super.update(itemAcervo.getId(), itemAcervo.toStringUpdate());
    }
    
    //Preenche nosso array de itens do acervo com os diversos itens (livro,apostila e texto)    
    private void popularLista(ResultSet rs){
        JSONObject json = new JSONObject();  //objeto json em java
        JSONParser parse = new JSONParser();  //Objeto conversor de string para json
        try {
            while(rs.next()){
                json.putAll((JSONObject) parse.parse(rs.getObject("especifico").toString())); //converte a string em um json. Pode vir um livro,apostila ou texto
                            
                if(json.containsKey("livro")){                  
                    
                    json.putAll((JSONObject) parse.parse(json.get("livro").toString())); //Pega o que existe de json dentro do campo especifco do item
                    Livro livro = new Livro();                                       
                    popularLivro(livro, rs, json);                    
                    itensAcervo.add(livro);
                    
                } else if(json.containsKey("apostila")){
                    
                    json.putAll((JSONObject) parse.parse(json.get("apostila").toString())); //Pega o que existe de json dentro do campo especifco do item
                    Apostila apostila = new Apostila();
                    popularApostila(apostila, rs, json);
                    itensAcervo.add(apostila);
                    
                }  else if(json.containsKey("texto")){
                    
                    json.putAll((JSONObject) parse.parse(json.get("texto").toString())); //Pega o que existe de json dentro do campo especifco do item
                    Texto texto = new Texto();
                    popularTexto(texto, rs, json);
                    itensAcervo.add(texto);
                    
                }  
                
                json.clear();
            }                  
        } catch (SQLException ex) {
            Logger.getLogger(BibliotecaDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ItemAcervoDao.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    //Popula o objeto livro com o que vem do banco
    private void popularLivro(Livro livro,ResultSet rs,JSONObject json) throws SQLException{  
        livro.setId(rs.getInt("id"));
        livro.setBibliotecaId(rs.getInt("bibliotecas_id"));
        livro.setUserId(rs.getInt("user_id"));
        livro.setCusto(rs.getInt("custo"));
        livro.setCodigoItem(rs.getInt("codigoitem"));
        livro.setDataAluguel(rs.getTimestamp("dataaluguel"));
        livro.setDataDevolucao(rs.getTimestamp("datadevolucao"));
        livro.setPago(rs.getBoolean("pago"));
        livro.setDevolvido(rs.getBoolean("devolvido"));
        livro.setTitulo(json.get("titulo").toString());
        livro.setAutor(json.get("autor").toString());
        livro.setIsbn(json.get("isbn").toString());
        livro.setEdicao(Integer.parseInt(json.get("edicao").toString()));        
    }
    
    //Popula o objeto apostila com o que vem do banco
    private void popularApostila(Apostila apostila,ResultSet rs,JSONObject json) throws SQLException{
        apostila.setId(rs.getInt("id"));
        apostila.setBibliotecaId(rs.getInt("bibliotecas_id"));
        apostila.setUserId(rs.getInt("user_id"));
        apostila.setCusto(rs.getInt("custo"));
        apostila.setCodigoItem(rs.getInt("codigoitem"));
        apostila.setDataAluguel(rs.getTimestamp("dataaluguel"));
        apostila.setDataDevolucao(rs.getTimestamp("datadevolucao"));
        apostila.setPago(rs.getBoolean("pago"));
        apostila.setDevolvido(rs.getBoolean("devolvido"));
        apostila.setTitulo(json.get("titulo").toString());
        apostila.setAutor(json.get("autor").toString());
    }
    
    //Popula o objeto texto com o que vem do banco
    private void popularTexto(Texto texto,ResultSet rs,JSONObject json) throws SQLException{
        texto.setId(rs.getInt("id"));
        texto.setBibliotecaId(rs.getInt("bibliotecas_id"));
        texto.setUserId(rs.getInt("user_id"));
        texto.setCusto(rs.getInt("custo"));
        texto.setCodigoItem(rs.getInt("codigoitem"));
        texto.setDataAluguel(rs.getTimestamp("dataaluguel"));
        texto.setDataDevolucao(rs.getTimestamp("datadevolucao"));
        texto.setPago(rs.getBoolean("pago"));
        texto.setDevolvido(rs.getBoolean("devolvido"));
        texto.setAutor(json.get("autor").toString());
    }
}
