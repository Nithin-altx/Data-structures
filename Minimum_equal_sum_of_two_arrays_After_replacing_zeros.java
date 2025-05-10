class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1=0,zero1=0;
        long sum2=0,zero2=0;
        //Tc=O(N)
        //Sc=O(1)
        for(int i=0;i<nums1.length;i++)
        {
            if(nums1[i]==0)
            {
                nums1[i]=1;
                zero1++;
            }
        }
        for(int i=0;i<nums2.length;i++)
        {
            if(nums2[i]==0)
            {
                nums2[i]=1;
                zero2++;
            }
        }
        for(int x:nums1)
        {
            sum1+=x;;
            
        }
         for(int x:nums2)
        {
            sum2+=x;
        }
        if(sum1<sum2&&zero1==0)
        return -1;
        if(sum2<sum1&&zero2==0)
        return -1;

        return Math.max(sum1,sum2);
        
    }
}
