class Solution {
    public int numOfSubarrays(int[] nums) {
        //Tc=O(N)
        //sc=O(1)
        // Map<Integer,Integer> mp=new HashMap<>();
        int n=nums.length;
        // mp.put(2,1);
        int sum=0;
        int res=0;
        int even=1;
        int odd=0;
        int m=1000000007;
        for(int i=0;i<n;i++)
        {
            sum+=nums[i];
            if(sum%2==0)
            {
               res=(res+odd)%m;
               even++;
            }
            else{
               res=(res+even)%m;
               odd++;
            }
            
        }
        return res;
        
    }
}
