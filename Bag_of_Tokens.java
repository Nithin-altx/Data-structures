class Solution {
    // Input: tokens = [100,200,300,400], power = 200
    // Output: 2
    //Tc=O(NLogN)
    public int bagOfTokensScore(int[] tokens, int power) {
        int n=tokens.length;
        int maxscore=0;
        int i=0,j=n-1;
        int score=0;
        Arrays.sort(tokens);
        while(i<=j)
        {
            if(power>=tokens[i])
            {
                score++;
                power-=tokens[i];
                i++;
                maxscore=Math.max(maxscore,score);
            }
            else if(score>=1)
            {
                power+=tokens[j];
                score--;
                j--;
            }
            else{
                return maxscore;
            }
        }
           return maxscore;
        
    }
}
