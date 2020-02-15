public class Principal{
    public static void main(String[] args) {

        //******CASOS DE TESTE DO ABERTO LINEAR******

        HashAbertoLinear hash = new HashAbertoLinear(10);

        hash.inserir(1);
        hash.inserir(2);
        hash.inserir(3);
        hash.inserir(4);
        hash.inserir(5);
        hash.inserir(6);
        hash.inserir(7);
        hash.inserir(8);
        hash.inserir(9);
        hash.inserir(15);
        //Não vai inserir o elemento 10 pois declarei apenas 10 variaveis e o elemento 10 ultrapassa o limite
        hash.inserir(10);
        hash.listar();
        //Vai pesquisar o indice do elemento 
        hash.pesquisar(9);
        hash.pesquisar(15);
        //vai remover o elemento e Listar novamente
        System.out.println("Remover Elemento 15 :");
        hash.remover(15);
        hash.listar();
       

        



    }
}
