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
