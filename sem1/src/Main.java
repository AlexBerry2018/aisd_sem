import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String args[]) throws Exception {
        long v10time = 0, v100time = 0, v1000time = 0;
        long v10count = 0, v100count = 0, v1000count = 0;
        int rows = 10;
        int columns = 10;
        int V = 10;
        for (int c = 0; c < 149; c++) {
            if(c >= 50 && c <= 99){
                rows = 100;
                columns = 100;
                V = 100;
            }
            if(c >= 100){
                rows = 1000;
                columns = 1000;
                V = 1000;
            }
            Scanner sc = new Scanner(new BufferedReader(new FileReader("data/"+"data"+c+".txt")));
            int [][] myArray = new int[rows][columns];
            while(sc.hasNextLine()) {
                for (int i=0; i<myArray.length; i++) {
                    String[] line = sc.nextLine().trim().split(" ");
                    for (int j=0; j<line.length; j++) {
                        myArray[i][j] = Integer.parseInt(line[j]);
                    }
                }
            }
            PrimAlg g = new PrimAlg();
            int[][] G = myArray;
            long[] res = g.getMST(G, V);
            if(c < 50){
                v10time+=res[0];
                v10count+=res[1];
            }
            if(c >= 50 && c <= 99){
                v100time+=res[0];
                v100count+=res[1];
            }
            if(c >= 100){
                v1000time+=res[0];
                v1000count+=res[1];
            }
        }
        System.out.println("v10time average:"+(double)v10time/50+"ms");
        System.out.println("v100time average:"+(double)v100time/50+"ms");
        System.out.println("v1000time average:"+(double)v1000time/50+"ms");
        System.out.println("v10count average:"+(double)v10count/50);
        System.out.println("v100count average:"+(double)v100count/50);
        System.out.println("v1000count average:"+(double)v1000count/50);
    }
}