public class Pilha{
    private int valores[];//um vetor que ai receber a quantidade de valores inteiros
    private int topo;// valor que esta no topo da pilha
    //construtor 
    public Pilha(){
        valores = new int [10];
        topo    = -1;//o topo vai apontar pra um valor nulo da pilha pra indicar que esta vazia

    }
    //Para armazenar elemento / empilhar
    public void push(int elemento){
        topo = topo + 1;
        valores[topo] =  elemento;//valores na posicao correspondente ao topo recebe o elemento
    }
    //Para verificar se a Pilha esta vazia ou nao
    public boolean isEmpty(){
        return (topo == -1);

    }
    //Para verificar se a Pilha esta cheia ou nao
    public boolean isFull(){
        return (topo == 9);//ultima posicao do vetor indica que ela esta cheia
    }
    //Desenpilhar 
    public int pop(){
        int elem = valores[topo];//um elemento que recebe os valores que esta no topo
        topo --;
        return elem;
    }
}