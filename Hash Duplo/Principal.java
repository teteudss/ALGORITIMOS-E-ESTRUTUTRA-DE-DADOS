public class Principal{
    public static void main(String[] args) {


        //*****CASOS DE TESTE DO HASH ABERTO DUPLO******
        HashAbertoDuplo hashF = new HashAbertoDuplo(5);
        hashF.inserir(0);
        hashF.inserir(2);
        hashF.inserir(7);
        hashF.inserir(2);
        hashF.inserir(1);
        hashF.listar();
        hashF.remover(7);
        hashF.listar();
        hashF.inserir(19);
        hashF.listar();
        hashF.inserir(356);
        



    }
}
