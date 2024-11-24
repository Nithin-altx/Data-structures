class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int m=matrix.length;
        int negative=0;
        long sum=0;
        int minele=Integer.MAX_VALUE;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<m;j++)
            {
                 sum=sum+Math.abs(matrix[i][j]);
                 minele=Math.min(minele,Math.abs(matrix[i][j]));
                if(matrix[i][j]<0)
                {
                    negative++;
                }
            }
        }
        if(negative%2==0)
        {
            return sum;
        }
        else{
             return sum-2*minele;

        }
           
        
    }
}
