https://leetcode.com/problems/power-of-two/

class Solution {
    public boolean isPowerOfTwo(int n) {
        if( n <= 0 ){
            return false;
        }
        int count = 0;
        while( n != 0){
            int digit = n & 1;
            if(digit == 1){
                count++;
            }
            n = n >> 1 ; 
        }
       if(count == 1) return true;
        else return false;
    }
}
