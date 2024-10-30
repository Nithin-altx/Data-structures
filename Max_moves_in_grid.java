class Solution {
    int m,n;
    int dfs(int row,int col,int[][] grid,int[][]t)
    {
        int moves=0;
        int dir[]={-1,0,1};
        if(t[row][col]!=-1)
        return t[row][col];
        for(int i=0;i<dir.length;i++)
        {
            int newrow=row+dir[i];
            int newcol=col+1;
            if(newrow>=0&&newrow<m&&newcol>=0&&newcol<n&&grid[newrow][newcol]>grid[row][col])
            {
                moves=Math.max(moves,1+dfs(newrow,newcol,grid,t));
            }
        }
        return t[row][col]=moves;
    }
    public int maxMoves(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        int result=0;
        int t[][]=new int[m+1][n+1];
        for(int i=0;i<=m;i++)
        {
            Arrays.fill(t[i],-1);
        }
        for(int i=0;i<m;i++)
        {
            result=Math.max(result,dfs(i,0,grid,t));
        }
        return result;
        

    }
}
