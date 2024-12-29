class Solution {
    int m,k;
    int mod=1_000_000_007;
    long dp[][];
    //Tc=o(M*K)=Sc
    long solve(int i,int j,long [][]freq,String target)
    {
        if(i==m)
        return 1;
        if(j==k)
        return 0;
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        long nottake=solve(i,j+1,freq,target)%mod;
        long take=(freq[target.charAt(i)-'a'][j]*solve(i+1,j+1,freq,target))%mod;
        return dp[i][j]=(nottake+take)%mod;
    }
    public int numWays(String[] words, String target) {
         m=target.length();
         k=words[0].length();
        long [][]freq=new long[26][k];
        for(int col=0;col<k;col++)
        {
            for(String word:words)
            {
                char ch=word.charAt(col);
                freq[ch-'a'][col]++;
            }
        }
        dp=new long[1001][1001];
        for(int i=0;i<1001;i++)
        {
            Arrays.fill(dp[i],-1);
        }
       return (int)solve(0,0,freq,target);

    }
}
