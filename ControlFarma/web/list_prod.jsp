<%@page import="java.util.List"%>
<%@page import="model.GerenciarProdutoDAO"%>
<%@page import="model.Produto"%>
<link rel="stylesheet" type="text/css" href="css/style.css">
<meta charset="utf-8">
<table id="tabelaPedidos">
    <th>Código</th>
    <th>Nome</th>
    <th>Categoria</th>
    <th>Preço Unitário</th>
    <th>Validade</th>
    <th>Princípio ativo</th>
    <% 
        List<Produto> list = new GerenciarProdutoDAO().listar(); 
        for(Produto produto : list){%>
        
            <tr> 
                <td><%=produto.getCodigo() %></td>
                <td><%=produto.getNome() %></td>
                <td><%=produto.getCategoria() %></td>
                <td><%=produto.getPreco() %></td>
                <td><%=produto.getValidade() %></td>
                <td><%=produto.getPrincipioAtivo() %></td>
            </tr>
        <%}%>
    
</table>