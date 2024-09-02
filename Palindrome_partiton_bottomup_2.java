class Solution {
    public int minCut(String s) {
        int n=s.length();
        boolean t[][]=new boolean[2001][2001];
        for(int i=0;i<2001;i++)
        {
            Arrays.fill(t[i],false);
        }
        for(int i=0;i<n;i++)
        {
            t[i][i]=true;
        }
        for(int l=2;l<=n;l++)
        {
            for(int i=0;i<n-l+1;i++)
            {
                int j=i+l-1;
                if(l==2)
                {
                    t[i][j]=(s.charAt(i)==s.charAt(j));
                }
                else
                {
                    t[i][j]=(s.charAt(i)==s.charAt(j))&&t[i+1][j-1];

                }
            }
        }
        int []dp=new int[n];
        for(int i=0;i<n;i++)
        {
            if(t[0][i]==true)
            {
                dp[i]=0;
            }
            else{
                dp[i]=Integer.MAX_VALUE;
                for(int k=0;k<i;k++)
                {
                    if(t[k+1][i]==true&&1+dp[k]<dp[i])
                    {
                        dp[i]=1+dp[k];
                    }
                }
            }


            
        }
        return dp[n-1];
        
    }
}
