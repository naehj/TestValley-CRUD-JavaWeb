/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.turismo.core.negocio;

import br.com.turismo.core.util.ConverteDate;
import br.com.turismo.dominio.Cliente;
import br.com.turismo.dominio.Endereco;
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
        if (cliente.getEnd_De_Cobranca() == null) {
            msg = msg + "É necessário pelo menos um endereço de cobrança.\n";
        } else {
            if (cliente.getEnd_De_Cobranca().getCep() == null || cliente.getEnd_De_Cobranca().getCep().trim().equals("")) {
                msg = msg + "CEP não informado.\n";
            }

            if (cliente.getEnd_De_Cobranca().getLogradouro() == null || cliente.getEnd_De_Cobranca().getLogradouro().trim().equals("")) {
                msg = msg + "Logradouro não informado.\n";
            }

            if (cliente.getEnd_De_Cobranca().getCidade() == null || cliente.getEnd_De_Cobranca().getCidade().trim().equals("")) {
                msg = msg + "Cidade não informada.\n";
            }

            if (cliente.getEnd_De_Cobranca().getEstado() == null || cliente.getEnd_De_Cobranca().getEstado().trim().equals("")) {
                msg = msg + "Estado não informado.\n";
            }

            if (cliente.getEnd_De_Cobranca().getPais() == null || cliente.getEnd_De_Cobranca().getPais().trim().equals("")) {
                msg = msg + "País não informado.\n";
            }
            
            if (cliente.getEnd_De_Cobranca().getNumero()== null || cliente.getEnd_De_Cobranca().getNumero().trim().equals("")) {
                msg = msg + "Número não informado.\n";
            }

            if (cliente.getEnd_De_Cobranca().getTipoLogradouro() == null || cliente.getEnd_De_Cobranca().getTipoLogradouro().trim().equals("")) {
                msg = msg + "Tipo de logradouro não informado.\n";
            }

            if (cliente.getEnd_De_Cobranca().getTipoResidencia() == null || cliente.getEnd_De_Cobranca().getTipoResidencia().trim().equals("")) {
                msg = msg + "Tipo de residência não informada.\n";
            }
        }
        if (cliente.getEnd_De_Entrega() == null) {
            msg = msg + "É necessário pelo menos um endereço de entrega.\n";
        } else {
            for (Endereco endereco : cliente.getEnd_De_Entrega()) {
                if (endereco.getCep() == null || endereco.getCep().trim().equals("")) {
                    msg = msg + "CEP não informado.\n";
                }

                if (endereco.getLogradouro() == null || endereco.getLogradouro().trim().equals("")) {
                    msg = msg + "Logradouro não informado.\n";
                }

                if (endereco.getCidade() == null || endereco.getCidade().trim().equals("")) {
                    msg = msg + "Cidade não informada.\n";
                }

                if (endereco.getEstado() == null || endereco.getEstado().trim().equals("")) {
                    msg = msg + "Estado não informado.\n";
                }

                if (endereco.getPais() == null || endereco.getPais().trim().equals("")) {
                    msg = msg + "País não informado.\n";
                }
                if (endereco.getNumero()== null || endereco.getNumero().trim().equals("")) {
                    msg = msg + "Número não informado.\n";
                }

                if (endereco.getTipoLogradouro()== null || endereco.getTipoLogradouro().trim().equals("")) {
                    msg = msg + "Tipo de logradouro não informado.\n";
                }

                if (endereco.getTipoResidencia() == null || endereco.getTipoResidencia().trim().equals("")) {
                    msg = msg + "Tipo de residência não informada.\n";
                }
            }
        }
        System.out.println(" cheguei no cliente dados eee3");
        return msg;
    }
}
