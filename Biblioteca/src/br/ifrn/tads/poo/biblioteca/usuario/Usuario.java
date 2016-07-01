package br.ifrn.tads.poo.biblioteca.usuario;

import br.ifrn.tads.poo.biblioteca.acervo.ItemAcervo;

public class Usuario {
    private int id;
    private int biblioteca_id;
    private int codUsuario;
    private String nome;
    private String endereco;
    private String cpf;
    private String role;

    public Usuario() {
        this.role = "padrao";
    }
    
    public void pagar(){
        
    }
    
    public ItemAcervo escolherItemAcervo(){
        
        return null;
    }

    public String toStringUpdate(){
        StringBuilder s = new StringBuilder();
        s.append(" bibliotecas_id=").append(biblioteca_id).append(" ");
        s.append(" codusuario=").append(codUsuario).append(" ");
        s.append(" nome='").append(nome).append("' ");
        s.append(" endereco='").append(endereco).append("' ");
        s.append(" cpf='").append(cpf).append("' ");
        s.append(" role='").append(role).append("' ");
        return s.toString();
    }
    
    public String toStringCreate(){
        StringBuilder s = new StringBuilder();
        s.append(" ").append(biblioteca_id).append(", ");
        s.append(" ").append(codUsuario).append(", ");
        s.append(" '").append(nome).append("', ");
        s.append(" '").append(endereco).append("', ");
        s.append(" '").append(cpf).append("', ");
        s.append(" '").append(role).append("' ");
        return s.toString();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getBiblioteca_id() {
        return biblioteca_id;
    }

    public void setBiblioteca_id(int biblioteca_id) {
        this.biblioteca_id = biblioteca_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }    
}
