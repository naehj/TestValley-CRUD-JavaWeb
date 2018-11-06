package br.com.turismo.dominio;

/**
 *
 * @author hisak
 */

public class Estado extends EntidadeDominio{
    
     
    private String estado;
    private String sigla;
    
 
    private Pais pais;
    
 

  

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

 
    
}
