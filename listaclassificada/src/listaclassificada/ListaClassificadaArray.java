
package listaclassificada;

public class ListaClassificadaArray implements ListaClassificada {
    private Object [] array;
    int count;
 
    public ListaClassificadaArray(int tam){
        array = new Object[tam];
        count = 0;
    }
    public void inserir (Object objeto){
        if(count == array.length){
           // throw new ContainerCheioExeption();
        }else{
            array[count] = objeto;
            count ++;
        }
    }
    public boolean eMembro (Object o){
        for (int i=0; i < count ;i++){
            if(array[i].equals(o))
                return true;
        }
        return false;
    }
    public Object procurar (Object o){
        for (int i=0; i<count;i++){
            if (array[i].equals(o))
                return array[i];
        }
        return null;
    }
    public void remover (Object objeto){
        if(count == 0){
        //trow new ContainerVazioException();
        }else{
            int i = 0;
            while(i<count && array[i] != objeto)
                i++;
            if(i == count){
               // trow new ArgumentoIvalidoException();
            }else{
                for(; i<count -1; i++)
                    array[i] = array[i+1];
                array[i] = null;
                count -- ;
            }
               
        }
    }
    public Cursor procurarPosicao(Object objeto){
        int  i = 0;
        while(i<count && !array[i].equals(objeto))
            i++;
        return new MeuCursor(i);
    }
    public Object get (int offset){
        if(offset<0 || offset>= count){
          //  throw new IndexOutOfBoundsExceptions();
        }
        return array[offset];
    }
}
