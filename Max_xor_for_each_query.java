class Solution {
    //Tc=O(N)
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int xor=0;
        for(int i=0;i<nums.length;i++)
    {
        xor^=nums[i];
    }
    int result[]=new int[nums.length];
    int mask=(1<<maximumBit)-1;//To flip the bits of given number ,size=maxbit
    for(int i=0;i<nums.length;i++)
    {
        int k=xor^mask;
        result[i]=k;
        xor=xor^nums[nums.length-1-i];
    }
    return result;
    }
}
