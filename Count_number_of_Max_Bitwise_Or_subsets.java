class Solution {
    //Tc=O(2^N)
    //Sc=O(N)
   public int count(int idx,int currOr,int[]nums,int maxOr,int t[][])
    {
       if(idx==nums.length)
       {
        if(currOr==maxOr)
        return 1;
        else
         return 0;
       }
       if(t[idx][currOr]!=-1)
       return t[idx][currOr];
        int takecount=count(idx+1,currOr|nums[idx],nums,maxOr,t);
        int nottake=count(idx+1,currOr,nums,maxOr,t);

        return t[idx][currOr]=takecount+nottake;
    }
    public int countMaxOrSubsets(int[] nums) {
        int n=nums.length;
        int maxOr=0;
        for(int x:nums)
        {
            maxOr|=x;
        }
        int t[][]=new int[n+1][maxOr+1];
        for(int i=0;i<n+1;i++)
        {
            Arrays.fill(t[i],-1);
        
        }
        int currOr=0;
        return count(0,currOr,nums,maxOr,t);
        
    }
}
