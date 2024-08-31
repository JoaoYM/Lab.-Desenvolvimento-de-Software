// package main.java.universidade.users;

// import java.io.Serializable;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Scanner;
// import main.java.universidade.abstracoes.Usuario;
// import main.java.universidade.curso.matricula.Disciplina;
// import main.java.universidade.utils.FileOperations;

// public class Aluno extends Usuario implements Serializable {
//     private static final long serialVersionUID = 1L;
//     private static final String ARQUIVO_ALUNOS = "./src/main/java/universidade/assets/alunos.dat";

//     private List<Integer> idsSessao;
//     private List<Disciplina> disciplinasObrigatorias;
//     private List<Disciplina> disciplinasOptativas;

//     // Construtor padrão necessário para a desserialização
//     public Aluno() {
//         super("", "", "");
//         this.idsSessao = new ArrayList<>();
//     }

//     public Aluno(String nome, String login, String senha, int idSessao) {
//         super(nome, login, senha);
//         this.idsSessao = new ArrayList<>();
//         this.idsSessao.add(idSessao);
//     }

//     // Método separado para criar aluno com interação
//     public static Aluno criarAlunoInterativo() {
//         Scanner scan = new Scanner(System.in);

//         System.out.println("Digite o nome: ");
//         String nome = scan.nextLine();
//         System.out.println("Digite o login: ");
//         String login = scan.nextLine();
//         System.out.println("Digite a senha: ");
//         String senha = scan.nextLine();

//         return new Aluno(nome, login, senha, 0); // Passando idSessao 0 por padrão, ou modifique conforme necessário
//     }

//     public void addSessao(int idSessao) {
//         this.idsSessao.add(idSessao);
//     }

//     public List<Integer> getIdsSessao() {
//         return idsSessao;
//     }

//     public void matricularEmDisciplina(Disciplina disciplina, boolean obrigatoria) {
//         if (obrigatoria) {
//             if (disciplinasObrigatorias.size() < 4 && !disciplinasObrigatorias.contains(disciplina)) {
//                 disciplinasObrigatorias.add(disciplina);
//                 disciplina.addAluno(this);
//             } else {
//                 System.out.println("Não é possível matricular em mais disciplinas obrigatórias.");
//             }
//         } else {
//             if (disciplinasOptativas.size() < 2 && !disciplinasOptativas.contains(disciplina)) {
//                 disciplinasOptativas.add(disciplina);
//                 disciplina.addAluno(this);
//             } else {
//                 System.out.println("Não é possível matricular em mais disciplinas optativas.");
//             }
//         }
//     }

//     public void cancelarMatricula(Disciplina disciplina) {
//         if (disciplinasObrigatorias.remove(disciplina) || disciplinasOptativas.remove(disciplina)) {
//             disciplina.removeAluno(this);
//         } else {
//             System.out.println("Matrícula não encontrada.");
//         }
//     }

//     //--------------------------------------------------------------------||
//     //                                  CRUD                              ||
//     //--------------------------------------------------------------------||

//     // Criar novo aluno
//     public static void criarAluno() {
//         List<Aluno> alunos = FileOperations.recuperarDados(ARQUIVO_ALUNOS);
//         Aluno novoAluno = criarAlunoInterativo();
//         alunos.add(novoAluno);
//         FileOperations.salvarDados(ARQUIVO_ALUNOS, alunos);
//     }

//     // Listar todos os alunos
//     public static void listarAlunos() {
//         List<Aluno> alunos = FileOperations.recuperarDados(ARQUIVO_ALUNOS);
//         for (Aluno aluno : alunos) {
//             System.out.println(aluno.getNome());
//         }
//     }

//     // Atualizar aluno
//     public static void atualizarAluno(Aluno alunoAtualizado) {
//         FileOperations.atualizarDado(ARQUIVO_ALUNOS, alunoAtualizado);
//     }

//     // Deletar aluno
//     public static void deletarAluno(Aluno aluno) {
//         FileOperations.deletarDado(ARQUIVO_ALUNOS, aluno);
//     }
// }

package main.java.universidade.users;

import main.java.universidade.abstracoes.Usuario;
import main.java.universidade.curso.matricula.Disciplina;
import main.java.universidade.utils.FileOperations;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aluno extends Usuario {
    private static final String ARQUIVO_ALUNOS = "./src/main/java/universidade/assets/alunos.txt";

    private List<Integer> idsSessao;
    private List<Disciplina> disciplinasObrigatorias = new ArrayList<>();
    private List<Disciplina> disciplinasOptativas = new ArrayList<>();

    public Aluno() {
        super("", "", "");
        this.idsSessao = new ArrayList<>();
    }

    public Aluno(int idSessao, String nome, String login, String senha) {
        super(nome, login, senha);
        this.idsSessao = new ArrayList<>();
        this.idsSessao.add(idSessao);
    }

    public static Aluno criarAlunoInterativo() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o nome: ");
        String nome = scan.nextLine();
        System.out.println("Digite o login: ");
        String login = scan.nextLine();
        System.out.println("Digite a senha: ");
        String senha = scan.nextLine();

        return new Aluno(0, nome, login, senha); 
    }

    public void addSessao(int idSessao) {
        this.idsSessao.add(idSessao);
    }

    public List<Integer> getIdsSessao() {
        return idsSessao;
    }

    public void matricularEmDisciplina(Disciplina disciplina, boolean obrigatoria) {
        if (obrigatoria) {
            if (disciplinasObrigatorias.size() < 4 && !disciplinasObrigatorias.contains(disciplina)) {
                disciplinasObrigatorias.add(disciplina);
                disciplina.addAluno(this);
            } else {
                System.out.println("Não é possível matricular em mais disciplinas obrigatórias.");
            }
        } else {
            if (disciplinasOptativas.size() < 2 && !disciplinasOptativas.contains(disciplina)) {
                disciplinasOptativas.add(disciplina);
                disciplina.addAluno(this);
            } else {
                System.out.println("Não é possível matricular em mais disciplinas optativas.");
            }
        }
    }

    public void cancelarMatricula(Disciplina disciplina) {
        if (disciplinasObrigatorias.remove(disciplina) || disciplinasOptativas.remove(disciplina)) {
            disciplina.removeAluno(this);
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

    public static int getTotalAlunos() {

        List<Aluno> alunos = FileOperations.recuperarObjetos(ARQUIVO_ALUNOS, Aluno.class);
        
        return alunos.size();
    }

    public static void atualizarAluno(Aluno alunoAtualizado) {
        FileOperations.atualizarObjeto(ARQUIVO_ALUNOS, alunoAtualizado, Aluno.class);
    }

    public static void deletarAluno(Aluno aluno) {
        FileOperations.deletarObjeto(ARQUIVO_ALUNOS, aluno, Aluno.class);
    }

    @Override
    public String toString() {
        
        return (getTotalAlunos() + 1) + "," + getNome() + "," + getLogin() + "," + getSenha() + ",";
    }

    public static Aluno fromString(String data) {
        String[] splitData = data.split(",");
        Aluno aluno = new Aluno(Integer.parseInt(splitData[0]), splitData[1], splitData[2], splitData[3]);
        return aluno;
    }
}
