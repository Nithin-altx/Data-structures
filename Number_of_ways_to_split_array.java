class Solution {
    public int waysToSplitArray(int[] nums) {
        int n=nums.length;
        long leftsum[]=new long[n];
        leftsum[0]=nums[0];
        for(int i=1;i<n;i++)
        {
            leftsum[i]=leftsum[i-1]+nums[i];
        }
        int count=0;
        for(int i=0;i<n-1;i++)
        {
            long lsum=leftsum[i];
            long rsum=leftsum[n-1]-leftsum[i];
            if(lsum>=rsum)
            {
                count++;
            }

        }
        return count;
    }
}
//approach 2
class Solution {
    public int waysToSplitArray(int[] nums) {
        int n=nums.length;
       long rightsum=0;
        for(int i=0;i<n;i++)
        {
           rightsum+=nums[i];
        }
        int count=0;
        long lsum=0;
        for(int i=0;i<n-1;i++)
        {
             lsum+=nums[i];
            rightsum=rightsum-nums[i];
            if(lsum>=rightsum)
            {
                count++;
            }

        }
        return count;
    }
}
