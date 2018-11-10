
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Turismo</title>
    <c:import  url="../elements/header.jsp"/>


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
        <h1>Cadastrar Cartao</h1>
        <form action='novoCartao' method="POST">
            <br/>
            <div class="form-group row">
                <label for="nomeCartao" class="col-1 col-form-label">Nome do Cartão:</label>
                <div class="col-11">
                    <input class="form-control" type="text" id="nomeCartao" name="nomeCartao" >
                </div>
            </div>
            <div class="form-group row">

                <label for="numeroCartao" class="col-1 col-form-label">Número Cartão:</label>
                <div class="col-5">
                    <input class="form-control" type="text" id="numeroCartao" name="numeroCartao">
                </div>
                <label for="codigoCartao" class="col-1 col-form-label">Código de Segurança:</label>
                <div class="col-2">
                    <input class="form-control" type="text" id="codigoCartao" name="codigoCartao" >
                </div>

            </div>
            <div class="form-group row">

                <label for="mesCartao" class="col-1 col-form-label">Mês:</label>
                <div class="col-2">
                    <input class="form-control" type="number" min="1" max="12"id="mesCartao" name="mesCartao">
                </div>
                <label for="anoCartao" class="col-1 cm-label">Ano:</label>
                <div class="col-2">
                    <input class="form-control" type="number" min="2018" max="2040" id="anoCartao" name="anoCartao">
                </div>
                <label for="bandeira" class="col-1 cm-label">Bandeira:</label>
                <div class="col-2">
                    <input class="form-control" type="text" id="bandeira" name="bandeira">
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

    <!-- Bootstrap core JavaScript -->
<c:import  url="../elements/footer.jsp"/>
</body>
</html>
