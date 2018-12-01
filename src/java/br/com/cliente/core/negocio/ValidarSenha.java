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
public class ValidarSenha implements IStrategy {

    @Override
    public String processar(EntidadeDominio entidade) {

        Cliente cliente = (Cliente) entidade;
        String msg = "";
        String senhaforte = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        boolean flag = false;
        if (cliente.getSenha() != null || !cliente.getSenha().trim().equals("")) {
            flag = cliente.getSenha().matches(senhaforte);
        }

        if (flag == false) {
            msg = "Senha inválida.\nSenha deve ter 8 caracteres no mínimo, uma letra maiúscula e uma minúscula e um caracter especial(@#$%^&+=)";
        }
        System.out.println(" cheguei no cliente dados senha  " + flag);
        if (msg.equals("")) {
            return null;
        }
        return msg;
    }
}
