package br.com.cliente.web.command;

import br.com.cliente.core.fachada.Resultado;
import br.com.cliente.dominio.EntidadeDominio;
import java.util.List;

/**
 *
 * @author hisak
 */
public class AtualizarCommand extends AbstractCommand{
        
    @Override
    	public Resultado execute(EntidadeDominio entidade) {
		
		return fachada.atualizar(entidade);
	}
}
