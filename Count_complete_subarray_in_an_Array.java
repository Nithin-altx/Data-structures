class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> st1=new HashSet<>();
        for(int x:nums)
        {
            st1.add(x);
        }
        int n=nums.length;
        int res=0;
        for(int i=0;i<n;i++)
        {
            Set<Integer> st2=new HashSet<>();
            for(int j=i;j<n;j++)
            {
                st2.add(nums[j]);
                if(st2.size()==st1.size())
                {
                    res++;
                }
           
            }
          
        }
        return res;


        
    }
}
