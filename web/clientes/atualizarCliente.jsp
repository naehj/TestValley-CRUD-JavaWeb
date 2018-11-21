<%-- 
    Document   : paginaCliente
    Created on : 25/08/2018, 12:04:30
    Author     : hisak
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
        <c:import  url="../elements/header.jsp"/>
        <title>CRUD Cliente</title>
    </head>
    <body>
        <c:import url="../elements/menu-superior.jsp"/>

        <br/> <br/> <br/> <br/> <br/>

        <div class="container">	
            <h1>Atualizar Cliente</h1>
            <form action='atualizarCliente' method="POST">

                <div class="form-group row">
                    <label for="nome" class="col-2 col-form-label">Nome:</label>
                    <div class="col-6">
                        <input class="form-control" type="text" id="nome" name="nome" value="${resultado.get(0).nome}">
                    </div>
                    <label for="genero" class="col-2 col-form-label">Gênero:</label>
                    <div class="col-2">
                        <input class="form-control" type="text" id="nome" name="genero" value="${resultado.get(0).genero}">
                    </div>
                </div>

                <div class="form-group row">

                    <label for="cpf" class="col-2 col-form-label">CPF:</label>
                    <div class="col-5">
                        <input class="form-control" type="text" id="cpf" name="cpf"  value="${resultado.get(0).cpf}">
                    </div>
                    <label for="dtNasc" class="col-2 col-form-label">Data Nascimento:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="dtNasc" name="dtNasc"  value="<fmt:formatDate value="${resultado.get(0).dtNascimento}" pattern="dd/MM/yyyy"/>">
                    </div>
                </div>

                <div class="form-group row">

                    <label for="email" class="col-2 col-form-label">E-mail:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="email" name="email"  value="${resultado.get(0).email}">
                    </div>
                    <label for="senha" class="col-2 col-form-label">Senha:</label>
                    <div class="col-3">
                        <input class="form-control" type="password" id="email" name="senha"  value="${resultado.get(0).senha}">
                    </div>

                </div>
                <hr/>
                <input type="hidden" name="operacao" value="ATUALIZAR">
                <input type="hidden" name="idCliente" value="${resultado.get(0).id}"/>
                <input class="btn btn-primary" type="submit" value="Atualizar">
            </form>
        </div>

        <br/>
        <c:if test="${mensagem != null}">
            <br/>
            <p>${mensagem}</p>
        </c:if>
        <br/>
    </div>




    <!-- Bootstrap core JavaScript -->
    <c:import  url="../elements/footer.jsp"/>
</body>
</html>

