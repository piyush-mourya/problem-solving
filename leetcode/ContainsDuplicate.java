// https://leetcode.com/problems/contains-duplicate/

// Time limit exceeded
class Solution {
    public boolean containsDuplicate(int[] nums) {
        int size = nums.length;
        for(int i = 0 ; i < size - 1; i++ ){
            for(int j = i+1 ; j < size ; j++){
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }
}

// Using HashSet
// https://www.geeksforgeeks.org/hashset-in-java/

class Solution1 {
    public boolean containsDuplicate(int[] nums) {
        int size = nums.length;
        HashSet<Integer> uniqueEle = new HashSet<Integer>();
        for(int i = 0 ; i < size ; i++ ){
            uniqueEle.add(nums[i]);
        }
        if(size == uniqueEle.size()){
            return false;
        } else {
            return true;
        }
    }
}
