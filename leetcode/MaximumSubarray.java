// https://leetcode.com/problems/maximum-subarray/

// Kadane's Algorithm
/*
Some more problems based on Kadane Algorithm :)
121. Best Time to Buy and Sell Stock - https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
152. Maximum Product Subarray - https://leetcode.com/problems/maximum-product-subarray/
918. Maximum Sum Circular Subarray - https://leetcode.com/problems/maximum-sum-circular-subarray/
978. Longest Turbulent Subarray - https://leetcode.com/problems/longest-turbulent-subarray/
1749. Maximum Absolute Sum of Any Subarray - https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/
/*
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
