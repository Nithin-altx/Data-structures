class Solution {
    public int getLucky(String s, int k) {
        String num="";
        for(int i=0;i<s.length();i++)
        {
            int char_int=s.charAt(i)-'a'+1;
            num+=String.valueOf(char_int);
        }
        while(k>0)
        {
            int sum=0;
            for(int i=0;i<num.length();i++)
            {
                sum+=num.charAt(i)-'0';
            }
            num=String.valueOf(sum);
            k--;
        }
        return Integer.valueOf(num);
        
        
    }
}
