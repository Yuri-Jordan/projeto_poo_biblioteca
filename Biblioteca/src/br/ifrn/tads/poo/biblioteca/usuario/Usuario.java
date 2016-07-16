package br.ifrn.tads.poo.biblioteca.usuario;

import br.ifrn.tads.poo.biblioteca.acervo.ItemAcervo;

public class Usuario {
    protected int id;
    protected int biblioteca_id;
    protected String nome;
    protected String senha;
    protected String endereco;
    protected String cpf;
    protected String role;

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
        if(biblioteca_id!=0)
            s.append(" bibliotecas_id=").append(biblioteca_id).append(", ");
        if(nome!=null)
            s.append(" nome='").append(nome).append("', ");
        if(senha!=null)
            s.append(" senha='").append(senha).append("', ");
        if(endereco!=null)
            s.append(" endereco='").append(endereco).append("', ");
        if(cpf!=null)
            s.append(" cpf='").append(cpf).append("', ");
        if(role!=null)
            s.append(" role='").append(role).append("' ");
        return s.toString();
    }
    
    public String toStringCreate(){
        StringBuilder s = new StringBuilder();
        s.append(" ").append(biblioteca_id).append(", ");
        s.append(" '").append(nome).append("', ");
        s.append(" '").append(senha).append("', ");
        s.append(" '").append(endereco).append("', ");
        s.append(" '").append(cpf).append("', ");
        s.append(" '").append(role).append("' ");
        return s.toString();
    }
    
    public String toStringSelect(){
         StringBuilder s = new StringBuilder();
        s.append(" WHERE ");
        
        if(id!=0)
            s.append(" id=").append(id).append(" AND ");
        if(biblioteca_id!=0)
            s.append(" bibliotecas_id=").append(biblioteca_id).append(" AND ");
        if(nome!=null)
            s.append(" nome like '").append(nome).append("' AND ");
        if(senha!=null)
            s.append(" senha like '").append(senha).append("' AND ");
        if(endereco!=null)
            s.append(" endereco like '").append(endereco).append("' AND ");
        if(cpf!=null)
            s.append(" cpf like '").append(cpf).append("' AND ");
        if(role!=null)
            s.append(" role like '").append(role).append("'");
        return s.toString();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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
