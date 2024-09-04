package main.java.universidade.users;

import main.java.universidade.abstracoes.Usuario;
import main.java.universidade.curso.matricula.Disciplina;
import main.java.universidade.utils.FileOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aluno implements Usuario {
    private static final String ARQUIVO_ALUNOS = "./Lab.-Desenvolvimento-de-Software/implementação/sistema_matricula/src/main/java/universidade/assets/alunos.txt";


    private String nome;
    private String login;
    private String senha;


    public Aluno() {
        this("", "", "");
    }

    public Aluno(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public static Aluno criarAlunoInterativo() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o nome: ");
        String nome = scan.nextLine();
        System.out.println("Digite o login: ");
        String login = scan.nextLine();
        System.out.println("Digite a senha: ");
        String senha = scan.nextLine();

        return new Aluno(nome, login, senha);
    }

    public static void criarAluno() {
        Aluno novoAluno = criarAlunoInterativo();
        FileOperations.salvarObjeto(ARQUIVO_ALUNOS, novoAluno);
    }

    public static void listarAlunosByIndex() {
        List<Aluno> alunos = FileOperations.recuperarObjetos(ARQUIVO_ALUNOS, Aluno.class);
        int index = 0;
        for (Aluno aluno : alunos) {
            System.out.println("[" + index++ + "]" + aluno.getNome());
        }
    }

    public static Aluno obterAlunoByIndex(int index) {
        
        List<Aluno> alunos = FileOperations.recuperarObjetos(ARQUIVO_ALUNOS, Aluno.class);
        
        int currentIndex = 0;

        for (Aluno aluno : alunos) {
            if(currentIndex == index){
                return aluno;
            }

            currentIndex++;
        }

        return null;
    }

    public static void listarAlunos() {
        List<Aluno> alunos = FileOperations.recuperarObjetos(ARQUIVO_ALUNOS, Aluno.class);
        for (Aluno aluno : alunos) {
            System.out.println(aluno.getNome());
        }
    }

    public static void atualizarAluno(Aluno alunoAtualizado, Aluno alunoOriginal) {
        FileOperations.atualizarObjeto(ARQUIVO_ALUNOS, alunoAtualizado, alunoOriginal, Aluno.class);
    }

    public static void deletarAluno(Aluno aluno) {
        FileOperations.deletarObjeto(ARQUIVO_ALUNOS, aluno, Aluno.class);
    }

    @Override
    public String toString() {
        return getNome() + "," + getLogin() + "," + getSenha();
    }

    public static Aluno fromString(String data) {
        String[] splitData = data.split(",");
        return new Aluno(splitData[0], splitData[1], splitData[2]);
    }

    public static Aluno autenticar(String login, String senha) {
        List<Aluno> alunos = FileOperations.recuperarObjetos(ARQUIVO_ALUNOS, Aluno.class);
        for (Aluno aluno : alunos) {
            if (aluno.getLogin().equals(login) && aluno.getSenha().equals(senha)) {
                return aluno;
            }
        }
        return null;
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