package main.java.universidade.abstracoes;

public abstract class Object {
    private int id;

    private static int personIdGenerator = 0;
    private static int unidadeIdGenerator = 0;

    public Object() {
        if (this instanceof Usuario) {
            this.id = personIdGenerator++;
        }else if( this instanceof Unidade){
            this.id = unidadeIdGenerator++;
        }
    }

    public int getId() {
        return id;
    }
}
