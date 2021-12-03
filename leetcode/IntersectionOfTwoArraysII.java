// https://leetcode.com/problems/intersection-of-two-arrays-ii/

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> ans = new ArrayList<>();
        int i = 0, j = 0;
        while(i < n && j < m){
            if(nums1[i] == nums2[j]){
                ans.add(nums1[i]);
                i++;
                j++;
            } else if(nums1[i] > nums2[j]){
                j++;
            } else if(nums1[i] < nums2[j]){
                i++;
            }
        }
        return ans.stream().mapToInt(k -> k).toArray();
    }
}
