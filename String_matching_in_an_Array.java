class Solution {
    public List<String> stringMatching(String[] words) {
        //Kmp 
        List<String> res=new ArrayList<>();
        for(int i=0;i<words.length;i++)
        {
            String s=words[i];
            for(int j=0;j<words.length;j++)
            {
                if(i==j)
                continue;
                if(words[j].contains(s))
                {
                    res.add(s);
                    break;
                }
            }
        }
        return res;
    }
}
