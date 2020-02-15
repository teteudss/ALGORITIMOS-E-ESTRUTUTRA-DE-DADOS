public class Arvore {

    private Elemento ele;
    private Arvore   dir;
    private Arvore   esq;

    //Cria uma Arvore com os valores tudo Null
    public Arvore(){
        this.ele = null;
        this.esq = null;
        this.dir = null;
    }
    //Cria uma Arvore com um Elemento
    public Arvore(Elemento elem){
        this.ele = elem;
        this.dir = null;
        this.esq = null;
        //System.out.println("Criei uma arvore com Elemento " + elem.getValor());
    }
    //Metodos de controle

    //metodo para verificar se a arvore esta vazia
    public boolean isEmpty(){
        return(this.ele == null);
    }

    //Metodo para imprimir os valores em ordem
    public void imprimirInOrdem(){
        if(!isEmpty()){
            if(this.esq != null){
                this.esq.imprimirInOrdem();
            }
            System.out.print(this.ele.getValor() + " ");
            if(this.dir != null){
                this.dir.imprimirInOrdem();
            }
        }
    }

    /*metodo para inserção dos elementos
     *Verifica se a arvore está vazia se sim ele pega o elemento e aponta,
     *para o novo.
    */

    public void inserir(Elemento novo){
        if(isEmpty()){          
            this.ele = novo;    
        }
        else{
            Arvore novaArvore = new Arvore(novo);
            if(novo.getValor()< this.ele.getValor()){  //Se o novo elemento valor for menor que o outro valor inserir na esquerda
                if(this.esq == null){//sou um nó folha ?
                    this.esq = novaArvore;
                    //System.out.println("Inserir o elemento " + novo.getValor() + " à esquerda de " + this.ele.getValor());
                }
                else{
                    this.esq.inserir(novo);//Repassei a responsabilidade pra sub arvore a esquerda
                }
            }
            else if(novo.getValor() > this.ele.getValor()){ //Se o novo elemento valor for maior que o outro valor inserir na direita
                if(this.dir == null){//sou um nó folha ?
                    this.dir = novaArvore;
                    //System.out.println("Inserir o elemento " + novo.getValor() + " à direita de " + this.ele.getValor());
                }else{
                    this.dir.inserir(novo);
                }        
            
            }
        }
    }

    /*
    *Metodo que faz busca de elementos dentro da arvore
    */

    public boolean busca(int valor){
        if(isEmpty()){
            return false;
        }
        if(this.ele.getValor() == valor){
            return true;
        }
        else{
            if(valor < this.ele.getValor() ){
                if(this.esq == null){
                    return false;
                }
                else{
                    return this.esq.busca(valor);//Repassei a responsabilidade para a subarvore esquerda
                }
            }
            else if(valor > this.ele.getValor()){
                if(this.dir == null){
                    return false;
                }
                else{
                    return this.dir.busca(valor);
                }
            }
            return false;
        }
    }
      /*
    *Metodo que faz Remorção do no na Arvore
    */
    public Arvore remover(Elemento elem){
        //Primeiro caso - Achei o Elemento
        if(this.ele.getValor() == elem.getValor()){
            //caso simples o elemento esta em nó folhas
            //Não tem filhos a direita nem a esquerda
            if(this.dir == null && this.esq == null){
                return null;
            } 
            else{
                //Caso 2 - Tem filhos a esquerda, porem nao a direita
                if(this.esq != null && this.dir == null ){
                    return this.esq;
                }
                //Caso 3 - Tem filhos a direita, porem nao a esquerda
                else if(this.dir != null && this.esq == null){
                    return this.dir;
                }
                else{
                    //Caso 4 - Tem filhos dos dois lados - verifica os maiores dentre os menores
                    Arvore aux = this.esq;
                    //Equanto ouver filhos a direita
                    while(aux.dir != null){
                        aux = aux.dir;

                    }
                    //Troco os elementos da arvore
                    this.ele = aux.getElemento();   //O no atual recebe o elemento aux o maior entre os menores 
                    aux.setElemento(elem);          //Insiro no no folha o elemento a ser eliminado
                    this.esq = esq.remover(elem);

                }
            }
        }  
        else if(elem.getValor() < this.ele.getValor()){
            //se o elemento for menor delega a responsabilidade a sub arvore da esquerda
            this.esq = this.esq.remover(elem); 
        }
        else if(elem.getValor() > this.ele.getValor() ){
            //se o elemento for maior delega a responsabilidade a sub arvore da direita
            this.dir = this.dir.remover(elem);
        }
        //se nao for nem um nem outro logo nao encontrei o elemento e rretorna a propia arvora
        return this;
    }

    //GETTERS E SETTERS

    public void setElemento(Elemento ele){
        this.ele = ele;
    }
    public void setDir(Arvore dir){
        this.dir = dir;
    }
    public void setEsq(Arvore esq){
        this.esq = esq;
    }
    public Arvore getDireita(){
        return this.dir;
    }
    public Arvore getEsquerda(){
        return this.esq;
    }
    public Elemento getElemento(){
        return this.ele;
    }
}