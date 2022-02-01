//https://www.codingninjas.com/codestudio/problems/allocate-books_1090540

import java.util.*;
public class Solution {
    public static int allocateBooks(ArrayList<Integer> arr, int n, int m) {
        if(m > n){
            return -1;
        }
        int result = Integer.MAX_VALUE;
        int start = 0, end = 0;
        for(int i = 0 ; i < arr.size() ; i++){
            end += arr.get(i);
        }
        int mid = start + (end - start)/2;
        while(start <= end){
 				if(isPossibleAllocation(arr, n, m, mid)){
                    result = Math.min(result, mid);
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            mid = start + (end - start)/2;
        }
        return result;
    }
    
    public static boolean isPossibleAllocation(ArrayList<Integer> arr, int n, int m, int maxPages){
        int numStudents = 1;
        int currPageSum = 0;
        for(int i = 0 ; i < arr.size() ; i++){
            if(arr.get(i) > maxPages){
                return false;
            }
            if(currPageSum + arr.get(i) <= maxPages){
                currPageSum += arr.get(i);
            } else {
                currPageSum = arr.get(i);
                numStudents += 1;
                if(numStudents > m){
                    return false;
                }
            }
        }
        return true;
    }
}
