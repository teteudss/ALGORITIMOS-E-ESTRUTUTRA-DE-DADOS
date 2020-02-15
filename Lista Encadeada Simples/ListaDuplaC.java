public class ListaDuplaC{

    private Element tail;

    public Element getTail(){
        return this.tail;
    }
    public void setTail(Element tail){
    this.tail = tail;
    }
    public boolean EstaVazia(){
        return (this.getTail() = null);
    }
    public Element getPrimeiro(){
        if(!EstaVazia()){
            return this.getTail().getPrev();
        }else{
            return null;
        }
    }
    public Element getUltimo(){
        if(!EstaVazia()){
            return this.getTail();
        }else{
            return null;
        }

    }
    private void InserirListaVazia(Element temp){
        this.tail = temp;
        temp.next = tail;
        temp.prev = tail;
    }
    public void inserirInicio(int conteudo){
        Element temp = new Element (conteudo , null , null);
        if (this.EstaVazia()){
            this.SetTail(temp);
            temp.SetNext(tail);
            temp.SetPrev(tail);
		}else{
            this.getTail().getNext().setPrev(temp);
            temp.SetNext(tail.getNext());
            temp.SetPrev(this.getTail());
            this.getTail().SetNext(temp);
        }
		
    }
    public void inserirFim(int conteudo){
        Element temp = new Element(conteudo, null, null);
    
		if (this.EstaVazia()){
            this.InserirListaVazia(temp);

		}else {
            temp.SetPrev(this.getTail());
        }		
        this.getTail().SetNext(temp);
    }
    
    public void inserirAntes(int conteudo){
		Element temp = new Element (conteudo, null,null);
		if (this.EstaVazia()){
			this.SetTail(temp);
		}else {
	 		Element prevPtr = this.getTail();
	 		while (prevPtr !=null && prevPtr.next != this){
	 			prevPtr = prevPtr.next; }
	 		prevPtr.next=temp;
	 	}
    }

    public void inserirDepois (int conteudo){
    next = new Element (conteudo, next);
        if (this.EstaVazia()){
            temp.SetPrev(this.getTail());
        }else{

        }
    }

}