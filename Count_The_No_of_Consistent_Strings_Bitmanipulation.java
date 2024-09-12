class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int mask=0;
        for(int i=0;i<allowed.length();i++)
        {
            mask=mask|(1<<allowed.charAt(i)-'a');
        }
        int count=0;
       
        for(int i=0;i<words.length;i++)
        {
             int flag=0;
            String s=words[i];
            for(int j=0;j<s.length();j++)
            {
                if(((mask>>s.charAt(j)-'a')&1)==0)
                {
                    flag=1;
                    break;
                }
            }
            if(flag==0)
            {
                count++;
            }
        }
        return count;
        
    }
}
