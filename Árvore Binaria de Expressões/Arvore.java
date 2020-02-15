public class Arvore {
    
	public No raiz;
	static float soma = 0;
	public boolean add;
	
	/* retorna a altura de uma arvore binaria */
	public int altura(No no) {
		if (no == null) {
			return -1; /* arvore vazia */
		} else {
			int altEsq = altura(no.esquerdo);
			int altDir = altura(no.direito);
			return altEsq < altDir ? altDir + 1 : altEsq + 1;
		}
	}

	/* libera a arvore que se encontra abaixo do no */
	public No limpar(No no) {
		if (no != null) {
			no.esquerdo = limpar(no.esquerdo); /* limpa o lado esquerdo */
			no.direito = limpar(no.direito); /* limpa o lado direito */
		}
		return null;
	}

	public boolean buscar(No no, String nro) {
		if (no == null) {
			return false; /* nao encontrou */
		} else {
			return nro == no.conteudo || buscar(no.esquerdo, nro) || buscar(no.direito, nro);
		}
	}

	boolean Operador(String s) {
		try {
			Integer.parseInt(s);
			return false;

		} catch (Exception e) {
			return true;
		}
	}

	boolean naoNumero(No no) {
		try {
			Integer.parseInt(no.conteudo);
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	public No criar(No no, String str) {
		if (no == null) { // Arvore vazia
			no = new No();
			no.conteudo = str;
			add = true; // condição para nao entrar no ultimo if
		} else if (naoNumero(no.direito)) {
			no.direito = criar(no.direito, str);
		}
		/*
		 * Caso nao encontrou nenhum lugar do lado direito, insere no lado
		 * esquerdo
		 */
		if ((!add) & naoNumero(no.esquerdo)) {
			no.esquerdo = criar(no.esquerdo, str);
		}

		return no;
	}

	/* varredura infixa ou em ordem ou simetrica */
	public void imprimirEsqRaizDir(No no) {
		if (no != null) {
			imprimirEsqRaizDir(no.esquerdo);
			System.out.print(no.conteudo + " ");
			imprimirEsqRaizDir(no.direito);
		}
	}

	/* varredura prefixa ou pre-ordem */
	public void imprimirRaizEsqDir(No no) {
		if (no != null) {
			System.out.print(no.conteudo + " ");
			imprimirRaizEsqDir(no.esquerdo);
			imprimirRaizEsqDir(no.direito);
		}
	}

	

	/* varredura posfixa ou pos-ordem */
	public void imprimirEsqDirRaiz(No no) {
		if (no != null) {
			imprimirEsqDirRaiz(no.esquerdo);
			imprimirEsqDirRaiz(no.direito);
			System.out.print(no.conteudo + " ");
		}
	}

	public void soma(No no) {
		if (no != null) {
			/*
			 * Percorre a arvore (Esquerda Direita Raiz) ate encontrar um numero
			 * Quando encontrar, pega o primeiro operando e faz os calculos
			 */
			soma(no.esquerdo);
			soma(no.direito);
			if (Operador(no.conteudo)) {
				switch (no.conteudo) {
				/*
				 * Quando for calcular, o nó do operando recebe o valor do
				 * calculo e anula os nós direito e esquerdo
				 */
				case "+":
					soma = Float.parseFloat(no.esquerdo.conteudo) + Float.parseFloat(no.direito.conteudo);
					System.out.println("Soma:" + soma);
					no.conteudo = "" + soma;
					no.direito = null;
					no.esquerdo = null;
					break;
				case "-":
					soma = Float.parseFloat(no.esquerdo.conteudo) - Float.parseFloat(no.direito.conteudo);
					System.out.println("Sub:" + soma);
					no.conteudo = "" + soma;
					no.direito = null;
					no.esquerdo = null;
					break;
				case "/":
					soma = Float.parseFloat(no.esquerdo.conteudo) / Float.parseFloat(no.direito.conteudo);
					System.out.println("Div:" + soma);
					no.conteudo = "" + soma;
					no.direito = null;
					no.esquerdo = null;
					break;
				case "*":
					soma = Float.parseFloat(no.esquerdo.conteudo) * Float.parseFloat(no.direito.conteudo);
					System.out.println("Mult:" + soma);
					no.conteudo = "" + soma;
					no.direito = null;
					no.esquerdo = null;
					break;
				}
			}
		}
	}
}