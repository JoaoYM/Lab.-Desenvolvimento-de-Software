package main.java.universidade.users;

import main.java.universidade.abstracoes.Usuario;
import main.java.universidade.curso.matricula.Disciplina;
import main.java.universidade.utils.FileOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Professor extends Usuario {
    private static final String ARQUIVO_PROFESSORES = "./src/main/java/universidade/assets/professores.txt";

    private List<Disciplina> disciplinasLecionadas;

    public Professor() {
        super("", "", "");
        this.disciplinasLecionadas = new ArrayList<>();
    }

    public Professor(String nome, String login, String senha) {
        super(nome, login, senha);
        this.disciplinasLecionadas = new ArrayList<>();
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        if (!disciplinasLecionadas.contains(disciplina)) {
            disciplinasLecionadas.add(disciplina);
        } else {
            System.out.println("Disciplina já está sendo lecionada por este professor.");
        }
    }

    public void removerDisciplina(Disciplina disciplina) {
        if (disciplinasLecionadas.remove(disciplina)) {
            System.out.println("Disciplina removida da lista de lecionadas.");
        } else {
            System.out.println("Disciplina não encontrada na lista de lecionadas.");
        }
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

    public static void listarProfessores() {
        List<Professor> professores = FileOperations.recuperarObjetos(ARQUIVO_PROFESSORES, Professor.class);
        for (Professor professor : professores) {
            System.out.println(professor.getNome());
        }
    }

    public static void atualizarProfessor(Professor professorAtualizado) {
        FileOperations.atualizarObjeto(ARQUIVO_PROFESSORES, professorAtualizado, Professor.class);
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

    public static boolean autenticar(String login, String senha) {
        // List<Secretaria> secretarias = FileOperations.recuperarObjetos(ARQUIVO_SECRETARIA, Aluno.class);
        // for (Aluno aluno : secretarias) {
        //     if (aluno.getLogin().equals(login) && aluno.getSenha().equals(senha)) {
        //         return true;
        //     }
        // }
        return false;
    }
}
