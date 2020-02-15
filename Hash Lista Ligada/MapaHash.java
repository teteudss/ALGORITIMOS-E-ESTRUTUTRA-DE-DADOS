package hashinglistaligada;

public class MapaHash {

    private ListaEncadeadaSimples<Registro>[] valores;

    public MapaHash() {
        valores = new ListaEncadeadaSimples[367];
    }

    public void inserir(Registro registro) {
        int posicao = registro.hashCode();
        if (valores[posicao] == null) {
            valores[posicao] = new ListaEncadeadaSimples();
            valores[posicao].inserirNoInicio(registro);
        } else {
            valores[posicao].inserirNoFim(registro);
        }
    }

    public Registro pesquisar(String key) {
        Registro r = new Registro();
        r.setKey(key);
        int posicao = r.hashCode();
        if (valores[posicao] == null) {
            return null;
        } else {
            Registro resultado = valores[posicao].getPrimeiro();
            if (resultado != null && resultado.getKey().equals(key)) {
                return resultado;
            } else {
                Element<Registro> elem = valores[posicao].getHead();
                while (resultado != null) {
                    elem = elem.getNext();
                    resultado = elem.getData();
                    if (resultado != null && resultado.getKey().equals(key)) {
                        return resultado;
                    }
                }
            }
            return null;
        }
    }

    public boolean remover(String key) {
        Registro r = new Registro();
        r.setKey(key);
        int posicao = r.hashCode();
        if (valores[posicao] == null) {
            return false;
        } else {
            Registro resultado = valores[posicao].getPrimeiro();
            if (resultado != null && resultado.getKey().equals(key)) {
                return valores[posicao].extrair(resultado);
            } else {
                Element<Registro> elem = valores[posicao].getHead();
                while (resultado != null) {
                    elem = elem.getNext();
                    resultado = elem.getData();
                    if (resultado != null && resultado.getKey().equals(key)) {
                        return valores[posicao].extrair(resultado);
                    }
                }
            }
            return false;
        }
    }

    public void imprimir() {
        boolean vazia = true;
        System.out.println("        Nome  Aniversario");
        for (int i = 0; i < 367; i++) {
            if (valores[i] != null && !valores[i].estaVazia()) {
                for (Element<Registro> j = valores[i].getHead(); j != null; j = j.getNext()) {
                    System.out.printf("%12s %12s\n", j.getData().getKey(), j.getData().getValue());
                }
                vazia = false;
            }
        }
        if (vazia) {
            System.out.println("      Tabela vazia!");
        }
    }
}
