/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.turismo.web.vh;

import br.com.turismo.core.fachada.Resultado;
import br.com.turismo.dominio.CartaoCredito;
import br.com.turismo.dominio.Cliente;
import br.com.turismo.dominio.EntidadeDominio;
import br.com.turismo.web.command.AtualizarCommand;
import br.com.turismo.web.command.ConsultarCommand;
import br.com.turismo.web.command.ExcluirCommand;
import br.com.turismo.web.command.SalvarCommand;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hisak
 */
public class CartaoCreditoViewHelper implements IViewHelper {

    //Objetos necessários para cadastrar um Cliente
    Cliente cliente;
    
    CartaoCredito cartao;
    
    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {

        //Recebe operação do formulário, na request.
        String operacao = request.getParameter("operacao");
        
        if (operacao.equals("SALVAR")) {
            cliente = new Cliente();
            cliente.setId(Integer.parseInt(request.getParameter("idCliente")));
            cartao = new CartaoCredito();
            String numero = request.getParameter("numeroCartao");
            String codigo = request.getParameter("codigoCartao");
            String bandeira = request.getParameter("bandeira");
            String nome = request.getParameter("nomeCartao");
            if (numero != null && !numero.trim().equals("")) {
                cartao.setNumero(numero);
            }
            
            if (codigo != null && !codigo.trim().equals("")) {
                cartao.setCodigo(codigo);
            }
            
            if (bandeira != null && !bandeira.trim().equals("")) {
                cartao.setBandeira(bandeira);
            }
            if (nome != null && !nome.trim().equals("")) {
                cartao.setNome(nome);
            }
            HashSet<CartaoCredito> cartoes = new HashSet<>();
            cartoes.add(cartao);
            cliente.setCartaoCredito(cartoes);
            return cliente;
            
        }
        
        if (operacao.equals("ATUALIZAR")) {
            
            cartao = new CartaoCredito();
            String numero = request.getParameter("numeroCartao");
            String codigo = request.getParameter("codigoCartao");
            String bandeira = request.getParameter("bandeira");
            String nome = request.getParameter("nomeCartao");
            
            cartao.setId(Integer.parseInt(request.getParameter("idCartao")));
            
            if (numero != null && !numero.trim().equals("")) {
                cartao.setNumero(numero);
            }
            
            if (codigo != null && !codigo.trim().equals("")) {
                cartao.setCodigo(codigo);
            }
            
            if (bandeira != null && !bandeira.trim().equals("")) {
                cartao.setBandeira(bandeira);
            }
            if (nome != null && !nome.trim().equals("")) {
                cartao.setNome(nome);
            }
            
            return cartao;
            
        }
        
        if (operacao.equals("EXCLUIR")) {
            
            cartao = new CartaoCredito();
            
            cartao.setId(Integer.parseInt(request.getParameter("idCartao")));
            
            return cartao;
            
        }
        
        return cartao;
    }
    
    @Override
    public void setView(Resultado resultado, HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher rd = null;
        
        String operacao = request.getParameter("operacao");
        
        if (operacao.equals("SALVAR")) {
            if (resultado.getMsg() != null) {
                
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                
                rd = request.getRequestDispatcher("cadastroCartao.jsp");
            } else {
                ConsultarCommand consulta = new ConsultarCommand();
                cliente = new Cliente();
                cliente.setId(Integer.parseInt(request.getParameter("idCliente")));
                resultado = consulta.execute(cliente);
                request.getSession().setAttribute("resultado", resultado.getEntidades());
                
                rd = request.getRequestDispatcher("paginaCliente.jsp");
            }
        }
        
        if (operacao.equals("ATUALIZAR")) {
            if (resultado.getMsg() != null) {
                
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                
                rd = request.getRequestDispatcher("atualizarCartao.jsp");
            } else {
                request.getSession().setAttribute("resultado", resultado.getEntidades());
                
                rd = request.getRequestDispatcher("paginaCliente.jsp");
            }
        }
        
        if (operacao.equals("EXCLUIR")) {
            if (resultado.getMsg() != null) {
                
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                
                rd = request.getRequestDispatcher("paginaInicial.jsp");
            } else {
                ConsultarCommand consulta = new ConsultarCommand();
                cliente = new Cliente();
                cliente.setId(Integer.parseInt(request.getParameter("idCliente")));
                resultado = consulta.execute(cliente);
                request.getSession().setAttribute("resultado", resultado.getEntidades());
                
                rd = request.getRequestDispatcher("paginaCliente.jsp");
            }
        }
        
        rd.forward(request, response);
    }
    
}
