/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cliente.web.vh;

import br.com.cliente.core.fachada.Resultado;
import br.com.cliente.core.util.ConverteDate;
import br.com.cliente.dominio.CartaoCredito;
import br.com.cliente.dominio.Cliente;
import br.com.cliente.dominio.Endereco;
import br.com.cliente.dominio.EntidadeDominio;
import br.com.cliente.web.command.ConsultarCommand;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
public class ClienteViewHelper implements IViewHelper {

    //Objetos necessários para cadastrar um Cliente
    Cliente cliente;
    CartaoCredito cartao;
    Endereco endereco;

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {

        //Recebe operação do formulário, na request.
        String operacao = request.getParameter("operacao");

        if (operacao.equals("SALVAR")) {

            cliente = new Cliente();
            cartao = new CartaoCredito();
            endereco = new Endereco();

            //Dados referentes ao cliente
            String nome = request.getParameter("nome");
            String cpf = request.getParameter("cpf");
            String email = request.getParameter("email");
            String genero = request.getParameter("genero");
            String senha = request.getParameter("senha");
            String dtNascimento = request.getParameter("dtNasc");

            //Dados referentes ao cartão
            String numeroCartao = request.getParameter("numeroCartao");
            String codigo = request.getParameter("codigoCartao");
            String bandeira = request.getParameter("bandeira");
            String nomeCartao = request.getParameter("nomeCartao");

            //Dados referentes ao endereço de cobrança
            String logradouroC = request.getParameter("logradouroC");
            String numeroResC = request.getParameter("numeroResC");
            String complementoC = request.getParameter("complementoC");
            String cepC = request.getParameter("cepC");
            String cidadeC = request.getParameter("cidadeC");
            String estadoC = request.getParameter("estadoC");
            String paisC = request.getParameter("paisC");
            String tipo_LogradouroC = request.getParameter("tipo_logradouroC");
            String tipo_ResidenciaC = request.getParameter("tipo_residenciaC");

            //Dados referentes ao endereço de entrega
            String logradouroE = request.getParameter("logradouroE");
            String numeroResE = request.getParameter("numeroResE");
            String complementoE = request.getParameter("complementoE");
            String cepE = request.getParameter("cepE");
            String cidadeE = request.getParameter("cidadeE");
            String estadoE = request.getParameter("estadoE");
            String paisE = request.getParameter("paisE");
            String tipo_LogradouroE = request.getParameter("tipo_logradouroE");
            String tipo_ResidenciaE = request.getParameter("tipo_residenciaE");

            //Setando os valores do cliente
            cliente.setNome(nome);
            cliente.setCpf(cpf);
            cliente.setEmail(email);
            cliente.setGenero(genero);
            cliente.setSenha(senha);
            cliente.setDtNascimento(ConverteDate.converteStringDate(dtNascimento));

            //Setando os valores do primeiro cartão de crédito
            cartao.setNumero(numeroCartao);
            cartao.setCodigo(codigo);
            cartao.setBandeira(bandeira);
            cartao.setNome(nomeCartao);
            HashSet<CartaoCredito> cartoes = new HashSet<>();
            cartoes.add(cartao);

            cliente.setCartaoCredito(cartoes);

            //Setando os valores do endereço de cobrança
            endereco.setLogradouro(logradouroC);
            endereco.setNumero(numeroResC);
            endereco.setComplemento(complementoC);
            endereco.setCep(cepC);
            endereco.setCidade(cidadeC);
            endereco.setEstado(estadoC);
            endereco.setPais(paisC);
            endereco.setTipoLogradouro(tipo_LogradouroC);
            endereco.setTipoResidencia(tipo_ResidenciaC);

            cliente.setEnd_De_Cobranca(endereco);
            System.out.println(cliente.getEnd_De_Cobranca().getCidade());

            //Setando os valores do primeiro endereço de entrega
            endereco = new Endereco();
            endereco.setLogradouro(logradouroE);
            endereco.setNumero(numeroResE);
            endereco.setComplemento(complementoE);
            endereco.setCep(cepE);
            endereco.setCidade(cidadeE);
            endereco.setEstado(estadoE);
            endereco.setPais(paisE);
            endereco.setTipoLogradouro(tipo_LogradouroE);
            endereco.setTipoResidencia(tipo_ResidenciaE);

            HashSet<Endereco> enderecos = new HashSet<>();
            enderecos.add(endereco);

            cliente.setEnd_De_Entrega(enderecos);
            return cliente;

        }

        if (operacao.equals("ATUALIZAR")) {

            cliente = new Cliente();
            String nome = request.getParameter("nome");
            String cpf = request.getParameter("cpf");
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            String dtNascimento = request.getParameter("dtNasc");
            String idCliente = request.getParameter("idCliente");
            String genero = request.getParameter("genero");

            cliente.setId(Integer.parseInt(idCliente));

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

            if (genero != null && !genero.trim().equals("")) {
                cliente.setGenero(genero);
            }

            return cliente;

        }

        if (operacao.equals("CONSULTAR")) {

            String id = request.getParameter("idCliente");
            cliente = new Cliente();
            if (id != null && !id.equals("")) {

                cliente.setId(Integer.parseInt(id));

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
            cliente.setId(Integer.parseInt(request.getParameter("idCliente")));

            return cliente;

        }// fim excluir (ATIVAR/DESATIVAR)

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

        if (operacao.equals("NOVOEE")) {
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

            String id = request.getParameter("idCliente");

            if (id != null && !id.trim().equals("")) {

                cliente.setId(Integer.parseInt(id));

                return cliente;

            } else {

                return cliente;
            }
        } // PREATUALIZAR

        if (operacao.equals("LISTARCLIENTES")) {
            cliente = new Cliente();

            String nome = request.getParameter("nomeCliente");

            if (nome != null && !nome.trim().equals("")) {

                cliente.setNome(nome);

                return cliente;

            } else {

                return cliente;
            }
        }

        if (operacao.equals("LISTARCARTOES")) {
            cliente = new Cliente();

            String id = request.getParameter("idCliente");

            if (id != null && !id.trim().equals("")) {

                cliente.setId(Integer.parseInt(id));

                return cliente;

            } else {

                return cliente;
            }
        }

        if (operacao.equals("LISTARENDERECOS")) {
            cliente = new Cliente();

            String id = request.getParameter("idCliente");

            if (id != null && !id.trim().equals("")) {

                cliente.setId(Integer.parseInt(id));

                return cliente;

            } else {

                return cliente;
            }
        }

        if (operacao.equals("HOME")) {
            cliente = new Cliente();

            String id = request.getParameter("idCliente");

            if (id != null && !id.trim().equals("")) {

                cliente.setId(Integer.parseInt(id));

                return cliente;

            } else {

                return cliente;
            }
        }

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

            if (resultado.getMsg() != null && !resultado.getMsg().trim().equals("")) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                request.getSession().setAttribute("status", "danger");
                rd = request.getRequestDispatcher("cadastroCliente.jsp");

            } else {

                request.getSession().setAttribute("resultado", resultado.getEntidades());
                request.getSession().setAttribute("mensagem", "Cliente cadastrado com sucesso!");
                request.getSession().setAttribute("status", "success");
                //request.getSession().setAttribute("auditoria", resultado.getEntidade());
                rd = request.getRequestDispatcher("paginaCliente.jsp");
            }
        } else if (operacao.equals("ATUALIZAR")) {
            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                request.getSession().setAttribute("resultado", resultado.getEntidades());
                rd = request.getRequestDispatcher("atualizarCliente.jsp");

            } else {
                ConsultarCommand consulta = new ConsultarCommand();
                cliente = new Cliente();
                cliente.setId(Integer.parseInt(request.getParameter("idCliente")));
                resultado = consulta.execute(cliente);
                request.getSession().setAttribute("resultado", resultado.getEntidades());
                request.getSession().setAttribute("mensagem", "Cliente atualizado com sucesso!");
                request.getSession().setAttribute("status", "success");
                //request.getSession().setAttribute("auditoria", resultado.getEntidade());
                rd = request.getRequestDispatcher("paginaCliente.jsp");
            }
        } else if (operacao.equals("CONSULTAR")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                //request.getSession().setAttribute("auditoria", resultado.getEntidade());
                rd = request.getRequestDispatcher("paginaCliente.jsp");

            } else {
                request.getSession().setAttribute("resultado", resultado.getEntidades());
                //request.getSession().setAttribute("auditoria", resultado.getEntidade());
                rd = request.getRequestDispatcher("consultarCliente.jsp");
            }

        } //fim consultar
        else if (operacao.equals("NOVOCC")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());

                rd = request.getRequestDispatcher("paginaCliente.jsp");

            } else {
                request.getSession().setAttribute("resultado", resultado.getEntidades());
                request.getSession().setAttribute("mensagem", null);

                rd = request.getRequestDispatcher("cadastroCartao.jsp");
            }

        } else if (operacao.equals("NOVOEE")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());

                rd = request.getRequestDispatcher("paginaCliente.jsp");

            } else {
                request.getSession().setAttribute("resultado", resultado.getEntidades());
                request.getSession().setAttribute("mensagem", null);

                rd = request.getRequestDispatcher("cadastroEndereco.jsp");
            }

        } else if (operacao.equals("PREATUALIZAR")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());

                rd = request.getRequestDispatcher("paginaCliente.jsp");

            } else {
                request.getSession().setAttribute("resultado", resultado.getEntidades());

                rd = request.getRequestDispatcher("atualizarCliente.jsp");
                request.getSession().setAttribute("resultado", resultado.getEntidades());
                request.getSession().setAttribute("mensagem", null);
            }

        } //fim consultar
        else if (operacao.equals("LISTARCLIENTES")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());

                rd = request.getRequestDispatcher("paginaCliente.jsp");

            } else {
                if (resultado.getEntidades().isEmpty()) {
                    request.getSession().setAttribute("mensagem", "Não há nenhum cliente cadastrado no sistema com este nome!");
                    request.getSession().setAttribute("resultado", null);
                    request.getSession().setAttribute("status", "danger");
                } else {
                    request.getSession().setAttribute("resultado", resultado.getEntidades());
                    request.getSession().setAttribute("mensagem", null);
                }

                rd = request.getRequestDispatcher("listarClientes.jsp");
            }

        } else if (operacao.equals("LISTARCARTOES")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());

                rd = request.getRequestDispatcher("paginaCliente.jsp");

            } else {
                request.getSession().setAttribute("resultado", resultado.getEntidades());
                request.getSession().setAttribute("mensagem", null);

                rd = request.getRequestDispatcher("listarCartoes.jsp");
            }

        } else if (operacao.equals("LISTARENDERECOS")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());

                rd = request.getRequestDispatcher("paginaCliente.jsp");

            } else {
                request.getSession().setAttribute("resultado", resultado.getEntidades());
                request.getSession().setAttribute("mensagem", null);

                rd = request.getRequestDispatcher("listarEnderecos.jsp");
            }

        } else if (operacao.equals("HOME")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());

                rd = request.getRequestDispatcher("paginaCliente.jsp");

            } else {
                request.getSession().setAttribute("resultado", resultado.getEntidades());
                request.getSession().setAttribute("mensagem", null);

                rd = request.getRequestDispatcher("paginaCliente.jsp");
            }

        } else if (operacao.equals("EXCLUIR")) {
            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());

                rd = request.getRequestDispatcher("../login.jsp");

            } else {
                request.getSession().setAttribute("resultado", resultado.getEntidade());

                rd = request.getRequestDispatcher("../login.jsp");
            }
        } else if (operacao.equals("AUTENTICAR")) {
            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());

                rd = request.getRequestDispatcher("paginaCliente.jsp");

            } else {
                request.getSession().setAttribute("resultado", resultado.getEntidades());

                rd = request.getRequestDispatcher("paginaCliente.jsp");
            }
        }

        rd.forward(request, response);
    }

}
