import java.util.HashMap;
import java.util.Map;

public class ContainsNearbyDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(containsNearbyDuplicate(nums, 1));
    }

    private static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        boolean foundIt = false;
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                int index = map.get(nums[i]);
                int diff = Math.abs(i - index);
                if(diff <= k) {
                    foundIt = true;
                    break;
                }
            } else {
                map.put(nums[i], i);
            }
        }
        return foundIt;
    }
}
