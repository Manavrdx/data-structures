import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(removeDuplicates(nums));
        System.out.println(removeDuplicatesUsingTwoPointers(nums));
    }

    private static int removeDuplicates(int[] nums) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int[] nonDuplicateArray = set.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        System.arraycopy(nonDuplicateArray, 0, nums, 0, nonDuplicateArray.length);

        return nonDuplicateArray.length;
    }

    private static int removeDuplicatesUsingTwoPointers(int[] nums) {
        int index = 1;
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            if (nums[i-1] != nums[i]) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
