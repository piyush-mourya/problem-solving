class Solution {
  // Method that worked
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
			return intervals;

		// Sort by ascending starting point
		Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

		List<int[]> result = new ArrayList<>();
		int[] newInterval = intervals[0];
		result.add(newInterval);
		for (int[] interval : intervals) {
            // Overlapping intervals, move the end if needed
			if (interval[0] <= newInterval[1]) 
				newInterval[1] = Math.max(newInterval[1], interval[1]);
			else {                             
                // Disjoint intervals, add the new interval to the list
				newInterval = interval;
				result.add(newInterval);
			}
		}

		return result.toArray(new int[result.size()][]);
	}
  
  // method that worked excluding the cases where the merging continues till the end
   public int[][] merge(int[][] intervals) {
   int first = 0;
        int second = 1;
        int n = intervals.length;
        if(n == 1){
            return intervals;
        }
		Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        List<int[]> ans = new ArrayList<>();
        int i = 1;
        while(i < n){
            if(intervals[i][0] <= intervals[i-1][1]){
                first = i-1;
                //second = i+1;
                
                while(intervals[i][0] <= intervals[i-1][1]){
                    second = i;
                        i++;
                }
                
                int[] ele = { intervals[first][0] , intervals[second][1] };
                ans.add(ele);
            } else if (intervals[i][0] > intervals[i-1][1]){
                ans.add(intervals[i]);
                i++;
                first = i-1;
                second = first + 1;
            }
            
        }
        return ans.toArray(new int[ans.size()][]);
     }
}
