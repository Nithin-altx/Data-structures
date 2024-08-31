class Solution {
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
    if(ispalindrome(s,i,j))
    {
        return  0;
    }
    int cuts=Integer.MAX_VALUE;
    for(int k=i;k<=j-1;k++)
    {
        int temp=1+solve(s,i,k)+solve(s,k+1,j);
        cuts=Math.min(cuts,temp);
    }
    return cuts;
}
    public int minCut(String s) {
        int n=s.length();
        return solve(s,0,n-1);
        
    }
}
