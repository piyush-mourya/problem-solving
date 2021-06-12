// Method 1
// { Driver Code Starts
//Initial template for Java

import java.io.*;
import java.util.*;


 // } Driver Code Ends
//User function template for Java

class Solution
{
    public static void sort012(int a[], int n)
    {
        // code here 
        int zero = 0, one = 0, two = 0;
        int size = a.length;
        
        for(int i = 0 ; i < size ; i++) {
            switch(a[i]){
                case 0:
                    zero++;
                    break;
                case 1:
                    one++;
                    break;
                case 2:
                    two++;
                    break;
                default:
                break;
            }
            
            }
            int i = 0;
            if(zero > 0){
                while(zero>0){
                    a[i] = 0;
                    zero--;
                    i++;
                }
            }
            if(one > 0){
                while(one>0){
                    a[i] = 1;
                    one--;
                    i++;
                }
            }
            if(two > 0){
                while(two>0){
                    a[i] = 2;
                    two--;
                    i++;
                }
        }
    }
}

// { Driver Code Starts.

class GFG {
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob=new Solution();
            ob.sort012(arr, n);
            StringBuffer str = new StringBuffer();
            for(int i=0; i<n; i++){
                str.append(arr[i]+" ");
            }
            System.out.println(str);
        }
    }
}

  // } Driver Code Ends
// method 2 using pointers single pass
public static void sort012(int a[], int n)
    {
        int size = a.length;
        int zero = 0;
        int one = 0;
        int two = size - 1;
        int i = 0;
        while (one <= two){
            if(a[one] == 0){
                int temp = a[one];
                a[one] = a[zero];
                a[zero] = temp;
                one++;
                zero++;
            } else if(a[one] == 2){
                int temp = a[one];
                a[one] = a[two];
                a[two] = temp;
                two--;
            } else {
                one++;
            }
        }
    }
