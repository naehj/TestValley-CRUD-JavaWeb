/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.turismo.core.dao;

import br.com.turismo.core.util.Conexao;
import br.com.turismo.dominio.Cliente;
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

    public void atualizar_Cobranca(EntidadeDominio entidade) throws SQLException {
        Endereco endereco = (Endereco) entidade;
        if (endereco.getId() != 0) {
            try {
                // Abre uma conexao com o banco.
                conexao = Conexao.getConexao();

                StringBuilder sql = new StringBuilder();
                sql.append("UPDATE tb_endereco_cobranca SET cidade=?, estado=?, pais=?, logradouro=?, numero=?, cep=?, tipo_residencia=?, tipo_logradouro=?, complemento=? WHERE id_end=?");
                pst = conexao.prepareStatement(sql.toString());
                pst.setString(1, endereco.getCidade());
                pst.setString(2, endereco.getEstado());
                pst.setString(3, endereco.getPais());
                pst.setString(4, endereco.getLogradouro());
                pst.setString(5, endereco.getNumero());
                pst.setString(6, endereco.getCep());
                pst.setString(7, endereco.getTipoResidencia());
                pst.setString(8, endereco.getTipoLogradouro());
                pst.setString(9, endereco.getComplemento());
                pst.setInt(10, endereco.getId());
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
    
    public void atualizar_Entrega(EntidadeDominio entidade) throws SQLException {
        Endereco endereco = (Endereco) entidade;
        if (endereco.getId() != 0) {
            try {
                // Abre uma conexao com o banco.
                conexao = Conexao.getConexao();

                StringBuilder sql = new StringBuilder();
                sql.append("UPDATE tb_endereco_entrega SET cidade=?, estado=?, pais=?, logradouro=?, numero=?, cep=?, tipo_residencia=?, tipo_logradouro=?, complemento=? WHERE id_end=?");
                pst = conexao.prepareStatement(sql.toString());
                pst.setString(1, endereco.getCidade());
                pst.setString(2, endereco.getEstado());
                pst.setString(3, endereco.getPais());
                pst.setString(4, endereco.getLogradouro());
                pst.setString(5, endereco.getNumero());
                pst.setString(6, endereco.getCep());
                pst.setString(7, endereco.getTipoResidencia());
                pst.setString(8, endereco.getTipoLogradouro());
                pst.setString(9, endereco.getComplemento());
                pst.setInt(10, endereco.getId());
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

    public void excluir_Cobranca(EntidadeDominio entidade) throws SQLException {
        Endereco endereco = (Endereco) entidade;
        if (endereco.getId() != 0) {
            try {
                // Abre uma conexao com o banco.
                Connection conexao = Conexao.getConexao();

                StringBuilder sql = new StringBuilder();

                sql.append("DELETE FROM tb_endereco_cobranca * WHERE id_end=?");
                PreparedStatement pst = conexao.prepareStatement(sql.toString());
                pst.setInt(1, endereco.getId());
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

    public void excluir_Entrega(EntidadeDominio entidade) throws SQLException {
        Endereco endereco = (Endereco) entidade;
        if (endereco.getId() != 0) {
            try {
                // Abre uma conexao com o banco.
                Connection conexao = Conexao.getConexao();

                StringBuilder sql = new StringBuilder();

                sql.append("DELETE FROM tb_endereco_entrega * WHERE id=?");
                PreparedStatement pst = conexao.prepareStatement(sql.toString());
                pst.setInt(1, endereco.getId());
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

    public Endereco consultar_Cobranca(EntidadeDominio entidade) throws SQLException {
        Cliente cliente = (Cliente) entidade;
        Endereco endereco = null;
        try {
            // Abre uma conexao com o banco.
            conexao = Conexao.getConexao();

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM tb_endereco_cobranca INNER JOIN tb_cliente_endereco_cobranca WHERE id_cli=?");
            pst = conexao.prepareStatement(sql.toString());
            pst.setInt(1, cliente.getId());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                endereco = new Endereco();
                endereco.setCep(rs.getString("cep"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setComplemento(rs.getString("complemento"));
                endereco.setDtCadastro(rs.getDate("dt_cadastro"));
                endereco.setEstado(rs.getString("estado"));
                endereco.setId(rs.getInt("id_end"));
                endereco.setLogradouro(rs.getString("logradouro"));
                endereco.setNumero(rs.getString("numero"));
                endereco.setPais(rs.getString("pais"));
                endereco.setTipoLogradouro(rs.getString("tipo_logradouro"));
                endereco.setTipoResidencia(rs.getString("tipo_residencia"));
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
        return endereco;
    }

    public List<Endereco> consultar_Entrega(EntidadeDominio entidade) throws SQLException {
        List<Endereco> enderecos = null;
        Cliente cliente = (Cliente) entidade;
        Endereco endereco = null;
        try {
            // Abre uma conexao com o banco.
            conexao = Conexao.getConexao();

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM tb_endereco_entrega INNER JOIN tb_cliente_endereco_entrega WHERE id_cli=?");
            pst = conexao.prepareStatement(sql.toString());
            pst.setInt(1, cliente.getId());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                endereco = new Endereco();
                endereco.setCep(rs.getString("cep"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setComplemento(rs.getString("complemento"));
                endereco.setDtCadastro(rs.getDate("dt_cadastro"));
                endereco.setEstado(rs.getString("estado"));
                endereco.setId(rs.getInt("id_end"));
                endereco.setLogradouro(rs.getString("logradouro"));
                endereco.setNumero(rs.getString("numero"));
                endereco.setPais(rs.getString("pais"));
                endereco.setTipoLogradouro(rs.getString("tipo_logradouro"));
                endereco.setTipoResidencia(rs.getString("tipo_residencia"));
                enderecos.add(endereco);
            }
            
            // Fecha a conexao.
            conexao.close();
            return enderecos;
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

    public int salvarId_Cobranca(EntidadeDominio entidade) {
        System.out.println("Estou  na dao de endereco");
        Cliente cliente = (Cliente) entidade;
        try {
            // Abre uma conexao com o banco.
            conexao = Conexao.getConexao();

            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO tb_endereco_cobranca (cidade, estado, pais, logradouro, numero, cep, dt_cadastro, tipo_residencia, tipo_logradouro, complemento)");
            sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pst = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

            pst.setString(1, cliente.getEnd_De_Cobranca().getCidade());
            pst.setString(2, cliente.getEnd_De_Cobranca().getEstado());
            pst.setString(3, cliente.getEnd_De_Cobranca().getPais());
            pst.setString(4, cliente.getEnd_De_Cobranca().getLogradouro());
            pst.setString(5, cliente.getEnd_De_Cobranca().getNumero());
            pst.setString(6, cliente.getEnd_De_Cobranca().getCep());
            pst.setDate(7, new java.sql.Date(System.currentTimeMillis()));
            pst.setString(8, cliente.getEnd_De_Cobranca().getTipoResidencia());
            pst.setString(9, cliente.getEnd_De_Cobranca().getTipoLogradouro());
            pst.setString(10, cliente.getEnd_De_Cobranca().getComplemento());

            pst.execute();
            ResultSet generatedKeys = pst.getGeneratedKeys();
            if (null != generatedKeys && generatedKeys.next()) {
                cliente.getEnd_De_Cobranca().setId(generatedKeys.getInt(1));
            }
            StringBuilder sql2 = new StringBuilder();
            sql2.append("INSERT INTO tb_cliente_cobranca(id_end, id_cli)");
            sql2.append("VALUES(?, ?)");
            pst = conexao.prepareStatement(sql2.toString());
            pst.setInt(1, cliente.getEnd_De_Cobranca().getId());
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
        return cliente.getEnd_De_Cobranca().getId();
    }

    public int salvarId_Entrega(EntidadeDominio entidade_cli, EntidadeDominio entidade_end) {
        Cliente cliente = (Cliente) entidade_cli;
        Endereco endereco = (Endereco) entidade_end;
        try {
            // Abre uma conexao com o banco.
            conexao = Conexao.getConexao();

            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO tb_endereco_entrega (cidade, estado, pais, logradouro, numero, cep, dt_cadastro, tipo_residencia, tipo_logradouro, complemento)");
            sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pst = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

            pst.setString(1, endereco.getCidade());
            pst.setString(2, endereco.getEstado());
            pst.setString(3, endereco.getPais());
            pst.setString(4, endereco.getLogradouro());
            pst.setString(5, endereco.getNumero());
            pst.setString(6, endereco.getCep());
            pst.setDate(7, new java.sql.Date(System.currentTimeMillis()));
            pst.setString(8, endereco.getTipoResidencia());
            pst.setString(9, endereco.getTipoLogradouro());
            pst.setString(10, endereco.getComplemento());

            pst.execute();
            ResultSet generatedKeys = pst.getGeneratedKeys();
            if (null != generatedKeys && generatedKeys.next()) {
                endereco.setId(generatedKeys.getInt(1));
            }
            StringBuilder sql2 = new StringBuilder();
            sql2.append("INSERT INTO tb_cliente_entrega(id_end, id_cli)");
            sql2.append("VALUES(?, ?)");
            pst = conexao.prepareStatement(sql2.toString());
            pst.setInt(1, endereco.getId());
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
        return endereco.getId();
    }

    @Override
    public List<EntidadeDominio> filtrar(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int salvarId(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EntidadeDominio> consultar(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void salvar(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
