package main.java.universidade.aluno;

import java.util.Date;

import main.java.universidade.users.Aluno;

public class Matricula {
    private Date   dataMatricula;
    private Aluno  aluno;
    private Double valor;

    public Matricula(Aluno aluno) {
        this.aluno = aluno;
    }

    public void notificarCobranca(Aluno aluno, String dataMatricula){
        System.out.println("Notificação concluída!");
    }


    public Date getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(Date dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}


