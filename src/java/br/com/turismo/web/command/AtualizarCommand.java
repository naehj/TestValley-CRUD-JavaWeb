package br.com.turismo.web.command;

import br.com.turismo.core.fachada.Resultado;
import br.com.turismo.dominio.EntidadeDominio;
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
