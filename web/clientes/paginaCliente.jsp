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
        <link rel="stylesheet" href="../style/css/bootstrap.min.css">
        <title>Turismo</title>
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
                            <a class="nav-link dropdown-toggle"  id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Cliente
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="cadastroCliente.jsp">Cadastrar</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="consultarCliente.jsp">Consultar Clientes</a>
                                <div class="dropdown-divider"></div>

                            </div>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>

        <br/> <br/> <br/> <br/> <br/>

        <div class="container">	
            <h1>Cliente</h1>
            <br/>
            <br/>
            <form action='preAtualizar' method="POST">
                <input type="hidden" name="operacao" value="NOVOCC">
                <input type="hidden" name="idCliente" value="${resultado.get(0).id}"/>
                <input class="btn btn-primary" type="submit" value="Novo Cartão">
                <br/>
            </form>


            <div class="form-group row">
                <label for="nome" class="col-1 col-form-label">Nome:</label>
                <div class="col-5">
                    <input class="form-control" type="text" id="nome" name="nome"  disabled value="${resultado.get(0).nome}">
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
            <c:forEach var="cartao" items="${resultado.get(0).cartaoCredito}" >
                <div class="form-group row">
                    <label for="nomeCartao" class="col-1 col-form-label">Nome do Cartão:</label>
                    <div class="col-11">
                        <input class="form-control" type="text" id="nomeCartao" name="nomeCartao" disabled value="${cartao.nome}">
                    </div>
                </div>
                <div class="form-group row">

                    <label for="numeroCartao" class="col-1 col-form-label">Número Cartão:</label>
                    <div class="col-5">
                        <input class="form-control" type="text" id="numeroCartao" name="numeroCartao" disabled value="${cartao.numero}">
                    </div>
                    <label for="codigoCartao" class="col-1 col-form-label">Código de Segurança:</label>
                    <div class="col-2">
                        <input class="form-control" type="text" id="codigoCartao" name="codigoCartao" disabled value="${cartao.codigo}">
                    </div>
                </div>
                <div class="form-group row">

                    <label for="mesCartao" class="col-1 col-form-label">Mês:</label>
                    <div class="col-2">
                        <input class="form-control" type="number" min="1" max="12"id="mesCartao" name="mesCartao" disabled value="${cartao.mes}">
                    </div>
                    <label for="anoCartao" class="col-1 cm-label">Ano:</label>

                    <div class="col-2">
                        <input class="form-control" type="number" min="2018" max="2040" id="anoCartao" name="anoCartao" disabled value="${cartao.ano}">
                    </div>
                    <label for="bandeira" class="col-1 cm-label">Bandeira:</label>

                    <div class="col-2">
                        <input class="form-control" type="text" id="bandeira" name="bandeira" disabled value="${cartao.bandeira}">
                    </div>
                </div>
                <br/>
                <br/>
            </c:forEach>
            <hr/>

            <div class="form-group row">
                <label for="cep" class="col-2 col-form-label">CEP:</label>
                <div class="col-3">
                    <input class="form-control" type="text" id="cep" name="cep" disabled value="${resultado.get(0).endereco.cep}">
                </div>
            </div>
            <div class="form-group row">

                <label for="logradouro" class="col-2 col-form-label">Logradouro:</label>
                <div class="col-5">
                    <input class="form-control" type="text" id="logradouro" name="logradouro" disabled value="${resultado.get(0).endereco.logradouro}">
                </div>
                <label for="numeroRes" class="col- col-form-label">Número:</label>
                <div class="col-2">
                    <input class="form-control" type="text" id="numeroRes" name="numeroRes" disabled value="${resultado.get(0).endereco.numero}">
                </div>
                <div class="form-group row">


                    <label for="complemento" class="col-2 cm-label">Complemento:</label>
                    <div class="col-5">
                        <input class="form-control" type="text" id="complemento" name="complemento" disabled value="${resultado.get(0).endereco.complemento}">
                    </div>

                </div>
                <div class="form-group row">

                    <label for="bairro" class="col-2 col-form-label">Bairro:</label>
                    <div class="col-2">
                        <input class="form-control" type="mesCartao" id="bairro" name="bairro" disabled value="${resultado.get(0).endereco.bairro}">
                    </div>

                    <label for="idCidade" class="col-2 cm-label">idCidade</label>
                    <div class="col-2">
                        <input class="form-control" type="text" id="idCidade" disabled name="idCidade">
                    </div>

                </div>
                <div class="form-group row">

                    <label for="idEstado" class="col-2 col-form-label">idEstado</label>
                    <div class="col-5">
                        <input class="form-control" type="text" id="idEstado" disabled name="idEstado">
                    </div>
                    <label for="idPais" class="col-2 col-form-label">idPais</label>
                    <div class="col-2">
                        <input class="form-control" type="text" id="idPais" disabled name="idPais">
                    </div>

                </div>
                <br/>
                <br/>



                <!-- Bootstrap core JavaScript -->
                <script src="../style/js/jquery-3.3.1.min.js"></script>
                <script src="../style/js/popper.min.js"></script>
                <script src="../style/js/bootstrap.min.js"></script>
                </body>
                </html>
