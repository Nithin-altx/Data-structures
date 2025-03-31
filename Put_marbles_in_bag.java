class Solution {
    public long putMarbles(int[] weights, int k) {
        int n=weights.length;
        int m=n-1;
        long pairsum[]=new long[m];
        for(int i=0;i<m;i++)
        {
            pairsum[i]=weights[i]+weights[i+1];

        }
        Arrays.sort(pairsum);
        long maxval=0,minval=0;
        for(int i=0;i<k-1;i++)
        {
            minval+=pairsum[i];
            maxval+=pairsum[m-i-1];
        }
        return maxval-minval;
        
    }
}
