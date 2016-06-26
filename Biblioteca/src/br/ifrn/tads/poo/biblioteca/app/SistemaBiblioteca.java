package br.ifrn.tads.poo.biblioteca.app;
import br.ifrn.tads.poo.biblioteca.model.Banco;
import br.ifrn.tads.poo.biblioteca.model.Biblioteca;
import br.ifrn.tads.poo.view.InterfaceBiblioteca;

public class SistemaBiblioteca {
    public static void main(String[] args) {
        //InterfaceBiblioteca painel = new InterfaceBiblioteca();
        //painel.setVisible(true);
        Banco.conectarBanco();        
        Biblioteca biblioteca = new Biblioteca();
        String[] valores = {"'teste'"};
        String[] campos = {"nome"};
        biblioteca.create(valores);
    }
        
    //Exemplo do uso de json do jdbc
//     JSONObject json = new JSONObject();  //objeto json em java
//        JSONParser parse = new JSONParser();  //Objeto conversor de string para json
//        try {
//            String[] fields = {"*"};
//            String[] options = {"where especifico->>'texto'='texto'"};            
//            ResultSet rs = item.read(fields,options);            
//            while(rs.next()){
//                System.out.println("Os ids: "+rs.getInt("id"));
//                System.out.println(rs.getObject("especifico"));                
//                json.putAll((JSONObject) parse.parse(rs.getObject("especifico").toString())); //converte a string em um json
//                
//            }            
//            System.out.println(json.get("texto")); //recupera o json pela sua key
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(SistemaBiblioteca.class.getName()).log(Level.SEVERE, null, ex);
//        }
}
