package controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pedido;

@WebServlet(name = "PedidoController", urlPatterns = {"/pedidocontroller"})
public class PedidoController extends HttpServlet {

	private Pedido pedido = new Pedido();

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public void salvar() throws IOException {

		PedidoDAO p = new PedidoDAO();
		p.salvar(getPedido());
	}

	public void novoItemPedido(int codigo, int quantidade) throws Exception {

		getPedido().getItens().add(new PedidoDAO().novoItemPedido(codigo, quantidade));
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		response.setContentType("text/html;charset=UTF-8");
		String metodoString = request.getParameter("enviar");
		int qtde;
		int codigo;
		switch (metodoString) {

			case "Adicionar":
				qtde = Integer.parseInt(request.getParameter("quantidade"));
				codigo = Integer.parseInt(request.getParameter("cod"));
				 {
					try {
						this.novoItemPedido(codigo, qtde);
					} catch (Exception ex) {
						Logger.getLogger(PedidoController.class.getName()).log(Level.SEVERE, null, ex);
					}
				}
				try (PrintWriter out = response.getWriter()) {
         
					out.println("<!DOCTYPE html>");
					out.println("<html>");								
					out.println("<body>batata");
					
					out.println(": " + getPedido().getItens().size());
					
					//out.println("<script> window.top.location.href=\"pedido.html\"</script>");
					//out.println("<script> window.location.href=\"pedido.html\"</script>");										
					
					out.println("</body>");
					out.println("</html>");
					out.close();
				}
				break;
			case "finalizar":
				this.salvar();
				if("true".equals(request.getParameter("estaCadastrado"))){
					
					
				}
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
		}

	}
}
