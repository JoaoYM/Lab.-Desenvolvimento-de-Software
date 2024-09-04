package main.java.universidade.aluno;

import java.util.Date;
import java.util.List;

import main.java.universidade.users.Aluno;
import main.java.universidade.utils.FileOperations;

public class Matricula {
    private String dataMatricula;
    private Aluno  aluno;
    private Double valor;
    private static final String ARQUIVO_MATRICULAS = "./Lab.-Desenvolvimento-de-Software/implementação/sistema_matricula/src/main/java/universidade/assets/matriculas.txt";

    public Matricula(Aluno aluno){
        this.dataMatricula = new Date().toString();
        this.aluno         = aluno;
        this.valor         = 150.00;
    }

     public static void listarMatriculasByIndex() {
        List<Matricula> matriculas = FileOperations.recuperarObjetos(ARQUIVO_MATRICULAS, Matricula.class);
        int index = 0;
        for (Matricula matricula : matriculas) {
            if(matricula.getAluno().getNome().equals(aluno.getNome()))){
                System.out.println("[" + index++ + "]" + matricula.toString());
            }
        }
    }

    public static Matricula obterMatriculayIndex(int index) {
        
        List<Matricula> matriculas = FileOperations.recuperarObjetos(ARQUIVO_MATRICULAS, Matricula.class);
        
        int currentIndex = 0;

        for (Matricula matricula : matriculas) {
            if(currentIndex == index){
                return matricula;
            }

            currentIndex++;
        }

        return null;
    }

    public void notificarCobranca(Aluno aluno,  String dataMatricula){
        System.out.println("Notificação concluída!");
    }
}


