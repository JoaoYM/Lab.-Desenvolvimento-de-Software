package main.java.universidade.curso.matricula;

import main.java.universidade.users.Aluno;
import main.java.universidade.users.Professor;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private Disciplina disciplina;
    private Professor professorResponsavel; // Add this attribute
    private List<Aluno> alunosInscritos;
    private int numeroMinimoAlunos;
    private int numeroMaximoAlunos;
    private String status;

    public Turma(Disciplina disciplina) {
        this.disciplina = disciplina;
        this.alunosInscritos = new ArrayList<>();
        this.numeroMinimoAlunos = 3;
        this.numeroMaximoAlunos = 60;
        this.status = "Aberta";
    }

    public Turma(Disciplina disciplina, Professor professorResponsavel) {
        this.disciplina = disciplina;
        this.professorResponsavel = professorResponsavel; // Initialize it here
        this.alunosInscritos = new ArrayList<>();
        this.numeroMinimoAlunos = 3;
        this.numeroMaximoAlunos = 60;
        this.status = "Aberta";
    }

    public void addAluno(Aluno aluno) {
        if (alunosInscritos.size() < numeroMaximoAlunos) {
            alunosInscritos.add(aluno);
            atualizarStatus();
        } else {
            System.out.println("Não é possível adicionar mais alunos. Limite atingido.");
        }
    }

    public boolean removeAluno(Aluno aluno) {
        if (alunosInscritos.remove(aluno)) {
            atualizarStatus();
            return true;
        }
        return false;
    }

    public Professor getProfessorResponsavel() {
        return professorResponsavel;
    }

    public List<Aluno> getAlunosInscritos() {
        return alunosInscritos;
    }

    public int getNumeroDeAlunos() {
        return alunosInscritos.size();
    }

    public int getNumeroMinimoAlunos() {
        return numeroMinimoAlunos;
    }

    public int getNumeroMaximoAlunos() {
        return numeroMaximoAlunos;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private void atualizarStatus() {
        if (alunosInscritos.size() >= numeroMinimoAlunos && alunosInscritos.size() < numeroMaximoAlunos) {
            this.status = "Aberta";
        } else if (alunosInscritos.size() >= numeroMaximoAlunos) {
            this.status = "Fechada";
        }
    }
}
