package main.java.universidade.aluno;

import java.util.Date;

import main.java.universidade.curso.matricula.Disciplina;
import main.java.universidade.users.Aluno;

public class Matricula {
    private Date dataMatricula;
    private Disciplina disciplina;
    private Aluno aluno;

    public void notificarCobranca(Aluno aluno,  String dataMatricula){
        System.out.println("Notificação concluída!");
    }
}


