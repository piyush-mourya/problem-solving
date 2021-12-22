// https://leetcode.com/problems/number-of-1-bits/
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight1(int n) {
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
    
     public int hammingWeight2(int n) {
        int count = 0 ;
        while(n != 0){
                count += (n&1);
            
            n = n >>> 1;
        }
        return count;
    }
    
     public int hammingWeight3(int n) {
        
		int setBitCount = 0;
        
		while (n != 0) {
            n &= (n - 1); // to clear the right most set bit
            ++setBitCount;
        }
		
        return setBitCount;
    }

}
 
/* while (n > 0) will not work especially in this case because the input will be an unsigned integer.
According to Java, we cannot declare a variable as unsigned, by default they are signed. For unsigned integer, the input will range from 0 to 2^(32)-1. So, there is a possibility that the input will exceed from the signed integer positive range i.e. greater than 2^(31)-1. For those values which are greater than 2^(31)-1, for example 2147483648, 2147483650, their corresponding negative value will be stored in n.
For example: 2147483648 in binary => 1000 0000 0000 0000 0000 0000 0000 0000 and its corresponding negative value will be -2147483648 which will be stored in the variable n.
Now, according to your condition "while (n > 0)", it will not enter into the loop and the loop will terminate. So for all the values in range 2^(31) to 2^(32)-1 inclusive, "while (n > 0)" will fail. So the loop condition has to be while (n != 0).

FYI as per the java documentation: int: By default, the int data type is a 32-bit signed two's complement integer, which has a minimum value of -2^31 and a maximum value of 2^31-1. In Java SE 8 and later, you can use the int data type to represent an unsigned 32-bit integer, which has a minimum value of 0 and a maximum value of 2^32-1. Use the Integer class to use int data type as an unsigned integer. See the section The Number Classes for more information. Static methods like compareUnsigned, divideUnsigned etc have been added to the Integer class to support the arithmetic operations for unsigned integers.

But they still do not provide a way to declare a variable as unsigned, because it is working for them with the signed itself. */
