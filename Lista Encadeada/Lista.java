public class Lista{

    private Caixinha inicio;
    

    //criando Lista vazia
    public Lista(){
        this.inicio = null;
    }
    public void inserir(int elemento){
        //criando uma nova caixinha
        Caixinha nova = new Caixinha();
        nova.setElemento(elemento);//inserir o elemento na caixinha
        nova.setProximo(null);//depois dela nao vem ngm

        if(inicio == null){  //verifica se esta vazia
            inicio = nova;
        }
        else{               //ja tem coisa nessa lista
            Caixinha aux;
            aux = inicio;
            while (aux.getProximo() != null ){
                aux = aux.getProximo();
            }
            aux.setProximo(nova);
        }
    }
    public int retirar(){

        if(inicio != null){
        //considera que sempre vai haver elementos
        //alguem na aplicação precisa (antes remover), testar se a lista esta vazia

        Caixinha aux = inicio;
        int elemento = aux.getElemento();
        inicio = aux.getProximo();
        return elemento;

        }
        else{
            throw new RuntimeException("Lista Vazia ");
        }

    }
    public void listar(){
        if(inicio == null){
            System.out.println("Nada a Exibir , a lista esta vazia ");
        }
        else{
            Caixinha aux = inicio;
            while(aux != null){
                System.out.println("Elemento visto " + aux.getElemento());
                aux = aux.getProximo();
            }
        }

    }
    public boolean isEmpty(){
       return this.inicio == null;
    }

    public void inverter(){
        Caixinha tnp;
        tnp = inicio;
        do{
            System.out.println("Elemento da Lista = " + tnp.getElemento());
            tnp = tnp.getAnteriro();
        }while(tnp != inicio);
    }
}