// https://www.codingninjas.com/codestudio/problems/square-root_893351

public class Solution {

	public static int sqrtN(long N) {
		long start = 0;
        long end = N;
        long mid = start + (end - start)/2;
        long ans = -1;
        if(N == 0){
            return 0;
        }
        if(N == 1){
            return 1;
        }
        while(start <= end){
            if(mid == N/mid){
                return (int)mid;
            } else if(mid < N/mid){
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = start + (end - start)/2;
        }
        return (int)ans;
	}
}
