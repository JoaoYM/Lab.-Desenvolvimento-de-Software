package main.java.universidade.users;

import main.java.universidade.abstracoes.Usuario;
import main.java.universidade.curso.matricula.Disciplina;
import main.java.universidade.curso.matricula.Turma;
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

    //public void adicionarDisciplina(Disciplina disciplina) {
        //if (!disciplinasLecionadas.contains(disciplina)) {
            //disciplinasLecionadas.add(disciplina);
        //} else {
            //System.out.println("Disciplina já está sendo lecionada por este professor.");
        //}
    //}

    public void adicionarDisciplina(Disciplina disciplina) {
        Turma novaTurma = new Turma(disciplina, this);
        this.disciplinasLecionadas.add(disciplina);
        disciplina.setProfessorResponsavel(this); // Define o professor responsável
        disciplina.addTurma(novaTurma); // Adiciona a nova turma à lista de turmas da disciplina
    }
    

    public void removerDisciplina(Disciplina disciplina) {
        Turma turma = null;
    
        for (Turma t : disciplina.getTurmas()) { // Assuming Disciplina has a list of Turmas
            if (t.getProfessorResponsavel().equals(this)) {
                turma = t;
                break;
            }
        }
    
        if (turma != null) {
            this.disciplinasLecionadas.remove(disciplina);
            disciplina.getTurmas().remove(turma); // Remove the Turma from the discipline
            System.out.println("Disciplina removida com sucesso.");
        } else {
            System.out.println("Disciplina não encontrada para este professor.");
        }
    }

    //public void removerDisciplina(Disciplina disciplina) {
        //if (disciplinasLecionadas.remove(disciplina)) {
            //System.out.println("Disciplina removida da lista de lecionadas.");
        //} else {
            //System.out.println("Disciplina não encontrada na lista de lecionadas.");
        //}
    //}

    public void listarDisciplinasLecionadas() {
        if (disciplinasLecionadas.isEmpty()) {
            System.out.println("Este professor não está lecionando nenhuma disciplina no momento.");
        } else {
            System.out.println("Disciplinas lecionadas pelo professor " + getNome() + ":");
            for (Disciplina disciplina : disciplinasLecionadas) {
                System.out.println("- " + disciplina.getNome());
            }
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

