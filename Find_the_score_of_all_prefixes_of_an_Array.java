class Solution {
    //Tc=O(N)
    public long[] findPrefixScore(int[] nums) {
        long pre1[]=new long[nums.length];
        int maxbeauty=nums[0];
        for(int i=0;i<nums.length;i++)
        {
            maxbeauty=Math.max(maxbeauty,nums[i]);
            pre1[i]=maxbeauty;
        }
          long pre2[]=new long[nums.length];
          for(int i=0;i<nums.length;i++)
          {
            pre2[i]=pre1[i]+nums[i];
          }
        long res[]=new long[nums.length];
        res[0]=pre2[0];
        for(int i=1;i<nums.length;i++)
        {
            res[i]=pre2[i]+res[i-1];
        }
        return res;
    }
}
