import java.util.*;

public class MajorityElementII {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2};
        System.out.println(getMajorityElementIIUsingBruteForce(arr));
        System.out.println(getMajorityElementIIUsingMooreVotingAlgorithm(arr));
    }

    private static List<Integer> getMajorityElementIIUsingMooreVotingAlgorithm(int[] nums) {
        int length = nums.length;
        int candidate1 = -1;
        int votes1 = 0;
        int frequency1 = 0;

        int candidate2 = -1;
        int votes2 = 0;
        int frequency2 = 0;
        for (int value : nums) {
            if (candidate1 == value) {
                votes1++;
            } else if (candidate2 == value) {
                votes2++;
            } else if (votes1 == 0) {
                candidate1 = value;
                votes1++;
            } else if (votes2 == 0) {
                candidate2 = value;
                votes2++;
            } else {
                votes1--;
                votes2--;
            }
        }

        for (int value : nums) {
            if (candidate1 == value) frequency1++;
            else if (candidate2 == value) frequency2++;
        }

        List<Integer> list = new ArrayList<>();
        if (frequency1 > length/3) {
            list.add(candidate1);
        }
        if (frequency2 > length/3) {
            list.add(candidate2);
        }

        return list;
    }

    private static List<Integer> getMajorityElementIIUsingBruteForce(int[] nums) {
        int length = nums.length;
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
            if (map.get(num) > length/3) {
                set.add(num);
            }
        }
        return set.stream().toList();
    }
}
