package controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
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

	public void salvar() throws IOException {

		new GerenciarProdutoDAO().cadastrar(getProduto());
	}

	public void listar() throws IOException, ParseException {

		List<Produto> lista = new GerenciarProdutoDAO().listar();
	}

	public void excluir() throws IOException {

		new GerenciarProdutoDAO().excluir(produto.getCodigo());
	}

	/**
	 *
	 * @param request
	 * @param response
	 * @throws java.io.IOException
	 * @throws javax.servlet.ServletException
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		response.setContentType("text/html;charset=UTF-8");
		String metodoString = request.getParameter("enviar");

		this.produto = new Produto();

		switch (metodoString) {

			case "cadastrar":
				getProduto().setNome(request.getParameter("nome"));
				getProduto().setPrincipioAtivo(request.getParameter("principio_ativo"));
				getProduto().setCodigo(Integer.parseInt(request.getParameter("codigo")));
				getProduto().setCategoria(request.getParameter("categoria"));
				getProduto().setLote(request.getParameter("lote"));
				getProduto().setPreco(Float.parseFloat(request.getParameter("preco")));
				getProduto().setValidade(request.getParameter("vencimento"));
				this.salvar();
				try (PrintWriter out = response.getWriter()) {
         
					out.println("<!DOCTYPE html>");
					out.println("<html>");										
					out.println("<body>");
					out.println("<script> window.top.location.href=\"index.html\"</script>");										
					out.println("</body>");
					out.println("</html>");
					out.close();
				}				
				break;			
			case "fazerpedido":
				break;				
		}
	}
}