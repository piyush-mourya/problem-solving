https://leetcode.com/problems/number-complement/

class Solution {
    public int findComplement(int num) {
        int mask = 0 ;
        int complement = 0 ;
        int numCopy = num ;
        
        if( num == 0) {
            return 1;
        }
        
        while(numCopy != 0){
            mask = ( mask << 1 ) | 1 ;
            numCopy = numCopy >> 1 ;
        }
        complement = ( ~ num ) & ( mask ) ;
        return complement ;
    }
}
