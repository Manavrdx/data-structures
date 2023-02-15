import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        System.out.println(Arrays.toString(merge(nums1, m, nums2, n)));
    }

    private static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int left = 0;
        int right = 0;
        int[] mergedArray = new int[m+n];
        int index = 0;

        while (left < m && right < n) {
            if (nums1[left] < nums2[right]) {
                mergedArray[index] = nums1[left];
                left++;
                index++;
            } else {
                mergedArray[index] = nums2[right];
                right++;
                index++;
            }
        }

        while (left < m) {
            mergedArray[index] = nums1[left];
            index++;
            left++;
        }
        while (right < n) {
            mergedArray[index] = nums2[right];
            index++;
            right++;
        }

        return mergedArray;
    }
}
