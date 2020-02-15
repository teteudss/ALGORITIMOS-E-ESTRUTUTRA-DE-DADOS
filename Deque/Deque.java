package deque;

public interface Deque {

   public void fazVazia();
   public boolean estaVazia();
   public int getPrimeiro();
   public int getUltimo();
   public void enfileirarInicio(int valor);
   public void enfileirarFinal(int valor);
   public int desinfileirarInici();
   public int desinfileirarFi();
    
}
