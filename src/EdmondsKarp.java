
import java.util.ArrayList;
import java.util.LinkedList;

public class EdmondsKarp {
    public int edmondsKarp(int[][] rGrafo, int s, int t) {
        int FuxoMax = 0;
        ArrayList<Vertices> caminho = null;
        while ((caminho = buscaEmLargura(rGrafo, s, t)) != null) {
            System.out.print("Caminho: ");
            for (Vertices p : caminho)
                System.out.print(p.getX() + " -> ");
            System.out.println(t);

            int Fluxo = Integer.MAX_VALUE;
            for (Vertices p : caminho)
                Fluxo = Math.min(Fluxo, rGrafo[p.getX()][p.getY()]);
            System.out.println("  Fluxo no caminho: " + Fluxo);


            for (Vertices p : caminho) {
                int u = p.getX();
                int v = p.getY();
                rGrafo[u][v] -= Fluxo;
                rGrafo[v][u] += Fluxo;
            }
            FuxoMax += Fluxo;
        }
        return FuxoMax;
    }
    private static ArrayList<Vertices> buscaEmLargura(int[][] rGrafo, int s, int t) {

        int numVs = rGrafo.length;
        boolean visited[] = new boolean[numVs];
        int parentOf[] = new int[numVs];

        LinkedList<Integer> fila = new LinkedList<Integer>();
        fila.add(s);
        visited[s] = true;
        parentOf[s] = -1;

        while (fila.size() != 0) {
            int u = fila.poll();
            for (int v = 0; v < numVs; v++) {

                if ((!visited[v]) && (rGrafo[u][v] > 0)) {

                    fila.add(v);
                    parentOf[v] = u;
                    visited[v] = true;
                }
            }
        }

        if (visited[t]) {
            ArrayList<Vertices> caminho = new ArrayList<Vertices>();
            for (int v = t; v != s; v = parentOf[v])
                caminho.add(0, new Vertices(parentOf[v],v));

            return caminho;
        }
        else
            return null;
    }
}
