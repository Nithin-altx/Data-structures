class Solution {
    //Tc=O(n)
    public long maximumSubarraySum(int[] nums, int k) {
        Set<Integer> st=new HashSet<>();
        int i=0,j=0;
        int n=nums.length;
        long sum=0;
        long maxsum=0;
        while(j<n)
        {
               while(st.contains(nums[j]))
               {
                sum-=nums[i];
                st.remove(nums[i]);
                i++;
               }
                sum+=nums[j];
                st.add(nums[j]); 
            if(j-i+1==k)
            {
                maxsum=Math.max(maxsum,sum);
                sum-=nums[i];
                st.remove(nums[i]);
                i++;
            }
            j++;
        }
        return maxsum;
    }
}
