class Solution {
    //3 3 3 2 1 5
    //Tc=O(N)
    void update(int num,int[]vec,int val)
    {
        for(int i=0;i<32;i++)
        {
            if(((num>>i)&1)!=0)
            {
                vec[i]+=val;
            }
        }
    }
    int getdecimal(int[]vec)
    {
        int num=0;
        for(int i=0;i<32;i++)
        {
            if(vec[i]>0)
            num|=(1<<i);
        }
        return num;
    }
    public int minimumSubarrayLength(int[] nums, int k) {
        int n=nums.length;
        int i=0,j=0;
        int vec[]=new int[32];
        int result=Integer.MAX_VALUE;
        while(j<n)
        {
            update(nums[j],vec,1);
            while(i<=j&&getdecimal(vec)>=k)
            {
                result=Math.min(result,j-i+1);
                    update(nums[i],vec,-1);
                i++;
            }
            j++;
        }
        return result==Integer.MAX_VALUE?-1:result;
    }
}
