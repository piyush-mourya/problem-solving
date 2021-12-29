// https://www.codingninjas.com/codestudio/problems/sort-0-1-2_631055

public class Solution 
{
    public static void sort012(int[] arr)
    {
        int n = arr.length ;
        int zero = 0, one = 0, two = n - 1 ;
        while( one <= two ){
            if(arr[one] == 0){
                int temp = arr[one];
                arr[one] = arr[zero];
                arr[zero]  = temp;
                zero++;
                one++;
            } else if(arr[one] == 2){
                int temp = arr[two];
                arr[two] = arr[one];
                arr[one] = temp;
                two--;
            } else {
               one++;
            }
        }
    }
}
