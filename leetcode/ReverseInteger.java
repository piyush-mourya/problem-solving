//https://leetcode.com/problems/reverse-integer/

// fails for cases where the rev number goes beyond range
class Solution {
    public int reverse(int x) {
        int revInt = 0;
        int sign = 1;
        if(x < 0){
            sign = -1;
            x = -x;
        }
        while(x > 0){
            int digit = x % 10 ;
             if(revInt > Integer.MAX_VALUE){
                return 0;
            }
            if( (x/10) == 0 ){
                revInt = (revInt + digit);
            } else {
                revInt = (revInt + digit) * 10 ;
            }
            System.out.println(revInt);
            x = x/10;
        }
        return sign * revInt;
    }
    
    public int reverse2(int x) {
        long revInt = 0;
        int sign = 1;
        if(x < 0){
            sign = -1;
            x = -x;
        }
        while(x > 0){
            int digit = x % 10 ;
            if( (x/10) == 0 ){
                revInt = (revInt + digit);
            } else {
                revInt = (revInt + digit) * 10 ;
            }
            x = x/10;
        }
        if(revInt > Integer.MAX_VALUE){
            return 0;
        }
        return sign * (int)revInt;
    }

}
