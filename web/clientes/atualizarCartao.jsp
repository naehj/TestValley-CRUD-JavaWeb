<%-- 
    Document   : atualizarCartao
    Created on : 18/11/2018, 10:07:42
    Author     : jhean
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <c:import  url="../elements/header.jsp"/>
        <<title>CRUD Cliente</title>
    </head>
    <body>
        <c:import url="../elements/menu-superior.jsp"/>

        <br/> <br/> <br/> <br/> <br/>
        <div class="container">	
            <h1>Cadastrar Cartao</h1>
            <form action='atualizarCartao' method="POST">
                <br/>
                <div class="form-group row">
                    <label for="nomeCartao" class="col-2 col-form-label">Nome do Cartão:</label>
                    <div class="col-10">
                        <input class="form-control" type="text" id="nomeCartao" name="nomeCartao" value="${resultado.get(0).nome}" >
                    </div>
                </div>
                <div class="form-group row">

                    <label for="numeroCartao" class="col-2 col-form-label">Número Cartão:</label>
                    <div class="col-5">
                        <input class="form-control" type="text" id="numeroCartao" name="numeroCartao" value="${resultado.get(0).numero}">
                    </div>
                    <label for="codigoCartao" class="col-2 col-form-label">Código de Segurança:</label>
                    <div class="col-2">
                        <input class="form-control" type="text" id="codigoCartao" name="codigoCartao" value="${resultado.get(0).codigo}" >
                    </div>

                </div>
                <div class="form-group row">

                    <label for="bandeira" class="col-2 cm-label">Bandeira:</label>
                    <div class="col-2">
                        <input class="form-control" type="text" id="bandeira" name="bandeira" value="${resultado.get(0).bandeira}">
                    </div>

                </div>

                <input type="hidden" name="idCartao" value="${resultado.get(0).id}"/>
                <input type="hidden" name="idCliente" value="${resultado.get(1).id}"/>
                <input type="hidden" name="operacao" value="ATUALIZAR">
                <input type='submit' class="btn btn-primary" name='Atualizar' value='Atualizar' />
                <br/>
                <c:if test="${mensagem != null}">
                    <br/>
                    <p>${mensagem}</p>
                </c:if>
            </form>
            <br/>
            <br/>
        </div>    

        <!-- Bootstrap core JavaScript -->
        <c:import  url="../elements/footer.jsp"/>
    </body>
</html>
