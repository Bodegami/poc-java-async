package br.com.bode.springasync.cadastro.dto;

import br.com.bode.springasync.cadastro.model.Cliente;

import java.io.Serializable;

public class ClienteResponse implements Serializable {

    private Long id;
    private String nome;
    private String sobrenome;
    private String telefone;
    private EnderecoResponse endereco;


    public ClienteResponse(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.sobrenome = cliente.getSobrenome();
        this.telefone = cliente.getTelefone();
        this.endereco = new EnderecoResponse(cliente.getEndereco());
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

    public EnderecoResponse getEndereco() {
        return endereco;
    }
}
