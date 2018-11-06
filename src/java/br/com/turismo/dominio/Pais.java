package br.com.turismo.dominio;

/**
 *
 * @author hisak
 */


public class Pais extends EntidadeDominio{
    
  
    private String pais;
    private String sigla;
   
    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

}
