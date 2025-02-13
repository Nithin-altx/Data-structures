//Approach 1
class Solution {
    public int maximumSum(int[] nums) {
        int n=nums.length;
        int sums[]=new int[n]  ;
        for(int i=0;i<n;i++)
        {
            int num=nums[i];
            int sum=0;
            while(num>0)
            {
                int rem=num%10;
                sum+=rem;
                num=num/10;
            }
            sums[i]=sum;
        }   
        Map<Integer,Integer> mp=new HashMap<>();
        int maxsum=-1;
        for(int i=0;i<n;i++)
        {
            if(mp.containsKey(sums[i]))
            {
                int idx=mp.get(sums[i]);
                int curridx=i;
                maxsum=Math.max(maxsum,nums[idx]+nums[curridx]);

                if(nums[curridx]>nums[idx]){
                mp.put(sums[i],i);
                }
            }
            else
            mp.put(sums[i],i);

        }  
        return maxsum;                                                           
    }
}
//Approach 2
class Solution {
    public int maximumSum(int[] nums) {
        int n=nums.length;
        int sums[]=new int[n]  ;
        for(int i=0;i<n;i++)
        {
            int num=nums[i];
            int sum=0;
            while(num>0)
            {
                int rem=num%10;
                sum+=rem;
                num=num/10;
            }
            sums[i]=sum;
        }   
     int mp[]=new int[82];
        int maxsum=-1;
        for(int i=0;i<n;i++)
        {
            if(mp[sums[i]]>0)
            {
                maxsum=Math.max(maxsum,mp[sums[i]]+nums[i]);
            }
            mp[sums[i]]=Math.max(mp[sums[i]],nums[i]);
           

        }  
        return maxsum;                                                           
    }
}
