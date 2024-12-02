class Solution {
    public int isPrefixOfWord(String s, String searchWord) {
        //Tc=o(M*N)
        //SC=O(N)
        String words[]=s.split(" ");
        for(int i=0;i<words.length;i++)
        {
            String comp=words[i];
            int count=0;
            for(int j=0;j<comp.length()&&j<searchWord.length();j++)
            {
                if(comp.charAt(j)==searchWord.charAt(j))
                {
                    count++;
                }
            }
            if(count==searchWord.length())
            {
                return i+1;
            }
        }
        return -1;
    }
}
