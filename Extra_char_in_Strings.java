
class Solution {
    //Tc=(2^n*n*n) in recursion
    //Tc=(n^3) in memorization
    int t[]=new int[51];
    int solve(int i,String s,Set<String> st,int n)
    {
        if(i>=n)
        return t[i]=0;
        if(t[i]!=-1)
        return t[i];
        int result=1+solve(i+1,s,st,n);
        for(int j=i;j<n;j++)
        {
            String curr=s.substring(i,j+1);
            if(st.contains(curr))
            {
                result=Math.min(result,solve(j+1,s,st,n));
            }
        }
        return t[i]= result;
    }
    public int minExtraChar(String s, String[] dic) {
        int n=s.length();
        Set<String> st=new HashSet<>();
        for(int i=0;i<dic.length;i++)
        {
            String k=dic[i];
            st.add(k);
        }
        for(int i=0;i<51;i++)
        {
           t[i]=-1;
        }
        return solve(0,s,st,n);
        
    }
}
//Dp_Approach tc=O(n^3)
class Solution {
    public int minExtraChar(String s, String[] dic) {
        int dp[]=new int[51];
         Set<String> st=new HashSet<>();
        for(int i=0;i<dic.length;i++)
        {
            String k=dic[i];
            st.add(k);
        }
        int n=s.length();
        for(int i=n-1;i>=0;i--)
        {
            dp[i]=1+dp[i+1];
            for(int j=i;j<n;j++)
            {
                String curr=s.substring(i,j+1);
                if(st.contains(curr))
                {
                    dp[i]=Math.min(dp[i],dp[j+1]);
                }
            }
        }
        return dp[0];
    }
}
