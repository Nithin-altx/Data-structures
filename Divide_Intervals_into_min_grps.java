class Solution {
    public int minGroups(int[][] intervals) {
     PriorityQueue<Integer> pq=new PriorityQueue<>();
       Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for(int x[]:intervals)
        {
            int start=x[0];
            int end=x[1];
            if(pq.isEmpty())
            {
                pq.offer(end);
            }
            else{
                int top=pq.peek();
                if(start>top)
                {
                    pq.poll();
                    pq.offer(end);
                }
                else{
                    pq.offer(end);
                }
            }
        }
        return pq.size();
        
    }
}
