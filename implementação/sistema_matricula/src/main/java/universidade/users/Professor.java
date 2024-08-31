// package main.java.universidade.users;

// import java.io.Serializable;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Scanner;

// import main.java.universidade.abstracoes.Usuario;
// import main.java.universidade.curso.matricula.Disciplina;
// import main.java.universidade.utils.FileOperations;

// public class Professor extends Usuario implements Serializable {
//     private static final long serialVersionUID = 1L;
//     private static final String ARQUIVO_PROFESSORES = "./arquivos/professores.dat";

//     private List<Integer> idsSessao;
//     private List<Disciplina> disciplinasObrigatorias;
//     private List<Disciplina> disciplinasOptativas;

//     public Professor(String nome, String login, String senha, int idSessao) {
//         super(nome, login, senha);
//         this.idsSessao = new ArrayList<>();
//         this.idsSessao.add(idSessao);
//     }

//     public Professor() {
//         super("", "", "");
//         Scanner scan = new Scanner(System.in);

//         System.out.println("Digite o nome: ");
//         String nome = scan.nextLine();
//         System.out.println("Digite o login: ");
//         String login = scan.nextLine();
//         System.out.println("Digite a senha: ");
//         String senha = scan.nextLine();

//         setNome(nome);
//         setLogin(login);
//         setSenha(senha);

//         this.idsSessao = new ArrayList<>();
//     }

//     public void addSessao(int idSessao) {
//         this.idsSessao.add(idSessao);
//     }

//     public List<Integer> getIdsSessao() {
//         return idsSessao;
//     }

//     public List<Aluno> visualizarMatriculas(Disciplina disciplina) {
//         // Implementação do método para visualizar matrículas
//         return null;
//     }

//     //--------------------------------------------------------------------||
//     //                                  CRUD                              ||
//     //--------------------------------------------------------------------||

//     // Criar novo professor
//     public static void criarProfessor() {
//         List<Professor> professores = FileOperations.recuperarDados(ARQUIVO_PROFESSORES);
//         Professor novoProfessor = new Professor();
//         professores.add(novoProfessor);
//         FileOperations.salvarDados(ARQUIVO_PROFESSORES, professores);
//     }

//     // Listar todos os professores
//     public static void listarProfessores() {
//         List<Professor> professores = FileOperations.recuperarDados(ARQUIVO_PROFESSORES);
//         for (Professor professor : professores) {
//             System.out.println(professor.getNome());
//         }
//     }

//     // Atualizar professor
//     public static void atualizarProfessor(Professor professorAtualizado) {
//         FileOperations.atualizarDado(ARQUIVO_PROFESSORES, professorAtualizado);
//     }

//     // Deletar professor
//     public static void deletarProfessor(Professor professor) {
//         FileOperations.deletarDado(ARQUIVO_PROFESSORES, professor);
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

public class Professor extends Usuario {
    private static final String ARQUIVO_PROFESSORES = "./src/main/java/universidade/assets/professores.txt";

    private List<Integer> idsSessao = new ArrayList<>();
    private List<Disciplina> disciplinasObrigatorias = new ArrayList<>();
    private List<Disciplina> disciplinasOptativas = new ArrayList<>();

    public Professor() {
        super("", "", "");
    }

    public Professor(String nome, String login, String senha, int idSessao) {
        super(nome, login, senha);
        this.idsSessao.add(idSessao);
    }

    public void addSessao(int idSessao) {
        this.idsSessao.add(idSessao);
    }

    public List<Integer> getIdsSessao() {
        return idsSessao;
    }

    public List<Aluno> visualizarMatriculas(Disciplina disciplina) {
        return disciplina.getAlunosInscritos();
    }

    public static void criarProfessor() {
        Professor novoProfessor = new Professor();
        FileOperations.salvarObjeto(ARQUIVO_PROFESSORES, novoProfessor);
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
        return getNome() + "," + getLogin() + "," + getSenha() + "," + idsSessao.toString();
    }

    public static Professor fromString(String data) {
        String[] splitData = data.split(",");
        Professor professor = new Professor(splitData[0], splitData[1], splitData[2], Integer.parseInt(splitData[3]));
        return professor;
    }
}
