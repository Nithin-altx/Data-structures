//BruteForce
class Solution {
    public int[] minOperations(String boxes) {
        int res[]=new int[boxes.length()];
        for(int i=0;i<boxes.length();i++)
        {
            int sum=0;
            for(int j=0;j<boxes.length();j++)
            {
                if(boxes.charAt(j)=='1')
                {
                    sum+=Math.abs(j-i);
                }
            }
            res[i]=sum;
        }
        return res;
    }
}
//Optimal
class Solution {
    public int[] minOperations(String boxes) {
        int res[]=new int[boxes.length()];
        int cumval=0;
        int cumsum=0;
        for(int i=0;i<boxes.length();i++)
        {
            res[i]=cumsum;
            cumval+=boxes.charAt(i)=='1'?1:0;
            cumsum+= cumval;
        }
        cumval=0;
        cumsum=0;
        for(int i=boxes.length()-1;i>=0;i--)
        {
            res[i]+=cumsum;
             cumval+=boxes.charAt(i)=='1'?1:0;
            cumsum+= cumval;
        }
        return res;
    }
}
