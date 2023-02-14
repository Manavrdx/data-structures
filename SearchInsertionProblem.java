public class SearchInsertionProblem {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(searchInsert(nums, 4));
    }

    private static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        while (start <= end) {
            int medium = start + (end-start)/2;
            if (nums[medium] == target) {
                return medium;
            } else if (nums[medium] > target) {
                end = medium - 1;
            } else {
                start = medium + 1;
            }
        }
        return start;
    }
}
