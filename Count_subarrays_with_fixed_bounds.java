class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans=0;
        int n=nums.length;
        int mink=-1,maxk=-1,ci=-1;
        for(int i=0;i<n;i++)
        {
            if(nums[i]==minK)
            {
                mink=i;
            }
            if(nums[i]==maxK)
            {
                maxk=i;
            }
            if(nums[i]<minK||nums[i]>maxK)
            {
                ci=i;
            }
            int smaller=Math.min(mink,maxk);
            int temp=smaller-(ci);
            ans+=temp<=0?0:temp;
        }
        return ans;
    }
}
