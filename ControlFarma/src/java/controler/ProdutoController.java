package controler;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.GerenciarProdutoDAO;
import model.Produto;

@WebServlet(name = "ProdutoController", urlPatterns = {"produtocontroller"})
public class ProdutoController extends HttpServlet {
    
    /**
     *
     * @param request
     * @param response
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
            
    }
    
    private Produto produto;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    public void salvar () throws IOException{
        
        new GerenciarProdutoDAO().cadastrar(produto);
    }
    
    public void listar() throws IOException, ParseException{
        
        List <Produto> lista = new GerenciarProdutoDAO().listar();
    }      
    
    public void excluir() throws IOException{
        
        new GerenciarProdutoDAO().excluir(produto.getCodigo());
    }
}