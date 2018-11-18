<%-- 
    Document   : cadastroEndereco
    Created on : 18/11/2018, 11:10:36
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
            <h1>Cadastrar Endereço de Entrega</h1>
            <form action="novoEndereco_Entrega" method="POST">
                <div class="form-group row">
                    <label for="cep" class="col-2 col-form-label">CEP:</label>
                    <div class="col-2">
                        <input class="form-control" type="text" id="cepC" name="cep" required="true">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="logradouro" class="col-2 col-form-label">Tipo de Logradouro:</label>
                    <div class="col-4">
                        <input class="form-control" type="text" id="tipo_logradouroC" name="tipo_logradouro" required="true">
                    </div>
                    <label for="logradouro" class="col-2 col-form-label">Tipo de Residência:</label>
                    <div class="col-4">
                        <input class="form-control" type="text" id="tipo_residenciaC" name="tipo_residencia" required="true">
                    </div>
                </div>
                <div class="form-group row">

                    <label for="logradouro" class="col-2 col-form-label">Logradouro:</label>
                    <div class="col-5">
                        <input class="form-control" type="text" id="logradouroC" name="logradouro" required="true">
                    </div>
                    <label for="numeroRes" class="col-1 col-form-label">Número:</label>
                    <div class="col-4">
                        <input class="form-control" type="text" id="numeroResC" name="numeroRes">
                    </div>

                </div>
                <div class="form-group row">

                    <label for="complemento" class="col-2 cm-label">Complemento:</label>
                    <div class="col-5">
                        <input class="form-control" type="text" id="complementoC" name="complemento">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="idCidade" class="col-2 col-form-label">Cidade:</label>
                    <div class="col-5">
                        <input class="form-control" type="text" id="cidadeC" name="cidade">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="idEstado" class="col-2 col-form-label">Estado:</label>
                    <div class="col-3">
                        <select class="form-control" id="estadoC" name="estado">
                            <option ></option>
                            <option value="São Paulo">São Paulo</option>
                            <option value="Rio de Janeiro">Rio de Janeiro</option>
                            <option value="Belo Horisonte">Belo Horizonte</option>
                            <option value="Curitiba">Curitiba</option>
                        </select>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="idPais" class="col-2 col-form-label">Pais:</label>
                    <div class="col-3">
                        <select class="form-control" id="paisC" name="pais">
                            <option ></option>
                            <option value="Brasil">Brasil</option>
                            <option value="Alemanha">Alemanha</option>
                        </select>
                    </div>
                </div>
                <input type="hidden" name="idCliente" value="${resultado.get(0).id}"/>
                <input type="hidden" name="operacao" value="SALVAR">
                <input type='submit' class="btn btn-primary" name='Salvar' value='Salvar' />
                <br/>
                <c:if test="${mensagem != null}">
                    <br/>
                    <p>${mensagem}</p>
                </c:if>
            </form>
            <br/>
            <br/>
        </div>
    </body>
</html>
