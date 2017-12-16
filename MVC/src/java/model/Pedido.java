package model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    
    private List<ItemPedido> itens;
    private float valorTotal;

    public Pedido() {
        
        this.itens = new ArrayList<>();
        this.valorTotal = 0;
    }        
    
    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }        
}