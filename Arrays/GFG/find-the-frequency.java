// https://practice.geeksforgeeks.org/problems/find-the-frequency/1

//User function Template for Java
// Attempt 1
// 13:34 to 13:37
class Solution{
    int findFrequency(int A[], int x){
        int count = 0;
        for(int i = 0 ; i < A.length ; i++){
            if(A[i] == x){
                count++;
            }
        }
        return count;
    }
}
