package main.java.universidade.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import main.java.universidade.users.Aluno;
import main.java.universidade.users.Professor;

public class FileOperations {

    public static <T> void salvarObjeto(String caminhoArquivo, T objeto) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoArquivo, true))) {
            bw.write(objeto.toString());
            bw.newLine();
            System.out.println("Dados salvos com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> List<T> recuperarObjetos(String caminhoArquivo, Class<T> clazz) {
        List<T> objetos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (clazz == Aluno.class) {
                    objetos.add(clazz.cast(Aluno.fromString(linha)));
                } else if (clazz == Professor.class) {
                    objetos.add(clazz.cast(Professor.fromString(linha)));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return objetos;
    }

    public static <T> void atualizarObjeto(String caminhoArquivo, T objetoAtualizado, T objetoOriginal, Class<T> clazz) {
        List<T> objetos = recuperarObjetos(caminhoArquivo, clazz);
        String objetoStr = objetoOriginal.toString();

        for (int i = 0; i < objetos.size(); i++) {
            if (objetos.get(i).toString().equals(objetoStr)) {
                objetos.set(i, objetoAtualizado);
                break;
            }
        }

        salvarObjetos(caminhoArquivo, objetos);
    }

    public static <T> void deletarObjeto(String caminhoArquivo, T objeto, Class<T> clazz) {
        List<T> objetos = recuperarObjetos(caminhoArquivo, clazz);
        objetos.remove(objeto);
        salvarObjetos(caminhoArquivo, objetos);
    }

    private static <T> void salvarObjetos(String caminhoArquivo, List<T> objetos) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoArquivo, false))) {
            for (T objeto : objetos) {
                bw.write(objeto.toString());
                bw.newLine();
            }
            System.out.println("Dados salvos com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
