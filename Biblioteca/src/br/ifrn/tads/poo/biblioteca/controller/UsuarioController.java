package br.ifrn.tads.poo.biblioteca.controller;

import br.ifrn.tads.poo.biblioteca.Dao.UsuarioDao;
import br.ifrn.tads.poo.biblioteca.usuario.Usuario;
import java.util.ArrayList;

/**
 *
 * @author ricardo
 */
public class UsuarioController {
    
    public static Usuario login(Usuario user){
        UsuarioDao uDao = new UsuarioDao();
        ArrayList<Usuario> lista = uDao.read(user);                
        
        if(lista.size()>0){
            return lista.get(0);
        }
        
        return null;
    }
}
