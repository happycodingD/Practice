package Amazon;

public class MaxSubArray {

    public static int maxSubArray(int[] nums) {

        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        int sum = nums[0];
        int maxSum = sum;
        int j = 1;
        while(j<nums.length) {
            /*if(nums[j]>(sum + nums[j])) {
                sum = nums[j];
            } else {
                sum = sum + nums[j];
            }*/
            sum = Math.max(nums[j], sum + nums[j]);
            maxSum = Math.max(maxSum, sum);
            j++;
        }
        return maxSum;
    }

    public static void main(String args[]) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
