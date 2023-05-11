import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("sem2/data/array.txt"));
        String strArr = scanner.nextLine().replace("]", "").replace("[", "");
        int[] arr = Arrays.stream(strArr.split(", ")).mapToInt(Integer::parseInt).toArray();
        long addStartTime, addEndTime, addDuration, addCount = 0;
        long findStartTime, findEndTime, findDuration, findCount = 0;
        long removeStartTime, removeEndTime, removeDuration, removeCount = 0;
        FenwikTree fT = new FenwikTree();
        addStartTime = System.nanoTime();
        for (int i = 0; i < arr.length; i++) {
            addCount  += fT.add(i, arr[i]);
        }
        addEndTime = System.nanoTime();
        addDuration = (addEndTime - addStartTime) / 10000;
        System.out.println("----------------------------------");
        System.out.println("[1] General add() time: "+ (double)addDuration + " ms");
        System.out.println("[2] Average add() time: "+ (double)addDuration / 10000 + " ms");
        System.out.println("[3] Average iteration count: "+ (int)addCount / 10000);
        System.out.println("----------------------------------");


        findStartTime = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            int rindex = new Random().nextInt(arr.length);
            findCount += fT.find(arr[rindex]);
        }
        findEndTime = System.nanoTime();
        findDuration = (findEndTime - findStartTime) / 10000;
        System.out.println("[1] General find() time: "+ (double)findDuration + " ms");
        System.out.println("[2] Average find() time: "+ (double)findDuration / 10000 + " ms");
        System.out.println("[3] Average iteration count: "+ (int)findCount / 100);
        System.out.println("----------------------------------");

        removeStartTime = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            int rindex = new Random().nextInt(arr.length);
            removeCount += fT.remove(rindex, arr[rindex]);
        }
        removeEndTime = System.nanoTime();
        removeDuration = (removeEndTime - removeStartTime) / 10000;
        System.out.println("[1] General remove() time: "+ (double)removeDuration + " ms");
        System.out.println("[2] Average remove() time: "+ (double)removeDuration / 10000 + " ms");
        System.out.println("[3] Average iteration count: "+ (int)removeCount / 100);
        System.out.println("----------------------------------");
    }
}
