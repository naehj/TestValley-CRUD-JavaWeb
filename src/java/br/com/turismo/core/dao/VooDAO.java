/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.turismo.core.dao;

/**
 *
 * @author hisak
 */
public class VooDAO  {

    /*@Override
    public void salvar(EntidadeDominio entidade) {

        Voo voo = (Voo) entidade;
        voo.setDtCadastro(new Date(System.currentTimeMillis()));
        voo.setAtivo(true);
        EntityManager em = new Conexao().getConexao();
        try {
            em.getTransaction().begin();
            em.persist(voo);
            em.getTransaction().commit();
        } catch (Exception e) {

            em.getTransaction().rollback();

            e.printStackTrace();
            System.out.println("Erro no VooDAO - Salvar");
        } finally {

        
            em.close();

        }

    }

    @Override
    public void atualizar(EntidadeDominio entidade) throws SQLException {
        Voo voo = (Voo) entidade;
        
        EntityManager em = new Conexao().getConexao();
        try {
            em.getTransaction().begin();
            em.merge(voo);
            em.getTransaction().commit();
        } catch (Exception e) {

            em.getTransaction().rollback();

            e.printStackTrace();
            System.out.println("Erro no VooDAO - Alterar");
        } finally {

          
            em.close();

        }

    }

    @Override
    public void excluir(EntidadeDominio entidade) throws SQLException {
        Voo voo = (Voo) entidade;
        voo.setAtivo(false);
        EntityManager em = new Conexao().getConexao();
        try {
            em.getTransaction().begin();
            em.merge(voo);
            em.getTransaction().commit();
        } catch (Exception e) {

            em.getTransaction().rollback();

            e.printStackTrace();
            System.out.println("Erro no VooDAO - Desativar");
        } finally {

            em.flush();
            em.close();

        }

    }

    @Override
    public List<EntidadeDominio> consultar(EntidadeDominio entidade) throws SQLException {
        List<EntidadeDominio> voos = null;
        EntityManager em = new Conexao().getConexao();
        try {
            voos = em.createQuery("from Voo v where v.ativo=true").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro no VooDAO - Consultar");
        } finally {
         
            em.close();
        }
        return voos;
    }
*/
}




