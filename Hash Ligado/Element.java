package hashinglistaligada;

public class Element <T>{
    private T data;
    private Element<T> next;
    
    public Element(T data, Element<T> next) {
        this.data = data;
        this.next = next;
    }
    
    public T getData() {
        return this.data;
    }
    
    public void setData(T data) {
        this.data = data;
    }
    
    public Element<T> getNext() {
        return this.next;
    }
    
    public void setNext(Element<T> next) {
        this.next = next;
    }
}
