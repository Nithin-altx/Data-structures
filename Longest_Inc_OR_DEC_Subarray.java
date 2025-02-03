//Brute Force
class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int maxlen=0;
        int n=nums.length;
        //Increasing
        for(int i=0;i<n;i++)
        {
            List<Integer> ls=new ArrayList<>();
            ls.add(nums[i]);
            for(int j=i+1;j<n;j++)
            {
                if(nums[j]>ls.get(ls.size()-1))
                {
                    ls.add(nums[j]);
                } 
                else{
                    break;

                }

            }
            maxlen=Math.max(maxlen,ls.size());
        }
        //Decreasing
          for(int i=0;i<n;i++)
        {
            List<Integer> ls=new ArrayList<>();
            ls.add(nums[i]);
            for(int j=i+1;j<n;j++)
            {
                if(nums[j]<ls.get(ls.size()-1))
                {
                    ls.add(nums[j]);
                } 
                else{
                    break;
                }
            }
            maxlen=Math.max(maxlen,ls.size());
        }
        return maxlen;
        
    }
}
//Optimal
class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        //Tc=O(N)
        //Sc=O(1)
        int inclen=1,declen=1;
        int n=nums.length;
        int prev=nums[0];
        int maxlen=1;
        for(int i=1;i<n;i++)
        {
            int curr=nums[i];
            if(curr>prev)
            {
                inclen++;
                declen=1;
                maxlen=Math.max(maxlen,inclen);
            }
            else if(curr<prev)
            {
                declen++;
                inclen=1;
                maxlen=Math.max(maxlen,declen);
            }
            else{
                inclen=1;
                declen=1;
            }
            prev=curr;
        }
        return maxlen;
         
    }
}
