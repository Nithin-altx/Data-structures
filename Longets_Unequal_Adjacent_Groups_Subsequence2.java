class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n=words.length;
        List<String> res=new ArrayList<>();
        int dp[]=new int[n];
        Arrays.fill(dp,1);
        int previdx[]=new int[n];
        Arrays.fill(previdx,-1);
       int lisidx = 0, lis = 1;
        if(n==1)
        return Arrays.asList(words[0]);
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(groups[i]!=groups[j])
                {
                    int hd=0;
                    String a=words[i];
                    String b=words[j];
                    if(a.length()!=b.length())
                    {
                        continue;
                    }
                    int k=0,l=0;
                    while(k<a.length()&&l<b.length())
                    {
                        if(a.charAt(k)!=b.charAt(l))
                        {
                            hd++;
                        }
                        k++;
                        l++;
                    }
                   if (hd == 1) {
                        if (dp[j] + 1 > dp[i]) {
                              dp[i] = dp[j] + 1;
                              previdx[i] = j; 
                        }
                   if (dp[i] > lis) {
                       lis = dp[i];
                       lisidx = i;
                    }
                }
            }
               
        }
    }
        while(lisidx!=-1)
        {
            res.add(words[lisidx]);
            lisidx=previdx[lisidx];
        }
        Collections.reverse(res);
        return res;

        
    }
}
