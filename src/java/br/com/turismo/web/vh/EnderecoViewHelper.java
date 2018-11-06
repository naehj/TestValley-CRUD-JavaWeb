/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.turismo.web.vh;

import br.com.turismo.core.fachada.Resultado;
import br.com.turismo.dominio.Cidade;
import br.com.turismo.dominio.Cliente;
import br.com.turismo.dominio.Endereco;
import br.com.turismo.dominio.EntidadeDominio;
import br.com.turismo.dominio.Estado;
import br.com.turismo.dominio.Pais;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

    

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {

        //Recebe operação do formulário, na request.
        String operacao = request.getParameter("operacao");

        if (operacao.equals("SALVAR")) {
            endereco = new Endereco();
           

            String logradouro = request.getParameter("logradouro");
            String numero = request.getParameter("numeroRes");
            String bairro = request.getParameter("bairro");
            String complemento = request.getParameter("complemento");
            String idCidade = request.getParameter("idCidade");
            String idEstado = request.getParameter("idEstado");
            String idPais = request.getParameter("idPais");
            String cep = request.getParameter("cep");
            if (logradouro != null && !logradouro.trim().equals("")) {
                endereco.setLogradouro(logradouro);
            }

            if (numero != null && !numero.trim().equals("")) {
                endereco.setNumero(numero);
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

            if (idEstado != null && !idEstado.trim().equals("")) {
                endereco.getCidade().setEstado(new Estado());
                endereco.getCidade().getEstado().setId(Integer.parseInt(idEstado));
            }
            if (idPais != null && !idPais.trim().equals("")) {
                endereco.getCidade().getEstado().setPais(new Pais());
                endereco.getCidade().getEstado().getPais().setId(Integer.parseInt(idPais));
            }
            if (cep != null && cep.trim().equals("")) {
                endereco.getCep();
            }

            return endereco;
        }

      
        return endereco;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       
    }

}
