import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {9, 9, 9};
        System.out.println(Arrays.toString(plusOne(digits)));
    }

    private static int[] plusOne(int[] digits) {
        int index = digits.length-1;
        while (index >= 0) {
            int sum = digits[index] + 1;
            if (sum > 9) {
                digits[index] = 0;
                index--;
            } else {
                digits[index] = sum;
                break;
            }
        }

        if (index < 0) {
            int[] newArray = new int[digits.length+1];
            newArray[0] = 1;
            return newArray;
        } else {
            return digits;
        }
    }
}
