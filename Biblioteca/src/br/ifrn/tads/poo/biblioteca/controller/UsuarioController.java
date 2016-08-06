package br.ifrn.tads.poo.biblioteca.controller;

import br.ifrn.tads.poo.biblioteca.Dao.UsuarioDao;
import br.ifrn.tads.poo.biblioteca.usuario.Usuario;
import java.util.ArrayList;

/**
 *
 * @author ricardo
 */
public class UsuarioController { 
    
    private UsuarioDao uDao;

    public UsuarioController() {
        uDao = new UsuarioDao();
    }
            
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
    
    //listar Tudo
    public ArrayList<Usuario> findAll(){
        ArrayList<Usuario> lista;        
        lista = uDao.read();        
        return lista;
    }
    
    //Cadastrar um usuario
    public void cadastrar(Usuario usuario){
        uDao.create(usuario);
    }
    
    //Editar um usuario
    public void editar(Usuario usuario){
        uDao.update(usuario);
    }
    
    //deleta um usuario
    public void deletar(Usuario usuario){
        uDao.delete(usuario);
    }
}
