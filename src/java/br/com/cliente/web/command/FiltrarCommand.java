/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cliente.web.command;

import br.com.cliente.core.fachada.Resultado;
import br.com.cliente.dominio.EntidadeDominio;
import java.util.List;

/**
 *
 * @author hisak
 */
public class FiltrarCommand extends AbstractCommand{
        
    @Override
    	public Resultado execute(EntidadeDominio entidade) {
		
		return fachada.listarfiltro(entidade);
	}
    
}
