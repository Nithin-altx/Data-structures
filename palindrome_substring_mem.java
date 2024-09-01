class Solution {
    int t[][]=new int[1001][1001];
    private int ispalindrome(String s,int i,int j)
    {
        if(i>j)
        return 1;
        if(t[i][j]!=-1)
        return t[i][j];
        if(s.charAt(i)==s.charAt(j))
        {
            return t[i][j]= ispalindrome(s,i+1,j-1);
        }
        return t[i][j]=0;

    }
    public int countSubstrings(String s) {
        int n=s.length();
        int count=0;
        for(int i=0;i<n;i++)
        {
            Arrays.fill(t[i],-1);
        }
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                if(ispalindrome(s,i,j)==1)
                {
                    count++;

                }
            }
        }
        return count;
        
    }
}
