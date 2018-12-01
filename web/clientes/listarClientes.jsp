<%-- 
    Document   : listarClientes
    Created on : 01/12/2018, 08:14:21
    Author     : jhean
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
        <c:import  url="../elements/header.jsp"/>
        <title>CRUD_JavaWeb</title>
    </head>
    <body>
        <c:import url="../elements/menu-superior.jsp"/>

        <br/> <br/> <br/> <br/> <br/>
        <div class="container">
            <c:set var="mensagem" value="${sessionScope.mensagem}"></c:set>
            <c:if test="${not empty mensagem}">
                <div class="alert alert-${status} alert-dismissible fade show"
                     role="alert">
                    ${mensagem}
                    <button type="button" class="close" data-dismiss="alert"
                            aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            </c:if>
            <h1>Clientes</h1>
            <form action="listarClientes" method="POST">
                <div class="form-group input-group">
                    <input type="hidden" name="operacao" value="LISTARCLIENTES"/>
                    <input name="nomeCliente" id="txt_consulta" placeholder="Digite o nome do Cliente a ser consultado" type="text" class="form-control">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-search"></i></span>
                </div>
            </form>
            <c:forEach var="cliente" items="${resultado}">
                <div class="card">
                    <div class="card-title">
                        <h3 class="card-title text-uppercase">Nome do cliente: ${cliente.nome}</h3>
                        <small>CPF: ${cliente.cpf}</small>
                    </div>
                    <div class="card-body">
                        <h4 class="card-subtitle mb-2 text-mutated">Email: ${cliente.email}</h4>
                        <p class="card-text text-justify">Gênero: ${cliente.genero}</p>
                        <table>
                            <tr>
                                <th>
                                    <form action="atualizarCliente" method="POST">
                                        <input type="hidden" name="idCliente" value="${cliente.id}"/>
                                        <input type="hidden" name="operacao" value="PREATUALIZAR"/>
                                        <input class="btn btn-primary" type="submit" value="Editar Cliente"/>
                                    </form>
                                </th>
                                <th>
                                    <form action="excluir" method="POST">
                                        <input type="hidden" name="idCliente" value="${cliente.id}"/>
                                        <input type="hidden" name="operacao" value="EXCLUIR"/>
                                        <input class="btn btn-danger" type="submit" value="Remover Cliente"/>
                                    </form>
                                </th>
                            </tr>
                        </table>
                    </div>
                </div>
                <hr/>
            </c:forEach>
            <form action='cadastroCliente.jsp' method="POST">
            <c:set var="mensagem" value="${null}"></c:set>
                <li style="list-style: none; text-align: center;">
                    <button class="btn btn-circle" style= "color:#007bff" type="submit">
                        <i class="material-icons" title="Adicionar novo cliente">add</i>
                    </button>
                </li>
                <br/>
            </form>
        </div>
        <!-- Bootstrap core JavaScript -->
        <c:import  url="../elements/footer.jsp"/>
    </body>
</html>
