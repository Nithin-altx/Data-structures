class GFG {
  
    
    static void rotate(int mat[][]) {
        // Code Here
        int m=mat.length;
        int n=mat[0].length;
        for(int i=0;i<m;i++)
        {
            for(int j=i;j<n;j++)
            {
                int temp=mat[i][j];
               mat[i][j]=mat[j][i];
              mat[j][i]=temp;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[i][n - 1 - j];
                mat[i][n - 1 - j] = temp;
            }
        }
       
   
    }
}
