import java.util.List;

public class Aluno implements Usuario {
    private String nome;
    private String senha;
    private Curso curso;
    private List<Matrícula> matriculas;

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public String getSenha() {
        return this.senha;
    }
}