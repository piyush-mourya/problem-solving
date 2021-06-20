/*
For this problem, coding is not a big deal. Algorithm is!

Now let's pick a number, for example, 24387651.

what is the next permutation? 24513678.

How can I get the answer?

First step: find the first ascending digit from the back of the number. 3 < 8 > 7 > 6 > 5 > 1. Then 3 is the digit.

Second step: swap that digit with the next big digit in following digits. Which one is the next big digit in 87651? 5! So swap them. Now the number becomes 24587631.

Third step: sort 87631 into 13678. The final answer is 24513678.
  */

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return;
        } 
        int i = n - 2;
        while(i >= 0 && nums[i+1] <= nums[i]){
            i--;
        }
        
        if(i >= 0){
        int j = n - 1;
            while(j >= 0 && nums[j] <= nums[i]){
                j--;
            }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        }
        int j = n-1;
        i = i+1;
        while(i<j){
           int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
