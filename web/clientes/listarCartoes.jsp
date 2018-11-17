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
        <h1>Cartões</h1>
        <c:forEach var="cartao" items="${resultado.get(0).cartaoCredito}" >
            <div class="card">
                <div class="card-body">
                    <h3 class="card-title text-uppercase">${catao.nome}</h3>

                    <p class="card-text text-justify">${cartao.bandeira}</p>
                    <h2 class="card-subtitle mb-2 text-mutated">${cartao.numero}</h2>
                    <p class="card-text text-justify">${cartao.codigo}</p>
                    <table>
                        <tr>
                            <th>
                                <form action="atualizarCartao" method="POST">
                                    <input type="hidden" name="idCartao" value="${cartao.id}"/>
                                    <input type="hidden" name="idCliente" value="${resultado.get(0).id}"/>
                                    <input type="hidden" name="operacao" value="ATUALIZAR"/>
                                    <input class="btn btn-primary" type="submit" value="Editar Cartão"/>
                                </form>
                            </th>
                            <th>
                                <form action="removerCartao" method="POST">
                                    <input type="hidden" name="idCartao" value="${cartao.id}"/>
                                    <input type="hidden" name="idCliente" value="${resultado.get(0).id}"/>
                                    <input type="hidden" name="operacao" value="EXCLUIR"/>
                                    <input class="btn btn-primary" type="submit" value="Remover Cartão"/>
                                </form>
                            </th>
                        </tr>
                    </table>
                </div>
            </div>
        </c:forEach>
    </body>
</html>
