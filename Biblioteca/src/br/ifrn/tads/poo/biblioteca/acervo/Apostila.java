package br.ifrn.tads.poo.biblioteca.acervo;

public class Apostila extends ItemAcervo{
    private String titulo;
    private String autor;
    
    @Override
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
            s.append(" especifico='{\"apostila\": { \"titulo\":").append("\"").append(titulo).append("\" , ")
             .append(" \"autor\":\"").append(autor).append("\"")
             .append("}}' ");            
        }
        return s.toString();
    }
    
    @Override
    public String toStringCreate(){
        StringBuilder s = new StringBuilder();
        s.append(" ").append(bibliotecaId).append(", ");        
        s.append(" ").append(custo).append(", ");
        s.append(" ").append(codigoItem).append(", ");
        s.append(" '{\"apostila\": { \"titulo\":").append("\"").append(titulo).append("\" , ")
             .append(" \"autor\":\"").append(autor).append("\"")
             .append("}}' "); 
        return s.toString();
    }
    
    @Override
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
            s.append(" datadevolucao='").append(dataDevolucao).append("' AND");
        if(titulo!=null)
            s.append(" especifico->'apostila'->>'titulo' like '").append(titulo).append("' AND ");           
        if(autor!=null)
             s.append(" especifico->'apostila'->>'autor' like '").append(autor).append("'");
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
}
