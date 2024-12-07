class Solution {
    //T.C : O(nlog(MAX)), where n = length of nums, MAX = max value in nums
//S.C : O(1)
    boolean ispossible(int[]nums,int mid,int maxop)
    {
          int totalop=0;
        for(int x:nums)
        {
          
            int op=x/mid;
            if(x % mid==0)
            {
                op-=1;   
            }         
            totalop+=op;
        }
        return totalop<=maxop;
    }
    public int minimumSize(int[] nums, int maxOp) {
        int n=nums.length;
        int l=1,r= Arrays.stream(nums).max().getAsInt();
        int result=r;
        while(l<=r)
        {
            int mid=(l+r)/2;
            if(ispossible(nums,mid,maxOp))
            {
                result=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return result;

    }
}
