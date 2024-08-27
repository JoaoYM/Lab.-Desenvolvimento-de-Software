// package main.java.universidade.curso.matricula;

// import main.java.universidade.users.Aluno;
// import main.java.universidade.users.Professor;
// import main.java.universidade.utils.FileOperations;

// import java.io.*;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Scanner;

// public class Disciplina {
//     private static final String ARQUIVO_DISCIPLINAS = "./src/main/java/universidade/assets/disciplinas.txt";

//     private String nome;
//     private int numeroMinimoAlunos;
//     private int numeroMaximoAlunos;
//     private int cargaHoraria;
//     private List<Aluno> alunosInscritos;
//     private List<Disciplina> preRequisitos;
//     private List<Disciplina> coRequisitos;
//     private Professor professorResponsavel;

//     public Disciplina(String nome, int cargaHoraria) {
//         this.nome = nome;
//         this.cargaHoraria = cargaHoraria;
//         this.numeroMinimoAlunos = 3;
//         this.numeroMaximoAlunos = 60;
//         this.alunosInscritos = new ArrayList<>();
//         this.preRequisitos = new ArrayList<>();
//         this.coRequisitos = new ArrayList<>();
//     }

//     public Disciplina() {
//         Scanner scan = new Scanner(System.in);

//         System.out.println("Digite o nome: ");
//         this.nome = scan.nextLine();
//         System.out.println("Digite a carga horária: ");
//         this.cargaHoraria = Integer.parseInt(scan.nextLine());

//         this.numeroMinimoAlunos = 3;
//         this.numeroMaximoAlunos = 60;
//         this.alunosInscritos = new ArrayList<>();
//         this.preRequisitos = new ArrayList<>();
//         this.coRequisitos = new ArrayList<>();
//     }

//     public void addAluno(Aluno aluno) {
//         if (alunosInscritos.size() < numeroMaximoAlunos) {
//             alunosInscritos.add(aluno);
//             System.out.println("Aluno adicionado à disciplina: " + nome);
//         } else {
//             System.out.println("Não é possível adicionar mais alunos. Limite atingido.");
//         }
//     }

//     public void removeAluno(Aluno aluno) {
//         if (alunosInscritos.remove(aluno)) {
//             System.out.println("Aluno removido da disciplina: " + nome);
//         } else {
//             System.out.println("Aluno não está matriculado nesta disciplina.");
//         }
//     }

//     public List<Aluno> getAlunosInscritos() {
//         return alunosInscritos;
//     }

//     public String getNome() {
//         return this.nome;
//     }

//     //--------------------------------------------------------------------||
//     //                                  CRUD                              ||
//     //--------------------------------------------------------------------||

//     // Criar nova disciplina
//     public static void criarDisciplina() {
//         Disciplina novaDisciplina = new Disciplina();
//         FileOperations.salvarObjeto(ARQUIVO_DISCIPLINAS, novaDisciplina);
//     }

//     // Listar todas as disciplinas
//     public static void listarDisciplinas() {
//         List<Disciplina> disciplinas = FileOperations.recuperarObjetos(ARQUIVO_DISCIPLINAS, Disciplina.class);
//         for (Disciplina disciplina : disciplinas) {
//             System.out.println(disciplina.getNome());
//         }
//     }

//     // Atualizar disciplina
//     public static void atualizarDisciplina(Disciplina disciplinaAtualizada) {
//         FileOperations.atualizarObjeto(ARQUIVO_DISCIPLINAS, disciplinaAtualizada, Disciplina.class);
//     }

//     // Deletar disciplina
//     public static void deletarDisciplina(Disciplina disciplina) {
//         FileOperations.deletarObjeto(ARQUIVO_DISCIPLINAS, disciplina, Disciplina.class);
//     }

//     @Override
//     public String toString() {
//         return nome + "," + cargaHoraria + "," + numeroMinimoAlunos + "," + numeroMaximoAlunos;
//     }

//     public static Disciplina fromString(String data) {
//         String[] splitData = data.split(",");
//         Disciplina disciplina = new Disciplina(splitData[0], Integer.parseInt(splitData[1]));
//         disciplina.numeroMinimoAlunos = Integer.parseInt(splitData[2]);
//         disciplina.numeroMaximoAlunos = Integer.parseInt(splitData[3]);
//         return disciplina;
//     }
// }


package main.java.universidade.curso.matricula;

import main.java.universidade.users.Aluno;
import main.java.universidade.users.Professor;
import main.java.universidade.utils.FileOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Disciplina {
    private static final String ARQUIVO_DISCIPLINAS = "./src/main/java/universidade/assets/disciplinas.txt";

    private String nome;
    private int cargaHoraria;
    private int ano;
    private int semestre;
    private Turma turma;
    private List<Disciplina> preRequisitos;
    private List<Disciplina> coRequisitos;
    private Professor professorResponsavel;

    public Disciplina(String nome, int cargaHoraria) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.preRequisitos = new ArrayList<>();
        this.coRequisitos = new ArrayList<>();
        this.turma = new Turma(this);
    }

    public Disciplina() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite o nome: ");
        this.nome = scan.nextLine();
        System.out.println("Digite a carga horária: ");
        this.cargaHoraria = Integer.parseInt(scan.nextLine());

        this.preRequisitos = new ArrayList<>();
        this.coRequisitos = new ArrayList<>();
        this.turma = new Turma(this);
    }

    public void matricularAluno(Aluno aluno) {
        if (turma.getNumeroDeAlunos() < turma.getNumeroMaximoAlunos()) {
            turma.addAluno(aluno);
            System.out.println("Aluno matriculado na disciplina: " + nome);
        } else {
            System.out.println("Não é possível matricular mais alunos. Limite atingido.");
        }
    }

    public void desmatricularAluno(Aluno aluno) {
        if (turma.removeAluno(aluno)) {
            System.out.println("Aluno desmatriculado da disciplina: " + nome);
        } else {
            System.out.println("Aluno não está matriculado nesta disciplina.");
        }
    }

    public Turma getTurma() {
        return turma;
    }

    public String getNome() {
        return this.nome;
    }

    // Métodos CRUD

    public static void criarDisciplina() {
        Disciplina novaDisciplina = new Disciplina();
        FileOperations.salvarObjeto(ARQUIVO_DISCIPLINAS, novaDisciplina);
    }

    public static void listarDisciplinas() {
        List<Disciplina> disciplinas = FileOperations.recuperarObjetos(ARQUIVO_DISCIPLINAS, Disciplina.class);
        for (Disciplina disciplina : disciplinas) {
            System.out.println(disciplina.getNome());
        }
    }

    public static void atualizarDisciplina(Disciplina disciplinaAtualizada) {
        FileOperations.atualizarObjeto(ARQUIVO_DISCIPLINAS, disciplinaAtualizada, Disciplina.class);
    }

    public static void deletarDisciplina(Disciplina disciplina) {
        FileOperations.deletarObjeto(ARQUIVO_DISCIPLINAS, disciplina, Disciplina.class);
    }

    @Override
    public String toString() {
        return nome + "," + cargaHoraria + "," + turma.getNumeroMinimoAlunos() + "," + turma.getNumeroMaximoAlunos();
    }

    public static Disciplina fromString(String data) {
        String[] splitData = data.split(",");
        Disciplina disciplina = new Disciplina(splitData[0], Integer.parseInt(splitData[1]));
        return disciplina;
    }
}
