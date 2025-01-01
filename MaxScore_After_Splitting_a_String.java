class Solution {
//Tc=O(N^2),SC=O(N)
    public int maxScore(String s) {
       int n=s.length();
       int maxscore=Integer.MIN_VALUE;

       for(int x=0;x<n;x++)
       {
        String left=s.substring(0,x+1);
        String right=s.substring(x+1,n);
        int leftscore=0;
        int rightscore=0;
        for(int i=0;i<left.length();i++)
        {
            if(left.charAt(i)=='0')
            {
                leftscore++;
            }
        }
        for(int j=0;j<right.length();j++)
        {
            if(right.charAt(j)=='1')
            {
                rightscore++;
            }
        }
        if(left.length()==0||right.length()==0)
        {
            continue;

        }
        else{

             maxscore=Math.max(maxscore,leftscore+rightscore);

        }
       
       }
       return maxscore;
    }
}
