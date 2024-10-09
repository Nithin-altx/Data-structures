class Solution {
    public int minAddToMakeValid(String s) {
     int ob=0,cb=0;
     //Tc=O(N)
     //Sc=O(1)
     for(int i=0;i<s.length();i++)
     {
        if(s.charAt(i)=='(')
        {
            ob++;
        }
        else if(ob!=0)
        {
            ob--;
        }
        else if(s.charAt(i)==')')
        {
            cb++;
        }
     }
     return cb+ob;
      
}
}
