package deque;

public class FilaArray implements IFila{
    
    protected int array [];
    protected int head, tail, count;

    protected FilaArray (int tam){//construtor passando int tam
        array = new int [tam];
        head = 0;
        tail = tam-1;
        count = 0 ;
    }

    protected void FazVazia (){
        while(count>0){
            array[head] = -1 ;
            ++head;
            if(head == array.length) head = 0;
            --count;
        }
    }
    protected boolean EstaVazia(){
        return (count == 0);
    }
    protected int getPrimeiro(){
        if(count == 0){
            return -1;
        }else{
            return array[head];
        }
    }
    protected void enfileirar(){
        if(count == array.length){
            
        }else{
            ++tail;
            if(tail== array.length){
                tail = 0;
                int valor = 0;
                array[tail] = valor;
                ++count;
            }
        }
    }
    protected int desinfilerar(){
        int resultado = -1;
        if(count ==0){
            System.out.println("Fila Vazia");
        }else{
            resultado = array[head];
            array[head] = -1;
            ++head;
            if(head==array.length){
                head = 0;
            }
                --count;
        }
        return resultado;
    }

    int desifileirar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}   
