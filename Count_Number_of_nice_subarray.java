class Solution {
    public int check(int []nums,int goal)
    {
        int left=0;
        int right=0;
        int sum=0;
        int count=0;
        for(;right<nums.length;right++)
        {
            sum+=nums[right];
            while(sum>goal&&left<=right)
            {
                sum-=nums[left];
                left++;
            }
            count+=right-left+1;
        }
        return count;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        for(int i=0;i<nums.length;i++)
        {
            nums[i]=nums[i]%2;
        }
        return check(nums,k)-check(nums,k-1);
        
    }
}
