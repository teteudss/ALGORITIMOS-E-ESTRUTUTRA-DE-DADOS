public final class Element {
    
    Object data;
    Element next;
    Element tail;
    Element head;    
    
    Element (Object d, Element n){
        data = d;
        next = n;
    }
    public Object getData(){ 
        return data;
    }
    public Element getNext(){
        return next;
    }
    
    public void inserirDepois (Object item){
        next = new Element (item, next);
	        if(tail == this){
                tail = next;
            } else {

            }
    }
    
    public void inserirAntes(Object item){
        
        Element temp = new Element (item, this);
	        if (this == head){
              head = temp;
	        }else {
             Element prevPtr = head;
                while (prevPtr !=null && prevPtr.next != this){
                     prevPtr = prevPtr.next; 
                }

            prevPtr.next=temp;
	        }
    }
		
    
}
    

