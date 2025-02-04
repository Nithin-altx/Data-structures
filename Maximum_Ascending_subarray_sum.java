//Brute Force
//Tc=O(N^2)
//sc=O(1)
class Solution {
    public int maxAscendingSum(int[] nums) {
        int n=nums.length;
        int maxsum=0;
        for(int i=0;i<n;i++)
        {
            int sum=nums[i];
            for(int j=i+1;j<n;j++)
            {
                if(nums[j-1]<nums[j])
                {
                    sum+=nums[j];
                }
                else{
                    break;
                }
            }
            maxsum=Math.max(maxsum,sum);
        }
        return maxsum;
    }
}
//Optimal
//Tc=O(N)
//sc=O(1)
class Solution {
    public int maxAscendingSum(int[] nums) {
        int n=nums.length;
        int inc=nums[0];
        int maxsum=0;
        if(n==1)
        return nums[0];
        for(int i=1;i<n;i++)
        {
            if(nums[i-1]<nums[i])
            {
                inc+=nums[i];
                maxsum=Math.max(maxsum,inc);
            }
            else{
                maxsum=Math.max(maxsum,inc);
                inc=nums[i];    
            }
        }
        return maxsum;
       

    }
}
