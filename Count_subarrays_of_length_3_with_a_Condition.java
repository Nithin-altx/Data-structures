//Brute Force
class Solution {
    public int countSubarrays(int[] nums) {
        int n=nums.length;
        int count=0;
        for(int i=0;i<n;i++)
        {
            List<Integer> ls=new ArrayList<>();
            for(int j=i;j<n;j++)
            {
                ls.add(nums[j]);
                if(ls.size()==3)
                {
                    break;
                }
            }
            if(ls.size()<3)
            {
                continue;
            }
            double ele=(double)ls.get(1)/2;
            double sum=ls.get(0)+ls.get(2);
            if(sum==ele)
            {
                count++;
            }
        }
        return count;
    }
}
//Optimal
class Solution {
    public int countSubarrays(int[] nums) {
        int i=0,j=0,count=0;
        int n=nums.length;
        while(j<n)
        {
            if(j-i+1==3)
            {
                double half=(double)nums[j-1]/2;
                double sum=nums[i]+nums[j];
                if(half==sum)
                {
                    count++;
                }
                i++;
            }
            j++;
        }
        return count;
        
    }
}
