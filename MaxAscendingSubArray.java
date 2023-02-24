public class MaxAscendingSubArray {
    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 5, 10, 50};
        System.out.println(maxAscendingSum(nums));
    }

    private static int maxAscendingSum(int[] nums) {
        int maxSum = 0;
        if(nums.length == 1) return nums[0];
        for (int i = 0; i < nums.length-1; i++) {
            int tempSum = nums[i];
            while (i < nums.length-1 && nums[i+1] > nums[i]) {
                tempSum = tempSum + nums[i+1];
                i++;
            }
            maxSum = Math.max(maxSum, tempSum);
        }
        return maxSum;
    }
}
