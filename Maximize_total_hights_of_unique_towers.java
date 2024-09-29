class Solution {
    public long maximumTotalSum(int[] nums) {
        Arrays.sort(nums);
        int min=Integer.MAX_VALUE;
        int n=nums.length;
        int sum=0;
        //Greedy
        //Tc=O(N)
        for(int i=n-1;i>=0;i--)
        {
            if(min>nums[i]){
                sum+=nums[i];
            min=nums[i];
            }
            else
            {
                int val=min-1;
                if(val<=0){
                return -1;
                }
                else{
                      sum+=val;
                     min=val;
                }
               
            }
        }
        return sum;
      
        
    }
}
