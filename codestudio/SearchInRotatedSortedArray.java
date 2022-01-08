// https://www.codingninjas.com/codestudio/problems/search-in-rotated-sorted-array_1082554

import java.util.*;
public class Solution {
    public static int findPosition(ArrayList<Integer> arr, int n, int k) {
        int pivot = findPivot(arr, n);
        int start, end, mid;
        if(k == arr.get(pivot)){
            return pivot;
        } else if(k < arr.get(0)){
            start = pivot;
            end = n - 1;
        } else {
            start = 0;
            end = pivot - 1;
        }
        mid = start + (end - start)/2;
        
        while(start <= end){
            if(arr.get(mid) == k){
                return mid;
            } else if (arr.get(mid) < k){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = start + (end - start)/2;
        }
        return -1;
    }

    public static int findPivot(ArrayList<Integer> arr, int n){
        int start = 0, end = n-1;
        int mid = start + (end - start)/2;
        while(start < end){
            if(arr.get(mid) >= arr.get(0)){
                start = mid + 1;
            } else {
                end = mid;
            }
            mid = start + (end - start)/2;
        }
        return start;
    }
}
