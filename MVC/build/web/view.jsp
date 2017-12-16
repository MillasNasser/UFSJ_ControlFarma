<%-- 
    Document   : view
    Created on : 05/11/2017, 21:00:33
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> JView </title>
    </head>
    <body>
        <h1>Página View!</h1>
        Nome: <%= request.getAttribute("nome") %><br>
        Cpf: <%= request.getAttribute("cpf") %><br>
        Cadastrado com Sucesso!<br><br>
        <input type="button" value="retornar" onclick="history.back()">
                
    </body>
</html>
