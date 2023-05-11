import java.util.Arrays;

public class FenwikTree {
    final static int MAX = 100000;
    static int[] tree = new int[MAX];
    public FenwikTree(){
        Arrays.fill(tree, 0);
    }
    int prefixSum(int i) {
        i++;
        int sum = 0;
        while (i > 0) {
            sum += tree[i];
            i -= i & -i;
        }
        return sum;
    }
    int add(int i, int v) {
        int c = 0;
        if (i == 0) {
            tree[0] += v;
            return 1;
        }
        for (; i < tree.length; i += ((i) & -(i))) {
            c++;
            tree[i] += v;
        }
        return c;
    }
    int remove(int i, int v){
        return add(i, -v);
    }
    int find(int v){
        int c = 0;
        int left = 0;
        int right = tree.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            int middleSum = prefixSum(middle);
            c++;
            if (middleSum == v) {
                break;
            }
            else if (middleSum < v) {
                left = middle + 1;
                c++;
            }
            else {
                right = middle - 1;
                c++;
            }
        }
        return c;
    }
}
