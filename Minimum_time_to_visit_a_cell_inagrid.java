class Solution {
    //Tc=O(E*log(v))
    //E=V=M*N
    //Sc=O(M*N)
    public int minimumTime(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int [][]directions={{0,1},{1,0},{0,-1},{-1,0}};
        if(grid[0][1]>1&&grid[1][0]>1)
        return -1;
        PriorityQueue<int[]>pq=new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        pq.offer(new int[]{0,0,0});
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++)
        {
            Arrays.fill(visited[i],false);
        }
        while(!pq.isEmpty())
        {
            int curr[]=pq.poll();
            int time=curr[0];
            int i=curr[1];
            int j=curr[2];
            if(i==m-1&&j==n-1)
            {
                return time;
            }
            if(visited[i][j]==true)
            {
                continue;
            }
            visited[i][j]=true;
            for(int[]dir:directions)
            {   
                int x=i+dir[0];
                int y=j+dir[1];
                if(x<0||x>=m||y<0||y>=n)
                {
                    continue;
                }
          if(grid[x][y]<=time+1)
            {

                pq.offer(new int[]{time+1,x,y});
            }
            else if((grid[x][y]-time)%2==0)
            {
                pq.offer(new int[]{grid[x][y]+1,x,y});
            }
            else{
             
                pq.offer(new int[]{grid[x][y],x,y});
            }  
        }
          
        }
        return -1;

    }
}
