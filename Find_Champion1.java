class Solution {
    public int findChampion(int[][] grid) {
        int res[]=new int[grid.length];
        for(int i=0;i<grid.length;i++)
        {
            int count=0;
            for(int j=0;j<grid.length;j++)
            {
                if(grid[i][j]==1)
                {
                    count++;
                }
            }
            res[i]=count;
        }
        int max=res[0];
        int idx=0;
        for(int i=0;i<grid.length;i++)
        {
            if(res[i]>max)
            {
                max=res[i];
                idx=i;
            }
        }
        return idx;

        
    }
}
