import java.util.List;

public class Disciplina implements Credito {
    private String nome;
    private int numeroMinimoAlunos;
    private int numeroMaximoAlunos;
    private int cargaHoraria;
    private String status;
    private Professor professorResponsavel;
    private List<Aluno> alunosInscritos;
    private List<Disciplina> preRequisitos;
    private List<Disciplina> coRequisitos;

    @Override
    public int getCargaHoraria() {
        return this.cargaHoraria;
    }
}