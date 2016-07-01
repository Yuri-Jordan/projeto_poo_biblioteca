package br.ifrn.tads.poo.biblioteca.Dao;

import br.ifrn.tads.poo.biblioteca.Biblioteca;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BibliotecaDao extends AbstractModels{
    private ArrayList<Biblioteca> bibliotecas;
    private ResultSet rs;
    
    public BibliotecaDao() {
        table = "bibliotecas";
        bibliotecas = new ArrayList<Biblioteca>();
    }    

    @Override
    public ArrayList<Biblioteca> read() {                
        rs = (ResultSet)super.read();         
        popularLista(rs);
        return bibliotecas;
    }

    @Override
    public ArrayList<Biblioteca> read(String options) {
        rs = (ResultSet)super.read(options);
        popularLista(rs);
        return bibliotecas;
    }               

    public void create(Biblioteca biblioteca) {          
        super.create(biblioteca.toStringCreate());
    }

    public void delete(Biblioteca biblioteca) {
        super.delete(biblioteca.getId());
    }
    
    public void update(Biblioteca biblioteca) {
        super.update(biblioteca.getId(), biblioteca.toStringUpdate());
    }
            
    private void popularLista(ResultSet rs){
        try {
            while(rs.next()){
                Biblioteca b = new Biblioteca();
                b.setId(rs.getInt("id"));
                b.setNomeBiblioteca(rs.getString("nome"));
                bibliotecas.add(b);
            }            
        } catch (SQLException ex) {
            Logger.getLogger(BibliotecaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
