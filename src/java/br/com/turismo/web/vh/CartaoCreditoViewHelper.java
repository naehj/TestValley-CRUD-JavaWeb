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
import br.com.turismo.web.command.ConsultarCommand;
import java.io.IOException;
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

            cartao = new CartaoCredito();
            String idCliente = request.getParameter("idCliente");
            String mes = request.getParameter("mesCartao");
            String numero = request.getParameter("numeroCartao");
            String ano = request.getParameter("anoCartao");
            String codigo = request.getParameter("codigoCartao");
            String bandeira = request.getParameter("bandeira");
            String nome = request.getParameter("nomeCartao");
            String status = request.getParameter("statusCartao");
            String preferencia = request.getParameter("preferencia");

            if (idCliente != null && !idCliente.trim().equals("")) {
                cartao.setCliente(Integer.parseInt(idCliente));
            }
            if (numero != null && !numero.trim().equals("")) {
                cartao.setNumero(numero);
            }

            if (mes != null && !mes.trim().equals("")) {
                cartao.setMes(mes);
            }

            if (ano != null && !ano.trim().equals("")) {
                cartao.setAno(ano);
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
            /*  if (status != null && status.trim().equals("")) {
                cartao.setBandeira(boolean.bandeira);
            }
            if (preferencia != null && preferencia.trim().equals("")) {
                cartao.setBandeira(bandeira);
            }*/

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
                ConsultarCommand consultar = new ConsultarCommand();
                cliente = new Cliente();
                cartao = new CartaoCredito();
                cartao = (CartaoCredito) resultado.getEntidades().get(0);
                cliente.setId(cartao.getCliente());
                System.out.println("cliente id" + cliente.getId());
                br.com.turismo.core.fachada.Resultado result = consultar.execute(cliente);
                request.getSession().setAttribute("resultado", result.getEntidades());

                rd = request.getRequestDispatcher("paginaCliente.jsp");
            }
        }

        rd.forward(request, response);
    }

}
