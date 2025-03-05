class Solution {
long a[];
    long solve(int n)
    {
        if(a[n]!=-1)
        return a[n];
        if(n==1)
        return a[n]=1;
        return a[n]=solve(n-1)+(n-1)*4;
    }
    public long coloredCells(int n) {
        a=new long[n+1];
        for(int i=0;i<n+1;i++)
        {
            a[i]=-1;
        }
        solve(n);
       return a[n];
    }
}
//Approach 2
class Solution {
    public long coloredCells(int n) {
        long a[]=new long[n+1];
        a[1]=1;
        for(int i=2;i<=n;i++)
        {
            a[i]=a[i-1]+(i-1)*4;
        }
        return a[n];
    }
}
