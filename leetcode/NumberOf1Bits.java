// https://leetcode.com/problems/number-of-1-bits/

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0 ;
        if(n < 0){
            n = ~n;
            count = -32;
        }
        while(n > 0){
            if(n%2 == 1){
                count++;
            }
            n = n/2;
        }
        return count > 0 ? count : -count;
    }
}
