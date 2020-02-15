package deque;

public class DequeArray extends FilaArray implements Deque {

    public DequeArray(int tam) {
        super(tam);
    }

    @Override
    public void fazVazia() {
        super.FazVazia();
    }

    @Override
    public boolean estaVazia() {
        return super.EstaVazia();
    }

    @Override
    public int getUltimo() {
         if(count == 0){
            return -1;
        }else{
            return array[tail];
        }
    }
    @Override
    public int getPrimeiro(){
        return super.getPrimeiro();
    }
    
    public void enfileirarInicio() {
      if(count == array.length){
           ++head;
           if(tail == array.length){
               head = 0;
               int valor = 0;
               array[head] = valor;
               ++count;
           }
        }else{
         
        }
    }

    @Override
    public void enfileirarFinal(int valor) {
       super.enfileirar();
    }
    
    public int desinfileirarInicio() {
        return super.desifileirar();
    }

    public int desinfileirarFim() {
        int resultado = -1;
        if(count == 0){
            resultado = array[tail];
            array[tail] = -1;
            --tail;
            if(tail==array.length){
                tail = 0;
            }
                --count;
        }
            
        
        return resultado;
    }  

    @Override
    public int desinfileirarInici() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int desinfileirarFi() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enfileirarInicio(int valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}