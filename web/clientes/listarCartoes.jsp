<%-- 
    Document   : listarCartoes
    Created on : 16/11/2018, 19:26:46
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
            <h1>Cartões</h1>

            <c:forEach var="cartao" items="${resultado.get(0).cartaoCredito}" >
                <div class="card">
                    <div class="card-title">
                        <h3 class="card-title text-uppercase">Nome do cartão: ${cartao.nome}</h3>
                        <small>Bandeira: ${cartao.bandeira}</small>
                    </div>
                    <div class="card-body">
                        <h4 class="card-subtitle mb-2 text-mutated">Numero: ${cartao.numero}</h4>
                        <p class="card-text text-justify">Código ${cartao.codigo}</p>
                        <table>
                            <tr>
                                <th>
                                    <form action="atualizarCartao" method="POST">
                                        <input type="hidden" name="idCartao" value="${cartao.id}"/>
                                        <input type="hidden" name="idCliente" value="${resultado.get(0).id}"/>
                                        <input type="hidden" name="operacao" value="PREATUALIZAR"/>
                                        <input class="btn btn-primary" type="submit" value="Editar Cartão"/>
                                    </form>
                                </th>
                                <th>
                                    <form action="removerCartao" method="POST">
                                        <input type="hidden" name="idCartao" value="${cartao.id}"/>
                                        <input type="hidden" name="idCliente" value="${resultado.get(0).id}"/>
                                        <input type="hidden" name="operacao" value="EXCLUIR"/>
                                        <input class="btn btn-danger" type="submit" value="Remover Cartão"/>
                                    </form>
                                </th>
                            </tr>
                        </table>
                    </div>
                </div>
                <hr/>
            </c:forEach>
            <form action='preAtualizar' method="POST">
                <input type="hidden" name="operacao" value="NOVOCC">
                <input type="hidden" name="idCliente" value="${resultado.get(0).id}"/>
                <li style="list-style: none; text-align: center;">
                    <button class="btn btn-circle" style= "color:#007bff" type="submit">
                        <i class="material-icons" title="Adicionar novo apoio">add</i>
                    </button>
                </li>
                <br/>
            </form>
        </div>
    </body>
</html>
