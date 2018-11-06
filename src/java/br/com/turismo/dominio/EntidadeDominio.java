/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.turismo.dominio;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author hisak
 */

public abstract class EntidadeDominio implements Serializable{

    private Integer id;
   
    private Date dtCadastro;

    public Integer getId() {
            return id;
    }
    public void setId(Integer id) {
            this.id = id;
    }
    public Date getDtCadastro() {
            return dtCadastro;
    }
    public void setDtCadastro(Date dtCadastro) {
            this.dtCadastro = dtCadastro;
    }


	

}