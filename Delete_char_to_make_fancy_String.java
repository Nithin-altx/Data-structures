class Solution {
    //Tc=O(n)
    //sc=O(n)
    public String makeFancyString(String s) {
        int count=1;
        char prev=s.charAt(0);
       StringBuilder res = new StringBuilder();
       res.append(s.charAt(0));
        for(int i=1;i<s.length();i++)
        {
            if(s.charAt(i)==prev)
            {
                count++;
            }
            else
            {
                prev=s.charAt(i);
                count=1;   
            }
              if(count<3)
            {
                res.append(s.charAt(i));
            }

          
        }
       return res.toString();
        
    }
}
