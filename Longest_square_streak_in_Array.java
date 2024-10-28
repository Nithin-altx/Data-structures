class Solution {
//Tc=O(n)
    public int longestSquareStreak(int[] nums) {  
        HashSet<Integer> st=new HashSet<>();
        for(int x:nums)
        {
            st.add(x);
        }
        int maxscore=0;
        for(int i=0;i<nums.length;i++)
        {
        long currnum=nums[i];
            int streak=0;
//O(5)
            while(st.contains((int)currnum))
            {
                streak++;
                if(currnum*currnum>1e5){
                    break;
                }
                currnum=currnum*currnum;
            }
            maxscore=Math.max(maxscore,streak);
        }
        return maxscore<2?-1:maxscore;
        
     
    }
}
