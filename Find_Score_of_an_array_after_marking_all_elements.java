class Solution {
    public long findScore(int[] nums) {
        int n=nums.length;
             PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]); // Break ties by index
            }
            return Integer.compare(a[0], b[0]); // Compare by value
        });
        for(int i=0;i<n;i++)
        {
            pq.offer(new int[]{nums[i],i});
        }
        boolean marked[]=new boolean[n];
        long score=0;
        while(!pq.isEmpty())
        {
            int idx[]=pq.poll();
            if(marked[idx[1]]==true)
            continue;

            score+=nums[idx[1]];

            marked[idx[1]]=true;
            if(idx[1]>0)
            {
                marked[idx[1]-1]=true;
            }
            if(idx[1]<n-1)
            {
                marked[idx[1]+1]=true;
            }
        }
        return score;

    }
}
