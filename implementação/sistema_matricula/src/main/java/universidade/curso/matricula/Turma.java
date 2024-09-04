package main.java.universidade.curso.matricula;

import main.java.universidade.aluno.Matricula;
import main.java.universidade.users.Professor;
import main.java.universidade.utils.FileOperations;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private Disciplina disciplina;
    private Professor professorResponsavel;
    private List<Matricula> matriculas;
    private int numeroMinimoAlunos;
    private int numeroMaximoAlunos;
    private String status;
    private int ano;
    private int semestre;
    private String codigo;

    public Turma(Disciplina disciplina) {
        this.disciplina = disciplina;
        this.professorResponsavel = null;
        this.matriculas = new ArrayList<>();
        this.numeroMinimoAlunos = 3;
        this.numeroMaximoAlunos = 60;
        this.status = "Aberta";
    }

    public Turma(Disciplina disciplina, Professor professorResponsavel) {
        this.disciplina = disciplina;
        this.professorResponsavel = professorResponsavel;
        this.matriculas = new ArrayList<>();
        this.numeroMinimoAlunos = 3;
        this.numeroMaximoAlunos = 60;
        this.status = "Aberta";
    }

    public void addMatricula(Matricula matricula) {
        if (matriculas.size() < numeroMaximoAlunos) {
            matriculas.add(matricula);
            atualizarStatus();
        } else {
            System.out.println("Não é possível adicionar mais matrículas. Limite atingido.");
        }
    }

    public boolean removeMatricula(Matricula matricula) {
        if (matriculas.remove(matricula)) {
            atualizarStatus();
            return true;
        }
        return false;
    }

    public Professor getProfessorResponsavel() {
        return professorResponsavel;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public int getNumeroDeMatriculas() {
        return matriculas.size();
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
        if (matriculas.size() >= numeroMinimoAlunos && matriculas.size() < numeroMaximoAlunos) {
            this.status = "Aberta";
        } else if (matriculas.size() >= numeroMaximoAlunos) {
            this.status = "Fechada";
        }
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}