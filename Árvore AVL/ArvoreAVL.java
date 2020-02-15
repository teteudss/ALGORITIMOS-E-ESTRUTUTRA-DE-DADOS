public class ArvoreAVL {

    private Elemento ele;
    private ArvoreAVL   dir;
    private ArvoreAVL   esq;
    private int         bal;//balanceamento

    //Cria uma Arvore com os valores tudo Null
    public ArvoreAVL(){
        this.ele = null;
        this.esq = null;
        this.dir = null;
        this.bal = 0;
    }
    //Cria uma Arvore com um Elemento
    public ArvoreAVL(Elemento elem){
        this.ele = elem;
        this.dir = null;
        this.esq = null;
        this.bal = 0;
        //System.out.println("Criei uma arvore com Elemento " + elem.getValor());
    }
    //Metodos de controle
    
    //Metodo Calcular a Altura
    public int calcularAltura(){
        if(this.esq == null && this.dir == null){ //Nao tem nenhum filho
            return 1;
        }
        else if (this.esq != null && this.dir == null){ // so tem filhos a esquerda
            return 1 + this.esq.calcularAltura();   //vai calcular a altura do lado esquerdo (vai ser o no mais a descendencia)
        }
        else if(this.esq == null && this.dir != null){ //So tem filhos a direita
            return 1 + this.dir.calcularAltura();       // vai calcular a altura do lado direito
        }
        else{
            return 1+ Math.max(this.esq.calcularAltura(), this.dir.calcularAltura());//Vai pegar a altura maxima para calcular metodo MAth
        
    }

    //Metodo para calcular o balanceamento
    //Balancemanto sempre e AlturaDaDireita - AlturaDaEsquerda
    //Balanceamento Positivo Direita ta tensa
    //Balanceamento Negativo Esquerda ta tensa
    public void calcularBalanceamento(){
        if(this.dir == null && this.esq == null){
            this.bal = 0;
        }
        else if(this.esq == null && this.dir != null){ //tem descendencia a direita
            this.bal = this.dir.calcularAltura() - 0;
        }
        else if(this.esq != null && this.dir == null){
            this.bal = 0 - this.esq.calcularAltura();
        }
        else{
            this.bal = this.dir.calcularAltura() - this.esq.calcularAltura();
        }
        if(this.dir != null) this.dir.calcularBalanceamento();
        if(this.esq != null) this.esq.calcularBalanceamento();
    }

    //Metodos de verificacao e Rotaçao
    public ArvoreAVL verificaBalanceamento(){
        if(this.bal >= 2 || this.bal <= -2){
            if(this.bal >= 2 ){
                if(this.bal * this.dir.getBalanceamento() > 0 ){
                    System.out.println("Rotacao Simples Direita");
                    return rotacaoSimplesDireita();
                }else{
                    System.out.println("Rotacao Dupla Direita");
                    return rotacaoDuplaDireita();
                }
            }
            else{ //balanceamento <= -2
                if(this.bal * this.esq.getBalanceamento() > 0){
                    System.out.println("Rotacao Simples Esquerda");
                    return rotacaoSimplesEsquerda();
                }else{
                    System.out.println("Rotacao Dupla Esquerda");
                    return rotacaoDuplaEsquerda();
                }

            }
        }
        this.calcularBalanceamento();
        if(this.esq != null ) this.esq = this.esq.verificaBalanceamento();
        if(this.dir != null ) this.dir = this.dir.verificaBalanceamento();
        return this;
    }

    public ArvoreAVL rotacaoSimplesDireita(){
        ArvoreAVL filhoDir;
        ArvoreAVL filhoDoFilho = null;

        filhoDir = this.getDireita();
        if(this.dir != null){
            if(this.dir.getEsquerda() != null){
                filhoDoFilho = filhoDir.getEsquerda();
            }
        }
        filhoDir.setEsq(this);
        this.setDir(filhoDoFilho);
        return filhoDir;
    }
    public ArvoreAVL rotacaoSimplesEsquerda(){
        ArvoreAVL filhoEsq;            
        ArvoreAVL filhoDoFilho = null;

        filhoEsq = this.getEsquerda();
        if(this.esq != null){
            if(this.esq.getDireita() != null){
                filhoDoFilho = filhoEsq.getDireita();
            }
        }
        filhoEsq.setDir(this);
        this.setEsq(filhoDoFilho);
        return filhoEsq;
    }

    public ArvoreAVL rotacaoDuplaDireita(){
        ArvoreAVL arvore = this;    //Criar uma Arvore q recebe ela msm
        ArvoreAVL filhoDir = this.getDireita(); // o filho do no raiz recebe o valor da direita
        ArvoreAVL filhoDoFilho = filhoDir.getEsquerda(); // o filho do filho recebe o valor da esuqerda
        ArvoreAVL noInserido = filhoDoFilho.getDireita(); //o novo elemento recebe o filho do filho a direita
        //Alinhamento
        filhoDir.setEsq(noInserido);    //o filho a direita recebe o valor 
        filhoDoFilho.setDir(filhoDir);  //o filho do filho recebe o filho a direita
        this.setDir(filhoDoFilho);      //o valor da direita logo e o filho fo filho
        //Tornar o filho á direitra a nova raiz
        ArvoreAVL novoFilhoDireita = this.getDireita(); //chama o filho da direita e referencia ele com o valor da direita
        arvore.setDir(null);    // o valor a direita recebe null
        novoFilhoDireita.setEsq(arvore); // o novo filho recebe o valor da esquerda da arvore
        return novoFilhoDireita; //retorna o valor do filho
    }

    public ArvoreAVL rotacaoDuplaEsquerda(){
        ArvoreAVL arvore = this;
        ArvoreAVL filhoEsq = this.getEsquerda();
        ArvoreAVL filhoDoFilho = filhoEsq.getDireita();
        ArvoreAVL noInserido = filhoDoFilho.getEsquerda();
        //Alinhamento
        filhoEsq.setDir(noInserido);
        filhoDoFilho.setEsq(filhoEsq);
        this.setEsq(filhoDoFilho);
        //Tornar o filho á Esquerda a nova raiz
        ArvoreAVL novoFilhoEsquerda = this.getEsquerda();
        arvore.setEsq(null);
        novoFilhoEsquerda.setDir(arvore);
        return novoFilhoEsquerda;
        
    }


    //metodo para verificar se a arvore esta vazia
    public boolean isEmpty(){
        return(this.ele == null);
    
    }
    /*metodo para inserção dos elementos
     *Verifica se a arvore está vazia se sim ele pega o elemento e aponta,
     *para o novo.
    */

    public ArvoreAVL inserir(Elemento novo){
        if(isEmpty()){          
            this.ele = novo;    
        }
        else{
            ArvoreAVL novaArvore = new ArvoreAVL(novo);
            if(novo.getValor()< this.ele.getValor()){  //Se o novo elemento valor for menor que o outro valor inserir na esquerda
                if(this.esq == null){//sou um nó folha ?
                    this.esq = novaArvore;
                    //System.out.println("Inserir o elemento " + novo.getValor() + " à esquerda de " + this.ele.getValor());
                }
                else{
                    this.esq = this.esq.inserir(novo);//Repassei a responsabilidade pra sub arvore a esquerda
                }
            }
            else if(novo.getValor() > this.ele.getValor()){ //Se o novo elemento valor for maior que o outro valor inserir na direita
                if(this.dir == null){//sou um nó folha ?
                    this.dir = novaArvore;
                    //System.out.println("Inserir o elemento " + novo.getValor() + " à direita de " + this.ele.getValor());
                }else{
                    this.dir = this.dir.inserir(novo);
                }        
            
            }
        }
        return this;
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
    public ArvoreAVL remover(Elemento elem){
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
                    ArvoreAVL aux = this.esq;
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
    public int getBalanceamento(){
        return this.bal;
    }
    public void setBalanceamento(int bal){
        this.bal = bal;
    }
    public void setElemento(Elemento ele){
        this.ele = ele;
    }
    public void setDir(ArvoreAVL dir){
        this.dir = dir;
    }
    public void setEsq(ArvoreAVL esq){
        this.esq = esq;
    }
    public ArvoreAVL getDireita(){
        return this.dir;
    }
    public ArvoreAVL getEsquerda(){
        return this.esq;
    }
    public Elemento getElemento(){
        return this.ele;
    }

    //Metodo de depuração
    public String printArvore(int level){
        String str = this.toString() + "\n";
        for(int i = 0; i < level; i++){
            str += "\t";
        }
        if(this.esq != null){
            str += "+- ESQ: " +this.esq.printArvore(level + 1);
        }else{
            str += "+-ESQ: NULL ";
        }
        str += "\n";

        for(int i = 0; i < level; i++){
            str += "\t";
        }
        if(this.dir != null){
            str += "+- DIR: " +this.dir.printArvore(level + 1);
        }else{
            str += "+-DIR: NULL ";
        }
        str += "\n";
        return str;
    }

    public String toString(){
        return "[" + this.ele.getValor()+"] (" + this.bal + ")";
    }
}