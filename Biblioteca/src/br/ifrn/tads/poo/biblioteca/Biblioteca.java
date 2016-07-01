package br.ifrn.tads.poo.biblioteca;

import br.ifrn.tads.poo.biblioteca.acervo.ItemAcervo;
import br.ifrn.tads.poo.biblioteca.usuario.Usuario;
import java.util.Date;

public class Biblioteca {
    private Usuario usuario;
    private ItemAcervo itemAcervo;
    private String nomeBiblioteca;
    private int id;

    public Biblioteca(Usuario usuario, ItemAcervo itemAcervo, String nomeBiblioteca, int id) {
        this.usuario = usuario;
        this.itemAcervo = itemAcervo;
        this.nomeBiblioteca = nomeBiblioteca;
        this.id = id;
    }

    public Biblioteca() {
    }
    
    public String toStringUpdate(){
        StringBuilder s = new StringBuilder();
        s.append(" nome='").append(nomeBiblioteca).append("' ");
        return s.toString();
    }
    
    public String toStringCreate(){
        StringBuilder s = new StringBuilder();
        s.append(" '").append(nomeBiblioteca).append("' ");
        return s.toString();
    }
    
    public double calcularValorMultas(Date dia){
        return 0.0;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ItemAcervo getItemAcervo() {
        return itemAcervo;
    }

    public void setItemAcervo(ItemAcervo itemAcervo) {
        this.itemAcervo = itemAcervo;
    }

    public String getNomeBiblioteca() {
        return nomeBiblioteca;
    }

    public void setNomeBiblioteca(String nomeBiblioteca) {
        this.nomeBiblioteca = nomeBiblioteca;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }   
}
