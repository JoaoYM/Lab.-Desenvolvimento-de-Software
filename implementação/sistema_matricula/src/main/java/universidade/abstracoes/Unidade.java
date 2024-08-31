package main.java.universidade.abstracoes;

import java.util.List;

public abstract class Unidade extends Object {
    private String nome = "";
    private List<Usuario> pessoas;

    public Unidade(String nome) {
        super();
    }

    public void adicionarPessoa(Usuario pessoa) {
        this.pessoas.add(pessoa);
    }

    public List<Usuario> getPessoas() {
        return pessoas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
