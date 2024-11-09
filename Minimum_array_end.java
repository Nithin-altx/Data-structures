class Solution {
    public long minEnd(int n, int x) {
        //To get the same number we can do and operation on that number
        //To get the same number(x) after anding with y ,do number+1|x=y
        //Tc=O(N)
        long result=x;
        for(int i=0;i<n-1;i++)
        {
            result=(result+1)|x;
        }
        return result;
    }
}
