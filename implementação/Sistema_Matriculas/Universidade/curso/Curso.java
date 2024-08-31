import java.util.List;

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