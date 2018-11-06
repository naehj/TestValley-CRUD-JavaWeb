/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.turismo.web.command;

import br.com.turismo.core.fachada.Resultado;
import br.com.turismo.dominio.EntidadeDominio;
import java.util.List;

/**
 *
 * @author hisak
 */
public interface ICommand {
    
    public Resultado execute(EntidadeDominio entidade);
}
