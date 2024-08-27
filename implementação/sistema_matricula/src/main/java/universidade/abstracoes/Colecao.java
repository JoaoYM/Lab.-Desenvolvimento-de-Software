package main.java.universidade.abstracoes;


import java.util.ArrayList;
import java.util.List;

public abstract class Colecao<T> extends Object {
    private List<T> units;

    public Colecao() {
        super();
        this.units = new ArrayList<T>();
    }

    public void incluir(T unit) {
        units.add(unit);
    }

    public T editar(T unit) {
        return units.set(units.indexOf(unit), unit);
    }

    public void excluir(T unit) {
        units.remove(unit);
    }

    public T pesquisar(int index) {
        return units.get(index);
    }

    public List<T> listar() {
        return units;
    }
}