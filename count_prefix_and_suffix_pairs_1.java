class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int count=0;
        int n=words.length;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                String s1=words[i];
                String s2=words[j];
                if(s1.length()<=s2.length())
                {
                    if(s2.substring(0,s1.length()).equals(s1)&&s2.substring(s2.length()-s1.length(),s2.length()).equals(s1))
                    {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
