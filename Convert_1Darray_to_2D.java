class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int [][]r=new int[m][n];
        if(m*n!=original.length)
        return new int[0][0];
       for(int i=0;i<original.length;i++)
        {
            r[i/n][i%n]=original[i];
        }
        return r;
        
    }
}

