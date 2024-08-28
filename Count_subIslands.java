class Solution {
    int m,n;
    boolean dfs(int[][] grid1,int [][] grid2,int i,int j)
    {
        if(i<0||i>=m||j<0||j>=n){
        return true;
        }
        if(grid2[i][j]!=1){
        return true;
        }
        grid2[i][j]=-1;
        boolean result=(grid1[i][j]==1);
        result=dfs(grid1,grid2,i+1,j)&result;//down
        result=dfs(grid1,grid2,i-1,j)&result;//Up
        result=dfs(grid1,grid2,i,j+1)&result;//left
        result=dfs(grid1,grid2,i,j-1)&result;//right
        return result;
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
         m=grid1.length;
         n=grid1[0].length;
        int result=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid2[i][j]==1&&dfs(grid1,grid2,i,j))
                {
                    result++;
                }
            }
               
        }
        return result;
        
    }
}
