class Solution {
    public boolean canSortArray(int[] nums) {
        int n=nums.length;
        //Tc=O(N^2)
        //Sc=O(N)
        int cp[]=new int[n];
        for(int i=0;i<n;i++)
        {
            cp[i]=nums[i];
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n-1;j++)
            {
                if(cp[j]<=cp[j+1])
                {
                    continue;
                }
                else{
                if(Integer.bitCount(cp[j])==Integer.bitCount(cp[j+1]))
                {
                    int temp=cp[j];
                    cp[j]=cp[j+1];
                    cp[j+1]=temp;
                }
                else{
                    return false;
                }
                }
            }
        }
        return true;
    }
}
