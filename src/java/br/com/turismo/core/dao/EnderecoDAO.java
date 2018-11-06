/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.turismo.core.dao;

import br.com.turismo.core.util.Conexao;
import br.com.turismo.dominio.Endereco;
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
public class EnderecoDAO implements IDAO {

    Connection conexao;
    PreparedStatement pst;

    @Override
    public void salvar(EntidadeDominio entidade) {
    
        Endereco endereco = (Endereco) entidade;
        try {
            // Abre uma conexao com o banco.
            conexao = Conexao.getConexao();

            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO endereco(dtCadastro, bairro, cep, complemento, logradouro, numero, cidade_id)");
            sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?)");
            PreparedStatement pst = conexao.prepareStatement(sql.toString());
       
            pst.setDate(1, new java.sql.Date(System.currentTimeMillis()));
            pst.setString(2, endereco.getBairro());
            pst.setString(3, endereco.getCep());
            pst.setString(4, endereco.getComplemento());
            pst.setString(5, endereco.getLogradouro());
            pst.setString(6, endereco.getNumero());
            pst.setInt(7, endereco.getCidade().getId());
            pst.execute();

            // Fecha a conexao.
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
        Endereco endereco = (Endereco) entidade;
if (endereco.getId() != 0) {
        try {
            // Abre uma conexao com o banco.
            conexao = Conexao.getConexao();

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE endereco SET bairro=?, cep=?, complemento=?, logradouro=?, numero=?, cidade_id=? WHERE id=?");
             pst = conexao.prepareStatement(sql.toString());          
            pst.setString(1, endereco.getBairro());
            pst.setString(2, endereco.getCep());
            pst.setString(3, endereco.getComplemento());
            pst.setString(4, endereco.getLogradouro());
            pst.setString(5, endereco.getNumero());
            pst.setInt(6, endereco.getCidade().getId());
            pst.setInt(7, endereco.getId());
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
        Endereco endereco = (Endereco) entidade;

       
    }

    @Override
    public List<EntidadeDominio> consultar(EntidadeDominio entidade) throws SQLException {
        List<EntidadeDominio> enderecos = null;
        Endereco endereco = (Endereco) entidade;
        try {
            // Abre uma conexao com o banco.
            conexao = Conexao.getConexao();

            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO endereco(dtCadastro, bairro, cep, complemento, logradouro, numero, cidade_id)");
            sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?)");
            pst = conexao.prepareStatement(sql.toString());
            Timestamp time = new Timestamp(endereco.getDtCadastro().getTime());
            pst.setTimestamp(1, time);
            pst.setString(2, endereco.getBairro());
            pst.setString(3, endereco.getCep());
            pst.setString(4, endereco.getComplemento());
            pst.setString(5, endereco.getLogradouro());
            pst.setString(6, endereco.getNumero());
            pst.setInt(7, endereco.getCidade().getId());
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
        return null;
    }

    public int salvarId(EntidadeDominio entidade) {
        System.out.println("Estou  na dao de endereco");
        Endereco endereco = (Endereco) entidade;
        try {
            // Abre uma conexao com o banco.
            conexao = Conexao.getConexao();

            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO endereco(dtCadastro, bairro, cep, complemento, logradouro, numero, cidade_id)");
            sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?)");
            pst = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
            System.out.println("Estou  na dao, tempo");

            pst.setDate(1, new java.sql.Date(System.currentTimeMillis()));
            pst.setString(2, endereco.getBairro());
            pst.setString(3, endereco.getCep());
            pst.setString(4, endereco.getComplemento());
            pst.setString(5, endereco.getLogradouro());
            pst.setString(6, endereco.getNumero());
            pst.setInt(7, endereco.getCidade().getId());
            pst.execute();
            ResultSet generatedKeys = pst.getGeneratedKeys();
            if (null != generatedKeys && generatedKeys.next()) {
                endereco.setId(generatedKeys.getInt(1));
            }
            System.out.println("eee" + endereco.getId());
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
        return endereco.getId();
    }

    @Override
    public List<EntidadeDominio> filtrar(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
