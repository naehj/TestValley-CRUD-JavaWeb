/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.turismo.web.command;

import br.com.turismo.core.fachada.IFachada;
import br.com.turismo.core.fachada.Fachada;

/**
 *
 * @author hisak
 */
public abstract class AbstractCommand implements ICommand{
    
    protected IFachada fachada = new Fachada();
}
