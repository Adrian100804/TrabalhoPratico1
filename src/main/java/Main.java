import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        String[] a = new String[m];
        String[] b = new String[n];

        for (int i = 0; i < m; i++) {
            a[i] = sc.next();
        }

        for (int i = 0; i < n; i++) {
            b[i] = sc.next();
        }

        ArrayList<Integer> posicoes = new ArrayList<>();
        ArrayList<String> ativos = new ArrayList<>();

        for (int i = 0; i < m; i++) {

            for (int j = n - 1; j >= 0; j--) {

                if (a[i].equals(b[j])) {
                    posicoes.add(j);
                    ativos.add(a[i]);
                }
            }
        }

        if (posicoes.isEmpty()) {
            System.out.println(0);
            System.out.println();
            sc.close();
            return;
        }

        int quantidade = posicoes.size();

        int[] fim = new int[quantidade];
        int[] indice = new int[quantidade];
        int[] anterior = new int[quantidade];

        Arrays.fill(anterior, -1);

        int tamanho = 0;

        for (int i = 0; i < quantidade; i++) {

            int esquerda = 0;
            int direita = tamanho;

            while (esquerda < direita) {

                int meio = (esquerda + direita) / 2;

                if (fim[meio] < posicoes.get(i)) {
                    esquerda = meio + 1;
                } else {
                    direita = meio;
                }
            }

            fim[esquerda] = posicoes.get(i);
            indice[esquerda] = i;

            if (esquerda > 0) {
                anterior[i] = indice[esquerda - 1];
            }

            if (esquerda == tamanho) {
                tamanho++;
            }
        }

        ArrayList<String> resposta = new ArrayList<>();

        int atual = indice[tamanho - 1];

        while (atual != -1) {
            resposta.add(ativos.get(atual));
            atual = anterior[atual];
        }

        Collections.reverse(resposta);

        System.out.println(resposta.size());

        for (int i = 0; i < resposta.size(); i++) {

            if (i > 0) {
                System.out.print(" ");
            }

            System.out.print(resposta.get(i));
        }

        System.out.println();

        sc.close();
    }
}