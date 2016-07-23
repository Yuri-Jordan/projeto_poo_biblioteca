package br.ifrn.tads.poo.biblioteca.app;
import br.ifrn.tads.poo.biblioteca.Dao.Banco;
import br.ifrn.tads.poo.biblioteca.view.TelaLogin;
import java.sql.SQLException;

public class SistemaBiblioteca {
    public static void main(String[] args) throws SQLException {
        Banco.conectarBanco();                
        TelaLogin painel = new TelaLogin();
        painel.setVisible(true);                
    }
}
// ############################ CHAT ######################################
//
//Ei vamo usar essa classe pra nos comunircarmos, pode ser?
//
//EU tentei cadastrar cliente mas n deu certo.  O erro ta na view.CadastrarUsuario.no botão cadastrar.
//
// ######################################################################