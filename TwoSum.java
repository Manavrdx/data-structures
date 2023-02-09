
import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 7, 8, 13, 1, 6, 20, 21};
        System.out.println(Arrays.toString(twoSumUsingBruteForce(arr, 28)));
        System.out.println(Arrays.toString(twoSumWithMap(arr, 28)));
        System.out.println(Arrays.toString(twoSumUsingTwoPointers(arr, 28)));
        int max = Math.max(2, 5);
        System.out.println(max);
    }

    private static int[] twoSumUsingTwoPointers(int[] sum, int target) {
        int[] resultSumIntegers = new int[2];
        Arrays.sort(sum);
        int startPointer = 0;
        int endPointer = sum.length-1;
        while(startPointer < endPointer) {
            int tempSum = sum[startPointer] + sum[endPointer];
            if(tempSum > target) {
                endPointer--;
            } else if (tempSum < target) {
                startPointer++;
            }
            else {
                resultSumIntegers[0] = sum[startPointer];
                resultSumIntegers[1] = sum[endPointer];
                break;
            }
        }

        return resultSumIntegers;
    }

    public static int[] twoSumUsingBruteForce(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        boolean doesSumExist = false;
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            if (doesSumExist) {
                break;
            }
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    result[0] = nums[i];
                    result[1] = nums[j];
                    doesSumExist = true;
                    break;
                }
            }
        }
        return result;
    }

    public static int[] twoSumWithMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int num : nums) {
            if (map.containsKey(num)) {
                result[1] = num;
                result[0] = map.get(num);
            } else {
                map.put(target - num, num);
            }
        }
        return result;
    }
}