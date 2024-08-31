class Solution {
    int t[][]=new int[2001][2001];
    boolean ispalindrome(String s,int i,int j)
{
    while(i<=j)
    {
        if(s.charAt(i)!=s.charAt(j))
        {
            return false;
        }
        i++;
        j--;
    }
    return true;
}
public int solve(String s,int i,int j)
{
    if(i>=j)
    return 0;
    if(t[i][j]!=-1)
    return t[i][j];
    if(ispalindrome(s,i,j))
    {
        return t[i][j]= 0;
    }
    int cuts=Integer.MAX_VALUE;
    for(int k=i;k<=j-1;k++)
    {
        int temp=1+solve(s,i,k)+solve(s,k+1,j);
        cuts=Math.min(cuts,temp);
    }
    return t[i][j]=cuts;
}
    public int minCut(String s) {
        int n=s.length();
        for (int i = 0; i < 2001; i++) {
    Arrays.fill(t[i], -1);
}
        return solve(s,0,n-1);
        
    }
}
