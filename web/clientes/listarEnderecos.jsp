<%-- 
    Document   : listarEnderecos
    Created on : 16/11/2018, 19:27:07
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
        </c:if>F
        <div class="container">
            <h1>Endereços de Entrega</h1>

            <c:forEach var="endereco" items="${resultado.get(0).end_De_Entrega}">
                <div class="card">
                    <div class="card-title">
                        <h3 class="card-title text-uppercase">Cidade: ${endereco.cidade}</h3>
                        <small>Estado: ${endereco.estado}</small>
                    </div>
                    <div class="card-body">
                        <h4 class="card-subtitle mb-2 text-mutated">CEP: ${endereco.cep}</h4>
                        <p class="card-text text-justify">Logradouro: ${endereco.logradouro}</p>
                        <p class="card-text text-justify">Número: ${endereco.numero}</p>
                        <table>
                            <tr>
                                <th>
                                    <form action="atualizarEndereco_Entrega" method="POST">
                                        <input type="hidden" name="idEndereco" value="${endereco.id}"/>
                                        <input type="hidden" name="idCliente" value="${resultado.get(0).id}"/>
                                        <input type="hidden" name="operacao" value="PREATUALIZAR"/>
                                        <input class="btn btn-primary" type="submit" value="Editar Endereço"/>
                                    </form>
                                </th>
                                <th>
                                    <form action="removerEndereco" method="POST">
                                        <input type="hidden" name="idEndereco" value="${endereco.id}"/>
                                        <input type="hidden" name="idCliente" value="${resultado.get(0).id}"/>
                                        <input type="hidden" name="operacao" value="EXCLUIR"/>
                                        <input class="btn btn-danger" type="submit" value="Remover Endereço"/>
                                    </form>
                                </th>
                            </tr>
                        </table>
                    </div>
                </div>
                <hr/>
            </c:forEach>
            <form action='preAtualizar' method="POST">
                <input type="hidden" name="operacao" value="NOVOEE">
                <input type="hidden" name="idCliente" value="${resultado.get(0).id}"/>
                <li style="list-style: none; text-align: center;">
                    <button class="btn btn-circle" style= "color:#007bff" type="submit">
                        <i class="material-icons" title="Adicionar novo apoio">add</i>
                    </button>
                </li>
                <br/>
            </form>
        </div>
        <!-- Bootstrap core JavaScript -->
        <c:import  url="../elements/footer.jsp"/>
    </body>
</html>
