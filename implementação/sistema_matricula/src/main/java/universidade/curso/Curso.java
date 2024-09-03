package main.java.universidade.curso;

import main.java.universidade.curso.matricula.Disciplina;
import main.java.universidade.utils.FileOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Curso {
    private static final String ARQUIVO_CURSOS = "./src/main/java/universidade/assets/cursos.txt";

    private int codigo;
    private String nome;
    private List<Disciplina> disciplinas;

    public Curso() {
        this(0, "");
    }

    public Curso(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
        this.disciplinas = new ArrayList<>();
    }

    public static Curso pesquisarCursoPorNome(String nome) {
        List<Curso> cursos = FileOperations.recuperarObjetos(ARQUIVO_CURSOS, Curso.class);
        for (Curso curso : cursos) {
            if (curso.getNome().equalsIgnoreCase(nome)) {
                return curso;
            }
        }
        return null;
    }

    public static Curso criarCursoInterativo() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o código do curso: ");
        int codigo = scan.nextInt();
        scan.nextLine();  // Consumir a quebra de linha
        System.out.println("Digite o nome do curso: ");
        String nome = scan.nextLine();

        return new Curso(codigo, nome);
    }

    public static void criarCurso() {
        Curso novoCurso = criarCursoInterativo();
        FileOperations.salvarObjeto(ARQUIVO_CURSOS, novoCurso);
    }

    public static void listarCursos() {
        List<Curso> cursos = FileOperations.recuperarObjetos(ARQUIVO_CURSOS, Curso.class);
        // int index = 0;
        
        for (Curso curso : cursos) {
            System.out.println("Código: " + curso.getCodigo() + ", Nome: " + curso.getNome());
        }
    }

    public static void atualizarCurso(Curso cursoAtualizado) {
        FileOperations.atualizarObjeto(ARQUIVO_CURSOS, cursoAtualizado, Curso.class);
    }

    public static void deletarCurso(Curso curso) {
        FileOperations.deletarObjeto(ARQUIVO_CURSOS, curso, Curso.class);
    }

    @Override
    public String toString() {
        return getCodigo() + "," + getNome();
    }

    public static Curso fromString(String data) {
        String[] splitData = data.split(",");
        int codigo = Integer.parseInt(splitData[0]);
        return new Curso(codigo, splitData[1]);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Disciplina> getDisciplinas() {
        return new ArrayList<>(disciplinas);
    }

    public void addDisciplina(Disciplina disciplina) {
        if (disciplina != null && !disciplinas.contains(disciplina)) {
            disciplinas.add(disciplina);
        }
    }

    public void removeDisciplina(Disciplina disciplina) {
        disciplinas.remove(disciplina);
    }
}
