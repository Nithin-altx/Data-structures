class Solution {
    int n;
    //Tc=O(Nlogn)
    //Sc=O(n)
    int dp[][]=new int[100001][3];
    int binarysearch(int[][] events,int endval)
    {
        int l=0,r=n-1;
        int result=n;
        while(l<=r)
        {
            int mid=(l+r)/2;
            if(events[mid][0]>endval)
            {
                result=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return result;
    }
    int solve(int[][] events,int i,int count)
    {
        if(count==2||i>=n)
        {
            return 0;
        }
        if(dp[i][count]!=-1)
        {
            return dp[i][count];
        }
        int valididx=binarysearch(events,events[i][1]);
        int take=events[i][2]+solve(events,valididx,count+1);
        int nottake=solve(events,i+1,count);
       dp[i][count]=Math.max(take,nottake);
       return dp[i][count];
    }
    public int maxTwoEvents(int[][] events) {
        n=events.length;
        for(int i=0;i<100001;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        Arrays.sort(events,(a,b)->Integer.compare(a[0],b[0]));
        return solve(events,0,0);
    }
}
