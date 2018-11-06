/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.turismo.web.servlet;

import br.com.turismo.web.command.AtualizarCommand;
import br.com.turismo.web.command.ConsultarCommand;
import br.com.turismo.web.command.ExcluirCommand;
import br.com.turismo.web.command.FiltrarCommand;
import br.com.turismo.web.command.ICommand;
import br.com.turismo.web.command.SalvarCommand;
import br.com.turismo.web.command.VisualizarCommand;
import br.com.turismo.web.vh.CartaoCreditoViewHelper;
import br.com.turismo.web.vh.ClienteViewHelper;
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
    	commands.put("PREATUALIZAR", new ConsultarCommand());
    	commands.put("VISUALIZAR", new VisualizarCommand());
    	commands.put("ATUALIZAR", new AtualizarCommand());
        commands.put("LISTARFILTRO", new FiltrarCommand());
        commands.put("NOVOCC", new ConsultarCommand());
    
    	
    	
    	/* Utilizando o ViewHelper para tratar especificações de qualquer tela e indexando 
    	 * cada viewhelper pela url em que esta servlet à chamada no form
    	 * garantimos que esta servelt atenderá qualquer entidade */
    	
    	vhs = new HashMap<String, IViewHelper>();
    	/*A chave do mapa é o mapeamento da servlet para cada form que 
    	 * está configurado no web.xml e sendo utilizada no action do html
    	 */
        vhs.put("/Turismo/clientes/salvar", new ClienteViewHelper());
        vhs.put("/Turismo/clientes/atualizar", new ClienteViewHelper());
        vhs.put("/Turismo/clientes/consultar", new ClienteViewHelper());
        vhs.put("/Turismo/clientes/filtrar", new ClienteViewHelper());
        vhs.put("/Turismo/clientes/excluir", new ClienteViewHelper());
        vhs.put("/Turismo/clientes/preAtualizar", new ClienteViewHelper());
        vhs.put("/Turismo/login", new ClienteViewHelper());
        vhs.put("/Turismo/clientes/novoCartao", new CartaoCreditoViewHelper());
    	
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
        br.com.turismo.dominio.EntidadeDominio entidade = vh.getEntidade(request);
      
        //Essa string recebe o valor do atributo "operacao" no formulário, que é do tipo hidden, e será utilizado para identificar o command no map
        String operacao = request.getParameter("operacao");

        //Obtem o objeto do comando que executará a operação
        ICommand command = commands.get(operacao);

        //Executa o commando que vai chamar a fachada para executar a opera��o requisitada
        //o retorno � uma inst�ncia da classe resultado que pode conter mensagens de erro ou entidades de retorno
        br.com.turismo.core.fachada.Resultado resultado = command.execute(entidade);

        //Chama o método para retornar a resposta para a view correta.
        vh.setView(resultado, request, response);

    }

}
