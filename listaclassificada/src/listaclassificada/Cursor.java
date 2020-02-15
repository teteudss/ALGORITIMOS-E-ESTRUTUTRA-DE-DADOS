
package listaclassificada;

public interface Cursor {
    
    Object getDado();
    void inserirDepois(Object O);
    void inserirAntes(Object O);
    void remover();
}
