import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] arr = new int[] {9, 5, 4, 9, 10, 10, 6, 12, 11};

        System.out.println(getLengthOfLongestSequenceUsingBruteForce(arr, arr.length));
        System.out.println(getLengthOfLongestSequenceUsingSorting(arr, arr.length));
        System.out.println(getLengthOfLongestSequenceUsingHashSet(arr, arr.length));
    }

    private static int getLengthOfLongestSequenceUsingHashSet(int[] arr, int length) {
        Set<Integer> set = new HashSet<>();
        int result = 1;

        for (int i = 0; i < length; i++) {
            set.add(arr[i]);
        }

        for (int i = 0; i < length; i++) {
            int start = arr[i];
            if (!set.contains(start - 1)) {
                while (set.contains(start)) {
                    start++;
                }
            }
            result = Math.max(result, start - arr[i]);
        }
        return result;
    }

    private static int getLengthOfLongestSequenceUsingSorting(int[] arr, int length) {
        Arrays.sort(arr);
        int sequenceLength = 1;
        int maxLength = 1;
        for (int i = 1; i < length; i++) {
            if (arr[i] == arr[i-1] + 1) {
                sequenceLength++;
            } else if (arr[i] == arr[i-1]) {
                continue;
            }
            else {
                sequenceLength = 1;
            }
            maxLength = Math.max(maxLength, sequenceLength);
        }
        return maxLength;
    }

    private static int getLengthOfLongestSequenceUsingBruteForce(int[] arr, int length) {
        int ans = 0;
        for (int i = 0; i < length; i++) {
            int start = arr[i];
            while (findNumber(start, arr)) {
                start++;
            }
            ans = Math.max(ans, (start-arr[i]));
        }
        return ans;
    }

    private static boolean findNumber(int target, int[] arr) {
        for (int a : arr) {
            if (a == target) return true;
        }
        return false;
    }
}
