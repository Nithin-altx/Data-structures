class Solution {
    public int findTheLongestSubstring(String s) {
        Map<String,Integer> mp=new HashMap<>();
       int a[]=new int[5];
        String currstate="00000";
        mp.put(currstate,-1);
        int result=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='a')
            {
                a[0]=(a[0]^1);//(a[0]+1)%2
            }
            else if(s.charAt(i)=='e')
            {
                 a[1]=(a[1]^1);
            }
             else if(s.charAt(i)=='i')
            {
                 a[2]=(a[2]^1);
            }
              else if(s.charAt(i)=='o')
            {
                  a[3]=(a[3]^1);
            }
              else if(s.charAt(i)=='u')
            {
                a[4]=(a[4]^1);
            }
            currstate="";
            for(int j=0;j<5;j++)
            {
                currstate+=a[j];
            }
            if(mp.containsKey(currstate))
            {
                result=Math.max(result,i-mp.get(currstate));
            }
            else{
                mp.put(currstate,i);
            }
        }
        return result;
        
    }
}
//Approach Two with mask
class Solution {
    public int findTheLongestSubstring(String s) {
        Map<Integer,Integer> mp=new HashMap<>();
        int mask=0;
        mp.put(mask,-1);
        int result=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='a')
            {
                mask=mask^(1<<0);
            }
            else if(s.charAt(i)=='e')
            {
                  mask=mask^(1<<1);
            }
             else if(s.charAt(i)=='i')
            {
                mask=mask^(1<<2);
            }
              else if(s.charAt(i)=='o')
            {
                  mask=mask^(1<<3);
            }
              else if(s.charAt(i)=='u')
            {
                mask=mask^(1<<4);
            }
           
            if(mp.containsKey(mask))
            {
                result=Math.max(result,i-mp.get(mask));
            }
            else{
                mp.put(mask,i);
            }
        }
        return result;
        
    }
}
