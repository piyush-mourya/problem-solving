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
	// Method 3 :
	/*
	Time Complexity: O(n)
Auxiliary Memory: O(1)
Code similar to a top submission on LeetCode.
Explanation: We traverse the array till the second last element, 
and maintain three things, all initialized to 0:
1. The number of minimum jumps we need
2. The farthest we can jump in the current window we're moving through
3. The end of the current window, currEnd

We update the farthest as max. of the current farthest we have, 
and i + arr[i].
We walk through the entire current window, collecting the best possible farthest, and when we reach the end of the current window, 
it's time to switch to another window. Switching to another window is analogous to incrementing a jump, and now we set the current
end to the farthest we could find, meaning we make the jump to that point in the array which carried us the farthest. 
We can only come to know this after traversing the whole window, hence we keep collecting possible solutions.
Finally, once we're at the last element, we've reached our destination (and don't need to loop through it), 
so we return the number of jumps we've collected so far.

Optimizations:
1. If the index i is the farthest we can go, then we've reached a 0 and all previous jumps lead to this element at best,
hence we can't proceed further and return a -1 there itself.
2. If we've encountered an array element which can take us to the last element (or beyond), we make a switch to that window,
or alternatively count 1 jump for the switch, and add it to the number of jumps we need so far, hence returning jumps+1.

Extra:
If initially i >= n-1, the loop won't execute. What does this mean?
Initially, i = 0, if 0 >= n - 1, it implies n <= 1, that means either we have an empty array (n=0), 
or an array with a single element (n=1). Either way, it's going to take zero jumps to reach the end, 
so our initialization holds here and the code returns 0.
*/
	static int minJumps(int[] arr){
        // your code here
        int n = arr.length;
        int jumps = 0 ;
        int currEnd = 0 ;
        int currFar = 0 ;
        
        for(int i = 0 ; i < n-1 ; i++){
            currFar = Math.max(currFar, i + arr[i]);
            if(currEnd == i){
                jumps++;
                currEnd = currFar; 
            }
            if(currEnd >= n-1){
                break;
            }
        }
        if(currEnd < n-1){
                return -1;
            }
            return jumps;
    }
}
