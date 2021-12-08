// https://leetcode.com/problems/shuffle-the-array/

class Solution {
    public int[] shuffle(int[] nums, int n) {
        // for n = 3
        // array is [x1, x2, x3, y1, y2, y3]
        for(int i = 0 ; i < n ; i++){
            nums[i] = nums[i] + nums[n+i]*10000; 
            //System.out.println(nums[i]);
        }
        // now array is [y1x1, y2x2, y3x3, y1, y2, y3]
        for(int i = n - 1 ; i >= 0 ; i-- ){
            nums[2*i + 1] = nums[i]/10000; //yn
            nums[2*i] = nums[i]%10000; //xn
        } 
        return nums;
    }
}
