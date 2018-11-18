/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.turismo.web.servlet;

import br.com.turismo.core.fachada.Resultado;
import br.com.turismo.dominio.CartaoCredito;
import br.com.turismo.dominio.Cliente;
import br.com.turismo.dominio.Endereco;
import br.com.turismo.dominio.EntidadeDominio;
import br.com.turismo.web.command.AtualizarCommand;
import br.com.turismo.web.command.ConsultarCommand;
import br.com.turismo.web.command.ExcluirCommand;
import br.com.turismo.web.command.FiltrarCommand;
import br.com.turismo.web.command.ICommand;
import br.com.turismo.web.command.SalvarCommand;
import br.com.turismo.web.command.VisualizarCommand;
import br.com.turismo.web.vh.CartaoCreditoViewHelper;
import br.com.turismo.web.vh.ClienteViewHelper;
import br.com.turismo.web.vh.EnderecoViewHelper;
import br.com.turismo.web.vh.IViewHelper;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hisak
 */
public class Servlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static Map<String, ICommand> commands;
    private static Map<String, IViewHelper> vhs;

    /**
     * Default constructor.
     */
    public Servlet() {

        /* Utilizando o command para chamar a fachada e indexando cada command 
    	 * pela operagarção gantimos que esta servelt atenderá qualquer operação */
        commands = new HashMap<String, ICommand>();

        commands.put("SALVAR", new SalvarCommand());
        commands.put("EXCLUIR", new ExcluirCommand());
        commands.put("CONSULTAR", new ConsultarCommand());
        commands.put("PREATUALIZAR", new ConsultarCommand());
        commands.put("HOME", new ConsultarCommand());
        commands.put("VISUALIZAR", new VisualizarCommand());
        commands.put("ATUALIZAR", new AtualizarCommand());
        commands.put("AUTENTICAR", new ConsultarCommand());
        commands.put("LISTARCARTOES", new ConsultarCommand());
        commands.put("LISTARENDERECOS", new ConsultarCommand());
        commands.put("LISTARFILTRO", new FiltrarCommand());
        commands.put("NOVOCC", new ConsultarCommand());
        commands.put("NOVOEE", new ConsultarCommand());

        /* Utilizando o ViewHelper para tratar especificações de qualquer tela e indexando 
    	 * cada viewhelper pela url em que esta servlet à chamada no form
    	 * garantimos que esta servelt atenderá qualquer entidade */
        vhs = new HashMap<String, IViewHelper>();
        /*A chave do mapa é o mapeamento da servlet para cada form que 
    	 * está configurado no web.xml e sendo utilizada no action do html
         */
        vhs.put("/CRUD_JavaWeb/clientes/salvar", new ClienteViewHelper());
        vhs.put("/CRUD_JavaWeb/clientes/atualizarCliente", new ClienteViewHelper());
        vhs.put("/CRUD_JavaWeb/clientes/consultar", new ClienteViewHelper());
        vhs.put("/CRUD_JavaWeb/clientes/filtrar", new ClienteViewHelper());
        vhs.put("/CRUD_JavaWeb/clientes/autenticar", new ClienteViewHelper());
        vhs.put("/CRUD_JavaWeb/clientes/listarCartoes", new ClienteViewHelper());
        vhs.put("/CRUD_JavaWeb/clientes/listarEnderecos", new ClienteViewHelper());
        vhs.put("/CRUD_JavaWeb/clientes/excluir", new ClienteViewHelper());
        vhs.put("/CRUD_JavaWeb/clientes/preAtualizar", new ClienteViewHelper());
        vhs.put("/CRUD_JavaWeb/clientes/home", new ClienteViewHelper());
        vhs.put("/CRUD_JavaWeb/login", new ClienteViewHelper());
        vhs.put("/CRUD_JavaWeb/clientes/novoCartao", new CartaoCreditoViewHelper());
        vhs.put("/CRUD_JavaWeb/clientes/atualizarCartao", new CartaoCreditoViewHelper());
        vhs.put("/CRUD_JavaWeb/clientes/removerCartao", new CartaoCreditoViewHelper());
        vhs.put("/CRUD_JavaWeb/clientes/novoEndereco_Entrega", new EnderecoViewHelper());
        vhs.put("/CRUD_JavaWeb/clientes/atualizarEndereco_Cobranca", new EnderecoViewHelper());
        vhs.put("/CRUD_JavaWeb/clientes/atualizarEndereco_Entrega", new EnderecoViewHelper());
        vhs.put("/CRUD_JavaWeb/clientes/removerEndereco", new EnderecoViewHelper());

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcessRequest(request, response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doProcessRequest(request, response);
    }

    protected void doProcessRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //pega a uri de onde vem a requisição, indicada no action no form
        String uri = request.getRequestURI();

        //Obtem o objeto da viewHelper correta, mapeada no hash acima;
        IViewHelper vh = vhs.get(uri);

        //Vai retornar o objeto do dominio, que foi constru�do na viewhelper espec�fica
        EntidadeDominio entidade = vh.getEntidade(request);
        Cliente entidadeCli = new Cliente();
        CartaoCredito entidadeCartao = new CartaoCredito();
        Endereco entidadeEndereco = new Endereco();
        if (uri.contains("novoCartao")) {
            entidadeCli = (Cliente) entidade;
            entidadeCartao = entidadeCli.getCartaoCredito().iterator().next();
        } else if (uri.contains("novoEndereco_Entrega")) {
            entidadeCli = (Cliente) entidade;
            entidadeEndereco = entidadeCli.getEnd_De_Entrega().iterator().next();
        }

        //Essa string recebe o valor do atributo "operacao" no formulário, que é do tipo hidden, e será utilizado para identificar o command no map
        String operacao = request.getParameter("operacao");

        //Obtem o objeto do comando que executará a operação
        ICommand command = commands.get(operacao);

        //Executa o commando que vai chamar a fachada para executar a opera��o requisitada
        //o retorno � uma inst�ncia da classe resultado que pode conter mensagens de erro ou entidades de retorno
        Resultado resultado = new Resultado();
        if (uri.contains("novoCartao")) {
            SalvarCommand salvar = new SalvarCommand();
            resultado = salvar.execute(entidadeCli, entidadeCartao);
        } else if (uri.contains("novoEndereco_Entrega")) {
            SalvarCommand salvar = new SalvarCommand();
            resultado = salvar.execute(entidadeCli, entidadeEndereco);
        } else {
            resultado = command.execute(entidade);
        }

        //Chama o método para retornar a resposta para a view correta.
        vh.setView(resultado, request, response);

    }

}
