package br.ifrn.tads.poo.biblioteca.controller;

import br.ifrn.tads.poo.biblioteca.Dao.ItemAcervoDao;
import br.ifrn.tads.poo.biblioteca.acervo.ItemAcervo;
import java.util.ArrayList;

/**
 *
 * @author ricardo
 */
public class AcervoController {
    private ItemAcervoDao dItem;

    public AcervoController() {        
        dItem = new ItemAcervoDao();
    }
    
    //Retorna uma lista com todos os itens    
    public ArrayList<ItemAcervo> findAll(){
        return dItem.read();
    }
    
    //Cria um item
    public void createItem(ItemAcervo item){                
        dItem.create(item);
    }
    
    //Atualiza o item
    public void editar(ItemAcervo item){
        dItem.update(item);
    }
    
    //Alugar/Devolver item
    public void alugarDevolver(ItemAcervo item){
        dItem.alugarDevolver(item);
    }
    
    //Deleta o item
    public void delete(ItemAcervo item){
        dItem.delete(item);
    }
}
