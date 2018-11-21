
package br.com.cliente.web.command;

import br.com.cliente.core.fachada.Resultado;
import br.com.cliente.dominio.EntidadeDominio;
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
