public class Caixinha {
    private int     elemento;
    private Caixinha proximo;//Auto referenciada , chama ela
    private Caixinha anterior;

    public void setElemento(int elemento){
        this.elemento = elemento;
    }
    public int getElemento(){
        return this.elemento;
    }
    public void setProximo(Caixinha proximo){
        this.proximo = proximo;
    }
    public Caixinha getProximo(){
        return this.proximo;
    } 
    public Caixinha getAnterior(){
        return this.anterior;
    }
    public void setAnterior(Caixinha anterior){
        this.anterior = anterior;
    }
}