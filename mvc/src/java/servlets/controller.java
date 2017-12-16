package servlets;

import logica.DAOBdFuncionarios;
import logica.Funcionario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "controller", urlPatterns = {"/controller"})
public class controller extends HttpServlet {
       
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        
        Funcionario f = new Funcionario(nome, cpf);
        DAOBdFuncionarios save = new DAOBdFuncionarios();
        save.salvar(f);        
        
        request.setAttribute("nome", nome);
        request.setAttribute("cpf", cpf);        
        request.getRequestDispatcher("/view.jsp").forward(request, response);
    }  
}

/*
try (PrintWriter out = response.getWriter()){
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Resultado de cadastro</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
        }
*/