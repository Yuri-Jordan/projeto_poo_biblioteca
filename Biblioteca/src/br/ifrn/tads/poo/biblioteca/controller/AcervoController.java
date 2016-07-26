package br.ifrn.tads.poo.biblioteca.controller;

import br.ifrn.tads.poo.biblioteca.Dao.ItemAcervoDao;
import br.ifrn.tads.poo.biblioteca.acervo.ItemAcervo;
import java.util.ArrayList;

/**
 *
 * @author ricardo
 */
public class AcervoController {
    private ItemAcervo item;
    private ArrayList<ItemAcervo> itens;
    private ItemAcervoDao dItem;

    public AcervoController() {
        item = new ItemAcervo();
        itens = new ArrayList<>();
        dItem = new ItemAcervoDao();
    }
    
    //Retorna uma lista com todos os itens    
    public ArrayList<ItemAcervo> findAll(){
        return dItem.read();
    }
    
    public void createItem(ItemAcervo item){
        ItemAcervoDao dItem = new ItemAcervoDao();
        
        dItem.create(item);
    }
    
}
