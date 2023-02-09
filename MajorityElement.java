import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int arr[] = new int[] {2, 3, 9, 2, 2};

        System.out.println(getMajorityElementUsingMap(arr, arr.length));
        System.out.println(getMajorityElementUsingSort(arr, arr.length));
        System.out.println(getMajorityElementUsingMooresVotingAlgorithm(arr, arr.length));
    }

    private static int getMajorityElementUsingMooresVotingAlgorithm(int[] arr, int length) {
        int candidate = arr[0];
        int votes = 0;
        int frequency = 0;

        for (int num: arr) {
            if (candidate == num) {
                votes++;
            } else {
                votes--;
            }
            if (votes == 0) {
                candidate = num;
                votes = 1;
            }
        }

        for (int num: arr) {
            if (candidate == num) frequency++;
        }

        if (frequency > length/2) {
            return candidate;
        } else return -1;
    }

    private static int getMajorityElementUsingSort(int[] arr, int length) {
        Arrays.sort(arr);
        int centerNumber = arr[length/2];
        int frequency = 0;
        for (int num : arr) {
            if (num == centerNumber) frequency++;
        }

        if (frequency > length/2) return centerNumber;
        else return -1;
    }

    private static int getMajorityElementUsingMap(int[] arr, int length) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int value : arr) {
            if (map.containsKey(value)) {
                map.put(value, map.get(value) + 1);
            } else {
                map.put(value, 1);
            }
            if (map.get(value) > length/2) {
                return value;
            }
        }
        return -1;
    }
}
