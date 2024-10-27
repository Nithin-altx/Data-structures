//*************Recursion+Memorization****************class Solution {
    int m,n;
    int t[][];
    //Tc=O(m*N)
    //Sc=O(m*n);
    int solve(int i,int j,int[][] matrix,int t[][])
    {
        if(i>=m||j>=n)
        {
            return 0;
        }
        if(t[i][j]!=-1)
        return t[i][j];
        if(matrix[i][j]==0)
        return 0;
        int right=solve(i,j+1,matrix,t);
        int diag=solve(i+1,j+1,matrix,t);
        int down=solve(i+1,j,matrix,t);
        return t[i][j]= 1+Math.min(right,Math.min(diag,down));
    }
    public int countSquares(int[][] matrix) {
         m=matrix.length;
         n=matrix[0].length;
        int result=0;
        t=new int[m+1][n+1];
        for(int i=0;i<=m;i++)
        {
            Arrays.fill(t[i],-1);
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]==1)
                {
                    result+=solve(i,j,matrix,t);
                }
            }
        }
        return result;
        
    }
}
//***************BottomUp Approach*****************
class Solution {
    int m,n;
    int t[][];
    //Tc=O(m*N)
    //Sc=O(m*n);
    public int countSquares(int[][] matrix) {
         m=matrix.length;
         n=matrix[0].length;
        int result=0;
        t=new int[m+1][n+1];
        for(int i=0;i<=m;i++)
        {
            Arrays.fill(t[i],0);
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0||j==0)
                {
                    t[i][j]=matrix[i][j];
                }
                else if(matrix[i][j]==1)
                {
                   t[i][j]=1+Math.min(t[i-1][j],Math.min(t[i][j-1],t[i-1][j-1]));
                }
            result+=t[i][j];
            }
            
        }
        return result;
        
    }
}
