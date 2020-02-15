package hashinglistaligada;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        String texto;
        String chave;
        int continua;
        MapaHash mapa = new MapaHash();
        Registro r;

        System.out.println("INSERINDO...");
        do {
            System.out.print("Digite o nome (chave): ");
            chave = ler.next();
            System.out.print("Informe a data de aniversário: ");
            texto = ler.next();
            r = new Registro(chave, texto);
            System.out.println(r.hashCode());
            mapa.inserir(r);

            System.out.println("\nContinuar? (1-sim / 0-não)");
            continua = Integer.parseInt(ler.next());
        } while (continua != 0);

        System.out.println("\n===============================");
        System.out.println("PESQUISANDO...");
        do {
            System.out.print("Digite o nome (chave): ");
            chave = ler.next();
            r = mapa.pesquisar(chave);
            if (r != null) {
                System.out.println("Data de aniversário: " + r.getValue());
            } else {
                System.out.println("[ERRO] Não existe!");
            }

            System.out.println("\nContinuar? (1-sim / 0-não)");
            continua = Integer.parseInt(ler.next());
        } while (continua != 0);

        System.out.println("\n===============================");
        System.out.println("REMOVENDO...");
        do {
            System.out.print("Digite o nome (chave): ");
            chave = ler.next();
            if (mapa.remover(chave)) {
                System.out.println("Removido com sucesso!");
            } else {
                System.out.println("[ERRO] Não existe!");
            }

            System.out.println("\nContinuar? (1-sim / 0-não)");
            continua = Integer.parseInt(ler.next());
        } while (continua != 0);

        System.out.println("\n===============================");
        System.out.println("IMPRIMINDO...");
        System.out.println("Tabela hash:");
        mapa.imprimir();

    }

}
