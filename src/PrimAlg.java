import java.util.Arrays;

public class PrimAlg {

    public long[] getMST(int G[][], int V) {
        int INFINITY = 9999999;
        int noEdge = 0;
        boolean[] selected = new boolean[V];
        Arrays.fill(selected, false);
        selected[0] = true;
        System.out.println("Edge : Weight");
        long startTime = System.nanoTime();
        long iterationCount = 0;
        while (noEdge < V - 1) {
            int min = INFINITY;
            int x = 0;
            int y = 0;
            for (int i = 0; i < V; i++) {
                if (selected[i]) {
                    for (int j = 0; j < V; j++) {
                        if (!selected[j] && G[i][j] != 0) {
                            if (min > G[i][j]) {
                                min = G[i][j];
                                x = i;
                                y = j;
                                iterationCount++;
                            }
                        }
                    }
                }
            }
            String l = x + " - " + y + " :  " + G[x][y];
            if(!l.equals("0 - 0 :  0")){
                System.out.println(l);
                selected[y] = true;
                noEdge++;
            }
            else{
                selected[y] = true;
                noEdge++;
            }
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime)/1000000;
        System.out.println("Time:"+duration+"ms");
        System.out.println("Iteration count:"+iterationCount);
        return new long[]{duration, iterationCount};
    }
}