//******************Recursion+Memorization************
class Solution {
    int m,n;
    int t[][];
    //Tc=O(M*N)
    //Sc=O(M*n)
    int solve(int i,int j,char[][] matrix)
    {
        if(i>=m||j>=n)
        {
            return 0;
        }
        if(t[i][j]!=-1)
        return t[i][j];
        if(matrix[i][j]=='0')
        return 0;
        int right=solve(i,j+1,matrix);
        int diag=solve(i+1,j+1,matrix);
        int down=solve(i+1,j,matrix);

        return t[i][j]=1+Math.min(right,Math.min(diag,down));
    }
    public int maximalSquare(char[][] matrix) {
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
                if(matrix[i][j]=='1')
                {
                    result=Math.max(result,solve(i,j,matrix));
                }
            }
        }
        return result*result;
        
    }
}
//*****************BottomUp Approach************
class Solution {
    int m,n;
    int t[][];
    //Tc=O(M*N)
    //Sc=O(M*n)
    public int maximalSquare(char[][] matrix) {
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
                t[i][j]=(matrix[i][j]=='0')?0:1;
                else if(matrix[i][j]=='1')
                {
                    t[i][j]=1+Math.min(t[i-1][j],Math.min(t[i][j-1],t[i-1][j-1]));
                }
                result=Math.max(result,t[i][j]);

            }
        }
        return result*result;
        
    }
}
