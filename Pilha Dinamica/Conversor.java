//vai converter um numero decimal para binario

public class Conversor;

    
    public static void main(String args[]){
        int numero = Integer.parseInt(args[0]);//primeiro elemento do vetor
        PilhaDinamica p = new PilhaDinamica();//criei uma pilha P

        int resto;
        
        //Empilhamento dos restos
        while(numero != 0){
            resto = numero % 2;  //pego o resto da divisao por 2 e armazeno em resto
            p.push(resto);       //pego esse resto e armazeno na pilha
            numero = numero / 2; //gero um novo numero, resultado da divisao por 2
        }
        //Exibicao dos restos
        while(!p.isEmpty()){  //Equanto a pilha nao for vazia
            resto = p.pop(); //remove da pilha(Sempre o topo)
            System.out.print(resto);
        }
        System.out.println("Fim");
    }
}