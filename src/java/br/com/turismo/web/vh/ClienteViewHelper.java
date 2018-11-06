/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.turismo.web.vh;

import br.com.turismo.core.fachada.Resultado;
import br.com.turismo.core.util.ConverteDate;
import br.com.turismo.dominio.CartaoCredito;
import br.com.turismo.dominio.Cidade;
import br.com.turismo.dominio.Cliente;
import br.com.turismo.dominio.Endereco;
import br.com.turismo.dominio.EntidadeDominio;
import br.com.turismo.dominio.Estado;
import br.com.turismo.dominio.Pais;
import java.io.IOException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hisak
 */
public class ClienteViewHelper implements IViewHelper {

    //Objetos necessários para cadastrar um Cliente
    Cliente cliente;
    CartaoCredito cartao;
    Endereco endereco;
    Cidade cidade;
    Estado estado;
    Pais pais;

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {

        //Recebe operação do formulário, na request.
        String operacao = request.getParameter("operacao");

        if (operacao.equals("SALVAR")) {

            cliente = new Cliente();
            cartao = new CartaoCredito();
            endereco = new Endereco();
            cidade = new Cidade();
            estado = new Estado();
            pais = new Pais();
            String nome = request.getParameter("nome");
            String cpf = request.getParameter("cpf");
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            String dtNascimento = request.getParameter("dtNasc");
            String mes = request.getParameter("mesCartao");
            String numeroCartao = request.getParameter("numeroCartao");
            String ano = request.getParameter("anoCartao");
            String codigo = request.getParameter("codigoCartao");
            String bandeira = request.getParameter("bandeira");
            String nomeCartao = request.getParameter("nomeCartao");
            //String status = request.getParameter("statusCartao");
            // String preferencia = request.getParameter("preferencia");

            String logradouro = request.getParameter("logradouro");
            String numeroRes = request.getParameter("numeroRes");
            String bairro = request.getParameter("bairro");
            String complemento = request.getParameter("complemento");
            String idCidade = request.getParameter("idCidade");
            String idEstado = request.getParameter("idEstado");
            String idPais = request.getParameter("idPais");
            String cep = request.getParameter("cep");

            if (nome != null && !nome.trim().equals("")) {
                cliente.setNome(nome);
            }

            if (cpf != null && !cpf.trim().equals("")) {
                cliente.setCpf(cpf);
            }

            if (email != null && !email.trim().equals("")) {
                cliente.setEmail(email);
            }

            if (senha != null && !senha.trim().equals("")) {
                cliente.setSenha(senha);
            }

            if (dtNascimento != null && !dtNascimento.trim().equals("")) {
                cliente.setDtNascimento(ConverteDate.converteStringDate(dtNascimento));
            }
            if (numeroCartao != null && !numeroCartao.trim().equals("")) {
                cartao.setNumero(numeroCartao);
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
            if (nomeCartao != null && !nomeCartao.trim().equals("")) {
                cartao.setNome(nomeCartao);
            }

            cliente.getCartaoCredito().add(cartao);

            if (logradouro != null && !logradouro.trim().equals("")) {
                endereco.setLogradouro(logradouro);
            }

            if (numeroRes != null && !numeroRes.trim().equals("")) {
                endereco.setNumero(numeroRes);
            }

            if (bairro != null && !bairro.trim().equals("")) {
                endereco.setBairro(bairro);
            }

            if (complemento != null && !complemento.trim().equals("")) {
                endereco.setComplemento(complemento);
            }

            if (idCidade != null && !idCidade.trim().equals("")) {
                endereco.setCidade(new Cidade());
                
                endereco.getCidade().setId(Integer.parseInt(idCidade));
            }

            if (cep != null && cep.trim().equals("")) {
                endereco.setCep(cep);
            }

            cliente.setEndereco(endereco);
            return cliente;

        }

        if (operacao.equals("ATUALIZAR")) {

            cliente = new Cliente();

            cartao = new CartaoCredito();
            endereco = new Endereco();
            cidade = new Cidade();
            estado = new Estado();
            pais = new Pais();
            String nome = request.getParameter("nome");
            String cpf = request.getParameter("cpf");
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            String dtNascimento = request.getParameter("dtNasc");
            String idEndereco = request.getParameter("idEndereco");
            String logradouro = request.getParameter("logradouro");
            String numeroRes = request.getParameter("numeroRes");
            String bairro = request.getParameter("bairro");
            String complemento = request.getParameter("complemento");
            String idCidade = request.getParameter("idCidade");
            String idEstado = request.getParameter("idEstado");
            String idPais = request.getParameter("idPais");
            String cep = request.getParameter("cep");
            String idCliente = request.getParameter("idCliente");

            cliente.setId(Integer.parseInt(idCliente));
           
            endereco.setId(Integer.parseInt(idEndereco));
          
            
            if (nome != null && !nome.trim().equals("")) {
                cliente.setNome(nome);
            }

            if (cpf != null && !cpf.trim().equals("")) {
                cliente.setCpf(cpf);
            }

            if (email != null && !email.trim().equals("")) {
                cliente.setEmail(email);
            }

            if (senha != null && !senha.trim().equals("")) {
                cliente.setSenha(senha);
            }

            if (dtNascimento != null && !dtNascimento.trim().equals("")) {
                cliente.setDtNascimento(ConverteDate.converteStringDate(dtNascimento));
            }

            if (logradouro != null && !logradouro.trim().equals("")) {
                endereco.setLogradouro(logradouro);
            }

            if (numeroRes != null && !numeroRes.trim().equals("")) {
                endereco.setNumero(numeroRes);
            }

            if (bairro != null && !bairro.trim().equals("")) {
                endereco.setBairro(bairro);
            }

            if (complemento != null && !complemento.trim().equals("")) {
                endereco.setComplemento(complemento);
            }

            if (idCidade != null && !idCidade.trim().equals("")) {
                endereco.setCidade(new Cidade());
                endereco.getCidade().setId(Integer.parseInt(idCidade));
            }

            if (cep != null && cep.trim().equals("")) {
                endereco.setCep(cep);
            }

            cliente.setEndereco(endereco);

            return cliente;

        }

        if (operacao.equals("CONSULTAR")) {

            String op = request.getParameter("op");
            cliente = new Cliente();
            if (op != null && op != "") {

                cliente.setId(Integer.parseInt(request.getParameter("idCliente")));

                return cliente;

            } else {
                cliente = new Cliente();

                return cliente;
            }
        } // fim consultar

        String uri = request.getRequestURI();
        if (uri.equals("/Turismo/clientes/preAtualizar")) {
            operacao = "PREATUALIZAR";
        }
        if (operacao.equals("EXCLUIR")) {

            cliente = new Cliente();
            System.out.println(request.getParameter("id"));
            cliente.setId(Integer.parseInt(request.getParameter("id")));
            String status = request.getParameter("opStatus");
            if (status != null && status.trim().equals("")) {
                if (status == "1") {
                    cliente.setStatus(false);
                }
            }

            return cliente;

        }// fim excluir (ATIVAR/DESATIVAR)

        if (operacao.equals("LISTARFILTRO")) {
            System.out.println("operacao" + operacao);

            cliente = new Cliente();
            endereco = new Endereco();
            cartao = new CartaoCredito();

            String status = request.getParameter("opStatus");
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");

            String logradouro = request.getParameter("logradouro");
            String idCidade = request.getParameter("idCidade");

            String nomeCartao = request.getParameter("nomeCartao");

            if (status.equals("0")) {
                cliente.setStatus(false);
                
            } else {
                cliente.setStatus(true);
            }

            if (nome != null && !nome.trim().equals("")) {
                cliente.setNome(nome);
            }

            if (email != null && !email.trim().equals("")) {
                cliente.setEmail(email);
            }

            if (logradouro != null && !logradouro.trim().equals("")) {
                endereco.setLogradouro(logradouro);
            }

            if (idCidade != null && !idCidade.trim().equals("")) {
                cidade = new Cidade();
                cidade.setId(Integer.parseInt(idCidade));

                endereco.setCidade(cidade);
             

            } else {
                cidade = new Cidade();
                cidade.setId(null);

                endereco.setCidade(cidade);

            }

            if (nomeCartao != null && !nomeCartao.trim().equals("")) {
                cartao.setNome(nomeCartao);
            }
            cliente.setEndereco(endereco);
            cliente.getCartaoCredito().add(cartao);
            return cliente;

        } // fim listar filtro

        if (operacao.equals("NOVOCC")) {
            cliente = new Cliente();

            String id = request.getParameter("idCliente");

            if (id != null && !id.trim().equals("")) {

                cliente.setId(Integer.parseInt(id));

                return cliente;

            } else {

                return cliente;
            }
        }

        if (operacao.equals("PREATUALIZAR")) {
            cliente = new Cliente();

            String id = request.getParameter("id");

            if (id != null && !id.trim().equals("")) {

                cliente.setId(Integer.parseInt(id));

                return cliente;

            } else {

                return cliente;
            }
        } // PREATUALIZAR

        if (operacao.equals("AUTENTICAR")) {
            cliente = new Cliente();

            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            if (email != null && !email.trim().equals("")) {

                cliente.setEmail(email);
            }
            if (senha != null && !senha.trim().equals("")) {

                cliente.setSenha(senha);
            }
        } // AUTENTICAR

        return cliente;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd = null;

        //Recebe operação do formulário, na request.
        String operacao = request.getParameter("operacao");

        if (operacao.equals("SALVAR")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                rd = request.getRequestDispatcher("cadastroCliente.jsp");

            } else {

                request.getSession().setAttribute("resultado", resultado.getEntidades());
                //request.getSession().setAttribute("auditoria", resultado.getEntidade());
                rd = request.getRequestDispatcher("paginaCliente.jsp");
            }
        }

        if (operacao.equals("ATUALIZAR")) {
            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                request.getSession().setAttribute("resultado", resultado.getEntidades());
                rd = request.getRequestDispatcher("atualizarCliente.jsp");

            } else {

                request.getSession().setAttribute("resultado", resultado.getEntidades());
                //request.getSession().setAttribute("auditoria", resultado.getEntidade());
                rd = request.getRequestDispatcher("paginaCliente.jsp");
            }
        }

        if (operacao.equals("CONSULTAR")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                //request.getSession().setAttribute("auditoria", resultado.getEntidade());
                rd = request.getRequestDispatcher("consultarCliente.jsp");

            } else {
                request.getSession().setAttribute("resultado", resultado.getEntidades());
                //request.getSession().setAttribute("auditoria", resultado.getEntidade());
                rd = request.getRequestDispatcher("consultarCliente.jsp");
            }

        } //fim consultar

        if (operacao.equals("LISTARFILTRO")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                //request.getSession().setAttribute("auditoria", resultado.getEntidade());
                rd = request.getRequestDispatcher("consultarCliente.jsp");

            } else {

                request.getSession().setAttribute("resultado", resultado.getEntidades());

                rd = request.getRequestDispatcher("consultarCliente.jsp");
            }

        } //fim consultar

        if (operacao.equals("NOVOCC")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());

                rd = request.getRequestDispatcher("consultarCliente.jsp");

            } else {
                request.getSession().setAttribute("resultado", resultado.getEntidades());

                rd = request.getRequestDispatcher("cadaastroCartao.jsp");
            }

        } //fim consultar

        if (operacao.equals("PREATUALIZAR")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());

                rd = request.getRequestDispatcher("consultarCliente.jsp");

            } else {
                request.getSession().setAttribute("resultado", resultado.getEntidades());

                rd = request.getRequestDispatcher("atualizarCliente.jsp");
            }

        } //fim consultar

        if (operacao.equals("EXCLUIR")) {
            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());

                rd = request.getRequestDispatcher("consultarCliente.jsp");

            } else {
                request.getSession().setAttribute("resultado", resultado.getEntidade());

                rd = request.getRequestDispatcher("consultarCliente.jsp");
            }
        }

        rd.forward(request, response);
    }

}
