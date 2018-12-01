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
        String msg = "";
        boolean flag;

        if (cliente.getEmail() != null || !cliente.getEmail().trim().equals("")) {
            String email = "(?=.*[a-z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
            flag = cliente.getEmail().matches(email);

            if (flag == false) {
                msg = "E-mail inválido.";
            }
            System.out.println(msg + " cheguei no cliente dado email vv " + flag);
        }
        System.out.println(msg + " cheguei no cliente dado email  ");
        if (msg.equals("")) {
            return null;
        }
        return msg;
    }
}
