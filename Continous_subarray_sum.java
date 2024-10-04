class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n=nums.length;
        Map<Integer,Integer> mp=new HashMap<>();
        mp.put(0,-1);
        int len=0;
        int curr=0;
        for(int i=0;i<n;i++)
        {
            curr+=nums[i];
            int rem=curr%k;
            if(mp.containsKey(rem))
            {
                len=i-mp.get(rem);
                if(len>=2)
                return true;
            }
            else
            mp.put(rem,i);
        }
        return false;
     
        
    }
}
