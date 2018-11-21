/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cliente.dominio;

import br.com.cliente.core.dao.ClienteDAO;


/**
 *
 * @author hisak
 */
public class Teste {
    public static void main(String[] args) {
       //Pais pais = new Pais();
      // pais.setPais("Brasgfgil");
      // pais.setSigla("BRgg");
      String senha = "*111aA####";
      String senhaforte= "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
			boolean flag = senha.matches(senhaforte);
        System.out.println("1" + flag);
      /* Cliente cliente = new Cliente();
        cliente.setCpf("2312312");
        cliente.setNome("Manoel");
        cliente.setId(3);
        CartaoCredito cartao = new CartaoCredito();
        cartao.setAno("123");
        cliente.getCartaoCredito().add(cartao);
        Pais pais = new Pais();
        pais.setId(1);
        Estado estado = new Estado();
        estado.setId(1);
        Cidade cidade = new Cidade();
        cidade.setId(1);
        Endereco endereco = new Endereco();
        endereco.setCidade(cidade);
        endereco.setBairro("fddfs");
        cliente.setEndereco(endereco);
        ClienteDAO cliDAO = new ClienteDAO();
        cliDAO.excluir(cliente);
        */
       // EntityManager em = new Conexao().getConexao();
      
      // em.getTransaction().begin();
      //  em.persist(pais);
     //  em.getTransaction().commit();
    //    
        
      //  em.close();
      
       /* try {
            em.getTransaction().begin();
            em.persist(cartao);
            em.persist(endereco);
            em.persist(cliente);
            System.out.println("Erro no ClienteDAO - Salvar");
            em.getTransaction().commit();
        } catch (Exception e) {

            em.getTransaction().rollback();

            e.printStackTrace();
            System.out.println("Erro no ClienteDAO - Salvar");
        } finally {

            
            em.close();

        }*/
        
         /* Session session = NewHibernateUtil.getSessionFactory().openSession();
          session.beginTransaction();
          session.persist(pais);
          session.getTransaction().commit();
          session.flush();
          session.close();*/
    }
}
