class Solution {
//Tc=O(N)
//Sc=O(1)
    public List<List<Integer>> merge(int[][] intervals) {
        int n = intervals.length;
        // List to store merged intervals
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        // Start by adding the first interval
        List<Integer> firstInterval = new ArrayList<>();
        firstInterval.add(intervals[0][0]);
        firstInterval.add(intervals[0][1]);
        res.add(firstInterval);

        for (int i = 1; i < n; i++) {
            // Get the last interval in the result list
            List<Integer> lastInterval = res.get(res.size() - 1);

            // Check if the current interval overlaps with the last one
            if (intervals[i][0] < lastInterval.get(1)) {
                // Merge the intervals
                lastInterval.set(0, Math.min(intervals[i][0], lastInterval.get(0)));
                lastInterval.set(1, Math.max(intervals[i][1], lastInterval.get(1)));
            } else {
                // No overlap, just add the current interval
                List<Integer> newInterval = new ArrayList<>();
                newInterval.add(intervals[i][0]);
                newInterval.add(intervals[i][1]);
                res.add(newInterval);
            }
        }
        return res;
    }
    public boolean checkValidCuts(int n, int[][] rectangles) {
        int size=rectangles.length;
       int xaxis[][]=new int[size][2];
       int yaxis[][]=new int[size][2];
        int i=0;
        for(int r[]:rectangles)
        {
            int x1=r[0];
            int y1=r[1];
            int x2=r[2];
            int y2=r[3];
            xaxis[i][0]=x1;
            xaxis[i][1]=x2;
            yaxis[i][0]=y1;
            yaxis[i][1]=y2;
            i++;
        }
        List<List<Integer>> res1=merge(xaxis);
        List<List<Integer>> res2=merge(yaxis);
      
        return res1.size()>=3||res2.size()>=3;    
    }
}
