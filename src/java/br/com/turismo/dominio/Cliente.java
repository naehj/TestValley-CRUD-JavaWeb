package br.com.turismo.dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author hisak
 */
public class Cliente extends EntidadeDominio {

    private String nome;
    private String cpf;
    private String senha;
    private String email;
    private String genero;
    private Endereco end_de_cobranca = new Endereco();
    private HashSet<Endereco> end_de_entrega = new HashSet<>();
    private Date dtNascimento;
    private HashSet<CartaoCredito> cartaoCredito = new HashSet<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public HashSet<CartaoCredito> getCartaoCredito() {
        return cartaoCredito;
    }

    public void setCartaoCredito(HashSet<CartaoCredito> cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }

    public Endereco getEnd_De_Cobranca() {
        return end_de_cobranca;
    }

    public void setEnd_De_Cobranca(Endereco end_de_cobranca) {
        this.end_de_cobranca = end_de_cobranca;
    }

    public HashSet<Endereco> getEnd_De_Entrega() {
        return end_de_entrega;
    }

    public void setEnd_De_Entrega(HashSet<Endereco> end_de_entrega) {
        this.end_de_entrega = end_de_entrega;
    }

}
