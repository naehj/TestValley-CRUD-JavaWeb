
package br.com.turismo.dominio;

/**
 *
 * @author hisak
 */

public class Local extends EntidadeDominio{
    
    
    private String local;
    

    private Cidade cidade;
  
    
    public Local() {
    }

    public Local(String local, Cidade cidade) {
        this.local = local;
        this.cidade = cidade;
    }



    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    
    
}
