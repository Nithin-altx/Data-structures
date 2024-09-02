class Solution {
  public void solve(String s,int i,boolean t[][],List<String> l1,List<List<String>> l2)
  {
    if(i==s.length())
    {
        l2.add(new ArrayList<>(l1));
        return;
    }
    for(int j=i;j<s.length();j++)
    {
        if(t[i][j])
        {
            l1.add(s.substring(i,j+1));
            solve(s,j+1,t,l1,l2);
            l1.remove(l1.size()-1);
        }
    }
    
  
  }
    public List<List<String>> partition(String s) {
        int n=s.length();
        boolean t[][]=new boolean[17][17];
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
                {
                    t[i][j]=true;
                }
                else if(i+1==j)
                {
                    t[i][j]=(s.charAt(i)==s.charAt(j));
                }
                else {
                    t[i][j]=(s.charAt(i)==s.charAt(j))&&t[i+1][j-1];
                }
             
                 
            }
            
        }

        List<String> l1=new ArrayList<>();
        List<List<String>> l2=new ArrayList<>();
        solve(s,0,t,l1,l2);
        return l2;

      

    }
}
