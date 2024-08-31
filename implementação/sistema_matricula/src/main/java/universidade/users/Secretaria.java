// package main.java.universidade.users;

// import main.java.universidade.abstracoes.Usuario;
// import main.java.universidade.curso.Curriculo;
// import main.java.universidade.curso.matricula.Disciplina;
// import main.java.universidade.utils.FileOperations;

// import java.io.Serializable;
// import java.util.ArrayList;
// import java.util.List;

// public class Secretaria extends Usuario implements Serializable {
//     private static final long serialVersionUID = 1L;
//     private List<Integer> idsSessao;

//     public Secretaria(String nome, String login, String senha, int idSessao) {
//         super(nome, login, senha);
//         this.idsSessao = new ArrayList<Integer>();
//         this.idsSessao.add(idSessao);
//     }

//     public void addSessao(int idSessao) {
//         this.idsSessao.add(idSessao);
//     }

//     public List<Integer> getIdsSessao() {
//         return idsSessao;
//     }

//     public void gerirCurriculoSemestral(Curriculo curriculo) {
//         List<Object> disciplinas = FileOperations.recuperarDados("./arquivos/disciplinas.dat");

//         for (Object disciplina : disciplinas) {
//             Disciplina d = (Disciplina) disciplina;

//             System.out.println(d.getAlunosInscritos());
//         }
//     }

//     public Aluno cadastrarAluno(){
//         return new Aluno();
//     }

//     public Professor cadastrarProfessor(){
//         return new Professor();
//     }

//     public void notificarCobranca(Aluno aluno, String semestre) {
//         // Implementação do método para notificar cobrança
//     }
// }

package main.java.universidade.users;

import main.java.universidade.abstracoes.Usuario;
import main.java.universidade.curso.Curriculo;
import main.java.universidade.curso.matricula.Disciplina;
import main.java.universidade.utils.FileOperations;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Secretaria extends Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Integer> idsSessao;

    public Secretaria(String nome, String login, String senha, int idSessao) {
        super(nome, login, senha);
        this.idsSessao = new ArrayList<>();
        this.idsSessao.add(idSessao);
    }

    public void addSessao(int idSessao) {
        this.idsSessao.add(idSessao);
    }

    public List<Integer> getIdsSessao() {
        return idsSessao;
    }

    public void gerirCurriculoSemestral(Curriculo curriculo) {
        List<Disciplina> disciplinas = FileOperations.recuperarObjetos("./src/main/java/universidade/assets/disciplinas.txt", Disciplina.class);

        for (Disciplina disciplina : disciplinas) {
            System.out.println("Disciplina: " + disciplina.getNome());
            System.out.println("Alunos Inscritos: " + disciplina.getAlunosInscritos());
        }
    }

    public Aluno cadastrarAluno() {
        return new Aluno();
    }

    public Professor cadastrarProfessor() {
        return new Professor();
    }

    public void notificarCobranca(Aluno aluno, String semestre) {
        // Implementação do método para notificar cobrança
    }
}
