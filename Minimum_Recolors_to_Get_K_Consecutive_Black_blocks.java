//Brute Force
//Tc=O(N^2)
//sc=O(N)
class Solution {
    public int minimumRecolors(String blocks, int k) {
        int maxbs=Integer.MAX_VALUE;
        int n=blocks.length();
        int count=0;
        for(int i=0;i<n;i++)
        {
            String s="";
            for(int j=i;j<n;j++)
            {
                if(blocks.charAt(j)=='W')
                {
                    count++;
                    s+="B";
                }
                else{
                    s+=blocks.charAt(j);
                }
                if(s.length()==k)
                {
                    maxbs=Math.min(maxbs,count);
                    count=0;
                    break;
                }

            }

        }
        return maxbs;

        
    }
}
