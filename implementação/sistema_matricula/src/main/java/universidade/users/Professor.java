package main.java.universidade.users;

import main.java.universidade.abstracoes.Usuario;
import main.java.universidade.curso.matricula.Disciplina;
import main.java.universidade.curso.matricula.Turma;
import main.java.universidade.utils.FileOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Professor implements Usuario {
    private static final String ARQUIVO_PROFESSORES = "./Lab.-Desenvolvimento-de-Software/implementação/sistema_matricula/src/main/java/universidade/assets/professores.txt";

    private String nome;
    private String login;
    private String senha;
    
    public Professor() {
        this("", "", "");
    }

    public Professor(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public static void criarProfessor() {
        Professor novoProfessor = criarProfessorInterativo();
        FileOperations.salvarObjeto(ARQUIVO_PROFESSORES, novoProfessor);
    }

    public static Professor criarProfessorInterativo() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o nome: ");
        String nome = scan.nextLine();
        System.out.println("Digite o login: ");
        String login = scan.nextLine();
        System.out.println("Digite a senha: ");
        String senha = scan.nextLine();

        return new Professor(nome, login, senha);
    }

    public static void listarProfessoresByIndex() {
        List<Professor> professores = FileOperations.recuperarObjetos(ARQUIVO_PROFESSORES, Professor.class);
       
        int index = 0;
        
        for (Professor professor : professores) {
            System.out.println("[" + index++ + "]" + professor.getNome());
        }
    }

    public static Professor obterProfessorByIndex(int index) {
        
        List<Professor> professores = FileOperations.recuperarObjetos(ARQUIVO_PROFESSORES, Professor.class);
        
        int currentIndex = 0;

        for (Professor professor : professores) {
            if(currentIndex == index){
                return professor;
            }

            currentIndex++;
        }

        return null;
    }

    public static void listarProfessores() {
        List<Professor> professores = FileOperations.recuperarObjetos(ARQUIVO_PROFESSORES, Professor.class);
        for (Professor professor : professores) {
            System.out.println(professor.getNome());
        }
    }

    public static void atualizarProfessor(Professor professorAtualizado, Professor professorOriginal) {
        FileOperations.atualizarObjeto(ARQUIVO_PROFESSORES, professorAtualizado, professorOriginal, Professor.class);
    }

    public static void deletarProfessor(Professor professor) {
        FileOperations.deletarObjeto(ARQUIVO_PROFESSORES, professor, Professor.class);
    }

    @Override
    public String toString() {
        return getNome() + "," + getLogin() + "," + getSenha();
    }

    public static Professor fromString(String data) {
        String[] splitData = data.split(",");
        return new Professor(splitData[0], splitData[1], splitData[2]);
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

    public static Professor autenticar(String login, String senha) {
        List<Professor> professores = FileOperations.recuperarObjetos(ARQUIVO_PROFESSORES, Professor.class);
        for (Professor professor : professores) {
            if (professor.getLogin().equals(login) && professor.getSenha().equals(senha)) {
                return professor;
            }
        }
        return null; // Retorna null se a autenticação falhar
    }
    
}

