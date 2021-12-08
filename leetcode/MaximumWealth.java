// https://leetcode.com/problems/richest-customer-wealth/

class Solution {
    public int maximumWealth(int[][] accounts) {
        int n = accounts.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++){
            int sum = 0;
            int m = accounts[i].length;
            for(int j = 0 ; j < m ; j++ ){
                sum = sum + accounts[i][j];
            }
            if(sum > max){
                max = sum;
            }
        }
        return max;
    }
}
