import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.GroupLayout.Alignment;

import main.java.universidade.aluno.Matricula;
import main.java.universidade.curso.matricula.Disciplina;
import main.java.universidade.users.Aluno;
import main.java.universidade.users.Professor;
import main.java.universidade.users.Secretaria;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selecione sua origem:");
        System.out.println("1. Professor");
        System.out.println("2. Aluno");
        System.out.println("3. Secretaria");
        int origem = Integer.parseInt(scanner.nextLine());

        System.out.println("Digite o login:");
        String login = scanner.nextLine();
        System.out.println("Digite a senha:");
        String senha = scanner.nextLine();

        switch (origem) {
            case 1:
                Professor professor = Professor.autenticar(login, senha);
                if (professor != null) {
                    menuProfessor(professor);
                } else {
                    System.out.println("Login ou senha incorretos.");
                }
                break;
            case 2:
                Aluno aluno = Aluno.autenticar(login, senha);
                if (aluno != null) {
                    menuAluno(aluno);
                } else {
                    System.out.println("Login ou senha incorretos.");
                }
                break;
            case 3:
                if (Secretaria.autenticar(login, senha)) {
                    menuSecretaria();
                } else {
                    System.out.println("Login ou senha incorretos.");
                }
                break;
            default:
                System.out.println("Origem inválida.");
        }
    }

    private static void menuSecretaria() throws Exception {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nSistema de Gestão Universitária");
            System.out.println("1. Gerenciar Alunos");
            System.out.println("2. Gerenciar Professores");
            System.out.println("3. Gerenciar Disciplinas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: \n");

            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    rotinasGerenciamento("Aluno");
                    break;
                case 2:
                    rotinasGerenciamento("Professor");
                    break;
                case 3:
                    rotinasGerenciamento("Disciplina");
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void rotinasGerenciamento(String entidade) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nGerenciamento de " + entidade + "s");
            System.out.println("1. Criar " + entidade);
            System.out.println("2. Listar " + entidade + "s");
            System.out.println("3. Atualizar " + entidade);
            System.out.println("4. Deletar " + entidade);
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: \n");
            opcao = Integer.parseInt(scanner.nextLine());


            switch (opcao) {
                case 1:
                    if (entidade.equals("Aluno")) {
                        Aluno.criarAluno();
                    } else if (entidade.equals("Professor")) {
                        Professor.criarProfessor();
                    } else if (entidade.equals("Disciplina")) {
                        Disciplina.criarDisciplina();
                    }
                    break;
                case 2:
                    if (entidade.equals("Aluno")) {
                        Aluno.listarAlunos();
                    } else if (entidade.equals("Professor")) {
                        Professor.listarProfessores();
                    } else if (entidade.equals("Disciplina")) {
                        Disciplina.listarDisciplinas();
                    }
                    break;
                case 3:
                    if (entidade.equals("Aluno")) {
                        Aluno.atualizarAluno(new Aluno());;
                    } else if (entidade.equals("Professor")) {
                        Professor.atualizarProfessor(new Professor());
                    } else if (entidade.equals("Disciplina")) {
                        Disciplina.atualizarDisciplina(new Disciplina());;
                    }
                    break;
                case 4:
                    if (entidade.equals("Aluno")) {
                        Aluno.deletarAluno(new Aluno());
                    } else if (entidade.equals("Professor")) {
                        Professor.deletarProfessor(new Professor());
                    } else if (entidade.equals("Disciplina")) {
                        Disciplina.deletarDisciplina(new Disciplina());
                    }
                    break;
                case 0:
                    System.out.println("Voltando ao menuSecretaria principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void menuProfessor(Professor professor) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu do Professor");
            System.out.println("1. Listar Disciplinas Lecionadas");
            System.out.println("2. Adicionar Disciplina");
            System.out.println("3. Remover Disciplina");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: \n");

            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    break;
                case 2:
                 
                case 3:
                    
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void menuAluno(Aluno aluno) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu do Aluno");
            System.out.println("1. Criar Matricula");
            System.out.println("2. Cancelar Matrícula");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: \n");

            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    Matricula.criarMatricula(aluno);
                    break;
                case 2:
                    System.out.println("Digite o nome da disciplina para cancelar matrícula:");
                    String disciplinaDesmatricula = scanner.nextLine();
                    Disciplina disciplinaDesmatricular = buscarDisciplinaPorNome(disciplinaDesmatricula);
                    if (disciplinaDesmatricular != null) {
                        //disciplinaDesmatricular.desmatricularAluno(aluno);
                    } else {
                        System.out.println("Disciplina não encontrada.");
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static Disciplina buscarDisciplinaPorNome(String nome) {
        List<Disciplina> disciplinas = Disciplina.listarDisciplinasList();
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getNome().equals(nome)) {
                return disciplina;
            }
        }
        return null;
    }
}
