package br.com.turismo.dominio;

/**
 *
 * @author hisak
 */

public class Cidade extends EntidadeDominio{
    
  
    private String cidade;
    
 
    private Estado estado;
    
 

   

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

  
    
}
