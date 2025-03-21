class Solution {
//T.C : O(m*n log(m*n))
//S.C : O(m*n)
    public int minimumObstacles(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int result[][]=new int[m][n];
        for(int i=0;i<m;i++)
        {
            Arrays.fill(result[i],Integer.MAX_VALUE);
        }
        result[0][0]=0;
        PriorityQueue<int[]>pq=new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        pq.offer(new int[]{0,0,0});
        int [][]directions={{0,1},{0,-1},{1,0},{-1,0}};
        while(!pq.isEmpty())
        {
            int []curr=pq.poll();
            int obstaclecount=curr[0];
            int i=curr[1];
            int j=curr[2];
            for(int dir[]:directions)
            {
                int x=i+dir[0];
                int y=j+dir[1];
                if(x<0||x>=m||y<0||y>=n)
                {
                    continue;
                }
                int wt=(grid[x][y]==1)?1:0;
                if(obstaclecount+wt<result[x][y])
                {
                    result[x][y]=obstaclecount+wt;
                    pq.offer(new int[]{obstaclecount+wt,x,y});
                }
              
            }

        }
        return result[m-1][n-1];
    }

}
