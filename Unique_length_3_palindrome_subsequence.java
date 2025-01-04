class Solution {
    public int countPalindromicSubsequence(String s) {
        int n=s.length();
        int[]first=new int[26];
        int[]last=new int[26];
        Arrays.fill(first,-1);
        for(int i=0;i<n;i++)
        {
            int curr=s.charAt(i)-'a';
            if(first[curr]==-1)
            {
                first[curr]=i;
            }
            last[curr]=i;
        }
        int result=0;
        for(int i=0;i<26;i++)
        {
            if(first[i]==-1)
            continue;
            int leftidx=first[i];
            int rightidx=last[i];
                   Set<Character> st1=new HashSet<>();
                for(int k=leftidx+1;k<=rightidx-1;k++)
                {
                    st1.add(s.charAt(k));

                }
                result+=st1.size();
        }
        return result;
    }
}
//Approach 2
class Solution {
    public int countPalindromicSubsequence(String s) {
        int n=s.length();
        Set<Character> st=new HashSet<>();
        for(int i=0;i<n;i++)
        {
            st.add(s.charAt(i));
        }
        int result=0;
        for(char ch:st)
        {
            int leftidx=-1;
            int rightidx=-1;
            for(int i=0;i<n;i++)
            {
                if(s.charAt(i)==ch&&leftidx==-1)
                {
                    leftidx=i;
                }
                if(s.charAt(i)==ch)
                {
                    rightidx=i;
                }
            }
                   Set<Character> st1=new HashSet<>();
                for(int k=leftidx+1;k<=rightidx-1;k++)
                {
                    st1.add(s.charAt(k));

                }
                result+=st1.size();
        }
        return result;
    }
}
