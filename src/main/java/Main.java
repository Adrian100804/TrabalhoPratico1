import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        int n = scanner.nextInt();

        String[] corretoraA = new String[m];
        String[] corretoraB = new String[n];

        for (int i = 0; i < m; i++) {
            corretoraA[i] = scanner.next();
        }

        for (int i = 0; i < n; i++) {
            corretoraB[i] = scanner.next();
        }

        List<String> consenso = encontrarConsenso(corretoraA, corretoraB, 0, 0);
        System.out.println(consenso.size());

        if (consenso.isEmpty()) {
            System.out.println();
        } else {
            for (int i = 0; i < consenso.size(); i++) {
                if (i > 0) {
                    System.out.print(" ");
                }

                System.out.print(consenso.get(i));
            }

            System.out.println();
        }

        scanner.close();
    }

    private static List<String> encontrarConsenso(String[] a, String[] b, int i, int j) {

        if (i == a.length || j == b.length) {
            return new ArrayList<>();
        }

        if (a[i].equals(b[j])) {

            List<String> resultado = encontrarConsenso(a, b, i + 1, j + 1);

            resultado.add(0, a[i]);

            return resultado;
        }

        List<String> ignorandoA = encontrarConsenso(a, b, i + 1, j);

        List<String> ignorandoB = encontrarConsenso(a, b, i, j + 1);

        if (ignorandoA.size() >= ignorandoB.size()) {
            return ignorandoA;
        }

        return ignorandoB;
    }
}