import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int difference = -nums[i];
                int low = i+1;
                int high = length-1;

                while (low < high) {
                    int result = nums[low] + nums[high];
                    if (result > difference) {
                        high--;
                    } else if (result < difference) {
                        low++;
                    } else {
                        list.add(Arrays.asList(nums[i], nums[low], nums[high]));
//                        doing this to incr or decr the low and high to not compare the duplicates
                        while (low < high && nums[low] == nums[low+1]) {
                            low++;
                        }
                        while (low < high && nums[high] == nums[high-1]) {
                            high--;
                        }
                        low++;
                        high--;
                    }
                }
            }
        }
        return list;
    }
}
