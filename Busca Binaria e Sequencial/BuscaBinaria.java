public class BuscaBinaria{
    private int interacoes = 0;

    public BuscaBinaria(){
        
    }

    public int busca_binaria(int[] vetor, int low, int hight, int numero){
        interacoes++;
        int mid = (low + hight) / 2;

        if(vetor[mid] == numero){
            return mid;
        }else if(numero <= vetor[mid]){
            return busca_binaria(vetor, low, mid-1, numero);
        }else{
            return busca_binaria(vetor, mid+1, hight, numero);
        }
    }

    public int getIntecacoes(){
        return this.interacoes;
    }


}
