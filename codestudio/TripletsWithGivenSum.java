// https://www.codingninjas.com/codestudio/problems/triplets-with-given-sum_893028?source=youtube&campaign=LoveBabbar_Codestudiovideo1&utm_source=youtube&utm_medium=affiliate&utm_campaign=LoveBabbar_Codestudiovideo1

import java.util.*;
public class Solution {

	public static ArrayList<ArrayList<Integer>> findTriplets(int[] arr, int n, int K)  {
		ArrayList<ArrayList<Integer>> triplets = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(arr);
        int l = 0 , r = 0 ;
        for(int i = 0 ; i < n - 2 ; i++){
            l = i + 1;
            r = n - 1;
            while( l < r ){
                if(arr[i] + arr[l] + arr[r] == K){
                    triplets.add(new ArrayList<>(Arrays.asList(arr[i], arr[l], arr[r])));
                    int x = arr[l];
                    int y = arr[r];
                    
                    while( l < r && arr[l] == x )l++;
                    while( l < r && arr[r] == y )r--;
                    }else if(arr[i]+arr[l]+arr[r]<K)
                   		l++;
               		 else
                  		 r--;
         		  }
                    while(i + 1 < n - 2 && arr[i] == arr[i+1])i++;
                }
        return triplets;
	}
}
