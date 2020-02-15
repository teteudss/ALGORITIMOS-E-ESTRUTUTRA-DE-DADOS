import java.util.Scanner;

public class Principal{
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int cem_k = 100000;
        int vetor[] = new int[cem_k];

        // Preencher o vetor
        for(int i = 0; i < cem_k; i++){
            vetor[i] = i;
        }

        BuscaBinaria busca = new BuscaBinaria();
        BuscaSequencial buscac = new BuscaSequencial();

        System.out.println("Digite o numero que deseja procurar entre 0  e 100K : ");
        int valor = ler.nextInt();
        int indice;

        if((valor < 0) || (valor > cem_k)){
            System.out.println(" Valor fora do intervalo ! ");
        }else{
            long temp_inicio = System.currentTimeMillis();
            indice = busca.busca_binaria(vetor, 0, cem_k, valor);
            long gasto = System.currentTimeMillis() - temp_inicio;

            System.out.println("*************BUSCA BINARIA*************");
            System.out.println(" Indice do valor: " + indice);
            System.out.println(" Interacoes: " + busca.getIntecacoes());
            System.out.println(" Tempo: " + gasto + " millis segundos ");
            System.out.println();

            temp_inicio = System.currentTimeMillis();
            indice = buscac.buscaSequencial(vetor, 0, cem_k, valor);
            gasto = System.currentTimeMillis() - temp_inicio;

            System.out.println("***********BUSCA SEQUENCIAL***********");
            System.out.println(" Indice do valor: " + indice);
            System.out.println(" Interacoes: " + buscac.getIntecacoes());
            System.out.println(" Tempo: " + gasto + " millis segundos ");

        }
    }
}
