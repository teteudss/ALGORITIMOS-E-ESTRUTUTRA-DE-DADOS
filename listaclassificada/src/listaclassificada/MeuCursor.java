package listaclassificada;
public class MeuCursor implements Cursor {
    private Object [] array;
    int offset;
    int count;
    
    MeuCursor(int offset){
        this.offset = offset;
    }

    @Override
    public Object getDado() {
      if(offset<0 || offset>= count){
          
      }
        return array[offset];
    }

    @Override
    public void inserirDepois(Object objeto) {
        if(offset < 0 || offset >= count){
            if(count == array.length){
                
            }else{
                int posInserir = offset +1 ;
                for (int i= count; i>posInserir; i--){
                    array[i] = array[i-1];
                    array[posInserir] = objeto;
                    count ++;
                }
            }
        }
        
    }

    @Override
    public void inserirAntes(Object objeto) {
       if(offset <0 || offset>= count){
           if(count == array.length){
               
           }else{
               for(int i=count; i>offset; i--)
                   array[i] = array[i-1];
               array[offset] = objeto;
               count ++;
           }
       }
    }

    @Override
    public void remover() {
      if(offset < 0 || offset >= count){
          if(count == 0){
              
          }else{
              int i = offset;
              while(i <count -1){
                  array[i] = array[i+1];
                  i++;
              }
              array[i] = null;
              count --;
          }
      }
    }
}
