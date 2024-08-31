public class Secretaria implements Usuario {
    private String nome;

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public String getSenha() {
        return null; // Implementar lógica para senha se necessário
    }

    public void gerirCurriculoSemestral(Curriculo curriculo) {
        // Implementação do método para gerir currículo semestral
    }

    public void notificarCobranca(Aluno aluno, String semestre) {
        // Implementação do método para notificar cobrança
    }
}
