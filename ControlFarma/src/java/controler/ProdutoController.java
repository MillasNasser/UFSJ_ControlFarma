package controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.GerenciarProdutoDAO;
import model.Produto;

@WebServlet(name = "ProdutoController", urlPatterns = {"/produtocontroller"})
public class ProdutoController extends HttpServlet {        
    
    private Produto produto;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    public void salvar () throws IOException{
        
        new GerenciarProdutoDAO().cadastrar(getProduto());
    }
    
    public void listar() throws IOException, ParseException{
        
        List <Produto> lista = new GerenciarProdutoDAO().listar();
    }      
    
    public void excluir() throws IOException{
        
        new GerenciarProdutoDAO().excluir(produto.getCodigo());
    }
    
    /**
     *
     * @param request
     * @param response
     * @throws java.io.IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
       
        
        response.setContentType("text/html;charset=UTF-8");
        String metodoString = request.getParameter("enviar");
        try (PrintWriter out = response.getWriter()) {
         
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet at " + System.getProperty("user.dir") + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }       
        
        
        getProduto().setNome(request.getParameter("nome"));
        getProduto().setPrincipioAtivo(request.getParameter("principio_ativo"));
        getProduto().setCodigo(Integer.parseInt(request.getParameter("codigo")));
        getProduto().setCategoria(request.getParameter("cateforia"));
        getProduto().setLote(request.getParameter("lote"));
        getProduto().setNome(metodoString);
     
     
        try {
            getProduto().setValidade(new SimpleDateFormat().parse(request.getParameter("vencimento")));
        } catch (ParseException ex) {
            Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        switch (metodoString) {

            case "cadastrar":

                break;
        }
        this.salvar();
    }    
}