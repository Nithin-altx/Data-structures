class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        //Tc=O(N)
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
