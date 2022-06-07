// 14 min
//https://practice.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1#
class Solution
{
    public static void sort012(int a[], int n)
    {
        int one = 0, two = 0, zero = 0;
        for(int i = 0 ; i < n ; i++){
            if(a[i] == 0){
                zero++;
            } else if(a[i] == 1){
                one++;
            } else {
                two++;
            }
        }
        int i = 0;
            inputValue(zero,i,0,a);
            inputValue(one,i + zero,1,a);
            inputValue(two,i + zero + one,2,a);
    }
    
    public static void inputValue(int num, int pos,int value, int a[]){
        while(num > 0){
                a[pos] = value;
                pos++;
                num--;
            }
    }
}
