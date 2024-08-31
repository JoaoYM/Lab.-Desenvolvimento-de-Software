package main.java.universidade.curso;

import java.util.List;

import main.java.universidade.curso.matricula.Disciplina;

public class Curso implements Credito {
    private String nome;
    private int creditos;
    private int cargaHoraria;
    private List<Disciplina> disciplinas;

    @Override
    public int getCargaHoraria() {
        return this.cargaHoraria;
    }
}