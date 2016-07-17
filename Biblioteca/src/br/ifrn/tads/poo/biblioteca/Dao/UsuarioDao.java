package br.ifrn.tads.poo.biblioteca.Dao;

import br.ifrn.tads.poo.biblioteca.usuario.Administrador;
import br.ifrn.tads.poo.biblioteca.usuario.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDao extends AbstractModels{
    private ArrayList<Usuario> usuarios;
    private ResultSet rs;
        
    public UsuarioDao() {
        table = "usuarios";
        usuarios = new ArrayList<Usuario>();
    } 

    @Override
    public ArrayList<Usuario> read() {                
        rs = (ResultSet)super.read();         
        popularLista(rs);
        return usuarios;
    }

    public ArrayList<Usuario> read(Usuario usuario) {
        rs = (ResultSet)super.read(usuario.toStringSelect());
        popularLista(rs);
        return usuarios;
    }               

    public void create(Usuario usuario) {
        super.create(usuario.toStringCreate());
    }

    public void delete(Usuario usuario) {
        super.delete(usuario.getId());
    }
    
    public void update(Usuario usuario) {
        super.update(usuario.getId(), usuario.toStringUpdate());
    }
            
    private void popularLista(ResultSet rs){
        try {
            while(rs.next()){
                Usuario b;
                
                if(rs.getString("role").equals("admin")){
                    b = new Administrador();
                } else {
                    b = new Usuario();
                }
                                
                b.setId(rs.getInt("id"));
                b.setBiblioteca_id(rs.getInt("bibliotecas_id"));
                b.setNome(rs.getString("nome"));
                b.setEndereco(rs.getString("endereco"));
                b.setCpf(rs.getString("cpf"));  
                b.setRole(rs.getString("role"));
                usuarios.add(b);
            }            
        } catch (SQLException ex) {
            Logger.getLogger(BibliotecaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
