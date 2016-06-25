package br.ifrn.tads.poo.biblioteca;

import br.ifrn.tads.poo.biblioteca.acervo.ItemAcervo;
import br.ifrn.tads.poo.biblioteca.usuario.Usuario;
import java.util.Date;

public class Biblioteca {
    private Usuario usuario;
    private ItemAcervo itemAcervo;
    private String nomeBiblioteca;

    public Biblioteca(Usuario usuario, ItemAcervo itemAcervo, String nomeBiblioteca) {
        this.usuario = usuario;
        this.itemAcervo = itemAcervo;
        this.nomeBiblioteca = nomeBiblioteca;
    }
    
    public double calcularValorMultas(Date dia){
        return 0.0;
    }
}
