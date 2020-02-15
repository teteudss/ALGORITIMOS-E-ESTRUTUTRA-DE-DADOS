package listaclassificadaencadeada;
public class ListaClassificadaEncadeada implements ListaClassificada {
    private ListaEncadeada lista;
    int count;

    public ListaClassificadaEncadeada(){
        lista = new ListaEncadeada();
        count = 0;

    }
    public void inserir (Object objeto){
        lista.inserirFim(objeto);
        count ++;
    }
    public Object get (int offset){
      if (offset <0 || offset >=count)
        throw new
        IndexOutOfBoundsException();
       ListaEncadeada.Element ptr;
        ptr = lista.getHead();

      for(int i=0;i<offset && ptr!=null;i++)
        ptr = ptr.getNext();

        return ptr.getData();
    }
    public boolean eMembro (Object objeto){
        ListaEncadeada.Element ptr;
            for (ptr=lista.getHead();
                ptr!=null; ptr=ptr.getNext()){
                if (ptr.getData() == objeto)

        return true;

    }

        return false;
    }
    public Object procurar(Object arg){
        ListaEncadeada.Element ptr;
            for (ptr = lista.getHead();
                ptr!=null; ptr = ptr.getNext()){
                Object obj = ptr.getData();

            if (obj.equals(arg))

                return obj;
    }
    public Object remover (objeto){
        if (count == 0)
    //throw ContainerVazioExceptiom();
            lista.extrair(objeto);
                count--;

    }
}
