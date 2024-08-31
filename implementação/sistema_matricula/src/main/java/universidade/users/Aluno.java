package main.java.universidade.users;

import main.java.universidade.abstracoes.Usuario;
import main.java.universidade.curso.matricula.Disciplina;
import main.java.universidade.utils.FileOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aluno extends Usuario {
    private static final String ARQUIVO_ALUNOS = "./src/main/java/universidade/assets/alunos.txt";

    private List<Disciplina> disciplinasObrigatorias;
    private List<Disciplina> disciplinasOptativas;

    public Aluno() {
        super("", "", "");
        this.disciplinasObrigatorias = new ArrayList<>();
        this.disciplinasOptativas = new ArrayList<>();
    }

    public Aluno(String nome, String login, String senha) {
        super(nome, login, senha);
        this.disciplinasObrigatorias = new ArrayList<>();
        this.disciplinasOptativas = new ArrayList<>();
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

    public void matricularEmDisciplina(Disciplina disciplina, boolean obrigatoria) {
        if (obrigatoria) {
            if (disciplinasObrigatorias.size() < 4 && !disciplinasObrigatorias.contains(disciplina)) {
                disciplinasObrigatorias.add(disciplina);
                disciplina.matricularAluno(this);
            } else {
                System.out.println("Não é possível matricular em mais disciplinas obrigatórias.");
            }
        } else {
            if (disciplinasOptativas.size() < 2 && !disciplinasOptativas.contains(disciplina)) {
                disciplinasOptativas.add(disciplina);
                disciplina.matricularAluno(this);
            } else {
                System.out.println("Não é possível matricular em mais disciplinas optativas.");
            }
        }
    }

    public void cancelarMatricula(Disciplina disciplina) {
        if (disciplinasObrigatorias.remove(disciplina) || disciplinasOptativas.remove(disciplina)) {
            disciplina.desmatricularAluno(this);
        } else {
            System.out.println("Matrícula não encontrada.");
        }
    }

    public static void criarAluno() {
        Aluno novoAluno = criarAlunoInterativo();
        FileOperations.salvarObjeto(ARQUIVO_ALUNOS, novoAluno);
    }

    public static void listarAlunos() {
        List<Aluno> alunos = FileOperations.recuperarObjetos(ARQUIVO_ALUNOS, Aluno.class);
        for (Aluno aluno : alunos) {
            System.out.println(aluno.getNome());
        }
    }

    public static void atualizarAluno(Aluno alunoAtualizado) {
        FileOperations.atualizarObjeto(ARQUIVO_ALUNOS, alunoAtualizado, Aluno.class);
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

    public static boolean autenticar(String login, String senha) {
        List<Aluno> alunos = FileOperations.recuperarObjetos(ARQUIVO_ALUNOS, Aluno.class);
        for (Aluno aluno : alunos) {
            if (aluno.getLogin().equals(login) && aluno.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }
}