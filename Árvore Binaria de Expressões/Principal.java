import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		String[] letras;
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite a expressao matematica: ");
		String entrada = scan.next();
		/*
		 * Exemplos para teste: (((8-7)+(5/5))/((4-3)-(2+1))) = -1
		 * ((6-(4*3))/(2*1)) = -3
		 */
		String palavra = infixaToPosfixa(entrada);
		System.out.println("PosFixa: " + palavra);
		letras = palavra.split("");
		String conta = "";
		Pilha p = new Pilha();
		for (int i = 0; i < letras.length; i++) {
			p.push(letras[i]);
		}
		System.out.println(" ");
		for (int i = 0; i < letras.length; i++) {
			conta += p.pop();
		}
		letras = conta.split("");
		Arvore ar = new Arvore();
		for (int i = 0; i < letras.length; i++) {
			ar.add = false;
			ar.raiz = ar.criar(ar.raiz, letras[i]);
		}
		System.out.printf("Esquerda Raiz Direita: ");
		ar.imprimirEsqRaizDir(ar.raiz);
		System.out.printf("\nRaiz Esquerda Direita: ");
		ar.imprimirRaizEsqDir(ar.raiz);
		System.out.printf("\nEsquerda Direita Raiz: ");
		ar.imprimirEsqDirRaiz(ar.raiz);
		System.out.println();
		ar.soma(ar.raiz);
		
		scan.close();

	}

	public static String infixaToPosfixa(String exp) {
		Pilha pilha = new Pilha(); /* mantem os parïrenteses e operadores */

		String resultado = "", c;
		String[] v = exp.split("");
		/*
		 * pilha.pop() ira retornar o caractere # quando a pilha estiver vazia
		 */
		for (int i = 0; i < v.length; i++) {
			switch (v[i]) {
			case "(": /* empilha o ( */
				pilha.push(v[i]);
				break;
			case ")": /*
						 * desempilha enquanto o topo da pilha for diferente de
						 * (
						 */
				c = pilha.pop();
				while (!c.equals("(") && !c.equals("#")) {
					resultado = resultado + c;
					c = pilha.pop();
				}
				break;
			case "+":
			case "-": /*
						 * desempilha enquanto o topo da pilha for diferente de
						 * (
						 */
				c = pilha.pop();
				while (!c.equals("(") && !c.equals("#")) {
					resultado = resultado + c;
					c = pilha.pop();
				}
				pilha.push(c);
				pilha.push(v[i]);
				break;
			case "*":
			case "/":
				/*
				 * desempilha enquanto o topo da pilha for diferente de (, + e -
				 */
				c = pilha.pop();
				while (!c.equals("(") && !c.equals("+") && !c.equals("-") && !c.equals("#")) {
					resultado = resultado + c;
					c = pilha.pop();
				}
				pilha.push(c);
				pilha.push(v[i]);
				break;
			default: /* empilha o operando */
				resultado = resultado + v[i];
			}
		}
		return resultado;
	}

}