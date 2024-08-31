import java.util.List;

public class Professor implements Usuario {
    private String nome;
    private String senha;
    private List<Disciplina> disciplinas;

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public String getSenha() {
        return this.senha;
    }

    public List<Aluno> visualizarMatriculas(Disciplina disciplina) {
        // Implementação do método para visualizar matrículas
        return null;
    }
}
