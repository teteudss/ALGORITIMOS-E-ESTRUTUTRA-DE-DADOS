
package fila;

public interface IFila{
    
    public int getHead();
    public void setHead(int h);
    public int getTail();
    public void setTail(int t);
    
    public void FazVazia();
    public boolean EstaVazia();
    public int getPrimeiro();
    public void enfileirar(int valor);
    public int desifileirar ();

}
