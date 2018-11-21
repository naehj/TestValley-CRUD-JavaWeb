/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cliente.core.fachada;

import br.com.cliente.dominio.EntidadeDominio;
import java.util.List;

/**
 *
 * @author hisak
 */
public interface IFachada {
    
    public Resultado salvar(EntidadeDominio entidade);
    
    public Resultado salvar(EntidadeDominio entidadeCli, EntidadeDominio entidadeAlt);

    public Resultado atualizar(EntidadeDominio entidade);

    public Resultado excluir(EntidadeDominio entidade);

    public Resultado consultar(EntidadeDominio entidade);

    public Resultado visualizar(EntidadeDominio entidade);
    
    public Resultado listarfiltro(EntidadeDominio entidade);
}
