package controler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import model.GerenciarProdutoDAO;
import model.ItemPedido;
import model.Pedido;

public class PedidoDAO {
    String path = System.getProperty("user.home") + "/pedidos.txt";
    public void salvar(Pedido pedido) throws IOException{
        
        try (PrintWriter escritor = new PrintWriter(
                new BufferedWriter(new FileWriter(path, true)))) {
            for(ItemPedido item:pedido.getItens()){
            
                escritor.println(item.getQuantidade());
                escritor.println(item.getProduto().toString());               
            }
            escritor.close();
        }
    }
    
    public ItemPedido novoItemPedido(int codigo, int quantidade) throws Exception{
                                
        return new ItemPedido(new GerenciarProdutoDAO().getProduto(codigo), quantidade);
    }
}