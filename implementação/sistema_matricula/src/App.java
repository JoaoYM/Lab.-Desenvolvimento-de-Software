import java.util.List;
import java.util.Scanner;

import main.java.universidade.curso.matricula.Disciplina;
import main.java.universidade.users.Aluno;
import main.java.universidade.users.Professor;
import main.java.universidade.users.Secretaria;
import main.java.universidade.utils.FileOperations;

public class App {
    public static void main(String[] args) throws Exception {

        menu();
        // Scanner scan = new Scanner(System.in);
        
        // System.out.println("Informe sua origem: \n" +
        //                     "(1) Aluno\n" +
        //                     "(2) Professor\n" +
        //                     "(3) Secretaria");

        // String origem = scan.nextLine();

        // switch (origem) {
        //     case "1":
        //         // Implementar a lógica para o Aluno aqui
        //         break;
        //     case "2":
        //         System.out.println("Login: ");
        //         String login = scan.nextLine();
        //         System.out.println("Senha: ");
        //         String senha = scan.nextLine();

        //         List<Object> usuarios = FileOperations.recuperarDados("./main/java/universidade/assets/secretaria.dat");

        //         Secretaria secretaria = (Secretaria) usuarios.get(0); // Assumindo que há apenas uma Secretaria no sistema

        //         if (!login.equals(secretaria.getLogin()) || !senha.equals(secretaria.getSenha())) {
        //             System.out.println("Login ou senha incorretos, verifique os dados informados e efetue uma nova tentativa");
        //         } else {
        //             System.out.println("[MENU]: \n" +
        //                     "(1) Gerenciar Alunos\n" +
        //                     "(2) Gerenciar Professores\n" +
        //                     "(3) Gerenciar Disciplinas\n" +
        //                     "(4) Gerar Curriculo Semestral\n");

        //             String opcao = scan.nextLine();

        //             switch (opcao) {
        //                 case "1":
        //                     System.out.println("[Gerenciador Discentes]: \n" +
        //                     "(1) Cadastrar Aluno\n" +
        //                     "(2) Deletar   Aluno\n" +
        //                     "(3) Atualizar cadastro discente\n" +
        //                     "(4) Listar alunos");

        //                     rotinasGerenciamento(String opcao, String operation)
        //                     break;

        //                 case "2":
        //                     System.out.println("[Gerenciador Docentes]: \n" +
        //                     "(1) Cadastrar Professor\n" +
        //                     "(2) Deletar   Professor\n" +
        //                     "(3) Atualizar cadastro docente" +
        //                     "(4) Listar professores");
        //                     rotinasGerenciamento(String opcao, String operation)
        //                     break;

        //                 case "3":
        //                     System.out.println("[Gerenciador Disciplinas]: \n" +
        //                     "(1) Cadastrar Disciplina\n" +
        //                     "(2) Deletar   Disciplina\n" +
        //                     "(3) Atualizar cadastro da Disciplina\n" +
        //                     "(4) Listar disciplinas");
        //                     rotinasGerenciamento(String opcao, String operation)
        //                     break;

        //                 case "4":
        //                     // Implementação para gerar currículo semestral
        //                     break;

        //                 default:
        //                     System.out.println("Opção inválida.");
        //                     break;
        //             }
        //         }
        //         break;

        //     case "3":
        //         // Implementar a lógica para a Secretaria aqui
        //         break;

        //     default:
        //         System.out.println("Opção inválida.");
        //         break;
        // }

        // scan.close();
    }

    private static void menu() {
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

    private static void rotinasGerenciamento(String entidade) {
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
                    // Implementar a lógica de atualização baseado em identificador
                    break;
                case 4:
                    // Implementar a lógica de deleção baseado em identificador
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }
}
