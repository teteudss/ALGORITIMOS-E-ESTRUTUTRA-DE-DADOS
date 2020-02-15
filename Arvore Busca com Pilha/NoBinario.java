public class NoBinario {
private int conteudo;
private NoBinario esq, dir;

public NoBinario(int c, NoBinario e, NoBinario d){
this.conteudo = c;
this.esq = e;
this.dir = d;
}

public NoBinario(int c){
this.conteudo = c;
this.esq = null;
this.dir = null;
}


public int getConteudo(){
return this.conteudo;
}

public void setConteudo(int c){
this.conteudo = c;
}

public NoBinario getEsquerda() {
return this.esq;
}

public void setEsquerda(NoBinario noesq){
this.esq = noesq;
}

public NoBinario getDireita(){
return this.dir;
}

public void setDireita(NoBinario nodir){
this.dir = nodir;
}

}
