
package br.com.turismo.dominio;

import java.util.Date;

/**
 *
 * @author hisak
 */


public class Voo extends EntidadeDominio{
    
  
    private Date partida;
    
    private Date chegada;
     private boolean ativo;
    
  
    private Local origem;
    
 
    private Local destino;
    

    private CompanhiaAerea companhia;

    public Date getPartida() {
        return partida;
    }

    public void setPartida(Date partida) {
        this.partida = partida;
    }

    public Date getChegada() {
        return chegada;
    }

    public void setChegada(Date chegada) {
        this.chegada = chegada;
    }

    public Local getOrigem() {
        return origem;
    }

    public void setOrigem(Local origem) {
        this.origem = origem;
    }

    public Local getDestino() {
        return destino;
    }

    public void setDestino(Local destino) {
        this.destino = destino;
    }

    public CompanhiaAerea getCompanhia() {
        return companhia;
    }

    public void setCompanhia(CompanhiaAerea companhia) {
        this.companhia = companhia;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    
    
    
}
