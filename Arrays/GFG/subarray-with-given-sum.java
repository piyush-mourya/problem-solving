//https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1

// 20 mins
class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
         ArrayList<Integer> subArr = new ArrayList<>();
         subArr.add(0);
         subArr.add(0);
        int i = 0;
        int j = 0;
        int sum = 0;
        while(j < n && i < n){
            if(sum < s){
                sum = sum + arr[j]; 
                subArr.set( 0 , i+1 );
                subArr.set(1 , j+1 );
                j++;
            } else if(sum == s){
                System.out.println(i + " " + j);
                subArr.set(0, i+1);
                break;
            } else if(sum > s){
                System.out.println(i + " " + j + "+");
                sum = sum - arr[i];
                if(sum == s)
                i++;
                
            }
        }
        return subArr;
    }
}
