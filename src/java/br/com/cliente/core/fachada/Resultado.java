/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cliente.core.fachada;

import br.com.cliente.dominio.EntidadeDominio;
import java.util.List;

/**
 *
 * @author hisak
 */
public class Resultado {

    private String msg;
    private EntidadeDominio entidade;
    private List<EntidadeDominio> entidades;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public EntidadeDominio getEntidade() {
        return entidade;
    }

    public void setEntidade(EntidadeDominio entidade) {
        this.entidade = entidade;
    }

    public List<EntidadeDominio> getEntidades() {
        return entidades;
    }

    public void setEntidades(List<EntidadeDominio> entidades) {
        this.entidades = entidades;
    }

}
