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
//prefix sum
class Solution {
    public int maxScore(String s) {
        //Tc=O(N)
        //SC=O(N)
        int leftscore[]=new int[s.length()];
        int rightscore[]=new int[s.length()];
        int ls=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='0')
            {
                ls++;
            }
            leftscore[i]=ls;
        }
        int rs=0;
        for(int j=s.length()-1;j>0;j--)
        {
            if(s.charAt(j)=='1')
            {
                rs++;
            }
            rightscore[j]=rs;
        }
        int maxscore=Integer.MIN_VALUE;
        for(int k=0;k<s.length()-1;k++)
        {
            maxscore=Math.max(leftscore[k]+rightscore[k+1],maxscore);
        }
        return maxscore;
    }
}
