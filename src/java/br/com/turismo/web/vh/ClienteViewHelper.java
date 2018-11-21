/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.turismo.web.vh;

import br.com.turismo.core.fachada.Resultado;
import br.com.turismo.core.util.ConverteDate;
import br.com.turismo.dominio.CartaoCredito;
import br.com.turismo.dominio.Cliente;
import br.com.turismo.dominio.Endereco;
import br.com.turismo.dominio.EntidadeDominio;
import br.com.turismo.web.command.ConsultarCommand;
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
            if (nome != null && !nome.trim().equals("")) {
                cliente.setNome(nome);
            }

            if (cpf != null && !cpf.trim().equals("")) {
                cliente.setCpf(cpf);
            }

            if (email != null && !email.trim().equals("")) {
                cliente.setEmail(email);
            }

            if (genero != null && !genero.trim().equals("")) {
                cliente.setGenero(genero);
            }

            if (senha != null && !senha.trim().equals("")) {
                cliente.setSenha(senha);
            }

            if (dtNascimento != null && !dtNascimento.trim().equals("")) {
                cliente.setDtNascimento(ConverteDate.converteStringDate(dtNascimento));
            }

            //Setando os valores do primeiro cartão de crédito
            if (numeroCartao != null && !numeroCartao.trim().equals("")) {
                cartao.setNumero(numeroCartao);
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
            HashSet<CartaoCredito> cartoes = new HashSet<>();
            cartoes.add(cartao);

            cliente.setCartaoCredito(cartoes);

            //Setando os valores do endereço de cobrança
            if (logradouroC != null && !logradouroC.trim().equals("")) {
                endereco.setLogradouro(logradouroC);
            }

            if (numeroResC != null && !numeroResC.trim().equals("")) {
                endereco.setNumero(numeroResC);
            }

            if (complementoC != null && !complementoC.trim().equals("")) {
                endereco.setComplemento(complementoC);
            }

            if (cepC != null && !cepC.trim().equals("")) {
                endereco.setCep(cepC);
            }
            if (cidadeC != null && !cidadeC.trim().equals("")) {
                endereco.setCidade(cidadeC);
            }

            if (estadoC != null && !estadoC.trim().equals("")) {
                endereco.setEstado(estadoC);
            }

            if (paisC != null && !paisC.trim().equals("")) {
                endereco.setPais(paisC);
            }

            if (tipo_LogradouroC != null && !tipo_LogradouroC.trim().equals("")) {
                endereco.setTipoLogradouro(tipo_LogradouroC);
            }

            if (tipo_ResidenciaC != null && !tipo_ResidenciaC.trim().equals("")) {
                endereco.setTipoResidencia(tipo_ResidenciaC);
            }

            cliente.setEnd_De_Cobranca(endereco);
            System.out.println(cliente.getEnd_De_Cobranca().getCidade());

            //Setando os valores do primeiro endereço de entrega
            endereco = new Endereco();

            if (logradouroE != null && !logradouroE.trim().equals("")) {
                endereco.setLogradouro(logradouroE);
            }

            if (numeroResE != null && !numeroResE.trim().equals("")) {
                endereco.setNumero(numeroResE);
            }

            if (complementoE != null && !complementoE.trim().equals("")) {
                endereco.setComplemento(complementoE);
            }

            if (cepE != null && !cepE.trim().equals("")) {
                endereco.setCep(cepE);
            }
            if (cidadeE != null && !cidadeE.trim().equals("")) {
                endereco.setCidade(cidadeE);
            }

            if (estadoE != null && !estadoE.trim().equals("")) {
                endereco.setEstado(estadoE);
            }

            if (paisE != null && !paisE.trim().equals("")) {
                endereco.setPais(paisE);
            }

            if (tipo_LogradouroE != null && !tipo_LogradouroE.trim().equals("")) {
                endereco.setTipoLogradouro(tipo_LogradouroE);
            }

            if (tipo_ResidenciaE != null && !tipo_ResidenciaE.trim().equals("")) {
                endereco.setTipoResidencia(tipo_ResidenciaE);
            }

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

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                rd = request.getRequestDispatcher("cadastroCliente.jsp");

            } else {

                request.getSession().setAttribute("resultado", resultado.getEntidades());
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

                rd = request.getRequestDispatcher("cadastroCartao.jsp");
            }

        } else if (operacao.equals("NOVOEE")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());

                rd = request.getRequestDispatcher("paginaCliente.jsp");

            } else {
                request.getSession().setAttribute("resultado", resultado.getEntidades());

                rd = request.getRequestDispatcher("cadastroEndereco.jsp");
            }

        } else if (operacao.equals("PREATUALIZAR")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());

                rd = request.getRequestDispatcher("paginaCliente.jsp");

            } else {
                request.getSession().setAttribute("resultado", resultado.getEntidades());

                rd = request.getRequestDispatcher("atualizarCliente.jsp");
            }

        } //fim consultar
        else if (operacao.equals("LISTARCARTOES")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());

                rd = request.getRequestDispatcher("paginaCliente.jsp");

            } else {
                request.getSession().setAttribute("resultado", resultado.getEntidades());

                rd = request.getRequestDispatcher("listarCartoes.jsp");
            }

        } else if (operacao.equals("LISTARENDERECOS")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());

                rd = request.getRequestDispatcher("paginaCliente.jsp");

            } else {
                request.getSession().setAttribute("resultado", resultado.getEntidades());

                rd = request.getRequestDispatcher("listarEnderecos.jsp");
            }

        } else if (operacao.equals("HOME")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());

                rd = request.getRequestDispatcher("paginaCliente.jsp");

            } else {
                request.getSession().setAttribute("resultado", resultado.getEntidades());

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
