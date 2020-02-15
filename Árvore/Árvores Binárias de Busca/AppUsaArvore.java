
public class AppUsaArvore{

    public static void main (String [] args){

        //Cria uma nova Arvore
        Arvore arvore = new Arvore (new Elemento(20));
        //Cria um novo Elemento
        Elemento elem = new Elemento (0);
        //Inseri um elemento na arvore

        arvore.inserir(new Elemento(10));
        arvore.inserir(new Elemento(5));
        arvore.inserir(new Elemento(2));
        arvore.inserir(new Elemento(8));
        arvore.inserir(new Elemento(15));
        arvore.inserir(new Elemento(12));
        arvore.inserir(new Elemento(18));
        arvore.inserir(new Elemento(30));
        arvore.inserir(new Elemento(25));
        arvore.inserir(new Elemento(22));
        arvore.inserir(new Elemento(28));
        arvore.inserir(new Elemento(35));
        arvore.inserir(new Elemento(32));
        arvore.inserir(new Elemento(31));
        arvore.inserir(new Elemento(38));
        


        arvore.imprimirInOrdem();
        System.out.print("");
        
        //REMOVER
        elem.setValor(38);
        arvore = arvore.remover(elem);

        System.out.println("\nNova Arvore ...");
        arvore.imprimirInOrdem();
        System.out.println("");

        //REMOVER
        elem.setValor(35);
        arvore = arvore.remover(elem);

        System.out.println("Nova Arvore ...");
        arvore.imprimirInOrdem();
        System.out.println("");

        //REMOVER
        elem.setValor(20);
        arvore = arvore.remover(elem);

        System.out.println("Nova Arvore ...");
        arvore.imprimirInOrdem();
        System.out.println("");

        /*
        arvore.imprimirPreOrdem();
        System.out.println("");

        arvore.imprimirInOrdem();
        System.out.println("");

        arvore.imprimirPosOrdem();
        System.out.println("");

        arvore.imprimirInOrdemInversa();
        System.out.println("");
        */

         
        //Verificar se o Elemento existe
        //System.out.println("O elemento 5 " + (arvore.busca(5)?"Existe" : "Nao existe" ));
        //System.out.println("O elemento 5 " + (arvore.busca(100)?"Existe" : "Nao existe" ));
    }
}