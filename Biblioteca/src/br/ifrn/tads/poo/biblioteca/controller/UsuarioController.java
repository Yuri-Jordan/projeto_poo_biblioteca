package br.ifrn.tads.poo.biblioteca.controller;

import br.ifrn.tads.poo.biblioteca.Dao.UsuarioDao;
import br.ifrn.tads.poo.biblioteca.usuario.Usuario;
import java.util.ArrayList;

/**
 *
 * @author ricardo
 */
public class UsuarioController {           
    //Função de login para o usuario
    public Usuario login(String nome,String senha){
        Usuario user = new Usuario();
        user.setNome(nome);
        user.setSenha(senha);
        user.setRole(null);
        UsuarioDao uDao = new UsuarioDao();
        ArrayList<Usuario> lista = uDao.read(user);                
        
        if(lista.size()>0){
            return lista.get(0);
        }
        
        return null;
    }
    
    public ArrayList<Usuario> findAll(){
        ArrayList<Usuario> lista;
        UsuarioDao uDao = new UsuarioDao();
        lista = uDao.read();        
        return lista;
    }
    
    public void cadastrar(Usuario usuario){
        UsuarioDao uDao = new UsuarioDao();
        uDao.create(usuario);
    }
}
