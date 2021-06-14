// { Driver Code Starts
import java.lang.*;
import java.io.*;
import java.util.*;
class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int t = Integer.parseInt(br.readLine()); 

        while(t-- > 0){
            int size = Integer.parseInt(br.readLine());
            String[] arrStr = ((String)br.readLine()).split("\\s+");
            int[] arr= new int[size];
            for(int i = 0;i<size;i++){
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            System.out.println(new Solution().minJumps(arr));
        }
	 }
	 
}
// } Driver Code Ends



class Solution{
  // Naive recursive approach
    static int minJumps(int[] arr){
        // your code here
        int j = 0;
        int k = arr.length - 1;
        int ans = minJumpFromHere(j,k,arr);
        return ans;
    }
    
    static int minJumpFromHere(int j, int k, int[] arr) {
        if(j == k){
            return 0;
        }
        
        if(arr[j] == 0){
            return Integer.MAX_VALUE;
        }
        
        int min = Integer.MAX_VALUE;
        
        for(int i = j+1 ; i <= k && i <= arr[j] + j ; i++) {
            int jumps = minJumpFromHere(i, k, arr);
            if(jumps != Integer.MAX_VALUE && jumps + 1 < min){
                min = jumps + 1;
            }
        }
        return min;
    }
  
  // method 2 : Dynamic programming
  
  static int minJumps(int[] arr){
        // your code here
        int n = arr.length;
        
        if(n == 0 || arr[0] == 0){
            return -1;
        }
        int jumps[] = new int[n];
        jumps[0] = 0;
        
        for(int i = 1 ; i < n ; i++){
            jumps[i] = Integer.MAX_VALUE;
            for(int j = 0 ; j < n ; j++){
                if(i <= j + arr[j] && jumps[j] != Integer.MAX_VALUE){
                    jumps[i] = Math.min(jumps[j] + 1, jumps[i]);
                    break;
                }
            }
           
        }
         return jumps[n-1] == Integer.MAX_VALUE ? -1 : jumps[n-1];
    }
}
