class Solution {
    public long minimumSteps(String s) {
        int n=s.length();
        long swaps=0,zero=0;
        for(int i=n-1;i>=0;i--)
        {
            if(s.charAt(i)=='1')
            {
                swaps+=zero;
            }
            else{
                zero++;
            }
        }
      
        return swaps;
        
    }
}
