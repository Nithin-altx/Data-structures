class Solution {
    boolean check(int a[],int b[])
    {
        for(int i=0;i<26;i++)
        {
            if(a[i]!=b[i])
            return false;
        }
        return true;
    }
    //Sliding window Approach Tc=O(M+n) Sc=O(26)
    public boolean checkInclusion(String s1, String s2) {
        int a[]=new int[26];
        int n=s1.length();
        int m=s2.length();
        if(n>m)
        return false;
        for(int i=0;i<n;i++)
        {
            a[s1.charAt(i)-'a']++;
        }
       int b[]=new int [26];
       int i=0,j=0;
       while(j<m){
        b[s2.charAt(j)-'a']++;
        int len=j-i+1;
       if(len>n)
        {
             b[s2.charAt(i)-'a']--;
            i++;                                    
        } 
        len=j-i+1;
        if(len==n)
        {
           if(check(a,b))
           return true;
        } 
        j++;
       }
       return false;

        
      
        
    }
}
//using sorting
class Solution {
    //Tc=O(Nlogn *n)
    public boolean checkInclusion(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        if(n>m)
      return false;
      char sr[]=s1.toCharArray();
      Arrays.sort(sr)  ;
      for(int i=0;i<=m-n;i++)
      {
        String substr=s2.substring(i,i+n);
        char sr2[]=substr.toCharArray();
        Arrays.sort(sr2);
        if(Arrays.equals(sr,sr2))
        {
            return true;
        }
      }
      return false;
    }
}
