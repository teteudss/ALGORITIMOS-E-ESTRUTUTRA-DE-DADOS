import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Arvore {

    private NoBinario raiz;

    public NoBinario getRaiz() {
        return raiz;
    }

    public void insereElemento(int valor) {
        if (this.raiz == null) {
            raiz = new NoBinario(valor);
        } else {
            insereRecursivo(this.raiz, valor);
        }
    }

    private void insereRecursivo(NoBinario no, int valor) {

        if (valor < no.getConteudo()) { //insere na subarvore esquerda
            if (no.getEsquerda() == null) {
                NoBinario nonovo = new NoBinario(valor);
                no.setEsquerda(nonovo);
            } else {
                insereRecursivo(no.getEsquerda(), valor);
            }
        } else { //insere na subarvore direita

            if (no.getDireita() == null) {
                NoBinario nonovo = new NoBinario(valor);
                no.setDireita(nonovo);
            } else {
                insereRecursivo(no.getDireita(), valor);
            }

        }
    }

    public NoBinario buscarElemento(int valor) {

        if (this.raiz == null) {
            return null;
        } else {
            return buscaRecursivo(this.raiz, valor);
        }
    }

    private NoBinario buscaRecursivo(NoBinario no, int valor) {

        if (valor == no.getConteudo()) {
            return no;
        } else {

            if (valor < no.getConteudo()) { //busca na subarvore esquerda
                if (no.getEsquerda() == null) {
                    return null;
                } else {
                    return buscaRecursivo(no.getEsquerda(), valor);
                }
            }//fim subarvore esquerda
            else { //busca na subarvore direita
                if (no.getDireita() == null) {
                    return null;
                } else {
                    return buscaRecursivo(no.getDireita(), valor);
                }

            }
        }
    }

    private boolean estahNaArvoreRecursivo(NoBinario no, int valor) {

        if (valor == no.getConteudo()) {
            return true;
        } else {

            if (valor < no.getConteudo()) { //busca na subarvore esquerda
                if (no.getEsquerda() == null) {
                    return false;
                } else {
                    return estahNaArvoreRecursivo(no.getEsquerda(), valor);
                }
            }//fim subarvore esquerda
            else { //busca na subarvore direita
                if (no.getDireita() == null) {
                    return false;
                } else {
                    return estahNaArvoreRecursivo(no.getDireita(), valor);
                }

            }
        }
    }

    public boolean estahNaArvore(int valor) {
        if (this.raiz == null) {
            return false;
        } else {
            return estahNaArvoreRecursivo(this.raiz, valor);
        }
    }

    public static void imprimePreOrdem(NoBinario no) {
        if (no != null) {
            System.out.print(no.getConteudo() + " ");
            imprimePreOrdem(no.getEsquerda());
            imprimePreOrdem(no.getDireita());
        }
    }
    
   

    public static void imprimeInOrdem(NoBinario no) {
        if (no != null) {
            imprimeInOrdem(no.getEsquerda());
            System.out.print(no.getConteudo() + " ");
            imprimeInOrdem(no.getDireita());
        }
    }

    public static void imprimePosOrdem(NoBinario no) {
        if (no != null) {
            imprimePosOrdem(no.getEsquerda());
            imprimePosOrdem(no.getDireita());
            System.out.print(no.getConteudo() + " ");
        }
    }

    public void imprimeLargura() {
        Queue<NoBinario> fila;
        fila = new LinkedList();
        NoBinario temp;
        if (raiz != null) {
            fila.add(raiz);
            while (!fila.isEmpty()) {
                //remove da fila
                temp = fila.poll();

                System.out.print(temp.getConteudo() + " ");

                if (temp.getEsquerda() != null) {
                    fila.add(temp.getEsquerda());
                }

                if (temp.getDireita() != null) {
                    fila.add(temp.getDireita());
                }
            }
        }
    }
    
      
    
       // metodos imprime com pilha
    public void preOrdemPilha() {
        Stack<NoBinario> pilha = new Stack<>();
        pilha.push(this.raiz);
        NoBinario p;
        while (!pilha.empty()) {
            p = pilha.pop();
            System.out.print(p.getConteudo() + " ");
            if (p.getDireita() != null) {
                pilha.push(p.getDireita());
            }
            if (p.getEsquerda() != null) {
                pilha.push(p.getEsquerda());
            }
        }

    }

    public void inOrdemPilha() {
        NoBinario p = this.raiz;
        if(p == null){
            return;
        }
        Stack <NoBinario> pilha = new Stack<>();
        while(p != null || !pilha.empty()){
            if(p != null){
                pilha.push(p);
                p = p.getEsquerda();
            }else{
                p = pilha.pop();
                System.out.print(p.getConteudo() + " ");
                p = p.getDireita();
            }
        }
        
    }
    
    public void posOrdemPilha(){
        Stack <NoBinario> pilha1 = new Stack<>();
        Stack <NoBinario> pilha2 = new Stack<>();
        
        NoBinario p = this.raiz;
        pilha1.push(p);
        while(!pilha1.empty()){
            p = pilha1.pop();
            pilha2.push(p);
            if(p.getEsquerda() != null){
                pilha1.push(p.getEsquerda());
            }
           if (p.getDireita() != null){
               pilha1.push(p.getDireita());
           }
        }
        while(pilha2.empty()){
            p = pilha2.pop();
            System.out.print(p.getConteudo() + " ");
        }
    }

}
