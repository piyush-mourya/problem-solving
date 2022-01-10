// https://www.codingninjas.com/codestudio/problems/sum-of-max-and-min_1081476

public class Solution {
  public static int sumOfMaxMin(int[] arr, int n) {
      int max = Integer.MIN_VALUE ;
      int min = Integer.MAX_VALUE ;
      int sum = 0 ;
      for(int i = 0 ; i < n ; i++) {
          if(arr[i] > max){
              max = arr[i];
          }
          if(arr[i] < min){
              min = arr[i];
          }
      }
      sum = max + min;
      return sum;
  }
}
