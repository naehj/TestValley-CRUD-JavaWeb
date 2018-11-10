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
import java.sql.Statement;
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

        cartao = (CartaoCredito) entidade;
       
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

        cartao = (CartaoCredito) entidade;
        if (cartao.getId() != 0) {
            try {
                // Abre uma conexao com o banco.
                Connection conexao = Conexao.getConexao();

                StringBuilder sql = new StringBuilder();

                sql.append("DELETE FROM tb_cartao * WHERE id=?");
                PreparedStatement pst = conexao.prepareStatement(sql.toString());
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
        try {
            // Abre uma conexao com o banco.
            Connection conexao = Conexao.getConexao();

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT FROM tb_cartao INNER JOIN tb_cliente_cartao * WHERE id_cli=?");
            PreparedStatement pst = conexao.prepareStatement(sql.toString());
            pst.setInt(1, cliente.getId());
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                cartao = new CartaoCredito();
                cartao.setBandeira(rs.getString("bandeira"));
                cartao.setCodigo(rs.getString("codigo"));
                cartao.setNumero(rs.getString("n_cartao"));
                cartao.setId(Integer.parseInt("id_cartao"));
                cartao.setDtCadastro(rs.getDate("dt_cadastro"));
                cartao.setNome(rs.getString("nome"));
                cartoes.add(cartao);
            }

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
    
    public int salvarId_Cartao(EntidadeDominio entidade_cli, EntidadeDominio entidade_cartao) throws SQLException {
        Cliente cliente = (Cliente) entidade_cli;
        cartao = (CartaoCredito) entidade_cartao;

        try {
            // Abre uma conexao com o banco.
            conexao = Conexao.getConexao();

            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO tb_cartao(n_cartao, nome, bandeira, codigo, dt_cadastro)");
            sql.append(" VALUES(?, ?, ?, ?, ?)");
            pst = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, cartao.getNumero());
            pst.setString(2, cartao.getNome());
            pst.setString(3, cartao.getBandeira());
            pst.setString(4, cartao.getCodigo());
            pst.setDate(5, new java.sql.Date(System.currentTimeMillis()));
            pst.execute();
            ResultSet generatedKeys = pst.getGeneratedKeys();
            if (null != generatedKeys && generatedKeys.next()) {
                cartao.setId(generatedKeys.getInt(1));
            }
            StringBuilder sql2 = new StringBuilder();
            sql2.append("INSERT INTO tb_cliente_cartao(id_cartao, id_cli)");
            sql2.append("VALUES(?, ?)");
            pst = conexao.prepareStatement(sql2.toString());
            pst.setInt(1, cartao.getId());
            pst.setInt(2, cliente.getId());
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

    @Override
    public void salvar(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int salvarId(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
