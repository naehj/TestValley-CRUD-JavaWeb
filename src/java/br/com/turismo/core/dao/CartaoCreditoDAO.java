/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.turismo.core.dao;

import br.com.turismo.core.util.Conexao;
import br.com.turismo.dominio.CartaoCredito;
import br.com.turismo.dominio.Cliente;
import br.com.turismo.dominio.EntidadeDominio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 *
 * @author hisak
 */
public class CartaoCreditoDAO implements IDAO {

    Connection conexao;
    PreparedStatement pst;
    CartaoCredito cartao;

    @Override
    public void atualizar(EntidadeDominio entidade) throws SQLException {

        Cliente cliente = (Cliente) entidade;
        cartao = new CartaoCredito();
        cartao = cliente.getCartaoCredito().get(0);
        if (cartao.getId() != 0) {
            try {
                // Abre uma conexao com o banco.
                Connection conexao = Conexao.getConexao();

                StringBuilder sql = new StringBuilder();

                sql.append("UPDATE cartaocredito SET numero=?, nome=?, bandeira=?, codigo=? WHERE id=?");

                pst = conexao.prepareStatement(sql.toString());
                pst.setString(1, cartao.getNumero());
                pst.setString(2, cartao.getNome());
                pst.setString(3, cartao.getBandeira());
                pst.setString(4, cartao.getCodigo());
                pst.setInt(5, cartao.getId());
                pst.execute();

                // Fecha a conexao.
                conexao.close();
            } catch (ClassNotFoundException erro) {
                erro.printStackTrace();
                //throw new ExcecaoAcessoDados("Houve um problema de configuração");
            } catch (SQLException erro) {
                erro.printStackTrace();
                //throw new ExcecaoAcessoDados("Houve um problema de conectividade");
            } finally {
                try {
                    pst.close();
                    conexao.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void excluir(EntidadeDominio entidade) throws SQLException {

        Cliente cliente = (Cliente) entidade;
        cartao = new CartaoCredito();
        cartao = cliente.getCartaoCredito().get(0);
        if (cartao.getId() != 0) {
            try {
                // Abre uma conexao com o banco.
                Connection conexao = Conexao.getConexao();

                StringBuilder sql = new StringBuilder();

                sql.append("UPDATE cartaocredito SET status=? WHERE id=?");
                PreparedStatement pst = conexao.prepareStatement(sql.toString());

                pst.setBoolean(1, cartao.isPreferencia());
                pst.setInt(2, cartao.getId());
                pst.execute();

                // Fecha a conexao.
                conexao.close();
            } catch (ClassNotFoundException erro) {
                erro.printStackTrace();
                //throw new ExcecaoAcessoDados("Houve um problema de configuração");
            } catch (SQLException erro) {
                erro.printStackTrace();
                //throw new ExcecaoAcessoDados("Houve um problema de conectividade");
            } finally {
                try {
                    pst.close();
                    conexao.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Override
    public List<EntidadeDominio> consultar(EntidadeDominio entidade) throws SQLException {
        List<EntidadeDominio> cartoes = null;

        Cliente cliente = (Cliente) entidade;
        cartao = new CartaoCredito();
        cartao = cliente.getCartaoCredito().get(0);
        try {
            // Abre uma conexao com o banco.
            Connection conexao = Conexao.getConexao();

            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO cartaocredito( dtCadastro, ano, bandeira, codigo, mes, nome, numero, preferencia, status, cliente_id)");
            sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            PreparedStatement pst = conexao.prepareStatement(sql.toString());
            Timestamp time = new Timestamp(cartao.getDtCadastro().getTime());
            pst.setTimestamp(1, time);
            pst.setString(3, cartao.getBandeira());
            pst.setString(4, cartao.getCodigo());
            pst.setString(6, cartao.getNome());
            pst.setString(7, cartao.getNumero());
            pst.setBoolean(9, true);
            pst.setInt(7, cliente.getId());
            pst.execute();

            // Fecha a conexao.
            conexao.close();
        } catch (ClassNotFoundException erro) {
            erro.printStackTrace();
            //throw new ExcecaoAcessoDados("Houve um problema de configuração");
        } catch (SQLException erro) {
            erro.printStackTrace();
            //throw new ExcecaoAcessoDados("Houve um problema de conectividade");
        } finally {
            try {
                pst.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return cartoes;
    }

    @Override
    public int salvarId(EntidadeDominio entidade) throws SQLException {
        Cliente cliente = (Cliente) entidade;
        cartao = new CartaoCredito();
        cartao = cliente.getCartaoCredito().get(0);

        try {
            // Abre uma conexao com o banco.
            conexao = Conexao.getConexao();

            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO tb_cartao(n_cartao, nome, bandeira, codigo)");
            sql.append(" VALUES(?, ?, ?, ?)");
            pst = conexao.prepareStatement(sql.toString());
            pst.setString(1, cartao.getNumero());
            pst.setString(2, cartao.getNome());
            pst.setString(3, cartao.getBandeira());
            pst.setString(4, cartao.getCodigo());
            pst.execute();
            int id_cliente = 0;
            StringBuilder sql2 = new StringBuilder();
            sql2.append("SELEC id_cli FROM tb_cliente WHERE cpf=");
            sql2.append(cliente.getCpf());
            pst = conexao.prepareStatement(sql2.toString());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                id_cliente = rs.getInt("id_cli");
            }
            int id_cartao = 0;
            StringBuilder sql3 = new StringBuilder();
            sql3.append("SELEC id_cartao FROM tb_cartao WHERE n_cartao=");
            sql3.append(cartao.getNumero());
            pst = conexao.prepareStatement(sql3.toString());
            rs = pst.executeQuery();
            while (rs.next()) {
                id_cartao = rs.getInt("id_cartao");
            }
            StringBuilder sql4 = new StringBuilder();
            sql4.append("INSERT INTO tb_cliente_cartao(id_cartao, id_cli)");
            sql4.append("VALUES(?, ?)");
            pst = conexao.prepareStatement(sql4.toString());
            pst.setInt(1, id_cartao);
            pst.setInt(2, id_cliente);

            // Fecha a conexao.
            conexao.close();
        } catch (ClassNotFoundException erro) {
            erro.printStackTrace();
            //throw new ExcecaoAcessoDados("Houve um problema de configuração");
        } catch (SQLException erro) {
            erro.printStackTrace();
            //throw new ExcecaoAcessoDados("Houve um problema de conectividade");
        } finally {
            try {
                pst.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 1;
    }

    @Override
    public List<EntidadeDominio> filtrar(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void salvar(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
