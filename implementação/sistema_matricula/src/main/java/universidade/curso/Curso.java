package main.java.universidade.curso;

import java.util.ArrayList;
import java.util.List;

import main.java.universidade.curso.matricula.Disciplina;

public class Curso implements Credito {
    private String nome;
    private int creditos;
    private int cargaHoraria;
    private List<Disciplina> disciplinas;

    public Curso(String nome, int creditos, int cargaHoraria) {
        this.nome = nome;
        this.creditos = creditos;
        this.cargaHoraria = cargaHoraria;
        this.disciplinas = new ArrayList<>();
    }

    @Override
    public int getCargaHoraria() {
        return this.cargaHoraria;
    }

    public void listarDisciplinas() {
        if (disciplinas.isEmpty()) {
            System.out.println("Nenhuma disciplina cadastrada neste curso.");
        } else {
            System.out.println("Disciplinas do curso " + nome + ":");
            for (Disciplina disciplina : disciplinas) {
                System.out.println("- " + disciplina.getNome());
            }
        }
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

    public void removerDisciplina(Disciplina disciplina) {
        disciplinas.remove(disciplina);
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }
}
