class Solution {
    public boolean isCircularSentence(String s) {
        int n=s.length();
        boolean b=false;
        //Tc=O(N)
        //Sc=O(1)
        if(s.charAt(0)!=s.charAt(n-1))
        {
            return false;
        }
        if(s.charAt(0)==s.charAt(n-1))
        {
            b=true;
        }
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)==' ')
            {
                char prev=s.charAt(i-1);
                char next=s.charAt(i+1);
                if(prev==next)
                {
                    b=true;
                }
                else{
                    b=false;
                    break;
                }
            }
        }
        return b;
        
    }
}
