package br.ifrn.tads.poo.biblioteca.acervo;

public class Livro extends ItemAcervo{
    private String titulo;
    private String autor;
    private String isbn;
    private int edicao;   

    
    public String toStringUpdate(){
        StringBuilder s = new StringBuilder();
        if(custo!=0)
            s.append(" custo=").append(custo).append(", ");
        if(codigoItem!=0)
            s.append(" codigoitem=").append(codigoItem).append(", ");
        if(dataAluguel!=null)
            s.append(" dataaluguel='").append(dataAluguel).append("', ");
        if(dataDevolucao!=null)
            s.append(" datadevolucao='").append(dataDevolucao).append("', ");
        s.append(" pago=").append(pago).append(", ");
        s.append(" devolvido=").append(devolvido).append(", ");
        if(titulo!=null && autor!=null){
            s.append(" especifico='{\"livro\": { \"titulo\":").append("\"").append(titulo).append("\" , ")
             .append(" \"autor\":\"").append(autor).append("\"")
             .append("}}' ");            
        }
        return s.toString();
    }
    
    public String toStringCreate(){
        StringBuilder s = new StringBuilder();
        s.append(" ").append(bibliotecaId).append(", ");        
        s.append(" ").append(custo).append(", ");
        s.append(" ").append(codigoItem).append(", ");
        s.append(" '{\"livro\": { \"titulo\":").append("\"").append(titulo).append("\" , ")
             .append(" \"autor\": \"").append(autor).append(" \", ")
             .append(" \"isbn\": \"").append(isbn).append("\", ")
             .append(" \"edicao\": \"").append(edicao).append("\" ")
             .append("}}' "); 
        return s.toString();
    }
    
    public String toStringSelect(){
         StringBuilder s = new StringBuilder();
        s.append(" WHERE ");
        
        if(id!=0)
            s.append(" id=").append(id).append(" AND ");
        if(bibliotecaId!=0)
            s.append(" bibliotecas_id=").append(bibliotecaId).append(" AND ");
        if(userId!=0)
            s.append(" user_id=").append(userId).append(" AND ");
        if(custo!=0)
            s.append(" custo=").append(custo).append(" AND ");
        if(codigoItem!=0)
            s.append(" codigoitem=").append(codigoItem).append(" AND ");
        if(dataAluguel!=null)
            s.append(" dataaluguel='").append(dataAluguel).append("' AND ");        
        if(dataDevolucao!=null)
            s.append(" datadevolucao='").append(dataDevolucao).append("' AND ");
        if(titulo!=null)
            s.append(" especifico->'livro'->>'titulo' like '").append(titulo).append("' AND ");            
        if(autor!=null)
            s.append(" especifico->'livro'->>'autor' like '").append(autor).append("'");
        return s.toString();
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }        
}
