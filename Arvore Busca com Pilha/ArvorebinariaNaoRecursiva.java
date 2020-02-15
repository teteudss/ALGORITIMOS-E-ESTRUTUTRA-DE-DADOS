public class ArvorebinariaNaoRecursiva {

    public static void main(String[] args) {
        Arvore a = new Arvore();
        a.insereElemento(6);
        a.insereElemento(4);
        a.insereElemento(8);
        a.insereElemento(5);
        a.insereElemento(2);
        a.insereElemento(7);
        a.insereElemento(9);
        a.insereElemento(10);
       
        
        System.out.println("\nEm Profundidade :InOrdem ");
        a.inOrdemPilha();

        System.out.println("\nEm Profundidade :PreOrdem ");
        a.preOrdemPilha();

        System.out.println("\nEm Profundidade :PosOrdem ");
        a.posOrdemPilha();
        
        System.out.println("\nEm Largura\n ");
        a.imprimeLargura();
    }
       
}
    

