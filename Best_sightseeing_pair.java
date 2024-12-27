class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        //Tc=O(N)
//using no space
        int n=values.length;
        int maxleft=values[0]+0;
        int maxscore=Integer.MIN_VALUE;
        for(int j=1;j<n;j++)
        {
            maxscore=Math.max(maxscore,maxleft+values[j]-j);
            maxleft=Math.max(maxleft,values[j]+j);

        }
        return maxscore;
    }
}
//Use space
class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int v=values.length;
        int maxleft[]=new int[v];
        maxleft[0]=values[0];
        for(int i=1;i<v;i++)
        {
            maxleft[i]=Math.max(values[i]+i,maxleft[i-1]);
        }
        int maxscore=Integer.MIN_VALUE;
        for(int j=1;j<v;j++)
        {
            maxscore=Math.max(maxscore,maxleft[j-1]+values[j]-j);
        }
        return maxscore;
    }
}
