class Solution {
    Tc=O(N^2)
   Input: s = "aacecaaa"
      Output: "aaacecaaa"
    public String shortestPalindrome(String s) {
        StringBuilder rev=new StringBuilder(s);
        rev.reverse();
        int n=s.length();
        for(int i=0;i<s.length();i++)
        {
            if(s.substring(0,n-i).equals(rev.substring(i)))
            {
                return new StringBuilder(rev.substring(0,i)).append(s).toString();
            }
        }
        return "";
    }
}
class Solution {
    //Tc=O(N)
    //Sc=O(N)
    //watch kmp
    public void computelps(String s,int []lps)
    {
        int m=s.length();
        int len=0;
        int i=1;
        while(i<m)
        {
            if(s.charAt(i)==s.charAt(len))
            {
                len++;
                lps[i]=len;
                i++;
            }
            else if(len!=0)
            {
                len=lps[len-1];
            
            }
            else{
                lps[i]=0;
                i++;
            }
        }
    }
    public String shortestPalindrome(String s) {
         StringBuilder rev=new StringBuilder(s);
           rev.reverse().toString();
       String temp=s+"-"+rev;
       int lps[]=new int[temp.length()];
       computelps(temp,lps);
       int longestlps=lps[temp.length()-1];
       StringBuilder culprit= new StringBuilder(rev.substring(0,s.length()-longestlps));
       return culprit.append(s).toString();
    
    }
}
