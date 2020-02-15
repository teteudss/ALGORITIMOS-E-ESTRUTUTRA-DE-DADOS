
public class Principal{

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

        

        //Imprime na ordem 
        arvore.imprimirInOrdem();
        System.out.print("");
        
        //REMOVER
        elem.setValor(2);
        arvore = arvore.remover(elem);

        //imprime apos remover
        System.out.println("\nNova Arvore ...");
        arvore.imprimirInOrdem();
        System.out.println("");

        //Verificar se o Elemento existe
        System.out.println("O elemento 5 " + (arvore.busca(5)?"Existe" : "Nao existe" ));

        

        
    }
}