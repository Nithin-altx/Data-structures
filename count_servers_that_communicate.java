class Solution {
    public int countServers(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        //Tc=O(m*n)
        //Sc=O(M+N)
        int row[]=new int[m];
        int col[]=new int[n];
        for(int i=0;i<m;i++)
        {
            int count=0;
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                {
                    count++;
                }
            }
            row[i]=count;
        }
        for(int i=0;i<n;i++)
        {
            int count=0;
            for(int j=0;j<m;j++)
            {
                if(grid[j][i]==1)
                {
                    count++;
                }
            }
            col[i]=count;
        }
        int res=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                {
                    if(row[i]>=2||col[j]>=2)
                    {
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
