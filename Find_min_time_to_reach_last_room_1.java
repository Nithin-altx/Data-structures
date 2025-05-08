class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n=moveTime.length;
        int m=moveTime[0].length;
        int res[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(res[i],Integer.MAX_VALUE);
        }
        res[0][0]=0;
        int dir[][]=new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
           PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0,0,0});
        while(!pq.isEmpty())
        {
            int curr[]=pq.poll();
            int time=curr[0];
            int i=curr[1];
            int j=curr[2];
            if(i==n-1&&j==m-1)
            {
                return time;
            }
            for(int d[]:dir)
            {
                int i_=i+d[0];
                int j_=j+d[1];
                if(i_>=0&&j_>=0&&i_<n&&j_<m)
                {
                    int wait=Math.max(0,moveTime[i_][j_]-time);
                    int finaltime=wait+time+1;
                    if(res[i_][j_]>finaltime)
                    {
                        res[i_][j_]=finaltime;
                        pq.add(new int[]{finaltime,i_,j_});
                    }
                }
            }

        }
        return res[n-1][m-1];
    }
}
