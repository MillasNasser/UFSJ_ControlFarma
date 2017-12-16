package controler;

import java.io.IOException;
import java.util.List;
import model.GerenciarProdutoDAO;
import model.Produto;

public class ProdutoController {
    
    Produto produto;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    public void salvar () throws IOException{
        
        GerenciarProdutoDAO p = new GerenciarProdutoDAO();
        p.cadastrar(this.produto);
    }
    
    public void listar(){
        
        List <Produto> lista = new GerenciarProdutoDAO().listar();
    }
    
    public void excluir(){
        
        
    }
}