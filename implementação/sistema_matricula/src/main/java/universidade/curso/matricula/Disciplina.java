package main.java.universidade.curso.matricula;

import main.java.universidade.curso.Curso;
import main.java.universidade.utils.FileOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Disciplina {
    private static final String ARQUIVO_DISCIPLINAS = "./src/main/java/universidade/assets/disciplinas.txt";

    private String nome;
    private int cargaHoraria;
    private int creditos;
    private Curso curso;
    private List<Disciplina> preRequisitos;
    private List<Disciplina> coRequisitos;
    private Turma turma;

    // Construtor padrão para facilitar a criação via método de input
    public Disciplina() {
        this.preRequisitos = new ArrayList<>();
        this.coRequisitos = new ArrayList<>();
    }

    public Disciplina(String nome, int cargaHoraria, Curso curso) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.creditos = 0; // Assumindo um valor padrão
        this.curso = curso;
        this.preRequisitos = new ArrayList<>();
        this.coRequisitos = new ArrayList<>();
        this.turma = new Turma(this);
    }

    // Método para interação com o terminal para input dos dados
    public static Disciplina inputDadosDisciplina() throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome da disciplina:");
        String nome = scanner.nextLine();

        System.out.println("Digite a carga horária da disciplina:");
        int cargaHoraria = scanner.nextInt();
        scanner.nextLine();  // Consumir a nova linha

        System.out.println("Digite o número de créditos da disciplina:");
        int creditos = scanner.nextInt();
        scanner.nextLine();  // Consumir a nova linha

        // Aqui você deve implementar a lógica para selecionar o curso ou criar um novo
        // Para este exemplo, assumiremos que o curso já existe

        // Implementar
        System.out.println("Informe o nome do curso relativo a disciplina: ");
        
        Curso curso = new Curso();  // Isso deveria ser substituído por uma lógica de seleção de curso

        curso.listarCursos();

        System.out.println("Para cadastrar um novo curso digite 1: ");

        String opcao =  scanner.nextLine();

        if(opcao.equals("1")){
            curso = curso.criarCursoInterativo();
        }else if(curso.pesquisarCursoPorNome(opcao.trim()) == null){
            throw new Exception("Curso não encontrado!");
        }else{
            curso = curso.pesquisarCursoPorNome(opcao.trim());
        }
        
        Disciplina novaDisciplina = new Disciplina(nome, cargaHoraria, curso);
        novaDisciplina.setCreditos(creditos);

        // Lógica para input de pré-requisitos e co-requisitos pode ser adicionada aqui

        return novaDisciplina;
    }

    // Métodos CRUD

    public static void criarDisciplina() throws Exception {
        Disciplina novaDisciplina = inputDadosDisciplina();
        FileOperations.salvarObjeto(ARQUIVO_DISCIPLINAS, novaDisciplina);
    }

    public static void listarDisciplinas() {
        List<Disciplina> disciplinas = FileOperations.recuperarObjetos(ARQUIVO_DISCIPLINAS, Disciplina.class);
        for (Disciplina disciplina : disciplinas) {
            System.out.println(disciplina.getNome());
        }
    }

    public static List<Disciplina> listarDisciplinasList() {
        return FileOperations.recuperarObjetos(ARQUIVO_DISCIPLINAS, Disciplina.class);
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
        Disciplina disciplina = new Disciplina(splitData[0], Integer.parseInt(splitData[1]), null); // Curso deve ser atualizado com lógica correta
        return disciplina;
    }

    // Getters e Setters adicionais

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Disciplina> getPreRequisitos() {
        return preRequisitos;
    }

    public void setPreRequisitos(List<Disciplina> preRequisitos) {
        this.preRequisitos = preRequisitos;
    }

    public List<Disciplina> getCoRequisitos() {
        return coRequisitos;
    }

    public void setCoRequisitos(List<Disciplina> coRequisitos) {
        this.coRequisitos = coRequisitos;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}
