class Solution {
    int t[];
    //tc=O(high)
    //sc=O(high)
    int solve(int len,int low, int high, int zero, int one)
    {
        if(len>high)
        return 0;
        if(t[len]!=-1)
        return t[len];
        boolean addone=false;
        if(len>=low&&len<=high)
        {
            addone=true;
        }
        int left=solve(len+zero,low,high,zero,one);
        int right=solve(len+one,low,high,zero,one);
        t[len]=addone==true?(1+left+right):(left+right);
        t[len]%=1000000007;
        return t[len];
        
    }
    public int countGoodStrings(int low, int high, int zero, int one) {
        t=new int[high+1];
        for(int i=0;i<high+1;i++)
        {
            t[i]=-1;
        }
       return solve(0,low,high,zero,one);
    }
}
