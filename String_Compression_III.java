class Solution {
    //Tc=o(n)
    //Sc=O(1)
    public String compressedString(String word) {
        String comp="";
        char prev=word.charAt(0);
        int count=1;
        for(int i=1;i<word.length();i++)
        {
            if(word.charAt(i)==prev)
            {
                count++;
            }
            else{
                comp+=String.valueOf(count);
                comp+=String.valueOf(prev);
                prev=word.charAt(i);
                count=1;
            }
            if(count==9&&i!=word.length()-1)
            {
                comp+=String.valueOf(count);
                comp+=String.valueOf(prev);
                prev=word.charAt(i+1);
                i=i+1;
                count=1;
            }
            else{
                prev=word.charAt(i);
            }
        }
        comp+=String.valueOf(count);
        comp+=String.valueOf(prev);
        return comp;
    }
}
