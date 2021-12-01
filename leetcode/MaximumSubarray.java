// https://leetcode.com/problems/maximum-subarray/

// Kadane's Algorithm
class Solution {
    public int maxSubArray(int[] nums) {
        int size = nums.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int i = 0;
        while(i < size){
            sum += nums[i];
            max = sum > max ? sum : max;
            if(sum < 0){
               sum = 0;
            }
            i++;
        }
        return max;
    }
}
