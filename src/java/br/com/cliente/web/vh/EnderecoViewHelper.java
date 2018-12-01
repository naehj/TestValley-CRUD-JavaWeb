/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cliente.web.vh;

import br.com.cliente.core.fachada.Resultado;
import br.com.cliente.dominio.Cliente;
import br.com.cliente.dominio.Endereco;
import br.com.cliente.dominio.EntidadeDominio;
import br.com.cliente.web.command.AtualizarCommand;
import br.com.cliente.web.command.ConsultarCommand;
import br.com.cliente.web.command.ExcluirCommand;
import br.com.cliente.web.command.SalvarCommand;
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
public class EnderecoViewHelper implements IViewHelper {

    //Objetos necessários para cadastrar um Cliente
    Endereco endereco;
    Cliente cliente;

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {

        //Recebe operação do formulário, na request.
        String operacao = request.getParameter("operacao");

        if (operacao.equals("SALVAR")) {
            cliente = new Cliente();
            cliente.setId(Integer.parseInt(request.getParameter("idCliente")));
            endereco = new Endereco();

            String logradouro = request.getParameter("logradouro");
            String numero = request.getParameter("numeroRes");
            String complemento = request.getParameter("complemento");
            String cidade = request.getParameter("cidade");
            String estado = request.getParameter("estado");
            String pais = request.getParameter("pais");
            String cep = request.getParameter("cep");
            String tipoLogradouro = request.getParameter("tipo_logradouro");
            String tipoResidencia = request.getParameter("tipo_logradouro");

            if (logradouro != null && !logradouro.trim().equals("")) {
                endereco.setLogradouro(logradouro);
            }

            if (numero != null && !numero.trim().equals("")) {
                endereco.setNumero(numero);
            }

            if (complemento != null && !complemento.trim().equals("")) {
                endereco.setComplemento(complemento);
            }

            if (cidade != null && !cidade.trim().equals("")) {
                endereco.setCidade(cidade);
            }

            if (estado != null && !estado.trim().equals("")) {
                endereco.setEstado(estado);
            }
            if (pais != null && !pais.trim().equals("")) {
                endereco.setPais(pais);
            }
            if (cep != null && !cep.trim().equals("")) {
                endereco.setCep(cep);
            }
            if (tipoLogradouro != null && !tipoLogradouro.trim().equals("")) {
                endereco.setTipoLogradouro(tipoLogradouro);
            }
            if (tipoResidencia != null && !tipoResidencia.trim().equals("")) {
                endereco.setTipoResidencia(tipoResidencia);
            }
            HashSet<Endereco> enderecos = new HashSet<>();
            enderecos.add(endereco);
            cliente.setEnd_De_Entrega(enderecos);

            return cliente;
        }

        if (operacao.equals("ATUALIZAR")) {
            endereco = new Endereco();

            String logradouro = request.getParameter("logradouro");
            String numero = request.getParameter("numeroRes");
            String complemento = request.getParameter("complemento");
            String cidade = request.getParameter("cidade");
            String estado = request.getParameter("estado");
            String pais = request.getParameter("pais");
            String cep = request.getParameter("cep");
            String tipoLogradouro = request.getParameter("tipo_logradouro");
            String tipoResidencia = request.getParameter("tipo_logradouro");

            endereco.setId(Integer.parseInt(request.getParameter("idEndereco")));

            if (logradouro != null && !logradouro.trim().equals("")) {
                endereco.setLogradouro(logradouro);
            }

            if (numero != null && !numero.trim().equals("")) {
                endereco.setNumero(numero);
            }

            if (complemento != null && !complemento.trim().equals("")) {
                endereco.setComplemento(complemento);
            }

            if (cidade != null && !cidade.trim().equals("")) {
                endereco.setCidade(cidade);
            }

            if (estado != null && !estado.trim().equals("")) {
                endereco.setEstado(estado);
            }
            if (pais != null && !pais.trim().equals("")) {
                endereco.setPais(pais);
            }
            if (cep != null && !cep.trim().equals("")) {
                endereco.setCep(cep);
            }
            if (tipoLogradouro != null && !tipoLogradouro.trim().equals("")) {
                endereco.setTipoLogradouro(tipoLogradouro);
            }
            if (tipoResidencia != null && !tipoResidencia.trim().equals("")) {
                endereco.setTipoResidencia(tipoResidencia);
            }
            return endereco;
        }

        if (operacao.equals("PREATUALIZAR")) {
            cliente = new Cliente();
            cliente.setId(Integer.parseInt(request.getParameter("idCliente")));
            if (request.getRequestURI().contains("Entrega")) {
                endereco = new Endereco();
                endereco.setId(Integer.parseInt(request.getParameter("idEndereco")));

                return endereco;
            }
            return cliente;
        }

        if (operacao.equals("EXCLUIR")) {
            endereco = new Endereco();
            endereco.setId(Integer.parseInt(request.getParameter("idEndereco")));

            return endereco;
        }

        return endereco;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = null;

        String operacao = request.getParameter("operacao");

        if (operacao.equals("SALVAR")) {
            if (resultado.getMsg() != null) {

                request.getSession().setAttribute("mensagem", resultado.getMsg());

                rd = request.getRequestDispatcher("cadastroEndereco.jsp");
            } else {
                ConsultarCommand consulta = new ConsultarCommand();
                cliente = new Cliente();
                cliente.setId(Integer.parseInt(request.getParameter("idCliente")));
                resultado = consulta.execute(cliente);
                request.getSession().setAttribute("resultado", resultado.getEntidades());
                request.getSession().setAttribute("mensagem", "Endereço cadastrado com sucesso!");
                request.getSession().setAttribute("status", "success");
                rd = request.getRequestDispatcher("listarEnderecos.jsp");
            }
        }

        if (operacao.equals("ATUALIZAR")) {
            if (resultado.getMsg() != null) {

                request.getSession().setAttribute("mensagem", resultado.getMsg());

                rd = request.getRequestDispatcher("atualizarCartao.jsp");
            } else {
                ConsultarCommand consulta = new ConsultarCommand();
                cliente = new Cliente();
                cliente.setId(Integer.parseInt(request.getParameter("idCliente")));
                resultado = consulta.execute(cliente);
                request.getSession().setAttribute("resultado", resultado.getEntidades());
                request.getSession().setAttribute("mensagem", "Endereço atualizado com sucesso!");
                request.getSession().setAttribute("status", "success");
                if (request.getRequestURI().contains("Cobranca")) {
                    rd = request.getRequestDispatcher("paginaCliente.jsp");
                } else if (request.getRequestURI().contains("Entrega")) {
                    rd = request.getRequestDispatcher("listarEnderecos.jsp");
                }
            }
        }

        if (operacao.equals("PREATUALIZAR")) {
            if (resultado.getMsg() != null) {

                request.getSession().setAttribute("mensagem", resultado.getMsg());

                rd = request.getRequestDispatcher("paginaInicial.jsp");
            } else {

                if (request.getRequestURI().contains("Cobranca")) {
                    request.getSession().setAttribute("resultado", resultado.getEntidades());
                    rd = request.getRequestDispatcher("atualizarCobranca.jsp");
                } else if (request.getRequestURI().contains("Entrega")) {
                    cliente = new Cliente();
                    cliente.setId(Integer.parseInt(request.getParameter("idCliente")));
                    List<EntidadeDominio> entidades = new ArrayList<>();
                    entidades.add(resultado.getEntidade());
                    entidades.add(cliente);
                    resultado.setEntidades(entidades);
                    request.getSession().setAttribute("resultado", resultado.getEntidades());
                    rd = request.getRequestDispatcher("atualizarEntrega.jsp");
                }

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
                request.getSession().setAttribute("mensagem", "Endereço excluído com sucesso!");
                request.getSession().setAttribute("status", "success");

                rd = request.getRequestDispatcher("listarEnderecos.jsp");
            }
        }

        rd.forward(request, response);
    }

}
