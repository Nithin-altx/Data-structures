class Solution {
    // Function to find length of shortest common supersequence of two strings.
    static int solve(String s1, String s2,int i,int j,int t[][])
    {
      
        if(i==0||j==0)
        {
            return t[i][j]=i+j;
        }
          if(t[i][j]!=-1)
        return t[i][j];
        if(s1.charAt(i-1)==s2.charAt(j-1))
        {
            return t[i][j]= 1+solve(s1,s2,i-1,j-1,t);
        }
        else{
            return t[i][j]= 1+Math.min(solve(s1,s2,i-1,j,t),solve(s1,s2,i,j-1,t));
        }
    }
    public  static int shortestCommonSupersequence(String s1, String s2) {
        // Your code here
        int m=s1.length(),n=s2.length();
      int   t[][]=new int[m+1][n+1];
        for(int i=0;i<m+1;i++)
        {
            Arrays.fill(t[i],-1);
        }
        return solve(s1,s2,m,n,t);
    }
}
//Bottom up

class Solution {
    // Function to find length of shortest common supersequence of two strings.
   
    public  static int shortestCommonSupersequence(String s1, String s2) {
        // Your code here
     
        int m=s1.length(),n=s2.length();
         int   t[][]=new int[m+1][n+1];
        for(int i=0;i<m+1;i++)
        {
            for(int j=0;j<n+1;j++)
            {
                if(i==0||j==0)
                {
                    t[i][j]=j+i;
                }
                else if(s1.charAt(i-1)==s2.charAt(j-1))
                {
                    t[i][j]=1+t[i-1][j-1];
                }
                else{
                    t[i][j]=1+Math.min(t[i-1][j],t[i][j-1]);
                }
            }
        }
        return t[m][n];
    }
}
//Tc=O(m*n)
//Sc=O(m*n)
