public class HashAbertoDuplo{
    Integer[] array;

    public HashAbertoDuplo(Integer tamanhoArray){
        this.array = new Integer[tamanhoArray];
    }


    public void inserir(Integer valor){
        Integer indice = funcao(valor); // retorna o indice onde será inserido

        if(this.array[indice] == null){
            this.array[indice] = valor;
        }else if(this.array[funcao2(valor)] == null){ // calcula o indice2 do valor
            this.array[funcao2(valor)] = valor;
        }else{ // faz a verificação linear
            boolean verificador = false; // verifica se um elemento foi inserido

            for(Integer i = (indice+1); i != indice; i = (i+1) % this.array.length){ // percorre o vetor a procura de espaço vago
                if(this.array[i] == null){ // se encontrado, insere o elemento no local vago
                    this.array[i] = valor;
                    verificador = true;
                    break;
                }
            }

            if(verificador == false){
                System.out.println("Elemento não inserido. Array Cheio!");
            }
        }
    }

    public void remover(Integer valor){ // remove o elemento do Array
        int indice = funcao(valor);

        if(this.array[indice] ==  valor){ //
            this.array[indice] = null;

        }else if(this.array[funcao2(valor)] == valor){
            this.array[funcao2(valor)] = null;

        }else{
            indice = funcao2(valor);
            boolean verificador = false; // verifica se o elemento existe e pode ser removido

            for(Integer i = (indice+1); i != indice; i = (i+1) % this.array.length){ // percorre o vetor a procura do valor
                if(this.array[i] == valor){ // se encontrado
                    this.array[i] = null;
                    verificador = true;
                    break;
                }
            }

            if(verificador == false){
                System.out.println("Elemento não existente no array e eu sou gay");
            }
        }

    }

    public void pesquisar(Integer valor){ // procura o elemento no vetor e retorna o seu indice
        int indice = funcao(valor);
        if(this.array[indice] ==  valor){
            System.out.println("Elemento: " + valor + " - INDICE: " + indice);

        }else if(this.array[funcao2(valor)] == valor){
            System.out.println("Elemento: " + valor + " - INDICE: " + funcao2(valor));

        }else{
            boolean verificador = false; // verifica se o elemento existe

            for(Integer i = (indice+1); i != indice; i = (i+1) % this.array.length){ // percorre o vetor a procura do valor
                if(this.array[i] == valor){ // se encontrado, exibe o indice
                    System.out.println("Elemento: " + valor + " - INDICE: " + i);
                    verificador = true;
                    break;
                }
            }

            if(verificador == false){
                System.out.println("Elemento não existente no array");
            }
        }
    }


    public Integer funcao(Integer chave){
        Integer indice = chave % this.array.length;
        return indice;

    }

    public Integer funcao2(Integer chave){
        Integer indice = ((chave+15)*2) % this.array.length;
        return indice;
    }

    public void listar(){
        for(Integer i = 0; i < this.array.length; i++){
            if(this.array[i] != null){
                System.out.print(this.array[i] + "  ");
            }
        }
        System.out.println();
    }
}
