package br.com.turismo.dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author hisak
 */

public class Cliente extends EntidadeDominio{
    
    private String nome;
    private String cpf;
    private String senha;
    private String email;
    private boolean status;
    
   
    private Date dtNascimento;
    
  
    private List<CartaoCredito> cartaoCredito = new ArrayList<>();
    
   
    private Endereco endereco;

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

   

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public List<CartaoCredito> getCartaoCredito() {
        return cartaoCredito;
    }

    public void setCartaoCredito(List<CartaoCredito> cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    
}
