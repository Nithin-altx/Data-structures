class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> st=new HashSet<>();
        for(int i=0;i<allowed.length();i++)
        {
            st.add(allowed.charAt(i));
        }
        int flag=0;
        int count=0;
        for(int i=0;i<words.length;i++)
        {
            String s=words[i];
            for(int j=0;j<s.length();j++)
            {
                if(st.contains(s.charAt(j)))
                {
                    flag=1;
                }
                else
                {
                    flag=0;
                    break;
                }
            }
            if(flag==1)
            count++;
        }
        return count;
    }
}
