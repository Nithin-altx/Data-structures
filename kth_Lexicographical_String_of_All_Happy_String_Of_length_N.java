class Solution {
//Tc=O(2^N)
//Sc=O(N)
    void solve(int n, List<String> ls,StringBuilder res)
    {
        if(res.length()==n)
        {
            ls.add(res.toString());
            return;
        }
        for(char ch='a';ch<='c';ch++)
        {
            if(res.isEmpty()||res.charAt(res.length()-1)!=ch)
            {
                res.append(ch);
                solve(n,ls,res);
                res.deleteCharAt(res.length()-1);
            }
        }

    }
    public String getHappyString(int n, int k) {
        List<String> ls=new ArrayList<>();
        StringBuilder res=new StringBuilder();
        solve(n,ls,res);
        if(k>ls.size())
        return "";
        return ls.get(k-1);
        
    }
}
//Space OPtimization
class Solution {
    //Tc=O(2^N)
    //Sc=O(N)//Stack Space
    void solve(int n, int count[],StringBuilder res,StringBuilder s,int k)
    {
        if(res.length()==n)
        {
            count[0]++;
            if(count[0]==k)
            {
                s.append(res.toString());    
            }
            return;
        }
        for(char ch='a';ch<='c';ch++)
        {
            if(res.isEmpty()||res.charAt(res.length()-1)!=ch)
            {
                res.append(ch);
                solve(n,count,res,s,k);
                res.deleteCharAt(res.length()-1);
            }
        }

    }
    public String getHappyString(int n, int k) {
        StringBuilder res=new StringBuilder();
        StringBuilder s=new StringBuilder();
        int count[]=new int[1];
        solve(n,count,res,s,k);
      return s.toString();
        
    }
}
