package main.java.universidade.users;

import main.java.universidade.abstracoes.Usuario;
import main.java.universidade.curso.Curriculo;
import main.java.universidade.curso.matricula.Disciplina;
import main.java.universidade.utils.FileOperations;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Secretaria implements Usuario {
    private static final String ARQUIVO_SECRETARIAS = "implementação/sistema_matricula/src/main/java/universidade/assets/secretarias.txt";

    private String nome;
    private String login;
    private String senha;

    public Secretaria(String nome, String login, String senha, int idSessao) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public static Secretaria autenticar(String login, String senha) {
        List<Secretaria> secretarias = FileOperations.recuperarObjetos(ARQUIVO_SECRETARIAS, Secretaria.class);
        for (Secretaria secretaria : secretarias) {
            if (secretaria.getLogin().equals(login) && secretaria.getSenha().equals(senha)) {
                return secretaria;
            }
        }
        return null;
    }

    
    // -----------------------------------------------------------------------|
    //                                    CRUD                                |   
    // -----------------------------------------------------------------------|

    public Aluno cadastrarAluno() {
        return new Aluno();
    }

    public Professor cadastrarProfessor() {
        return new Professor();
    }

    public Disciplina cadastrarDisciplina(){
        return new Disciplina();
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String getSenha() {
        return senha;
    }

    @Override
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
