class Solution {
    public long countGood(int[] nums, int k) {
        int i=0,j=0;
        int n=nums.length;
        long pairs=0,res=0;
        Map<Integer,Integer> mp=new HashMap<>();
        while(j<n)
        {
            if(mp.containsKey(nums[j]))
            {
                pairs+=mp.get(nums[j]);
            }
             mp.put(nums[j],mp.getOrDefault(nums[j],0)+1);
            while(pairs>=k)
            {
                res+=n-j;
                mp.put(nums[i],mp.get(nums[i])-1);
                pairs-=mp.get(nums[i]);
                i++;
            }
            j++;
        }
        return res;
        
    }
}
