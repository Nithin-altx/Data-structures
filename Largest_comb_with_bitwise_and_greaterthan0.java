class Solution {
    //Tc=O(N)
    //Sc=O(1)
    //Number of bits required to represent a number=Ceil(log2(num))+1
    //To Know the ith bit is set or not=num&(1<<i)
    public int largestCombination(int[] candidates) {
        int result=0;
        for(int i=0;i<24;i++)
        {
            int count=0;
            for(int num: candidates)
            {
                if((num&(1<<i))!=0)
                {
                    count++;

                }
            }
            result=Math.max(result,count);
        }
        return result;
    }
}
