class Solution {
    int Countnum(long curr,long next,int n)
    {
        int count=0;
        while(curr<=n)
        {
            count+=next-curr;
            curr*=10;
            next*=10;
            next=Math.min(next,(long)n+1);
        }
        return count;
    }
    public int findKthNumber(int n, int k) {
        int curr=1;
        k-=1;
        while(k>0)
        {
            int count=Countnum(curr,curr+1,n);
            if(count<=k)
            {
                curr++;
                k-=count;
            }
            else{
                curr*=10;
                k-=1;
            }
        }
        return curr;
    }
}
