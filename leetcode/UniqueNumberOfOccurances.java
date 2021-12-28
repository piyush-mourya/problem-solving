// https://leetcode.com/problems/unique-number-of-occurrences/

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> elements = new HashMap<Integer, Integer>();
        HashSet<Integer> occurances = new HashSet();
        for(int element : arr){
            if(elements.containsKey(element)){
                elements.put(element, elements.get(element) + 1);
            } else {
                elements.put(element, 1);
            }
        }
        
        for(int element : elements.values()){
            occurances.add(element);
        }
        
        if(elements.size() == occurances.size()){
            return true;
        } else {
            return false;
        }
    }
}
