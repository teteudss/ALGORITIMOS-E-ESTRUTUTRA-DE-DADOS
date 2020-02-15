package hashinglistaligada;

public class ListaEncadeadaSimples<T> implements Lista<T> {

    private Element<T> head, tail;

    @Override
    public void fazVazia() {
        this.head = this.tail = null;
    }

    @Override
    public boolean estaVazia() {
        return this.head == null;
    }

    @Override
    public Element<T> getHead() {
        return this.head;
    }

    @Override
    public void setHead(Element<T> elemento) {
        this.head = elemento;
    }

    @Override
    public Element<T> getTail() {
        return this.tail;
    }

    @Override
    public void setTail(Element<T> elemento) {
        this.tail = elemento;
    }

    @Override
    public T getPrimeiro() {
        return this.head.getData();
    }

    @Override
    public T getUltimo() {
        return this.tail.getData();
    }

    @Override
    public Element<T> retornaElemento(T conteudo) {
        if (!estaVazia()) {
            for (Element<T> el = this.head; el != null; el = el.getNext()) {
                if (el.getData() == conteudo) {
                    return el;
                }
            }
            return null;
        } else {
            return null;
        }
    }

    @Override
    public boolean extrair(T conteudo) {
        if (!estaVazia()) {
            if (this.head.getData() == conteudo) {
                this.head = head.getNext();
                return true;
            } else {
                for (Element<T> el = this.head; el.getNext() != null; el = el.getNext()) {
                    if (el.getNext().getData() == conteudo) {
                        if (el.getNext() == this.tail) {
                            this.tail = el;
                        }
                        el.setNext(el.getNext().getNext());
                        return true;
                    }
                }
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public void inserirNoInicio(T conteudo) {
        this.head = new Element<>(conteudo, head);
        if (tail == null) {
            this.tail = this.head;
        }
    }

    @Override
    public void inserirNoFim(T conteudo) {
        Element<T> el = new Element<>(conteudo, null);
        if (estaVazia()) {
            this.head = this.tail = el;
        } else {
            this.tail.setNext(el);
            this.tail = el;
        }
    }

    @Override
    public boolean inserirAntes(T contRef, T conteudo) {
        Element<T> ref = retornaElemento(contRef);
        if (ref != null) {
            if (ref == this.head) {
                inserirNoInicio(conteudo);
            } else {
                Element<T> novo = new Element<>(conteudo, ref);
                for (Element<T> el = this.head; el != null; el = el.getNext()) {
                    if (el.getNext() == ref) {
                        el.setNext(novo);
                        break;
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean inserirDepois(T contRef, T conteudo) {
        Element<T> ref = retornaElemento(contRef);
        if (ref != null) {
            if (ref == this.tail) {
                inserirNoFim(conteudo);
            } else {
                Element<T> novo = new Element<>(conteudo, ref.getNext());
                ref.setNext(novo);
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void atribuir(ListaEncadeadaSimples lista) {
        if (lista != this) {
            this.fazVazia();
            for (Element<T> i = lista.getHead(); i != null; i = i.getNext()) {
                this.inserirNoFim(i.getData());
            }
        }
    }

    public void imprimir() {
        for (Element<T> i = head; i != null; i = i.getNext()) {
            System.out.print(i.getData() + " ");
        }
        System.out.println();
    }
}