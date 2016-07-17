package br.ifrn.tads.poo.biblioteca.acervo;

public class Texto extends ItemAcervo{
    private String autor;
    
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
        if(autor!=null){
            s.append(" especifico='{\"texto\": {").append(" \"autor\":\"").append(autor).append("\"").append("}}' ");            
        }
        return s.toString();
    }
    
    public String toStringCreate(){
        StringBuilder s = new StringBuilder();
        s.append(" ").append(bibliotecaId).append(", ");        
        s.append(" ").append(custo).append(", ");
        s.append(" ").append(codigoItem).append(", ");
        s.append(" '{\"texto\": {").append(" \"autor\":\"").append(autor).append("\"").append("}}' ");  
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
         if(autor!=null)
            s.append(" especifico->'texto'->>'autor' like '").append(autor).append("'");
        return s.toString();
    }
    
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
        
}
