// { Driver Code Starts
import java.io.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    //size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //adding elements
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Solution obj = new Solution();
		    
		    //calling maxSubarraySum() function
		    System.out.println(obj.maxSubarraySum(arr, n));
		}
	}
}

// } Driver Code Ends


class Solution{

    // arr: input array
    // n: size of array
    //Function to find the sum of contiguous subarray with maximum sum.
    int maxSubarraySum(int arr[], int n){
        
        // Your code here
        int maxEndingHere = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++){
            maxEndingHere += arr[i];
            if(maxEndingHere > max){
                max = maxEndingHere;
            }
            if(maxEndingHere < 0){
                maxEndingHere = 0;
            }
        }
        return max;
    }
    
	// method 2 Dynamic Programming
	int maxSubarraySum(int arr[], int n){
        
        // Your code here
        int maxSoFar = arr[0];
        int maxEndingHere = arr[0];
        for(int i = 1 ; i < n ; i++){
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
	//Method 3 slight opti,ization of method 1
	static int maxSubArraySum(int a[],int size) 
{ 
    
    int max_so_far = a[0], max_ending_here = 0; 

    for (int i = 0; i < size; i++) 
    { 
        max_ending_here = max_ending_here + a[i];
        if (max_ending_here < 0) 
            max_ending_here = 0; 
        
        /* Do not compare for all
           elements. Compare only 
           when max_ending_here > 0 */
        else if (max_so_far < max_ending_here) 
            max_so_far = max_ending_here; 
        
    } 
    return max_so_far; 
} 

}

