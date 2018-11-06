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
    public void salvar(EntidadeDominio entidade) throws SQLException {

        
        cartao = new CartaoCredito();
        cartao = (CartaoCredito) entidade;
        try {
            // Abre uma conexao com o banco.
            conexao = Conexao.getConexao();

            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO cartaocredito( dtCadastro, ano, bandeira, codigo, mes, nome, numero, preferencia, status, cliente_id)");
            sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pst = conexao.prepareStatement(sql.toString());
            pst.setDate(1, new java.sql.Date(System.currentTimeMillis()));
            pst.setString(2, cartao.getAno());
            pst.setString(3, cartao.getBandeira());
            pst.setString(4, cartao.getCodigo());
            pst.setString(5, cartao.getMes());
            pst.setString(6, cartao.getNome());
            pst.setString(7, cartao.getNumero());
            pst.setBoolean(8, cartao.isPreferencia());
            pst.setBoolean(9, true);
            pst.setInt(10, cartao.getCliente());
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
           
           sql.append("UPDATE cartaocredito SET ano=?, bandeira=?, codigo=?, mes=?, numero=?, preferencia=? WHERE id=?");
            PreparedStatement pst = conexao.prepareStatement(sql.toString());

            pst.setString(1, cartao.getAno());
            pst.setString(2, cartao.getBandeira());
            pst.setString(3, cartao.getCodigo());
            pst.setString(4, cartao.getMes());
            pst.setString(5, cartao.getNome());
            pst.setString(6, cartao.getNumero());
            pst.setBoolean(7, cartao.isPreferencia());
    pst.setInt(1, cartao.getId());
            pst.execute();

            // Fecha a conexao.
            conexao.close();
        } catch (ClassNotFoundException erro) {
            erro.printStackTrace();
            //throw new ExcecaoAcessoDados("Houve um problema de configuração");
        } catch (SQLException erro) {
            erro.printStackTrace();
            //throw new ExcecaoAcessoDados("Houve um problema de conectividade");
        }finally {
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
        }finally {
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
            pst.setString(2, cartao.getAno());
            pst.setString(3, cartao.getBandeira());
            pst.setString(4, cartao.getCodigo());
            pst.setString(5, cartao.getMes());
            pst.setString(6, cartao.getNome());
            pst.setString(7, cartao.getNumero());
            pst.setBoolean(8, cartao.isPreferencia());
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
        }finally {
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
            sql.append("INSERT INTO cartaocredito( dtCadastro, ano, bandeira, codigo, mes, nome, numero, preferencia, status, cliente_id)");
            sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pst = conexao.prepareStatement(sql.toString());
            pst.setDate(1, new java.sql.Date(System.currentTimeMillis()));
            pst.setString(2, cartao.getAno());
            pst.setString(3, cartao.getBandeira());
            pst.setString(4, cartao.getCodigo());
            pst.setString(5, cartao.getMes());
            pst.setString(6, cartao.getNome());
            pst.setString(7, cartao.getNumero());
            pst.setBoolean(8, cartao.isPreferencia());
            pst.setBoolean(9, true);
            pst.setInt(10, cliente.getId());
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
        return 1;
    }

    @Override
    public List<EntidadeDominio> filtrar(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
