package controler;

import java.io.IOException;
import model.Pedido;

public class PedidoController {
    
    private Pedido pedido;

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    public void salvar () throws IOException{
        
        PedidoDAO p = new PedidoDAO();
        p.salvar(pedido);
    }
    
    public void novoItemPedido(int codigo, int quantidade) throws Exception{
        
        getPedido().getItens().add(new PedidoDAO().novoItemPedido(codigo, quantidade));
    }
}