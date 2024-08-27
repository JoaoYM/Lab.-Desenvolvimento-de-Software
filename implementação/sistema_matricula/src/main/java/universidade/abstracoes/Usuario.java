package main.java.universidade.abstracoes;

public abstract class Usuario extends Object {
    private String  nome  = "";
    private String  login = "";
    private String  senha = "";

    public Usuario(String nome, String login, String senha) {
        super();
        this.nome   = nome;
        this.login  = login;
        this.senha  = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public String getLogin(){
        return this.login;
    }

    public void setLogin(String login){
        this.login = login;
    }
}