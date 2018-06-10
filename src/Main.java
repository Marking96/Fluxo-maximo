
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    private static final String  path = "G:\\Marce\\Documents\\Desenvolvimento\\FluxoMaximo\\src\\entradas\\";
    public static void main(String[] args) throws Exception {

        Scanner sc1 = new Scanner(new FileReader(path+"grafo1.txt"));
        int numVs = sc1.nextInt();
        int inicio = sc1.nextInt();
        int fim = sc1.nextInt();
        int[][] grafo2 = new int[numVs][numVs];
            for (int u = 0; u < numVs; u++){
            for (int j =0 ; j < numVs; j++) {
                grafo2[u][j] = sc1.nextInt();
            }
        }
        EdmondsKarp e = new EdmondsKarp();
        System.out.println("O Fluxo maximo é de: " +
                e.edmondsKarp(grafo2, inicio, fim));
    }
}
