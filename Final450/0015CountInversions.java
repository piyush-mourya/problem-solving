// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    
    // TLE : doesn't work for long inputs 
    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        long invCnt = 0;
        for(long i = 0 ; i < N - 1 ; i++){
            for(long j = i + 1 ; j < N ; j++ ){
                if(arr[(int)j] < arr[(int)i]){
                    invCnt++;
                }
            }
        }
        return invCnt;
    }
}
