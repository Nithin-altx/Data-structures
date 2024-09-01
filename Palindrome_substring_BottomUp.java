class Solution {
    boolean t[][]=new boolean[1001][1001];
    public int countSubstrings(String s) {
        int n=s.length();
        int count=0;
        for(int i=0;i<n;i++)
        {
            Arrays.fill(t[i],false);
        }
        for(int l=1;l<=n;l++)
        {
            for(int i=0;i+l-1<n;i++)
            {
                int j=i+l-1;
                if(i==j)
                t[i][j]=true;
                else if(i+1==j)
                {
                    t[i][j]=(s.charAt(i)==s.charAt(j));
                }
                else
                {
                    t[i][j]=(s.charAt(i)==s.charAt(j))&&t[i+1][j-1];
                }
                if(t[i][j]==true)
                {
                    count++;
                }

            }
        }
       
        return count;
        
    }
}
