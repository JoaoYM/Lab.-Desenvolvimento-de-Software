package main.java.universidade.curso;

import java.util.ArrayList;
import java.util.List;

import main.java.universidade.curso.matricula.Disciplina;

public class Curso{
    private int codigo;
    private String nome;
    private List<Disciplina> disciplinas;

    public Curso(String nome) {
        this.nome = nome;
        this.disciplinas = new ArrayList<>();
    }

    public void addDisciplina(Disciplina disciplina) {
        this.disciplinas.add(disciplina);
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

}
