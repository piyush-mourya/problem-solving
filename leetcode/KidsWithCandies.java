// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n = candies.length;
        int max = Integer.MIN_VALUE;
        List<Boolean> ans = new ArrayList<Boolean>();
        for(int i = 0 ; i < n ; i++){
            if(candies[i] > max){
                max = candies[i];
            }
        }
        for(int i = 0 ; i < n ; i++){
            if(candies[i] + extraCandies >= max){
                ans.add(true);
            } else {
                ans.add(false);
            }
        }
        return ans;
    }
}
