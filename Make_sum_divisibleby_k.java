class Solution {
    public int minSubarray(int[] nums, int p) {
        int sum=0;
        int n=nums.length;
        for(int x:nums)
        {
            sum=(sum+x)%p;
        }
        int target=sum%p;
        if(target==0)
        return 0;
        Map<Integer,Integer> mp=new HashMap<>();
        int result=n;
        int curr=0;
        mp.put(0,-1);
        for(int j=0;j<n;j++)
        {
             curr=(curr+nums[j])%p;
            int rem=(curr-target+p)%p;//Finding any prev value exist in map
            if(mp.containsKey(rem))
            {
                result=Math.min(result,j-mp.get(rem));
            }
            mp.put(curr,j);
        }
        return result==n?-1:result;
        
    }
}
