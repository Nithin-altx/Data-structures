class Solution {
    public long countSubarrays(int[] nums, long k) {
        //Tc=O(N)
        //Sc=O(1)
        long res=0;
        long sum=0;
        int i=0,j=0;
        int n=nums.length;
        while(j<n)
        {
            sum+=nums[j];
            if(sum*(j-i+1)<k)
            {
                res+=j-i+1;
            }
            else{
                while(sum*(j-i+1)>=k)
                {
                    sum-=nums[i];
                    i++;
                }
             if(sum*(j-i+1)<k)
            {
                res+=j-i+1;
            }
            }
            j++;
        }
        return res;

        
    }
}
