package model;

public class ItemPedido {
    
    private Produto produto;
    private int quantidade;

    public ItemPedido(Produto p, int quantidade) throws Exception {
        
        setProduto(produto);
        setQuantidade(quantidade);
    }        
    
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) throws Exception {
        
        if(quantidade <= 0)
            throw new Exception("Quantidade inválida.");
        
        if(getProduto().getQuantidade() < quantidade)            
            throw new Exception("Quantidade acima do existente em estoque.");     
        
        this.quantidade = quantidade;
    }
}