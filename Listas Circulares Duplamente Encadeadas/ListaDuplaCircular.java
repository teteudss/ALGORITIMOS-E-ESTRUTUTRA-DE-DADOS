public class ListaDuplaCircular {
    private CaixinhaDupla inicio;

    public ListaDuplaCircular(){
        inicio = null;
    }
    public boolean isEmpty(){
        return (this.inicio == null);
    }
    public void inserir (int elemento){

        CaixinhaDupla novo = new CaixinhaDupla(); // Cria uma nova caixa
        novo.setElemento(elemento);              // Passa como parametro um novo elemento

        if(isEmpty()){                           //Se a Lista estiver vazia
            novo.setProximo(novo);              //O proximo vira o novo , apontado para ele mesmo
            novo.setAnterior(novo);             //O anterior vira ele mesmo, apontando para ele mesmo
            inicio = novo;                      //Inicio aponta para nova caixinha
        }else{
            CaixinhaDupla tnp = inicio;
            while(tnp.getProximo() != inicio){
                tnp = tnp.getProximo();         //Sempre vai assumir o proximo elemento ate achar o inicio
            }
            inicio.setAnterior(novo);
            tnp.setProximo(novo);
            novo.setAnterior(tnp);
            novo.setProximo(inicio);
        }
    }
    public void exibirNaOrdem(){
        CaixinhaDupla tnp;
        tnp = inicio;
        do{
            System.out.println("Elemento da Lista = " + tnp.getElemento());
            tnp = tnp.getProximo();
        }while(tnp != inicio);
    }
    public void exibirNaOrdemInversa(){
        CaixinhaDupla tnp;
        tnp = inicio;
        do{
            System.out.println("Elemento da Lista = " + tnp.getElemento());
            tnp = tnp.getAnterior();
        }while(tnp != inicio);
    }
}