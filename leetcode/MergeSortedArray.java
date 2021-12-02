// https://leetcode.com/problems/merge-sorted-array/

// Rejected Solution
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m == 0 && n == 1){
            nums1[0] = nums2[0];
            return;
        }
        if(m == 1 && n == 0){
            return;
        }
        
        int i = 0, j = 0;
        while(i < n+m && j < n){
                if(nums1[i] <= nums2[j]){
                    i++;
                }else if(nums1[i] > nums2[j]){
                    for(int k = m+n-1 ; k > i ; k--){
                        nums1[k] = nums1[k-1];
                    }
                    nums1[i] = nums2[j];
                    i++;
                    j++;
                }
        }
        i = m+n-j-1;
        while(j < n){
            nums1[i] = nums2[j];
            j++;
            i++;
        }
        return;
    }
}

// After reading through discussions
class Solution2 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int a = m - 1;
        int b = n - 1;
        int i = m + n - 1;
        
        while( a >= 0 && b >= 0 ){
            if(nums1[a] > nums2[b]){
                nums1[i] = nums1[a];
                a = a - 1;
            }else {
                nums1[i] = nums2[b];
                b = b - 1;
            }
            i = i - 1;
        }
        
        while(b >= 0){
            nums1[i] = nums2[b];
            i = i - 1;
            b = b - 1;
        }
    }
}
