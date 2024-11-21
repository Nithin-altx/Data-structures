//Recurision
class Solution {
    void explore(int[][]matrix,int i,int j,int m,int n,int dir)
    {
        if(i>=m||i<0||j>=n||j<0||matrix[i][j]==3||matrix[i][j]==2)
        {
            return;
        }
        matrix[i][j]=1;
        if(dir==1)
        explore(matrix,i-1,j,m,n,1);
        else if(dir==2)
        explore(matrix,i+1,j,m,n,2);
        else if(dir==3)
        explore(matrix,i,j+1,m,n,3);
        else
        explore(matrix,i,j-1,m,n,4);
    }
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int matrix[][]=new int[m][n];
       for(int x[]:guards)
       {
        int a=x[0];
        int b=x[1];
        matrix[a][b]=2;
       }
        for(int y[]:walls)
       {
        int a=y[0];
        int b=y[1];
        matrix[a][b]=3;
       }
       for(int x[]:guards)
       {
        int i=x[0];
        int j=x[1];
        explore(matrix,i-1,j,m,n,1);
        explore(matrix,i+1,j,m,n,2);
        explore(matrix,i,j+1,m,n,3);
        explore(matrix,i,j-1,m,n,4);
       }
       int count=0;
       for(int i=0;i<m;i++)
       {
        for(int j=0;j<n;j++)
        {
            if(matrix[i][j]==0)
            {
                count++;
            }
        }
       }
       return count;


    }
}
//Iteration

class Solution {
    void explore(int row,int col,int[][]matrix)
    {
        for(int i=row-1;i>=0;i--)//up
        {
            if(matrix[i][col]==2||matrix[i][col]==3)
            {
                break;
            }
            matrix[i][col]=1;
        }
        for(int i=row+1;i<matrix.length;i++)//down
        {
            if(matrix[i][col]==2||matrix[i][col]==3)
            {
                break;
            }
            matrix[i][col]=1;
        }
        for(int i=col+1;i<matrix[0].length;i++)//right
        {
            if(matrix[row][i]==2||matrix[row][i]==3)
            {
                break;
            }
            matrix[row][i]=1;
        }
        for(int i=col-1;i>=0;i--)//left
        {
              if(matrix[row][i]==2||matrix[row][i]==3)
            {
                break;
            }
            matrix[row][i]=1;

        }


    }
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int matrix[][]=new int[m][n];
       for(int x[]:guards)
       {
        int a=x[0];
        int b=x[1];
        matrix[a][b]=2;
       }
        for(int y[]:walls)
       {
        int a=y[0];
        int b=y[1];
        matrix[a][b]=3;
       }
       for(int x[]:guards)
       {
        int i=x[0];
        int j=x[1];
        explore(i,j,matrix);
       }
       int count=0;
       for(int i=0;i<m;i++)
       {
        for(int j=0;j<n;j++)
        {
            if(matrix[i][j]==0)
            {
                count++;
            }
        }
       }
       return count;


    }
}
