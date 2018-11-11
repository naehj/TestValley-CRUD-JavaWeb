
package br.com.turismo.web.command;

import br.com.turismo.core.fachada.Resultado;
import br.com.turismo.dominio.EntidadeDominio;
import java.util.List;

/**
 *
 * @author hisak
 */
public class SalvarCommand extends AbstractCommand{
        
    @Override
    	public Resultado execute(EntidadeDominio entidade) {
		
		return fachada.salvar(entidade);
	}
        public Resultado execute(EntidadeDominio entidadeCli, EntidadeDominio entidadeAlt){
            return fachada.salvar(entidadeCli, entidadeAlt);
        }

}
