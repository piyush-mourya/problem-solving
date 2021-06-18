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

// merge sort solution
class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        long l = 0;
        long r = N-1;
        long temp[] = new long[(int)N];
        return  mergeSort(arr,temp,l,r);
    }
    
    static long mergeSort(long arr[], long temp[], long l, long r){
        long mid;
        long invCnt = 0;
        if(r > l){
            mid = (l+r)/2;
            invCnt = mergeSort(arr,temp,l,mid);
            invCnt += mergeSort(arr,temp,mid+1,r);
            invCnt += merge(arr,temp,l,mid+1,r);
        }
        
        return invCnt;
    }
    
    static long merge(long arr[], long temp[], long l, long mid, long r){
        long i,j,k;
        long invCnt = 0;
        
        i = l;
        j = mid;
        k = l;
        
        while(i <=(mid-1) && j<=r){
            if(arr[(int)i] <= arr[(int)j]){
                temp[(int)k++] = arr[(int)i++];
            } else {
                temp[(int)k++] = arr[(int)j++];
                invCnt +=(mid - i);
            }
        }
        
        while (i <= mid - 1){
            temp[(int)k++] = arr[(int)i++];
        }
        
        while (j <= r){
            temp[(int)k++] = arr[(int)j++];
        }
        
        for (i = l; i <= r; i++)
            arr[(int)i] = temp[(int)i];
            
        return invCnt;
    }
}
