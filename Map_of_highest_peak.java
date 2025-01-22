class Solution {
    public int[][] highestPeak(int[][] isWater) {
        //Tc=O(M*n)
        //sc=O(m*n)
        //Multiple source BFS
        int m=isWater.length;
        int n=isWater[0].length;
        int height[][]=new int[m][n];
        Queue<int[]> pq=new LinkedList<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(isWater[i][j]==1)
                {
                    pq.offer(new int[]{i,j});
                    height[i][j]=0;
                }
                else
                {
                    height[i][j]=-1;
                }
            }
        }
        int dir[][]={{1,0},{-1,0},{0,-1},{0,1}};
        while(!pq.isEmpty())
        {
            int N=pq.size();
            while(N-->0)
            {
                int []curr=pq.poll();
                int i=curr[0];
                int j=curr[1];
                for(int d[]:dir)
                {
                    int i_=i+d[0];
                    int j_=j+d[1];
                    if(i_>=0&&i_<m&&j_>=0&&j_<n&&height[i_][j_]==-1)
                    {
                        height[i_][j_]=height[i][j]+1;
                        pq.offer(new int[]{i_,j_});
                    }

                }


            }
        }
        return height;
    
        
    }
}
