class Solution {
    //Tc=O(NLogN)
    int lowerbound(int[]nums,int start,int end,int target)
    {
        while(start<=end)
        {
         int mid=(start+end)/2;
            if(nums[mid]<target)
            {
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return start;
    }
     int upperbound(int[]nums,int start,int end,int target)
    {
        while(start<=end)
        {
            int mid=(start+end)/2;
            if(nums[mid]<=target)
            {
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return start;
    }
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        int n=nums.length;
        long result=0;
        for(int i=0;i<n;i++)
        {
            int leftidx=lowerbound(nums,i+1,n-1,lower-nums[i]);
            int rightidx=upperbound(nums,i+1,n-1,upper-nums[i]);
            int x=leftidx-1-i;
            int y=rightidx-1-i;
            result+=(y-x);
        }
        return result;
    }
}
