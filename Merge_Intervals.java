//Tc=O(N)
//Sc=O(1)
class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        // List to store merged intervals
        List<List<Integer>> res = new ArrayList<>();
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
            if (intervals[i][0] <= lastInterval.get(1)) {
                // Merge the intervals
                lastInterval.set(0, Math.min(intervals[i][0], lastInterval.get(0)));
                lastInterval.set(1, Math.max(intervals[i][1], lastInterval.get(1)));
                res.remove(res.size()-1);
                res.add(lastInterval);
            } else {
                // No overlap, just add the current interval
                List<Integer> newInterval = new ArrayList<>();
                newInterval.add(intervals[i][0]);
                newInterval.add(intervals[i][1]);
                res.add(newInterval);
            }
        }
        int[][] result = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            List<Integer> interval = res.get(i);
            result[i][0] = interval.get(0);
            result[i][1] = interval.get(1);
        }

        return result;
    }
}
