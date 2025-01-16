class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        //Tc=O(N)
        //sc=O(1)
        int xor1=0;
        int n=nums1.length;
        int m=nums2.length;
        int add=m%2==0?0:1;
        for(int i=0;i<m;i++)
        {
            xor1=xor1^nums2[i];
        }
        int resxor=0;
        for(int i=0;i<n;i++)
        {
            if(add==0)
            {
                resxor=resxor^xor1;
            }
            else{
                resxor=resxor^xor1^nums1[i];
            }
        }
        return resxor;

      
    }
}
