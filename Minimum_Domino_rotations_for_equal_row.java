class Solution {
    int find(int[] tops, int[] bottoms,int val)
    {
        int swaptops=0,swapbottoms=0;
        for(int i=0;i<tops.length;i++)
        {
            if(tops[i]!=val&&bottoms[i]!=val)
            {
                return -1;
            }
            else if(tops[i]!=val)
            {
                swaptops++;
            }
            else if(bottoms[i]!=val)
            {
                swapbottoms++;
            }
        }
        return Math.min(swaptops,swapbottoms);
    }
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int result=10000;
        //Tc=O(N)
        //SC=O(1)
        for(int val=1;val<=6;val++)
        {
            int steps=find(tops,bottoms,val);
            if(steps!=-1)
            result=Math.min(result,steps);
        }
        return result==10000?-1:result;
        
    }
}
