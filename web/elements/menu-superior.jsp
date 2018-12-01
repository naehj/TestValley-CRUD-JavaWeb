<%-- 
    Document   : menu-superior
    Created on : 14/11/2018, 17:53:08
    Author     : jhean
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <div class="container-fluid">   

            <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
                <form  action="/CRUD_JavaWeb/clientes/home" method="POST">
                    <input type="hidden" name="idCliente" value="${resultado.get(0).id}">
                    <input type="hidden" name="operacao" value="HOME">
                    <input style="background-color: rgb(33,37,41); color: rgba(255, 255, 255, 0.5)" class="navbar-brand" value="CRUD_JavaWeb" type="submit">
                </form>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <form action="/CRUD_JavaWeb/clientes/home" method="POST">
                                <input type="hidden" name="idCliente" value="${resultado.get(0).id}">
                                <input type="hidden" name="operacao" value="HOME">
                                <input style="background-color: rgb(33,37,41); color: rgba(255, 255, 255, 0.5)" class="nav-link" value="Home" type="submit">
                            </form>
                        </li>

                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle"  id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Cliente
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="cadastroCliente.jsp">Cadastrar Cliente</a>
                                <div class="dropdown-divider"></div>
                                <form action='listarClientes' method="POST">
                                    <input type="hidden" name="operacao" value="LISTARCLIENTES">
                                    <input type="hidden" name="idCliente" value="${resultado.get(0).id}"/>
                                    <input class="dropdown-item" type="submit" value="Listar Clientes" style="width: 220.72px">
                                </form>
                                <div class="dropdown-divider"></div>
                            </div>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
    </body>
</html>
