/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.turismo.dominio;

/**
 *
 * @author hisak
 */

public class CompanhiaAerea  extends EntidadeDominio{
    
 
    private String nome;
    private String aviao;
    private int assentos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAviao() {
        return aviao;
    }

    public void setAviao(String aviao) {
        this.aviao = aviao;
    }

    public int getAssentos() {
        return assentos;
    }

    public void setAssentos(int assentos) {
        this.assentos = assentos;
    }

  
   
   
    
    
}
