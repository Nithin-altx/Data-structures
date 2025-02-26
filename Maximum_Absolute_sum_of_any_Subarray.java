class Solution {
    //Kadens Algorithm
    public int maxAbsoluteSum(int[] nums) {
        int maxsum=nums[0];
        int currsum=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            currsum=Math.max(nums[i],currsum+nums[i]);
            maxsum=Math.max(maxsum,currsum);
        }
        int minsum=nums[0];
        int currSum=nums[0];
         for(int i=1;i<nums.length;i++)
        {
            currSum=Math.min(nums[i],currSum+nums[i]);
            minsum=Math.min(minsum,currSum);
        }
        return Math.max(Math.abs(maxsum),Math.abs(minsum));
        
    }
}
