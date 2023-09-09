import java.util.ArrayList;
import java.util.Collections;

public class Task3 {
	static int iterationsCount = 0;

	public static int[] generateArray() {
		int[] arr = new int[100];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 10 + 1);
		}
		return arr;
	}
	
	public static int treeSort(int[] arr) {
		iterationsCount = 0;
		Tree tree = null;
		for(int i = 0; i < arr.length; i++) {
			tree = treeInsert(tree, arr[i]);
		}
		int[] newArr = new int[arr.length];
		treeTraverse(newArr, 0, tree);
		return iterationsCount;
	}
	
	public static Tree treeInsert(Tree tree, int value) {
		if(tree == null) {
			return new Tree(value);
		}
		else if(value < tree.value){
			tree.left = treeInsert(tree.left, value);
		}
		else {
			tree.right = treeInsert(tree.right, value);
		}
		iterationsCount++;
		return tree;
	}
	public static int treeTraverse(int[] arr, int index, Tree tree) {
		if(tree != null) {
			index = treeTraverse(arr, index, tree.left);
			arr[index++] = tree.value;
			index = treeTraverse(arr, index, tree.right);
		}
		iterationsCount++;
		return index;
	}
	public static void main(String[] args) {
		int[] arr = Task3.generateArray();
		int treeSortCount = Task3.treeSort(arr);
		int bucketSortCount = BucketSort.bucketSort(arr, arr.length);;
		System.out.println(treeSortCount < bucketSortCount ? "Tree Sort" : "Bucket Sort");
	}
}
class Tree{
	
	public int value;
	
	public Tree left;
	public Tree right;
	
	Tree(int value){
		this.value = value;
	}
}

// -----------------------------------------------------------------
// Bucket Sort
class BucketSort{
	static int iterationCount = 0;
	public static int bucketSort(int[] arr, int bsize) {
		int min = arr[0];
		int max = arr[0];
		
		for(int i = 1;i < arr.length;i++) {
			if(arr[i] < min) min = arr[i];
			if(arr[i] > max) max = arr[i];
		}
		
		int bcount = (int) Math.ceil((max - min) / (double) bsize);
		ArrayList<Integer>[] buckets = new ArrayList[bcount];
        for (int i = 0; i < bcount; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (int i = 0; i < arr.length; i++) {
            int bucketIndex = (int) Math.floor((arr[i] - min) / (double) bsize);
            buckets[bucketIndex].add(arr[i]);
            iterationCount++;
        }
        for (int i = 0; i < buckets.length; i++) {
            int temp = 0;
            for (int j = 0; j < buckets[i].size(); j++) {
                for (int k = 1; k < (buckets[i].size()-j); k++) {
                    if (buckets[i].get(k - 1) > buckets[i].get(k)){
                        temp = buckets[i].get(k-1);
                        buckets[i].set(k - 1, buckets[i].get(k));
                        buckets[i].set(k, temp);
                        iterationCount++;
                    }
                }
            }
        }
        return iterationCount;
	}
}