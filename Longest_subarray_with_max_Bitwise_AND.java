class Solution {
    public int longestSubarray(int[] nums) {
        int maxvalue=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>maxvalue)
            {
                maxvalue=nums[i];
            }
        }
        int c=0;
        int result=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==maxvalue)
            {
                c++;
            }
            else{
                c=0;
            }
            result=Math.max(result,c);
        }
        return result;
        
    }
}
