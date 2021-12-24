// https://leetcode.com/problems/two-sum/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int ans[] = new int[2];
        int n = nums.length;
        for(int i = 0 ; i < n-1 ; i++ ){
            for( int j = i + 1 ; j < n ; j++ ){
                if(nums[i] + nums[j] == target){
                    ans[0] = i;
                    ans[1] = j;
                    
                }
            }
        }
        return ans;
    }
    
    // optimized solution
    public int[] twoSum1(int[] nums, int target) {
        int ans[] = new int[2];
        int size = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < size ; i++){
            if(map.containsKey(target - nums[i])){
                ans[1] = i;
                ans[0] = map.get(target - nums[i]);
            }
            map.put(nums[i], i);
        }
        return ans;
    }
}
