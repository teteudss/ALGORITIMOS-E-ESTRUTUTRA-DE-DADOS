public class BuscaSequencial{
    private int interacoes = 0;


    public int buscaSequencial(int[] vetor, int low, int hight, int numero){
        for(int i = low; i < hight; i++){
            this.interacoes++;
            if(vetor[i] == numero){
                return i;
            }
        }
        return -1;
    }

    public int getIntecacoes(){
        return this.interacoes;
    }
}
