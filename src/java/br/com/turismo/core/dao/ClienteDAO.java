/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.turismo.core.dao;

import br.com.turismo.core.util.Conexao;
import br.com.turismo.dominio.CartaoCredito;
import br.com.turismo.dominio.Cliente;
import br.com.turismo.dominio.Endereco;
import br.com.turismo.dominio.EntidadeDominio;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hisak
 */
public class ClienteDAO implements IDAO {

    EnderecoDAO endDAO;
    CartaoCreditoDAO cartaoDAO;
    PreparedStatement pst;
    Connection conexao;

    @Override
    public void salvar(EntidadeDominio entidade) {
        Cliente cliente = (Cliente) entidade;

        //Salvando endereco de Cobrança
        endDAO = new EnderecoDAO();

        try {
            // Abre uma conexao com o banco.
            conexao = Conexao.getConexao();

            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO tb_cliente (dt_cadastro, nome, cpf, genero, dt_nascimento, email, senha)");
            sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?)");
            pst = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

            pst.setDate(1, new java.sql.Date(System.currentTimeMillis()));
            pst.setString(2, cliente.getNome());
            pst.setString(3, cliente.getCpf());
            pst.setString(4, cliente.getGenero());
            java.sql.Date dataSQL = new Date(cliente.getDtNascimento().getTime());
            pst.setDate(5, dataSQL);
            pst.setString(6, cliente.getEmail());
            pst.setString(7, cliente.getSenha());

            pst.execute();
            ResultSet generatedKeys = pst.getGeneratedKeys();
            if (null != generatedKeys && generatedKeys.next()) {
                cliente.setId(generatedKeys.getInt(1));
            }

            endDAO.salvarId_Cobranca(cliente);

            //Salvando endereços de entrega
            if (!cliente.getEnd_De_Entrega().equals(null)) {
                for (Endereco endereco : cliente.getEnd_De_Entrega()) {
                    endDAO.salvarId_Entrega(cliente, endereco);
                }
            }

            // Salvando cartões
            if (!cliente.getCartaoCredito().equals(null)) {
                cartaoDAO = new CartaoCreditoDAO();
                for (CartaoCredito cartao : cliente.getCartaoCredito()) {
                    cartaoDAO.salvarId_Cartao(cliente, cartao);
                }
            }

        } catch (ClassNotFoundException erro) {
            erro.printStackTrace();

        } catch (SQLException erro) {
            erro.printStackTrace();

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
    public void atualizar(EntidadeDominio entidade) {
        Cliente cliente = (Cliente) entidade;

        if (cliente.getId() != 0) {
            try {
                // Abre uma conexao com o banco.
                conexao = Conexao.getConexao();

                StringBuilder sql = new StringBuilder();
                sql.append("UPDATE tb_cliente SET cpf=?, dt_nascimento=?, email=?, nome=?, senha=?, genero=? WHERE id_cli=?");

                pst = conexao.prepareStatement(sql.toString());
                pst.setString(1, cliente.getCpf());
                java.sql.Date dataSQL = new Date(cliente.getDtNascimento().getTime());
                pst.setDate(2, dataSQL);
                pst.setString(3, cliente.getEmail());
                pst.setString(4, cliente.getNome());
                pst.setString(5, cliente.getSenha());
                pst.setString(6, cliente.getGenero());
                pst.setInt(7, cliente.getId());
                pst.execute();

            } catch (ClassNotFoundException erro) {
                erro.printStackTrace();

            } catch (SQLException erro) {
                erro.printStackTrace();

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
    public void excluir(EntidadeDominio entidade
    ) {
        Cliente cliente = (Cliente) entidade;
        if (cliente.getId() != 0) {
            try {
                // Abre uma conexao com o banco.
                conexao = Conexao.getConexao();
                endDAO = new EnderecoDAO();
                endDAO.excluir_Cobranca(cliente.getEnd_De_Cobranca());
                if (!cliente.getEnd_De_Entrega().equals(null)) {
                    for (Endereco endereco : cliente.getEnd_De_Entrega()) {
                        endDAO.excluir_Entrega(endereco);
                    }
                }
                cartaoDAO = new CartaoCreditoDAO();
                if (!cliente.getCartaoCredito().equals(null)) {
                    for (CartaoCredito cartao : cliente.getCartaoCredito()) {
                        cartaoDAO.excluir(cartao);
                    }
                }

                StringBuilder sql = new StringBuilder();
                sql.append("DELET FROM tb_cliente * WHERE id=?");

                pst = conexao.prepareStatement(sql.toString());
                pst.setInt(1, cliente.getId());
                pst.execute();

            } catch (ClassNotFoundException erro) {
                erro.printStackTrace();

            } catch (SQLException erro) {
                erro.printStackTrace();

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

        List<EntidadeDominio> clientes = null;
        Cliente cliente = (Cliente) entidade;
        System.out.println("cliente dao" + cliente.getId());

        try {

            // Abre uma conexao com o banco.
            conexao = Conexao.getConexao();
            cartaoDAO = new CartaoCreditoDAO();
            endDAO = new EnderecoDAO();
            if (cliente.getId() != null) {
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT * FROM tb_cliente WHERE id_cli=?");
                pst = conexao.prepareStatement(sql.toString());
                pst.setInt(1, cliente.getId());
                ResultSet rs = pst.executeQuery();
                System.out.println("clientexx" + cliente.getId());
                while (rs.next()) {
                    cliente.setNome(rs.getString("nome"));
                    cliente.setCpf(rs.getString("cpf"));
                    cliente.setEmail(rs.getString("email"));
                    cliente.setDtNascimento(rs.getDate("dt_nascimento"));
                    cliente.setDtCadastro(rs.getDate("dt_cadastro"));
                    cliente.setSenha(rs.getString("senha"));
                }
                cliente.setEnd_De_Cobranca(endDAO.consultar_Cobranca_Por_Cliente(cliente));
                cliente.setEnd_De_Entrega(endDAO.consultar_Entrega_Por_Cliente(cliente));
                cliente.setCartaoCredito(cartaoDAO.consultar_Cartao(cliente));
            } else if (cliente.getEmail() != null && cliente.getSenha() != null) {
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT * FROM tb_cliente WHERE email=? AND senha=?");
                pst = conexao.prepareStatement(sql.toString());
                pst.setString(1, cliente.getEmail());
                pst.setString(2, cliente.getSenha());
                ResultSet rs = pst.executeQuery();
                System.out.println("clientexx" + cliente.getId());
                while (rs.next()) {
                    cliente.setId(rs.getInt("id_cli"));
                    cliente.setNome(rs.getString("nome"));
                    cliente.setCpf(rs.getString("cpf"));
                    cliente.setEmail(rs.getString("email"));
                    cliente.setDtNascimento(rs.getDate("dt_nascimento"));
                    cliente.setDtCadastro(rs.getDate("dt_cadastro"));
                    cliente.setSenha(rs.getString("senha"));
                }
                cliente.setEnd_De_Cobranca(endDAO.consultar_Cobranca_Por_Cliente(cliente));
                cliente.setEnd_De_Entrega(endDAO.consultar_Entrega_Por_Cliente(cliente));
                cliente.setCartaoCredito(cartaoDAO.consultar_Cartao(cliente));
            }

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
        clientes = new ArrayList<>();
        clientes.add(cliente);
        return clientes;
    }

    @Override
    public int salvarId(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EntidadeDominio> filtrar(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
