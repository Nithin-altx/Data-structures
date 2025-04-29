//Approach 1
class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n=nums.length;
        long res=0;
            int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            max=Math.max(max,nums[i]);
        }
        List<Integer> maxi=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(nums[i]==max)
            {
                maxi.add(i);
            }
            int size=maxi.size();
            if(size>=k)
            {
                int lasi=maxi.get(size-k);
                res+=lasi+1;
            }
        }
        return res;
    }
}
//Approach 2
class Solution {
    public long countSubarrays(int[] nums, int k) {
        //Tc=O(N)
        //sc=O(1)
        int max=Integer.MIN_VALUE;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            max=Math.max(max,nums[i]);
        }
        long i=0;int j=0;
        int sum=0;
        long res=0;
        while(j<n)
        {
            if(nums[j]==max)
            {
                sum++;
            }
            while(sum>=k)
            {
                if(nums[(int)i]==max)
                {
                    sum--;
                }
                i++;
                res+=n-j;
            }
            j++;
            

        }
        return res;


        
    }
}
