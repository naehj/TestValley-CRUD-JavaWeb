package br.com.cliente.core.negocio;

import br.com.cliente.dominio.EntidadeDominio;

/**
 *
 * @author hisak
 */
public interface IStrategy {
    
    public String processar(EntidadeDominio entidade);
}
