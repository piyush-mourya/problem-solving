// https://www.codingninjas.com/codestudio/problems/first-and-last-position-of-an-element-in-sorted-array_1082549

import java.util.*;
import javafx.util.Pair;  
public class Solution {

    public static Pair<Integer, Integer> firstAndLastPosition(ArrayList<Integer> arr, int n, int k) {
        int first = -1, last = -1;
        int left = 0, right = n - 1 ;
        int mid = left + (right-left)/2;
        while(left <= right){
            if(arr.get(mid) == k){
                if( mid != 0 && arr.get(mid - 1) == k){
                    right = mid - 1;
                } else {
                    first = mid;
                    break;
                }
            } else if(arr.get(mid) > k){
                right = mid - 1;
            } else if(arr.get(mid) < k){
                left = mid + 1;
            }
            mid = left + (right-left)/2;
        }
        left = 0; right = n - 1;
        mid = left + (right-left)/2;
        while(left <= right){
            if(arr.get(mid) == k){
                if( mid != n-1 && arr.get(mid + 1) == k){
                    left = mid + 1;
                } else {
                    last = mid;
                    break;
                }
            } else if(arr.get(mid) > k){
                right = mid - 1;
            } else if(arr.get(mid) < k){
                left = mid + 1;
            }
            mid = left + (right-left)/2;
        }
        return new Pair<Integer, Integer>(first, last);
    }

};
