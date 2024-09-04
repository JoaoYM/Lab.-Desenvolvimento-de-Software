package main.java.universidade.aluno;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import main.java.universidade.users.Aluno;

public class Matricula {
    private Date dataMatricula;
    private Aluno aluno;
    private Double valor;

    // Construtor
    public Matricula(Date dataMatricula, Aluno aluno, Double valor) {
        this.dataMatricula = dataMatricula;
        this.aluno = aluno;
        this.valor = valor;
    }

    // Getters e Setters
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

    // Método para notificar cobrança
    public void notificarCobranca() {
        System.out.println("Notificação de cobrança enviada para o aluno " + aluno.getNome() + " na data " + dataMatricula);
    }

    // Métodos CRUD
    public static void criarMatricula(Aluno aluno) {
        Scanner scanner = new Scanner(System.in);
        List<Matricula> matriculas = new ArrayList<>();
        
        System.out.println("Digite a data da matrícula (formato: yyyy-mm-dd):");
        String data = scanner.nextLine();
        Date dataMatricula = java.sql.Date.valueOf(data);

        System.out.println("Digite o valor da matrícula:");
        Double valor = Double.parseDouble(scanner.nextLine());
        
        Matricula novaMatricula = new Matricula(dataMatricula, aluno, valor);
        matriculas.add(novaMatricula);
        
        System.out.println("Matrícula criada com sucesso!");
    }

    public static void listarMatriculas(List<Matricula> matriculas) {
        for (Matricula matricula : matriculas) {
            System.out.println("Aluno: " + matricula.getAluno().getNome() + " | Data: " + matricula.getDataMatricula() + " | Valor: " + matricula.getValor());
        }
    }

    public static void atualizarMatricula(Matricula matricula) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Atualize os dados da matrícula:");
        System.out.println("Digite a nova data da matrícula (formato: yyyy-mm-dd):");
        String novaData = scanner.nextLine();
        Date dataMatricula = java.sql.Date.valueOf(novaData);
        matricula.setDataMatricula(dataMatricula);
        
        System.out.println("Digite o novo valor da matrícula:");
        Double novoValor = Double.parseDouble(scanner.nextLine());
        matricula.setValor(novoValor);
        
        System.out.println("Matrícula atualizada com sucesso!");
    }

    public static void deletarMatricula(List<Matricula> matriculas, Matricula matricula) {
        if (matriculas.remove(matricula)) {
            System.out.println("Matrícula removida com sucesso!");
        } else {
            System.out.println("Matrícula não encontrada.");
        }
    }
}


