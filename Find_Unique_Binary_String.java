class Solution {
    //Tc=O(2^N)
    //SC=O(N)
    void solve(Set<String> st,int n , StringBuilder s)
    {
        if(s.length()==n)
        {
            st.add(s.toString());
            return;
        }
        for(char ch='0';ch<='1';ch++)
        {
            s.append(ch);
            solve(st,n,s);
            s.deleteCharAt(s.length()-1);
        }

    }
    public String findDifferentBinaryString(String[] nums) {
         Set<String> st=new HashSet<>();
         int n=nums[0].length();
         StringBuilder s=new StringBuilder();
         solve(st,n,s);
         Set<String> st2=new HashSet<>();
         for(String x:nums)
         {
            st2.add(x);
         }
         for(String it:st)
         {
            if(!st2.contains(it))
            {
                return it;
            }
         }
         return "";
         
         
    }
}
