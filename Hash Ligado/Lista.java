package hashinglistaligada;

public interface Lista <T>{
    void fazVazia();
    boolean estaVazia();
    Element getHead();
    void setHead(Element<T> elemento);
    Element getTail();
    void setTail(Element<T> elemento);
    T getPrimeiro();
    T getUltimo();
    Element<T> retornaElemento(T conteudo);
    boolean extrair(T conteudo);
    void inserirNoInicio(T conteudo);
    void inserirNoFim(T conteudo);
    boolean inserirAntes(T contRef, T conteudo);
    boolean inserirDepois(T contRef, T conteudo);
    void atribuir(ListaEncadeadaSimples lista);              
}
