import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class BinarySearchArray {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 8};
        int[] queries = {3, 6, 8};
        System.out.println(searchInSortedArray(arr, arr.length, queries, queries.length));
    }

    public static List<Integer> searchInSortedArray(int[] arr, int n, int[] queries, int q) {
        List<Integer> list = new ArrayList<>(Collections.nCopies(q, 0));
        for (int i = 0; i < q; i++) {
            int start = 0;
            int end = n-1;

            int target = queries[i];

            while (start <= end) {
                int medium = start + (end-start)/2;
                if (arr[medium] == target) {
                    list.add(i, 1);
                    break;
                } else if (arr[medium] < target) {
                    start = medium + 1;
                } else {
                  end = medium - 1;
                }
            }
        }
        return list;
    }
}
