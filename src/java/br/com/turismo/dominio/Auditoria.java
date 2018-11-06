/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.turismo.dominio;

import java.util.Date;

/**
 *
 * @author hisak
 */

public class Auditoria extends EntidadeDominio {

    private String usuario;
    private String operacao;
    private Date dtModificacao ;
   private Cliente cliente;
  

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public Date getDtModificacao() {
        return dtModificacao;
    }

    public void setDtModificacao(Date dtModificacao) {
        this.dtModificacao = dtModificacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

   
}
