// package main.java.universidade.curso.matricula;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Scanner;

// import main.java.universidade.users.Aluno;
// import main.java.universidade.users.Professor;
// import main.java.universidade.utils.FileOperations;

// public class Disciplina {
//     private static final String ARQUIVO_DISCIPLINAS = "./main/java/universidade/assets/disciplinas.dat";

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

//     private String getNome() {
//         return this.nome;
//     }

//     //--------------------------------------------------------------------||
//     //                                  CRUD                              ||
//     //--------------------------------------------------------------------||

//     // Criar nova disciplina
//     public static void criarDisciplina() {
//         List<Disciplina> disciplinas = FileOperations.recuperarDados(ARQUIVO_DISCIPLINAS);
//         Disciplina novaDisciplina = new Disciplina();
//         disciplinas.add(novaDisciplina);
//         FileOperations.salvarDados(ARQUIVO_DISCIPLINAS, disciplinas);
//     }

//     // Listar todas as disciplinas
//     public static void listarDisciplinas() {
//         List<Disciplina> disciplinas = FileOperations.recuperarDados(ARQUIVO_DISCIPLINAS);
//         for (Disciplina disciplina : disciplinas) {
//             System.out.println(disciplina.getNome());
//         }
//     }

//     // Atualizar disciplina
//     public static void atualizarDisciplina(Disciplina disciplinaAtualizada) {
//         FileOperations.atualizarDado(ARQUIVO_DISCIPLINAS, disciplinaAtualizada);
//     }

//     // Deletar disciplina
//     public static void deletarDisciplina(Disciplina disciplina) {
//         FileOperations.deletarDado(ARQUIVO_DISCIPLINAS, disciplina);
//     }
    
//     // Implementações para pré-requisitos e co-requisitos, se necessário
// }

package main.java.universidade.curso.matricula;

import main.java.universidade.users.Aluno;
import main.java.universidade.users.Professor;
import main.java.universidade.utils.FileOperations;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Disciplina {
    private static final String ARQUIVO_DISCIPLINAS = "./src/main/java/universidade/assets/disciplinas.txt";

    private String nome;
    private int numeroMinimoAlunos;
    private int numeroMaximoAlunos;
    private int cargaHoraria;
    private List<Aluno> alunosInscritos;
    private List<Disciplina> preRequisitos;
    private List<Disciplina> coRequisitos;
    private Professor professorResponsavel;

    public Disciplina(String nome, int cargaHoraria) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.numeroMinimoAlunos = 3;
        this.numeroMaximoAlunos = 60;
        this.alunosInscritos = new ArrayList<>();
        this.preRequisitos = new ArrayList<>();
        this.coRequisitos = new ArrayList<>();
    }

    public Disciplina() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite o nome: ");
        this.nome = scan.nextLine();
        System.out.println("Digite a carga horária: ");
        this.cargaHoraria = Integer.parseInt(scan.nextLine());

        this.numeroMinimoAlunos = 3;
        this.numeroMaximoAlunos = 60;
        this.alunosInscritos = new ArrayList<>();
        this.preRequisitos = new ArrayList<>();
        this.coRequisitos = new ArrayList<>();
    }

    public void addAluno(Aluno aluno) {
        if (alunosInscritos.size() < numeroMaximoAlunos) {
            alunosInscritos.add(aluno);
            System.out.println("Aluno adicionado à disciplina: " + nome);
        } else {
            System.out.println("Não é possível adicionar mais alunos. Limite atingido.");
        }
    }

    public void removeAluno(Aluno aluno) {
        if (alunosInscritos.remove(aluno)) {
            System.out.println("Aluno removido da disciplina: " + nome);
        } else {
            System.out.println("Aluno não está matriculado nesta disciplina.");
        }
    }

    public List<Aluno> getAlunosInscritos() {
        return alunosInscritos;
    }

    public String getNome() {
        return this.nome;
    }

    //--------------------------------------------------------------------||
    //                                  CRUD                              ||
    //--------------------------------------------------------------------||

    // Criar nova disciplina
    public static void criarDisciplina() {
        Disciplina novaDisciplina = new Disciplina();
        FileOperations.salvarObjeto(ARQUIVO_DISCIPLINAS, novaDisciplina);
    }

    // Listar todas as disciplinas
    public static void listarDisciplinas() {
        List<Disciplina> disciplinas = FileOperations.recuperarObjetos(ARQUIVO_DISCIPLINAS, Disciplina.class);
        for (Disciplina disciplina : disciplinas) {
            System.out.println(disciplina.getNome());
        }
    }

    // Atualizar disciplina
    public static void atualizarDisciplina(Disciplina disciplinaAtualizada) {
        FileOperations.atualizarObjeto(ARQUIVO_DISCIPLINAS, disciplinaAtualizada, Disciplina.class);
    }

    // Deletar disciplina
    public static void deletarDisciplina(Disciplina disciplina) {
        FileOperations.deletarObjeto(ARQUIVO_DISCIPLINAS, disciplina, Disciplina.class);
    }

    @Override
    public String toString() {
        return nome + "," + cargaHoraria + "," + numeroMinimoAlunos + "," + numeroMaximoAlunos;
    }

    public static Disciplina fromString(String data) {
        String[] splitData = data.split(",");
        Disciplina disciplina = new Disciplina(splitData[0], Integer.parseInt(splitData[1]));
        disciplina.numeroMinimoAlunos = Integer.parseInt(splitData[2]);
        disciplina.numeroMaximoAlunos = Integer.parseInt(splitData[3]);
        return disciplina;
    }
}
