//Brute Force
//Tc=O(M*N),sc=O(m*N)
class Solution {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int res[][]=new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                res[i][j]=matrix[i][j];
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]==1)
                continue;

                if(matrix[i][j]==0)
                {
                    int row=i;
                    int col=j;
                    for(int k=0;k<n;k++)
                    {
                        res[row][k]=0;
                    }
                    for(int l=0;l<m;l++)
                    {
                        res[l][col]=0;
                    }
                }
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                matrix[i][j]=res[i][j];
            }
        }
    }
}
//Better Tc=O(m*N),sc=O(m+n)
class Solution {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        boolean row[]=new boolean[m];
        boolean col[]=new boolean[n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]==1)
                continue;

                if(matrix[i][j]==0)
                {
                    row[i]=true;
                    col[j]=true;  
                }
            }
        }
         for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(row[i]==true||col[j]==true)
                {
                    matrix[i][j]=0;
                }

            }
        }
      
    }

     
}
//Optimal Tc=O(m+N) Sc=O(1)
class Solution {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
       boolean firstrowimpacted=false;
       boolean firstcolimpacted=false;
       for(int i=0;i<n;i++)
       {
        if(matrix[0][i]==0)
        {
            firstrowimpacted=true;
            break;
        }
       }
       for(int i=0;i<m;i++)
       {
        if(matrix[i][0]==0)
        {
            firstcolimpacted=true;
            break;
        }
       }
        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                if(matrix[i][j]==1)
                continue;

                if(matrix[i][j]==0)
                {
                   matrix[i][0]=0;
                   matrix[0][j]=0; 
                }
            }
        }
        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                if(matrix[i][0]==0||matrix[0][j]==0)
                {
                    matrix[i][j]=0;
                }
            }
        }
        if(firstrowimpacted)
        {
            for(int i=0;i<n;i++)
            {
                matrix[0][i]=0;
            }
        }
        if(firstcolimpacted)
        {
            for(int i=0;i<m;i++)
            {
                matrix[i][0]=0;
            }
        }
        
    }

     
}
