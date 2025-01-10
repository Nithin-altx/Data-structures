class Solution {
    boolean issubset(int[]freq1,int[]freq2)
    {
        for(int i=0;i<26;i++)
        {
            if(freq1[i]<freq2[i])
            {
                return false;
            }
        }
        return true;
    }
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> res=new ArrayList<>();
        int []freq2=new int[26];
        for(String w: words2)
        {
            int temp[]=new int[26];
            for(char ch:w.toCharArray())
            {
                temp[ch-'a']++;
                freq2[ch-'a']=Math.max(freq2[ch-'a'],temp[ch-'a']);
            }   
           
        }
        for(String x:words1)
        {
            int freq1[]=new int[26];
            for(char ch:x.toCharArray())
            {
                freq1[ch-'a']++;
            }
            if(issubset(freq1,freq2))
            {
                res.add(x);
            }
        }
        return res;

    }
}
