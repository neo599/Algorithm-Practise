import java.util.Arrays;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int [] nums = new int[] {2,3,1,2,4,3};

        System.out.println(minSubArrayLen(7, nums));
    }

    public static int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int start = 0, sum = 0, minLength = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            while (sum >= s) {
                minLength = Math.min(minLength, i - start + 1);
                sum -= nums[start++];
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
