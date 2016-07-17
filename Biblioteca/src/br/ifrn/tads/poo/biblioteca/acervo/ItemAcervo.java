package br.ifrn.tads.poo.biblioteca.acervo;

import java.util.Date;

public class ItemAcervo {
    protected int id;
    protected int bibliotecaId;
    protected int userId;
    protected double custo;
    protected Date dataAluguel;
    protected Date dataDevolucao;
    protected int codigoItem;
    protected boolean pago;
    protected boolean devolvido;
    
    public String toStringUpdate(){return "";}
    
    public String toStringCreate(){return "";}
    
    public String toStringSelect(){return "";}
    
    public ItemAcervo() {
        this.pago = false;
    }
            
    public void alugar(){
    
    }
    
    public double devolver(){
        
        return 0.0;
    }
    
    public boolean estaPago(){
    
        return false;
    }
    
    public void reservar(){
    
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBibliotecaId() {
        return bibliotecaId;
    }

    public void setBibliotecaId(int bibliotecaId) {
        this.bibliotecaId = bibliotecaId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
            
    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public Date getDataAluguel() {
        return dataAluguel;
    }

    public void setDataAluguel(Date dataAluguel) {
        this.dataAluguel = dataAluguel;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public int getCodigoItem() {
        return codigoItem;
    }

    public void setCodigoItem(int codigoItem) {
        this.codigoItem = codigoItem;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public boolean isDevolvido() {
        return devolvido;
    }

    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
    }
    
    
}
