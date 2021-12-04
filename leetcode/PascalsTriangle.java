https://leetcode.com/problems/pascals-triangle/

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> PascalTriangle = new ArrayList<List<Integer>>();
        if (numRows <=0){
            return PascalTriangle;
        }
        for (int i=0; i<numRows; i++){
            List<Integer> row =  new ArrayList<Integer>();
            for (int j=0; j<i+1; j++){
                if (j==0 || j==i){
                    row.add(1);
                } else {
                    row.add(PascalTriangle.get(i-1).get(j-1)+PascalTriangle.get(i-1).get(j));
                }
            }
            PascalTriangle.add(row);
        }
        return PascalTriangle;
    }
}
