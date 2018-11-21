/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cliente.core.negocio;

import br.com.cliente.dominio.Cliente;
import br.com.cliente.dominio.EntidadeDominio;

/**
 *
 * @author hisak
 */
public class ValidarEmail implements IStrategy {

    @Override
    public String processar(EntidadeDominio entidade) {
        System.out.println("erro ndddda fachada ok?");
        Cliente cliente = (Cliente) entidade;
        String msg = null;
        boolean flag;

        if (!cliente.getEmail().trim().equals("") && cliente.getEmail() != null) {
            String email = "^([\\w\\-]+\\.)*[\\w\\- ]+@([\\w\\- ]+\\.)+([\\w\\-]{2,3})$";
            flag = cliente.getEmail().matches(email);

            if (flag == false) {
                msg = "E-mail inválido.";
            }
            System.out.println(msg + " cheguei no cliente dado email vv " + flag);
        }
        System.out.println(msg + " cheguei no cliente dado email  " );
        return msg;
    }
}
