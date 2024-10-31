class Solution {
    public int lengthOfLIS(int[] nums) {
    int n=nums.length;
      int[] lis = new int[n];
      for (int i = 0; i < n; i++) {
            lis[i] = 1;
        }
        int maxlen=lis[0];
         for (int i = 0; i < n; i++) {
            for (int j = i-1; j>=0; j--) {
                if (nums[i] > nums[j]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
            maxlen=Math.max(maxlen,lis[i]);
        }
        return maxlen;


    }
}
//***************Rec+memo****************
class Solution {
    int n;
    int t[][];
    int solve(int i,int p,int []nums)
    {
       
        if(i>=n)
        return 0;
        if(p!=-1&&t[i][p]!=-1)
        {
            return t[i][p];
        }
        int take=0;
        if(p==-1||nums[p]<nums[i])
        {
             take=1+solve(i+1,i,nums);
        }
        int skip=solve(i+1,p,nums);
        if(p!=-1)
        t[i][p]=Math.max(take,skip);

        return  Math.max(take,skip);
        
    }
    public int lengthOfLIS(int[] nums) {
        n=nums.length;
        t=new int[n+1][n+1];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(t[i],-1);
        }
        return solve(0,-1,nums);
        
    }
}
