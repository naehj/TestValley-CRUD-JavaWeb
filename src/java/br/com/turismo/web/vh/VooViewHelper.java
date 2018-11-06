/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.turismo.web.vh;

import br.com.turismo.core.fachada.Resultado;
import br.com.turismo.core.util.ConverteDate;
import br.com.turismo.dominio.CompanhiaAerea;
import br.com.turismo.dominio.EntidadeDominio;
import br.com.turismo.dominio.Local;
import br.com.turismo.dominio.Voo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hisak
 */
public class VooViewHelper implements IViewHelper {

    //Objetos necessários para cadastrar um voo
    Voo voo;
    CompanhiaAerea cia;
    Local origem;
    Local destino;

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {

        //Recebe operação do formulário, na request.
        String operacao = request.getParameter("operacao");

        if (operacao.equals("SALVAR")) {
            voo = new Voo();
            cia = new CompanhiaAerea();
            origem = new Local();
            destino = new Local();

            String idDestino = request.getParameter("destino");
            String idOrigem = request.getParameter("origem");
            String idCia = request.getParameter("cia");
            String partida = request.getParameter("partida");
            String chegada = request.getParameter("chegada");

            if (partida != null && !partida.trim().equals("")) {
                voo.setPartida(new ConverteDate().converteStringDate(partida));
            }

            if (chegada != null && !chegada.trim().equals("")) {
                voo.setChegada(new ConverteDate().converteStringDate(chegada));
            }

            if (idDestino != null && !idDestino.trim().equals("")) {
                destino.setId(Integer.parseInt(idDestino));
                System.out.println("df" +idDestino + destino.getId());
                voo.setDestino(destino);
            }

            if (idOrigem != null && !idOrigem.trim().equals("")) {
                origem.setId(Integer.parseInt(idOrigem));
                voo.setOrigem(origem);
            }

            if (idCia != null && !idCia.trim().equals("")) {
                cia.setId(Integer.parseInt(idCia));
                voo.setCompanhia(cia);
            }

            System.out.println("data da partida " + voo.getPartida() + "   partida " + partida);

            return voo;

        }

     
        return voo;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
