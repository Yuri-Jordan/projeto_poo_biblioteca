package br.ifrn.tads.poo.biblioteca.acervo;

import java.util.Date;

public class ItemAcervo {
    private double custo;
    private Date dataAluguel;
    private Date dataDevolucao;
    private int codigoItem;
    private boolean pago;

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
}
