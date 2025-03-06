class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int a[]=new int[2];
        int n=grid.length;
        int hash[]=new int[(n*n)+1];
        int sum=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                hash[grid[i][j]]++;
                if(hash[grid[i][j]]>1)
                {
                    a[0]=grid[i][j];
                    continue;
                }
                sum+=grid[i][j];
            }
        }
        int t=n*n;
        int tsum=0;
        for(int i=1;i<=t;i++)
        {
            tsum+=i;
        }
        a[1]=tsum-sum;
        return a;
        
        
    }
}
