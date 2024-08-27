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
            System.out.println("Alunos Inscritos: " + disciplina.getTurma().getAlunosInscritos());
        }
    }

    public static boolean autenticar(String login, String senha) {
        // List<Secretaria> secretarias = FileOperations.recuperarObjetos(ARQUIVO_SECRETARIA, Aluno.class);
        // for (Aluno aluno : secretarias) {
        //     if (aluno.getLogin().equals(login) && aluno.getSenha().equals(senha)) {
        //         return true;
        //     }
        // }
        return false;
    }

    
    // -----------------------------------------------------------------------|
    //                                    CRUD                                |   
    // -----------------------------------------------------------------------|

    public Aluno cadastrarAluno() {
        return new Aluno();
    }

    public Professor cadastrarProfessor() {
        return new Professor();
    }

    public Disciplina cadastrarDisciplina(){
        return new Disciplina();
    }
}
