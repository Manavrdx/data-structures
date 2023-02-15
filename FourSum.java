import java.util.*;
import java.util.stream.Collectors;

public class FourSum {
    public static void main(String[] args) {
        int[] nums = {1000000000,1000000000,1000000000,1000000000};
        System.out.println(fourSum(nums, -294967296));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < length-3; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            for (int j = i + 1; j < length-2; j++) {
                if (j > i + 1 && nums[j] == nums[j-1]) continue;
                int start = j + 1;
                int end = length - 1;

                long firstTwoSum = nums[i] + nums[j];
                long difference = target - firstTwoSum;

                while (start < end) {
                    long sum = nums[start] + nums[end];
                    if (sum < difference) {
                        start++;
                    } else if (sum > difference) {
                        end--;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                        start++;
                    }
                }
            }
        }

        return result.stream()
                .map(integers -> integers.stream()
                        .sorted()
                        .collect(Collectors.toList()))
                .collect(Collectors.toSet())
                .stream().toList();
    }
}
