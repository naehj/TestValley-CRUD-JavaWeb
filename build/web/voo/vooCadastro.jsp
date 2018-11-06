<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Voo</title>
    </head>
    <body>
        <div><h1>Cadastro de Voo</h1></div>
        
          
        <form action="salvar" method="POST">
            <p><label for="destino">Destino:</label><input type="text" name="destino" id="destino"/></p>
            <p><label for="origem">Origem:</label><input type="text" name="origem" id="origem"/></p>
            <p><label for="cia">Companhia Aérea:</label><input type="text" name="cia" id="cia"/></p>
            <p><label for="partida">Partida:</label><input type="text" name="partida" id="partida"/></p>
            <p><label for="chegada">Chegada:</label><input type="text" name="chegada" id="chegada"/></p>
            <input type="hidden" name="operacao" value="SALVAR">
            <p><input type="submit" name="salvar" value=" Salvar " /></p>
        </form>
        
    </body>
</html>
