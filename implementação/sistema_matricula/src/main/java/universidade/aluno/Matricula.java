package main.java.universidade.aluno;

import java.util.Date;

import main.java.universidade.users.Aluno;

public class Matricula {
    private Date   dataMatricula;
    private Aluno  aluno;
    private Double valor;

    public void notificarCobranca(Aluno aluno,  String dataMatricula){
        System.out.println("Notificação concluída!");
    }
}


