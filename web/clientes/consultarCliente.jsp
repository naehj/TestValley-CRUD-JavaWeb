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
        <div class="container-fluid">   

            <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
                <a class="navbar-brand" href="#">Turismo</a>
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
            <h1>Consultar Cliente</h1>
            <form action='filtrar' method="POST">
                <div class="form-group row">
                    <label for="nome" class="col-1 col-form-label">Nome:</label>
                    <div class="col-5">
                        <input class="form-control" type="text" id="nome" name="nome" >
                    </div>
                </div>

                <div class="form-group row">

                    <label for="email" class="col-1 col-form-label">E-mail:</label>
                    <div class="col-5">
                        <input class="form-control" type="text" id="email" name="email"  >
                    </div>

                </div>
                <hr/>


                <div class="form-group row">

                    <label for="logradouro" class="col-1 col-form-label">Logradouro:</label>
                    <div class="col-5">
                        <input class="form-control" type="text" id="logradouro" name="logradouro" >
                    </div>


                </div>


                <div class="form-group row">
                    <label for="nomeCartao" class="col-1 col-form-label">Nome do Cartão:</label>
                    <div class="col-5">
                        <input class="form-control" type="text" id="nomeCartao" name="nomeCartao">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="idCidade" class="col-1 col-form-label">Cidade:</label>
                    <div class="col-3">
                        <select class="form-control" id="idCidade" name="idCidade">
                            <option selected ></option>
                            <option value="1">São Paulo</option>
                            <option value="2">Rio de Janeiro</option>
                            <option value="3">Minas Gerais</option>
                            <option value="4">Paraná</option>
                        </select>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="custom-control custom-radio custom-control-inline">
                        <input type="radio" class="custom-control-input" id="opStatus1" checked value="1" name="opStatus">
                        <label class="custom-control-label" for="opStatus1">Ativo</label>
                    </div>

                 
                    <div class="custom-control custom-radio custom-control-inline">
                        <input type="radio" class="custom-control-input" id="opStatus" value="0" name="opStatus">
                        <label class="custom-control-label" for="opStatus">Inativo</label>
                    </div>


                </div>


               	<input type="hidden" name="operacao" value="LISTARFILTRO">

                <input class="btn btn-primary" type="submit" value="filtrar">
                <br/>

                <c:if test="${mensagem != null}">
                    <br/>
                    <p>${mensagem}</p>
                </c:if>
          
            <br/>
            <div class="row">
                <form> 
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Nome</th>
                            <th scope="col">E-mail</th>
                            <th scope="col">Logardouro</th>
                            <th scope="col">Cidade</th>
                            <th scope="col">Cartão Crédito</th>
                            <th scope="row">Status</th>
                            <th scope="col">Alterar</th>
                            <th scope="row">Excluir</th>
                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach var="c" items="${resultado}" >
                            <tr>

                                <td>${c.nome}</td>
                                <td>${c.email}</td>
                                <td>${c.endereco.logradouro}</td>
                                <td>${c.endereco.cidade.cidade}</td>
                                <td>${c.cartaoCredito.get(0).nome}</td>
                                <td>${c.status}</td>
                                <td><a href="preAtualizar?id=${c.id}&operacao=PREATUALIZAR"><input class="btn btn-secondary" type="button" value="Alterar"></a></td>
                                <td><a href="excluir?id=${c.id}&operacao=EXCLUIR"><input class="btn btn-danger" type="button" value="Excluir"></a></td>

                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                </form
            </div>
        

        </div>




        <!-- Bootstrap core JavaScript -->
        <script src="../style/js/jquery-3.3.1.min.js"></script>
        <script src="../style/js/popper.min.js"></script>
        <script src="../style/js/bootstrap.min.js"></script>
    </body>
</html>

