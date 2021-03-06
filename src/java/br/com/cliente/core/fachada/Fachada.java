package br.com.cliente.core.fachada;

import br.com.cliente.core.dao.CartaoCreditoDAO;
import br.com.cliente.core.dao.ClienteDAO;
import br.com.cliente.core.dao.EnderecoDAO;
import br.com.cliente.core.dao.IDAO;
import br.com.cliente.core.negocio.ClienteDadosObrigatorios;
import br.com.cliente.core.negocio.IStrategy;
import br.com.cliente.core.negocio.ValidarEmail;
import br.com.cliente.core.negocio.ValidarSenha;
import br.com.cliente.dominio.CartaoCredito;
import br.com.cliente.dominio.Cliente;
import br.com.cliente.dominio.Endereco;
import br.com.cliente.dominio.EntidadeDominio;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hisak
 */
public class Fachada implements IFachada {

    /**
     * Mapa de DAOS, será indexado pelo nome da entidade;
     *
     */
    private Map<String, IDAO> daos;

    /**
     * Mapa para conter as regras de negócio de todas as operações por entidade;
     *
     */
    private Map<String, Map<String, List<IStrategy>>> regras;

    //Para conter as mensagem de resultado
    Resultado resultado;

    public Fachada() {
        /* Intanciando o Map de DAOS */
        daos = new HashMap<String, IDAO>();

        /* Intanciando o Map de Regras de Negócio */
        regras = new HashMap<String, Map<String, List<IStrategy>>>();

        /* Criando instancias dos DAOs a serem utilizados*/
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        CartaoCreditoDAO cartaoDAO = new CartaoCreditoDAO();
        ClienteDAO clienteDAO = new ClienteDAO();

        /* Adicionando cada dao no MAP indexando pelo nome da classe */
        // daos.put(Voo.class.getName(), vooDAO);
        daos.put(Endereco.class.getName(), enderecoDAO);
        daos.put(CartaoCredito.class.getName(), cartaoDAO);
        daos.put(Cliente.class.getName(), clienteDAO);

        /* Criando instâncias de regras de negócio a serem utilizados*/
        ClienteDadosObrigatorios clienteDadosObrigatorios = new ClienteDadosObrigatorios();
        ValidarEmail validarEmail = new ValidarEmail();
        ValidarSenha validarSenha = new ValidarSenha();

        List<IStrategy> regrasSalvarCliente = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operação salvar do cliente*/
        regrasSalvarCliente.add(clienteDadosObrigatorios);

        regrasSalvarCliente.add(validarEmail);
        regrasSalvarCliente.add(validarSenha);

        /* Criando uma lista para conter as regras de negócio de cliente
		 * quando a operação for atuallizar
         */
        List<IStrategy> regrasAtualizarCliente = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operação atuallizar do cliente*/
        regrasSalvarCliente.add(clienteDadosObrigatorios);
        regrasAtualizarCliente.add(clienteDadosObrigatorios);
        regrasAtualizarCliente.add(validarEmail);
        /* Cria o mapa que poderá conter todas as listas de regras de negócio específica 
		 * por operação  do cliente
         */
        Map<String, List<IStrategy>> regrasCliente = new HashMap<String, List<IStrategy>>();
        /*
		 * Adiciona a listra de regras na operação salvar no mapa do cliente
         */
        regrasCliente.put("SALVAR", regrasSalvarCliente);
        regrasCliente.put("ATUALIZAR", regrasAtualizarCliente);

        regras.put(Cliente.class.getName(), regrasCliente);

    }

    public String executarRegras(EntidadeDominio entidade, String operacao) {

        String nomeDaClasse = entidade.getClass().getName();
        StringBuilder mensagens = new StringBuilder();

        Map<String, List<IStrategy>> regrasOperacao = regras.get(nomeDaClasse);

        if (regrasOperacao != null) {
            List<IStrategy> regras = regrasOperacao.get(operacao);

            if (regras != null) {
                int i = 0;
                for (IStrategy r : regras) {

                    String msg = r.processar(entidade);
                    System.out.println(" cheguei no cliente 2" + i + " " + msg);
                    if (msg != null) {
                        mensagens.append(msg);
                        mensagens.append("\n");
                    }
                    i++;
                }
            }
        }

        if (mensagens.length() > 0) {
            return mensagens.toString();
        } else {
            return null;
        }

    }

    @Override
    public Resultado salvar(EntidadeDominio entidade) {

        resultado = new Resultado();

        String nmClasse = entidade.getClass().getName();

        String msg = executarRegras(entidade, "SALVAR");

        if (msg == null) {
            IDAO dao = daos.get(nmClasse);
            if (dao instanceof ClienteDAO) {
                try {
                    dao.salvar(entidade);
                    List<EntidadeDominio> entidades = new ArrayList<>();
                    entidades.add(entidade);
                    resultado.setEntidades(entidades);
                } catch (SQLException e) {
                    e.printStackTrace();
                    resultado.setMsg("Não foi possível realizar o registro!");
                }
            } else if (dao instanceof EnderecoDAO) {
                ((EnderecoDAO) dao).salvarId_Cobranca(entidade);
                List<EntidadeDominio> entidades = new ArrayList<>();
                entidades.add(entidade);
                resultado.setEntidades(entidades);
            }
        } else {
            resultado.setMsg(msg);
            System.out.println("seta msg erro");
        }
        return resultado;
    }

    @Override
    public Resultado salvar(EntidadeDominio entidadeCli, EntidadeDominio entidadeAlt) {

        resultado = new Resultado();

        String nmClasse = entidadeAlt.getClass().getName();

        String msg = executarRegras(entidadeAlt, "SALVAR");

        if (msg == null) {
            IDAO dao = daos.get(nmClasse);
            if (dao instanceof EnderecoDAO) {
                try {
                    ((EnderecoDAO) dao).salvarId_Entrega(entidadeCli, entidadeAlt);
                    List<EntidadeDominio> entidades = new ArrayList<>();
                    entidades.add(entidadeAlt);
                    resultado.setEntidades(entidades);
                } catch (SQLException e) {
                    e.printStackTrace();
                    resultado.setMsg("Não foi possível realizar o registro!");
                }
            } else if (dao instanceof CartaoCreditoDAO) {
                try {
                    ((CartaoCreditoDAO) dao).salvarId_Cartao(entidadeCli, entidadeAlt);
                    List<EntidadeDominio> entidades = new ArrayList<>();
                    entidades.add(entidadeAlt);
                    resultado.setEntidades(entidades);
                } catch (SQLException e) {
                    e.printStackTrace();
                    resultado.setMsg("Não foi possível realizar o registro!");
                }
            }
        } else {
            resultado.setMsg(msg);
            System.out.println("seta msg erro");
        }
        return resultado;
    }

    @Override
    public Resultado atualizar(EntidadeDominio entidade) {
        resultado = new Resultado();

        String nmClasse = entidade.getClass().getName();

        //String msg = executarRegras(entidade, "ATUALIZAR");
        // if (msg == null) {
        IDAO dao = daos.get(nmClasse);
        if (dao instanceof EnderecoDAO) {
            try {
                if (((EnderecoDAO) dao).consultar_Cobranca_Por_Endereco(entidade) != null) {
                    ((EnderecoDAO) dao).atualizar_Cobranca(entidade);
                }
                if (((EnderecoDAO) dao).consultar_Entrega_Por_Endereco(entidade) != null) {
                    ((EnderecoDAO) dao).atualizar_Entrega(entidade);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                resultado.setMsg("Não foi possível realizar o registro!");

            }
        } else {
            try {
                dao.atualizar(entidade);
                List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
                entidades.add(entidade);
                resultado.setEntidades(entidades);
            } catch (SQLException e) {
                e.printStackTrace();
                resultado.setMsg("Não foi possível realizar o registro!");

            }
        }
        //} else {
        //resultado.setMsg(msg);
        //  List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
        //  entidades.add(entidade);
        //   System.out.println("erro na fachada?");
        //    }

        System.out.println("erro na fachadssssa?");
        return resultado;

    }

    @Override
    public Resultado excluir(EntidadeDominio entidade) {
        resultado = new Resultado();

        String nmClasse = entidade.getClass().getName();

        //String msg = executarRegras(entidade, "EXCLUIR");
        //if(msg == null){
        IDAO dao = daos.get(nmClasse);
        if (dao instanceof EnderecoDAO) {
            try {
                if (((EnderecoDAO) dao).consultar_Cobranca_Por_Endereco(entidade) != null) {
                    ((EnderecoDAO) dao).excluir_Cobranca(entidade);
                }
                if (((EnderecoDAO) dao).consultar_Entrega_Por_Endereco(entidade) != null) {
                    ((EnderecoDAO) dao).excluir_Entrega(entidade);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                resultado.setMsg("Não foi possível excluir o registro!");

            }
        } else {
            try {
                dao.excluir(entidade);
                List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
                entidades.add(entidade);
                resultado.setEntidades(entidades);
            } catch (SQLException e) {
                e.printStackTrace();
                resultado.setMsg("Não foi possível excluir o registro!");

            }

        }

        //}else{
        //	resultado.setMsg(msg);
        //}
        return resultado;

    }

    @Override
    public Resultado consultar(EntidadeDominio entidade) {
        resultado = new Resultado();

        String nmClasse = entidade.getClass().getName();

        //String msg = executarRegras(entidade, "CONSULTAR");
        //if(msg == null){
        IDAO dao = daos.get(nmClasse);
        if (dao instanceof EnderecoDAO) {
            try {
                if (((EnderecoDAO) dao).consultar_Cobranca_Por_Endereco(entidade) != null) {
                    resultado.setEntidade(((EnderecoDAO) dao).consultar_Cobranca_Por_Endereco(entidade));
                }
                if (((EnderecoDAO) dao).consultar_Entrega_Por_Endereco(entidade) != null) {
                    resultado.setEntidade(((EnderecoDAO) dao).consultar_Entrega_Por_Endereco(entidade));
                }
            } catch (SQLException e) {
                e.printStackTrace();
                resultado.setMsg("Não foi possível realizar o registro!");

            }

        } else {
            try {
                List<EntidadeDominio> entidades = dao.consultar(entidade);
                resultado.setEntidades(entidades);
            } catch (SQLException e) {
                e.printStackTrace();
                resultado.setMsg("Não foi possível realizar o registro!");

            }
        }
        return resultado;
    }

    @Override
    public Resultado visualizar(EntidadeDominio entidade
    ) {
        resultado = new Resultado();

        resultado.setEntidades(new ArrayList<EntidadeDominio>());
        resultado.getEntidades().add(entidade);
        return resultado;

    }

    @Override
    public Resultado listarfiltro(EntidadeDominio entidade
    ) {
        resultado = new Resultado();

        String nomeClasse = entidade.getClass().getName();
        //	String mensagem = executarRegras(entidade, "LISTARFILTRO");

        //if(mensagem == null){
        IDAO dao = daos.get(nomeClasse);

        try {
            resultado.setEntidades(dao.filtrar(entidade));

        } catch (Exception e) {
            e.printStackTrace();
            resultado.setMsg("Não foi possível realizar a consulta.");
        } //fim try/catch
        //} else {
        //	resultado.setMsg(mensagem);
        //} // fim if

        return resultado;
    }

}
