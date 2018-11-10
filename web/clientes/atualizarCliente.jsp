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
        <title>Turismo</title>
    </head>
    <body>
        <div class="container-fluid">   

            <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
                <a class="navbar-brand" href="#">CRUD Cliente</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                        </li>

                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Cliente
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="cadastroCliente.jsp">Cadastrar</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="consultarCliente.jsp">Consultar Clientes</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#">Something else here</a>
                            </div>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>

        <br/> <br/> <br/> <br/> <br/>

        <div class="container">	
            <h1>Atualizar Cliente</h1>
            <form action='atualizar' method="POST">

                <div class="form-group row">
                    <label for="nome" class="col-2 col-form-label">Nome:</label>
                    <div class="col-6">
                        <input class="form-control" type="text" id="nome" name="nome"   value="${resultado.get(0).nome}">
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
                    <div class="col-5">
                        <input class="form-control" type="text" id="email" name="email"  value="${resultado.get(0).email}">
                    </div>

                </div>
                <hr/>
        </div>

        <input type="hidden" name="idEndereco" value="${resultado.get(0).endereco.id}"/>
        <input type="hidden" name="operacao" value="ATUALIZAR">
        <input type="hidden" name="idCliente" value="${resultado.get(0).id}"/>
        <input class="btn btn-primary" type="submit" value="atualizar">
        <br/>
        <c:if test="${mensagem != null}">
            <br/>
            <p>${mensagem}</p>
        </c:if>
    </form>
    <br/>
</div>




<!-- Bootstrap core JavaScript -->
<c:import  url="../elements/footer.jsp"/>
</body>
</html>

