class Solution {

    long solve(int i,int[][] questions,long t[])
    {
        if(i>=questions.length)
        return 0;
        if(t[i]!=-1)
        return t[i];
        long take=questions[i][0]+solve(questions[i][1]+i+1,questions,t);
        long nottake=solve(i+1,questions,t);

        return t[i]=Math.max(take,nottake);

    }
    public long mostPoints(int[][] questions) {
       long [] t=new long[questions.length+1];
        for(int i=0;i<questions.length+1;i++)
        {
            Arrays.fill(t,-1);
        }
         return solve(0,questions,t);
        
    }
}
//Using dp
class Solution {
    public long mostPoints(int[][] questions) {
        int n=questions.length;
        long dp[]=new long[n+1];
        for(int i=n-1;i>=0;i--)
        {
            int nextidx=i+ questions[i][1]+1;
            long take= questions[i][0]+(nextidx<n?dp[nextidx]:0);

            long skip=dp[i+1];
            dp[i]=Math.max(take,skip);
        }
        return dp[0];
        
    }
}
