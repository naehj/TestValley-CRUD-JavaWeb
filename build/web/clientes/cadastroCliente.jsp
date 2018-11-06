
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Turismo</title>
        <link rel="stylesheet" href="../style/css/bootstrap.min.css">

        <script type="text/javascript">
            // mascara para a data de nascimento
            function formatar(src, mask, e)
            {
                var tecla = ""
                if (document.all) // Internet Explorer
                    tecla = event.keyCode;
                else
                    tecla = e.which;
                //code = evente.keyCode;
                if (tecla != 8) {


                    if (src.value.length == src.maxlength) {
                        return;
                    }
                    var i = src.value.length;
                    var saida = mask.substring(0, 1);
                    var texto = mask.substring(i);
                    if (texto.substring(0, 1) != saida)
                    {
                        src.value += texto.substring(0, 1);
                    }
                }

        </script>
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
            <h1>Cadastrar Cliente</h1>
            <form action='salvar' method="POST">
                <div class="form-group row">
                    <label for="nome" class="col-2 col-form-label">Nome:</label>
                    <div class="col-5">
                        <input class="form-control" type="text" id="nome" name="nome" required="true">
                    </div>
                </div>
                <div class="form-group row">

                    <label for="cpf" class="col-2 col-form-label">CPF:</label>
                    <div class="col-5">
                        <input class="form-control" type="text" id="cpf" name="cpf" required="true">
                    </div>
                    <label for="dtNasc" class="col-2 col-form-label">Data Nascimento:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="dtNasc" name="dtNasc" onkeyup="formatar(this, '##/##/####', event)" >
                    </div>
                </div>

                <div class="form-group row">

                    <label for="email" class="col-2 col-form-label">E-mail:</label>
                    <div class="col-5">
                        <input class="form-control" type="text" id="email" name="email" required="true">
                    </div>
                    <label for="senha" class="col-2 col-form-label">Senha:</label>
                    <div class="col-5">
                        <input class="form-control" type="text" id="senha" name="senha" required="true">
                    </div>

                </div>
                <hr/>
                <div class="form-group row">
                    <label for="nomeCartao" class="col-2 col-form-label">Nome do Cartão:</label>
                    <div class="col-11">
                        <input class="form-control" type="text" id="nomeCartao" name="nomeCartao" >
                    </div>
                </div>
                <div class="form-group row">

                    <label for="numeroCartao" class="col-2 col-form-label">Número Cartão:</label>
                    <div class="col-5">
                        <input class="form-control" type="text" id="numeroCartao" name="numeroCartao">
                    </div>
                    <label for="codigoCartao" class="col-2 col-form-label">Código de Segurança:</label>
                    <div class="col-2">
                        <input class="form-control" type="text" id="codigoCartao" name="codigoCartao" >
                    </div>

                </div>
                <div class="form-group row">

                    <label for="mesCartao" class="col-2 col-form-label">Mês:</label>
                    <div class="col-2">
                        <input class="form-control" type="number" min="1" max="12"id="mesCartao" name="mesCartao">
                    </div>
                    <label for="anoCartao" class="col-2 cm-label">Ano:</label>
                    <div class="col-2">
                        <input class="form-control" type="number" min="2018" max="2040" id="anoCartao" name="anoCartao">
                    </div>
                    <label for="bandeira" class="col-2 cm-label">Bandeira:</label>
                    <div class="col-2">
                        <input class="form-control" type="text" id="bandeira" name="bandeira">
                    </div>

                </div>
                <hr/>

                <div class="form-group row">
                    <label for="cep" class="col-2 col-form-label">CEP:</label>
                    <div class="col-2">
                        <input class="form-control" type="text" id="cep" name="cep" required="true">
                    </div>
                </div>
                <div class="form-group row">

                    <label for="logradouro" class="col-2 col-form-label">Logradouro:</label>
                    <div class="col-5">
                        <input class="form-control" type="text" id="logradouro" name="logradouro" required="true">
                    </div>
                    <label for="numeroRes" class="col-2 col-form-label">Número:</label>
                    <div class="col-2">
                        <input class="form-control" type="text" id="numeroRes" name="numeroRes">
                    </div>

                </div>
                <div class="form-group row">

                    <label for="complemento" class="col-2 cm-label">Complemento:</label>
                    <div class="col-5">
                        <input class="form-control" type="text" id="complemento" name="complemento">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="bairro" class="col-2 col-form-label">Bairro:</label>
                    <div class="col-2">
                        <input class="form-control" type="mesCartao" id="bairro" name="bairro" required="true">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="idCidade" class="col-2 col-form-label">Cidade:</label>
                    <div class="col-5">
                        <input class="form-control" type="text" id="idCidade" name="idCidade">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="idEstado" class="col-2 col-form-label">Estado:</label>
                    <div class="col-3">
                        <select class="form-control" id="idEstado" name="idEstado">
                            <option ></option>
                            <option value="1">São Paulo</option>
                            <option value="2">Rio de Janeiro</option>
                            <option value="3">Belo Horizonte</option>
                            <option value="4">Curitiba</option>
                        </select>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="idPais" class="col-2 col-form-label">Pais:</label>
                    <div class="col-3">
                        <select class="form-control" id="idPais" name="idPais">
                            <option ></option>
                            <option value="1">Brasil</option>
                            <option value="2">Alemanha</option>

                        </select>
                    </div>
                </div>



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
        <script src="../style/js/jquery-3.3.1.min.js"></script>
        <script src="../style/js/popper.min.js"></script>
        <script src="../style/js/bootstrap.min.js"></script>
    </body>
</html>
