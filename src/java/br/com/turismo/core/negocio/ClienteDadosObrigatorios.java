/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.turismo.core.negocio;

import br.com.turismo.core.util.ConverteDate;
import br.com.turismo.dominio.Cidade;
import br.com.turismo.dominio.Cliente;
import br.com.turismo.dominio.EntidadeDominio;

/**
 *
 * @author hisak
 */
public class ClienteDadosObrigatorios implements IStrategy {

    @Override
    public String processar(EntidadeDominio entidade) {
    
        Cliente cliente = (Cliente) entidade;
        String msg = null;
         if (cliente.getNome() == null || cliente.getNome().trim().equals("")) {
                msg = msg + "Nome não informado.\n";
            }

            if (cliente.getCpf() == null && cliente.getCpf().trim().equals("")) {
                 msg = msg + "CPF não informado.\n";
            }

            if (cliente.getEmail() == null || cliente.getEmail().trim().equals("")) {
                msg = msg + "Email não informado.\n";
            }

         

            if (cliente.getDtNascimento() == null) {
               msg = msg + "Data de nascimento não informado.\n";
            }
          /*  if (numeroCartao = null && numeroCartao.trim().equals("")) {
                cartao.setNumero(numeroCartao);
            }

            if (mes == null && mes.trim().equals("")) {
                cartao.setMes(mes);
            }

            if (ano == null && ano.trim().equals("")) {
                cartao.setAno(ano);
            }

            if (codigo == null && codigo.trim().equals("")) {
                cartao.setCodigo(codigo);
            }

            if (bandeira == null && bandeira.trim().equals("")) {
                cartao.setBandeira(bandeira);
            }
            if (nomeCartao == null && nomeCartao.trim().equals("")) {
                cartao.setNome(nomeCartao);
            }
*/
   if (cliente.getEndereco().getCep()== null || cliente.getEndereco().getCep().trim().equals("")) {
                msg = msg + "Logradouro não informado.\n";
            }

       
            if (cliente.getEndereco().getLogradouro() == null || cliente.getEndereco().getLogradouro().trim().equals("")) {
                msg = msg + "Logradouro não informado.\n";
            }

            if (cliente.getEndereco().getBairro() == null || cliente.getEndereco().getBairro().trim().equals("")) {
                msg = msg + "Bairro não informado.\n";
            }

        
            if (cliente.getEndereco().getCidade().getId() == null ) {
                msg = msg + "Cidade não informado.\n";
            }

          
             System.out.println(" cheguei no cliente dados eee3");
            return msg;
    }
    
}
