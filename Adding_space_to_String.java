class Solution {
    //Tc=o(N)
    public String addSpaces(String s, int[] spaces) {
        StringBuilder res=new StringBuilder();
        int prev=0;
        for(int i=0;i<spaces.length;i++)
        {
            int idx=spaces[i];
            for(int j=prev;j<idx;j++)
            {
                res.append(s.charAt(j));
            }
            res.append(" ");
            prev=idx;
        }
        for(int i=spaces[spaces.length-1];i<s.length();i++)
        {
            res.append(s.charAt(i));
        }
        return res.toString();
    }
}
