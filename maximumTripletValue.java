class Solution {
    public long maximumTripletValue(int[] nums) {
        long val=0;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                for(int k=j+1;k<n;k++)
                {
                    long x=((long)nums[i]-nums[j])*nums[k];
                    val=Math.max(x,val);
                }
            }
        }
        return val<0?-1:val;
        
    }
}
//Approach 2
class Solution {
    public long maximumTripletValue(int[] nums) {
        long val=0;
        int n=nums.length;
        int leftmaxi[]=new int[n];
        int rightmaxk[]=new int[n];
        leftmaxi[0]=0;
        for(int i=1;i<n;i++)
        {//Finding max nums[i] value that is leftmost 
          leftmaxi[i]=Math.max(leftmaxi[i-1],nums[i-1]);
        }
        rightmaxk[n-1]=0;
        for(int i=n-2;i>=0;i--)
        {//Finding max nums[k] value that is right most
            rightmaxk[i]=Math.max(rightmaxk[i+1],nums[i+1]);
        }
        for(int j=0;j<n;j++)
        {
            val=Math.max((long)(leftmaxi[j]-nums[j])*rightmaxk[j],val);
        }
        return val<0?-1:val;


       
        
    }
}
//Approach 3
//Tc=O(n),sc=O(1)
class Solution {
    public long maximumTripletValue(int[] nums) {
        long val=0;
        int n=nums.length;
        long maxdiff=0;
        long maxi=0;
        for(int k=0;k<n;k++)
        {
            val=Math.max((long)(maxdiff*nums[k]),val);
            maxdiff=Math.max(maxdiff,(long)maxi-nums[k]);
            maxi=Math.max(maxi,nums[k]);

        }
        return val<0?-1:val;


       
        
    }
}
