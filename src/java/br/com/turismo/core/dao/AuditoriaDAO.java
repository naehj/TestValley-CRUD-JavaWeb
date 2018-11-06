/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.turismo.core.dao;

import br.com.turismo.core.util.Conexao;
import br.com.turismo.dominio.Auditoria;
import br.com.turismo.dominio.CartaoCredito;
import br.com.turismo.dominio.Cidade;
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
public class AuditoriaDAO implements IDAO {
    
    
    Endereco endereco;
    CartaoCredito cartao;
    EnderecoDAO endDAO;
    CartaoCreditoDAO cartaoDAO;
    PreparedStatement pst;
    Connection conexao;
    
    @Override
    public void salvar(EntidadeDominio entidade) {
        Auditoria auditoria = (Auditoria) entidade;
        Cliente cliente = new Cliente();
         endereco = new Endereco();
        endereco = cliente.getEndereco();
        if (cliente.getCartaoCredito() != null){
            cartao = new CartaoCredito();
            cartao = cliente.getCartaoCredito().get(0);
        }
       
        
        try {
            // Abre uma conexao com o banco.
            conexao = Conexao.getConexao();
            
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO auditoria_cliente( dtmodificacao, ");
               sql.append("dt_cad_cli, cpf, dtnascimento, email, ");
             sql.append("nome_cli, senha, status_cli, endereco_id, id_cli)");
            sql.append(" new_cpf, new_dtnascimento, new_email, new_nome_cli, new_senha, new_status_cli, ");
            sql.append("bairro, cep, complemento_res, logradouro, numero_res, cidade_id, ");
            sql.append("new_bairro, new_cep, new_complemento_res, new_logradouro, new_numero_res, new_cidade_id ");
            sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
            pst = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
            
            pst.setInt(1, 1);
            
            pst.setString(2, cliente.getCpf());
            java.sql.Date dataSQL = new Date(cliente.getDtNascimento().getTime());
            pst.setDate(3, dataSQL );
            
            pst.setString(4, cliente.getEmail());
            pst.setString(5, cliente.getNome());
            pst.setString(6, cliente.getSenha());
            pst.setBoolean(7, true);
           
            
            pst.execute();
            ResultSet generatedKeys = pst.getGeneratedKeys();
            if (null != generatedKeys && generatedKeys.next()) {
                cliente.setId(generatedKeys.getInt(1));
            }

            // salvando cartão
            if (!cliente.getCartaoCredito().equals(null)) {
                cartaoDAO = new CartaoCreditoDAO();
                cartaoDAO.salvar(cliente);
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
        
    }
    
    @Override
    public void atualizar(EntidadeDominio entidade) {
        Cliente cliente = (Cliente) entidade;
        
        if (cliente.getId() != 0) {
            try {
                // Abre uma conexao com o banco.
                conexao = Conexao.getConexao();
                
                StringBuilder sql = new StringBuilder();
                sql.append("UPDATE cliente SET cpf=?, dtnascimento=?, email=?, nome=? WHERE id=?");
                
                pst = conexao.prepareStatement(sql.toString());
                pst.setString(1, cliente.getCpf());
                java.sql.Date dataSQL = new Date(cliente.getDtNascimento().getTime());
                pst.setDate(2, dataSQL);
                pst.setString(3, cliente.getEmail());
                pst.setString(4, cliente.getNome());
                pst.setInt(5, cliente.getId());
                pst.execute();
                
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
            try {
                // Abre uma conexao com o banco.
                conexao = Conexao.getConexao();
                
                StringBuilder sql = new StringBuilder();
                sql.append("UPDATE cliente SET cpf=?, dtnascimento=?, email=?, nome=? WHERE id=?");
                
                pst = conexao.prepareStatement(sql.toString());
                pst.setString(1, cliente.getCpf());
                pst.setDate(2, null);
                pst.setString(3, cliente.getEmail());
                pst.setString(4, cliente.getNome());
                pst.setInt(5, cliente.getId());
                pst.execute();
                
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
    public void excluir(EntidadeDominio entidade) {
        Cliente cliente = (Cliente) entidade;
        cliente.setStatus(false);
        if (cliente.getId() != 0) {
            try {
                // Abre uma conexao com o banco.
                conexao = Conexao.getConexao();
                
                StringBuilder sql = new StringBuilder();
                sql.append("UPDATE cliente SET status=? WHERE id=?");
                
                pst = conexao.prepareStatement(sql.toString());
                pst.setBoolean(1, cliente.isStatus());
                pst.setInt(2, cliente.getId());
                pst.execute();
                
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
    
    public List<EntidadeDominio> filtrar(EntidadeDominio entidade) throws SQLException {
        List<EntidadeDominio> clientes = null;
        Cliente filtro = (Cliente) entidade;
        
        StringBuilder sql = new StringBuilder();
            sql.append("SELECT c.id,c.nome as nome,c.cpf,c.status,c.email, ");
            sql.append("e.id,e.logradouro, cid.id, cid.cidade, cc.id, cc.nome ");
            sql.append("FROM cliente c join endereco e ON c.endereco_id=e.id ");
            sql.append("JOIN cartaocredito cc ON c.id=cc.cliente_id ");
            sql.append("JOIN cidade cid ON cid.id=e.cidade_id ");
            sql.append("WHERE c.status=? ");
            if (filtro.getNome() != null && !filtro.getNome().equals("")) {
                sql.append("AND unaccent(c.nome) ILIKE unaccent('%' || ? || '%') ");
            }
             if (filtro.getEmail() != null && !filtro.getEmail().equals("")) {
                sql.append("AND  unaccent(c.email) ILIKE  unaccent('%' || ? || '%') ");
            }
            if (filtro.getEndereco().getLogradouro() != null && !filtro.getEndereco().getLogradouro().equals("")) {
                sql.append("AND  unaccent(e.logradouro) ilike  unaccent('%' || ? || '%') ");
            }
            if (filtro.getEndereco().getCidade().getId() != null && !filtro.getEndereco().getCidade().getId().equals("")) {
                
                sql.append("AND  cid.id=? ");
            }
            if (filtro.getCartaoCredito().get(0).getNome() != null && !filtro.getCartaoCredito().get(0).getNome().equals("")) {
                
                sql.append("AND  unaccent(cc.nome) ilike  unaccent'%' || ? || '%') ");
            };
        
        
        try {

            // Abre uma conexao com o banco.
            conexao = Conexao.getConexao();
            
           int i =2;
            
            pst = conexao.prepareStatement(sql.toString());
            pst.setBoolean(1, filtro.isStatus());
            
            if (filtro.getNome() != null && !filtro.getNome().equals("")) {
                pst.setString(i, filtro.getNome());
                i++;
            }
           
            if (filtro.getEmail() != null && !filtro.getEmail().equals("")) {
                pst.setString(i, filtro.getEmail());
                  i++;
            }
            
            if (filtro.getEndereco().getLogradouro() != null && !filtro.getEndereco().getLogradouro().equals("")) {
                pst.setString(i, filtro.getEndereco().getLogradouro());
                  i++;
            }
            
            if (filtro.getEndereco().getCidade().getId() != null && !filtro.getEndereco().getCidade().getId().equals("")) {
                
                pst.setInt(i, filtro.getEndereco().getCidade().getId());
                  i++;
            }
            
            if (filtro.getCartaoCredito().get(0).getNome() != null && !filtro.getCartaoCredito().get(0).getNome().equals("")) {
                pst.setString(i, filtro.getCartaoCredito().get(0).getNome());
                  i++;
            }
            
            ResultSet rs = pst.executeQuery();
            clientes = new ArrayList<>();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                endereco = new Endereco();
                Cidade cidade = new Cidade();
                cartao = new CartaoCredito();
                
                cliente.setId(rs.getInt(1));
                cliente.setNome(rs.getString(2));
                cliente.setCpf(rs.getString(3));
                cliente.setStatus(rs.getBoolean(4));
                cliente.setEmail(rs.getString(5));
                endereco.setId(rs.getInt(6));
                endereco.setLogradouro(rs.getString(7));
                cidade.setId(rs.getInt(8));
                cidade.setCidade(rs.getString(9));
                cartao.setId(rs.getInt(10));
                cartao.setNome(rs.getString(11));
                cartao.setCliente(cliente.getId());
                cliente.getCartaoCredito().add(cartao);
                endereco.setCidade(cidade);
                cliente.setEndereco(endereco);
                clientes.add(cliente);
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
        
        return clientes;
    }
    
    @Override
    public int salvarId(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<EntidadeDominio> consultar(EntidadeDominio entidade) throws SQLException {
        
        List<EntidadeDominio> clientes = null;
        Cliente cliente = (Cliente) entidade;
        endereco = new Endereco();
        Cidade cidade = new Cidade();
        System.out.println("cliente dao" + cliente.getId());
        
        try {

            // Abre uma conexao com o banco.
            conexao = Conexao.getConexao();
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM cliente WHERE id=?");
            pst = conexao.prepareStatement(sql.toString());
            pst.setInt(1, cliente.getId());
            ResultSet rs = pst.executeQuery();
             System.out.println("clientexx" + cliente.getId());
            while (rs.next()) {
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setStatus(rs.getBoolean("status"));
                cliente.setEmail(rs.getString("email"));
                cliente.setDtNascimento(rs.getDate("dtnascimento"));
                endereco.setId(rs.getInt("endereco_id"));
                cliente.setEndereco(endereco);
            }
            System.out.println("cliente" + cliente.getNome());
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
         try {

            // Abre uma conexao com o banco.
            conexao = Conexao.getConexao();
            
            StringBuilder sql = new StringBuilder();
        
            sql.append("SELECT * FROM endereco WHERE id=?");
            pst = conexao.prepareStatement(sql.toString());
            pst.setInt(1, cliente.getEndereco().getId());
            ResultSet rs = pst.executeQuery();
             System.out.println("clientev" + cliente.getEndereco().getId());
             System.out.println("clientev" + endereco.getId());
            while (rs.next()) {
                
                endereco.setLogradouro(rs.getString("logradouro"));
                endereco.setLogradouro(rs.getString("numero"));
                endereco.setLogradouro(rs.getString("complemento"));
                endereco.setLogradouro(rs.getString("bairro"));
                endereco.setLogradouro(rs.getString("cep"));
                cidade.setId(rs.getInt("cidade_id"));
                endereco.setCidade(cidade);
            }
             System.out.println("end " + cliente.getId() + "  "+cidade.getId());
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
         try {

            // Abre uma conexao com o banco.
            conexao = Conexao.getConexao();
            
            StringBuilder sql = new StringBuilder();
        
            sql.append("SELECT * FROM cartaocredito WHERE cliente_id=?");
            pst = conexao.prepareStatement(sql.toString());
            pst.setInt(1, cliente.getId());
            ResultSet rs = pst.executeQuery();
            List<CartaoCredito> cartoes = new ArrayList<>();
            while (rs.next()) {
                cartao = new CartaoCredito();
                cartao.setAno(rs.getString("ano"));
                cartao.setMes(rs.getString("mes"));
                cartao.setNome(rs.getString("nome"));
                cartao.setNumero(rs.getString("numero"));
                cartao.setCodigo(rs.getString("codigo"));
                cartao.setBandeira(rs.getString("bandeira"));
                System.out.println("  Cartao " +cartao.getNome());
               cartoes.add(cartao);
            }
            cliente.setCartaoCredito(cartoes);
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
         cliente.setEndereco(endereco);
         clientes = new ArrayList<>();
         clientes.add(cliente);
    return clientes;
    }
}