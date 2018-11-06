package br.com.turismo.core.negocio;

import br.com.turismo.dominio.EntidadeDominio;

/**
 *
 * @author hisak
 */
public interface IStrategy {
    
    public String processar(EntidadeDominio entidade);
}
