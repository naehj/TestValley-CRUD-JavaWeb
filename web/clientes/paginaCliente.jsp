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
        <div class="form-group" style="float: right">
            <div class="form-group row">
                <form action='listarCartoes' method="POST">
                    <input type="hidden" name="operacao" value="LISTARCLIENTES">
                    <input type="hidden" name="idCliente" value="${resultado.get(0).id}"/>
                    <input class="btn btn-primary" type="submit" value="Listar Clientes" style="width: 220.72px">
                </form>
            </div>
            <div class="form-group row">
                <form action='listarClientes' method="POST">
                    <input type="hidden" name="operacao" value="LISTARCARTOES">
                    <input type="hidden" name="idCliente" value="${resultado.get(0).id}"/>
                    <input class="btn btn-primary" type="submit" value="Listar Cartões" style="width: 220.72px">
                </form>
            </div>
            <div class="form-group row">
                <form action='listarEnderecos' method="POST">
                    <input type="hidden" name="operacao" value="LISTARENDERECOS">
                    <input type="hidden" name="idCliente" value="${resultado.get(0).id}"/>
                    <input class="btn btn-primary" type="submit" value="Listar Endereços de Entrega" style="width: 220.72px">
                </form>
            </div>
            <div class="form-group row">
                <form action='atualizarCliente' method="POST">
                    <input type="hidden" name="operacao" value="PREATUALIZAR">
                    <input type="hidden" name="idCliente" value="${resultado.get(0).id}"/>
                    <input class="btn btn-primary" type="submit" value="Editar Cliente" style="width: 220.72px">
                </form>
            </div>
            <div class="form-group row">
                <form action="atualizarEndereco_Cobranca" method="POST">
                    <input type="hidden" name="idEndereco" value="${endereco.id}"/>
                    <input type="hidden" name="idCliente" value="${resultado.get(0).id}"/>
                    <input type="hidden" name="operacao" value="PREATUALIZAR"/>
                    <input class="btn btn-primary" type="submit" value="Editar Endereço de Cobrança" style="width: 220.72px"/>
                </form>
            </div>
            <div class="form-group row">
                <a href="cadastroCliente.jsp" class="btn btn-primary" style="width: 220.72px">Cadastrar novo cliente</a>
            </div>
        </div>
        <div class="container">	
            <h1>Cliente</h1>
            <br>

            <h2>Dados do Cliente</h2>
            <br>
            <div class="form-group row">
                <label for="nome" class="col-1 col-form-label">Nome:</label>
                <div class="col-5">
                    <input class="form-control" type="text" id="nome" name="nome"  disabled value="${resultado.get(0).nome}">
                </div>
                <label for="genero" class="col-2 col-form-label">Gênero:</label>
                <div class="col-2">
                    <input class="form-control" type="text" id="nome" name="genero" disabled value="${resultado.get(0).genero}">
                </div>
            </div>
            <div class="form-group row">

                <label for="cpf" class="col-1 col-form-label">CPF:</label>
                <div class="col-5">
                    <input class="form-control" type="text" id="cpf" name="cpf" disabled value="${resultado.get(0).cpf}">
                </div>
                <label for="dtNasc" class="col-1 col-form-label">Data Nascimento:</label>
                <div class="col-3">
                    <input class="form-control" type="text" id="dtNasc" name="dtNasc" disabled  value="<fmt:formatDate value="${resultado.get(0).dtNascimento}" pattern="dd/MM/yyyy"/>">
                </div>
            </div>

            <div class="form-group row">

                <label for="email" class="col-1 col-form-label">E-mail:</label>
                <div class="col-5">
                    <input class="form-control" type="text" id="email" name="email" disabled value="${resultado.get(0).email}">
                </div>

            </div>
            <hr/>
            <h2>Cartões de Crédito</h2>
            <br>
            <c:forEach var="cartao" items="${resultado.get(0).cartaoCredito}" >
                <div class="form-group row">
                    <label for="nomeCartao" class="col-2 col-form-label">Nome do Cartão:</label>
                    <div class="col-10">
                        <input class="form-control" type="text" id="nomeCartao" name="nomeCartao" disabled value="${cartao.nome}">
                    </div>
                </div>
                <div class="form-group row">

                    <label for="numeroCartao" class="col-2 col-form-label">Número Cartão:</label>
                    <div class="col-5">
                        <input class="form-control" type="text" id="numeroCartao" name="numeroCartao" disabled value="${cartao.numero}">
                    </div>
                    <label for="codigoCartao" class="col-2 col-form-label">Código de Segurança:</label>
                    <div class="col-2">
                        <input class="form-control" type="text" id="codigoCartao" name="codigoCartao" disabled value="${cartao.codigo}">
                    </div>
                </div>
                <div class="form-group row">

                    <label for="bandeira" class="col-1 cm-label">Bandeira:</label>

                    <div class="col-2">
                        <input class="form-control" type="text" id="bandeira" name="bandeira" disabled value="${cartao.bandeira}">
                    </div>
                </div>
                <br/>
                <br/>
            </c:forEach>
            <hr/>
            <h2>Endereços de Cobrança</h2>
            <br>
            <div class="form-group row">
                <label for="cep" class="col-2 col-form-label">CEP:</label>
                <div class="col-3">
                    <input class="form-control" type="text" id="cep" name="cep" disabled value="${resultado.get(0).end_De_Cobranca.cep}">
                </div>
            </div>
            <div class="form-group row">

                <label for="logradouro" class="col-2 col-form-label">Logradouro:</label>
                <div class="col-5">
                    <input class="form-control" type="text" id="logradouro" name="logradouro" disabled value="${resultado.get(0).end_De_Cobranca.logradouro}">
                </div>
                <label for="numeroRes" class="col- col-form-label">Número:</label>
                <div class="col-2">
                    <input class="form-control" type="text" id="numeroRes" name="numeroRes" disabled value="${resultado.get(0).end_De_Cobranca.numero}">
                </div>
            </div>
            <div class="form-group row">


                <label for="complemento" class="col-2 cm-label">Complemento:</label>
                <div class="col-5">
                    <input class="form-control" type="text" id="complemento" name="complemento" disabled value="${resultado.get(0).end_De_Cobranca.complemento}">
                </div>

            </div>
            <div class="form-group row">
                <label for="idCidade" class="col-2 cm-label"idCidade>Cidade:</label>
                <div class="col-5">
                    <input class="form-control" type="text" id="Cidade" disabled name="Cidade" value="${resultado.get(0).end_De_Cobranca.cidade}">
                </div>

            </div>
            <div class="form-group row">

                <label for="idEstado" class="col-2 cm-label">Estado: </label>
                <div class="col-5">
                    <input class="form-control" type="text" id="Estado" disabled name="Estado" value="${resultado.get(0).end_De_Cobranca.estado}">
                </div>
                <label for="idPais" class="col-2 cm-label">País</label>
                <div class="col-3">
                    <input class="form-control" type="text" id="Pais" disabled name="Pais" value="${resultado.get(0).end_De_Cobranca.pais}">
                </div>
            </div>
            <hr/>
            <h2>Endereços de Entrega</h2>
            <br>
            <c:forEach var="endereco" items="${resultado.get(0).end_De_Entrega}">
                <div class="form-group row">
                    <label for="cep" class="col-2 col-form-label">CEP:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="cep" name="cep" disabled value="${endereco.cep}">
                    </div>
                </div>
                <div class="form-group row">

                    <label for="logradouro" class="col-2 col-form-label">Logradouro:</label>
                    <div class="col-5">
                        <input class="form-control" type="text" id="logradouro" name="logradouro" disabled value="${endereco.logradouro}">
                    </div>
                    <label for="numeroRes" class="col- col-form-label">Número:</label>
                    <div class="col-2">
                        <input class="form-control" type="text" id="numeroRes" name="numeroRes" disabled value="${endereco.numero}">
                    </div>
                </div>
                <div class="form-group row">


                    <label for="complemento" class="col-2 cm-label">Complemento:</label>
                    <div class="col-5">
                        <input class="form-control" type="text" id="complemento" name="complemento" disabled value="${endereco.complemento}">
                    </div>

                </div>
                <div class="form-group row">
                    <label for="idCidade" class="col-2 cm-label"idCidade>Cidade:</label>
                    <div class="col-5">
                        <input class="form-control" type="text" id="Cidade" disabled name="Cidade" value="${endereco.cidade}">
                    </div>

                </div>
                <div class="form-group row">

                    <label for="idEstado" class="col-2 cm-label">Estado: </label>
                    <div class="col-5">
                        <input class="form-control" type="text" id="Estado" disabled name="Estado" value="${endereco.estado}">
                    </div>
                    <label for="idPais" class="col-2 cm-label">País</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="Pais" disabled name="Pais" value="${endereco.pais}">
                    </div>
                </div>
                <br/>
                <br/>
            </c:forEach>
            <form action="excluir" method="POST">
                <input type="hidden" name="idCliente" value="${resultado.get(0).id}"/>
                <input type="hidden" name="operacao" value="EXCLUIR"/>
                <input class="btn btn-danger" type="submit" value="Excluir Cliente"/>
            </form>
        </div>
        <br/>
        <br/>




        <!-- Bootstrap core JavaScript -->
        <c:import  url="../elements/footer.jsp"/>
    </body>
</html>
