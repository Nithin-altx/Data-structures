class Solution {
    public int longestNiceSubarray(int[] nums) {
        int i=0,j=0;
        int n=nums.length;
        int res=1;
        int mask=0;
        while(j<n)
        {
            while(j<n&&(mask&nums[j])==0)
            {
                res=Math.max(res,j-i+1);
                 mask=mask|nums[j];
                 j++;
            }
            mask=mask^nums[i];
            i++;

        }
        return res;
    }
}
