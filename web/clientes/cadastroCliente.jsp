
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
        <c:import  url="../elements/header.jsp"/>
        <title>CRUD Cliente</title>

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
        <c:import url="../elements/menu-superior.jsp"/>

        <br/> <br/> <br/> <br/> <br/>
        <div class="container">	
            <h1>Cadastrar Cliente</h1>
            <form action='salvar' method="POST">
                <div class="form-group row">
                    <label for="nome" class="col-2 col-form-label">Nome:</label>
                    <div class="col-5">
                        <input class="form-control" type="text" id="nome" name="nome" required="true">
                    </div>
                    <label for="genero" class="col-2 col-form-label">Gênero:</label>
                    <div class="col-2">
                        <input class="form-control" type="text" id="nome" name="genero" required="true">
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
                    <div class="col-4">
                        <input class="form-control" type="text" id="email" name="email" required="true">
                    </div>
                    <label for="senha" class="col-2 col-form-label">Senha:</label>
                    <div class="col-4">
                        <input class="form-control" type="password" id="senha" name="senha" required="true">
                    </div>

                </div>
                <hr/>
                <h2>Cartão de Crédito</h2>
                <div class="form-group row">
                    <label for="nomeCartao" class="col-2 col-form-label">Nome do Cartão:</label>
                    <div class="col-10">
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
                    <label for="bandeira" class="col-2 cm-label">Bandeira:</label>
                    <div class="col-2">
                        <input class="form-control" type="text" id="bandeira" name="bandeira">
                    </div>

                </div>
                <hr/>
                <h2>Endereço de Cobrança</h2>
                <div class="form-group row">
                    <label for="cep" class="col-2 col-form-label">CEP:</label>
                    <div class="col-2">
                        <input class="form-control" type="text" id="cepC" name="cepC" required="true">
                    </div>
                </div>
                <div class="form-group row">

                    <label for="logradouro" class="col-2 col-form-label">Logradouro:</label>
                    <div class="col-5">
                        <input class="form-control" type="text" id="logradouroC" name="logradouroC" required="true">
                    </div>
                    <label for="numeroRes" class="col-2 col-form-label">Número:</label>
                    <div class="col-2">
                        <input class="form-control" type="text" id="numeroResC" name="numeroResC">
                    </div>

                </div>
                <div class="form-group row">
                    <label for="logradouro" class="col-2 col-form-label">Tipo de Logradouro:</label>
                    <div class="col-4">
                        <input class="form-control" type="text" id="tipo_logradouroC" name="tipo_logradouroC" required="true">
                    </div>
                    <label for="logradouro" class="col-2 col-form-label">Tipo de Residência:</label>
                    <div class="col-4">
                        <input class="form-control" type="text" id="tipo_residenciaC" name="tipo_residenciaC" required="true">
                    </div>
                </div>

                <div class="form-group row">

                    <label for="complemento" class="col-2 cm-label">Complemento:</label>
                    <div class="col-5">
                        <input class="form-control" type="text" id="complementoC" name="complementoC">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="idCidade" class="col-2 col-form-label">Cidade:</label>
                    <div class="col-5">
                        <input class="form-control" type="text" id="cidadeC" name="cidadeC">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="idEstado" class="col-2 col-form-label">Estado:</label>
                    <div class="col-3">
                        <select class="form-control" id="estadoC" name="estadoC">
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
                        <select class="form-control" id="paisC" name="paisC">
                            <option ></option>
                            <option value="Brasil">Brasil</option>
                            <option value="Alemanha">Alemanha</option>

                        </select>
                    </div>
                </div>
                <hr/>
                <h2>Endereço de Entrega</h2>
                <div class="form-group row">
                    <label for="cep" class="col-2 col-form-label">CEP:</label>
                    <div class="col-2">
                        <input class="form-control" type="text" id="cepE" name="cepE" required="true">
                    </div>
                </div>
                <div class="form-group row">

                    <label for="logradouro" class="col-2 col-form-label">Logradouro:</label>
                    <div class="col-5">
                        <input class="form-control" type="text" id="logradouroE" name="logradouroE" required="true">
                    </div>
                    <label for="numeroRes" class="col-2 col-form-label">Número:</label>
                    <div class="col-2">
                        <input class="form-control" type="text" id="numeroResE" name="numeroResE">
                    </div>

                </div>

                <div class="form-group row">
                    <label for="logradouro" class="col-2 col-form-label">Tipo de Logradouro:</label>
                    <div class="col-4">
                        <input class="form-control" type="text" id="tipo_logradouroC" name="tipo_logradouroE" required="true">
                    </div>
                    <label for="logradouro" class="col-2 col-form-label">Tipo de Residência:</label>
                    <div class="col-4">
                        <input class="form-control" type="text" id="tipo_residenciaC" name="tipo_residenciaE" required="true">
                    </div>
                </div>
                <div class="form-group row">

                    <label for="complemento" class="col-2 cm-label">Complemento:</label>
                    <div class="col-5">
                        <input class="form-control" type="text" id="complemento" name="complementoE">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="idCidade" class="col-2 col-form-label">Cidade:</label>
                    <div class="col-5">
                        <input class="form-control" type="text" id="cidade" name="cidadeE">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="idEstado" class="col-2 col-form-label">Estado:</label>
                    <div class="col-3">
                        <select class="form-control" id="estado" name="estadoE">
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
                        <select class="form-control" id="pais" name="paisE">
                            <option ></option>
                            <option value="Brasil">Brasil</option>
                            <option value="Alemanha">Alemanha</option>

                        </select>
                    </div>
                </div>
                <br>
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
