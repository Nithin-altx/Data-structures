//BruteForce
class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        StringBuilder res=new StringBuilder(s);
       for(int []x:shifts)
       {
        int start=x[0];
        int end=x[1];
        int dir=x[2];
        for(int i=start;i<=end;i++)
        {
            if(dir==1)
            {
                res.setCharAt(i,(char)('a'+(res.charAt(i)-'a'+1)%26));
            }
            else
            res.setCharAt(i,(char)('a'+(res.charAt(i)-'a'-1+26)%26));
            }
        }
       return res.toString();
    }
}
//Optimal
class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n=s.length();
        int diffarray[]=new int[n];
       for(int x[]:shifts)
       {
        int start=x[0];
        int end=x[1];
        int dir=x[2];
        if(dir==0){
        diffarray[start]=diffarray[start]-1;
        if(end+1<n)
        diffarray[end+1]=diffarray[end+1]+1;
       }
       else{
        diffarray[start]=diffarray[start]+1;
        if(end+1<n)
        diffarray[end+1]=diffarray[end+1]-1;
       }
    }
    StringBuilder res=new StringBuilder(s);
    for(int i=1;i<n;i++)
    {
        diffarray[i]+=diffarray[i-1];
    }
    for(int i=0;i<n;i++)
    {
        int freq=diffarray[i]%26;
        if(freq<0)
        {
            freq+=26;
        }
        char ch=(char)(((s.charAt(i)-'a'+freq)%26)+'a');
        res.setCharAt(i,ch);
        
    }
    return res.toString();
}
}
