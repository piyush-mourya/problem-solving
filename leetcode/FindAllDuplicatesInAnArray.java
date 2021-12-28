// https://leetcode.com/problems/find-all-duplicates-in-an-array

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> twice = new ArrayList<Integer>();
        Map<Integer, Integer> occurances = new HashMap<Integer, Integer>();
        for(int num : nums){
            if(occurances.containsKey(num)){
                occurances.put(num,  occurances.get(num) + 1);
            } else {
                occurances.put(num, 1);
            }
        }
        for(Map.Entry<Integer,Integer> entry : occurances.entrySet()){
            if(entry.getValue() == 2){
                twice.add(entry.getKey());
            }
        }
        return twice;
    }
}
