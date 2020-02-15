public class No{
    private int elemento;
    private No proximo;

    public No(int element){
        this.elemento = element;
        this.proximo = null;
    }

    public void setElemento(int element){
        this.elemento = element;
    }

    public int getElemento(){
        return this.elemento;
    }

    public void setProximo(No proximo){
        this.proximo = proximo;
    }

    public No getProximo(){
        return this.proximo;
    }

    public void inserir(No novo){
        if(this.proximo != null){
            this.proximo.inserir(novo);
        }else{
            this.proximo = novo;
        }
    }

    public void remover(int valor){
        if(this.proximo.getElemento() == valor){
            this.proximo = this.proximo.getProximo();
        }else{
            this.proximo.remover(valor);
        }
    }

    public Integer pesquisa(Integer qtd, Integer valor){ // qtd significa qual a posição do elemento na lista
        qtd++;
        if(this.elemento == valor){
            return qtd;
        }else{
            if(this.proximo != null){
                return this.proximo.pesquisa(qtd, valor);
            }
        }
        return null;
    }

    public void listar(){
        System.out.print(this.elemento);
        if(this.proximo != null){
            System.out.print(" - ");
            this.proximo.listar();
        }
    }

}//fim classe
