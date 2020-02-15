public class ElementDuplo{
    
    private Element prev;
    private Element next;
    private int conteudo;

    public Element(int conteudo,Element next,Element prev){
        this.conteudo = conteudo;
        this.next = next ;
        this.next = prev;
    }

    public int getConteudo(){
        return this.conteudo;
    }
    public Element getNext(){
        return this.next;
    }
    public Element getPrev(){
        return this.prev;
    }
    public void setNext(Element n ){
        this.next = n;
    }
    public void setPrev(Element p){
        this.prev = p;
    }
    public setConteudo(int c){
        this.conteudo = c;
    }
		
    
}
 
