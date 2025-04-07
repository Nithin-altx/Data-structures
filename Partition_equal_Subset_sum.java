class Solution {
   Boolean memo[][];
    boolean solve(int i,int[] nums,int total)
    {
        if(total==0){
        return true;
        }
        if(i>=nums.length)
        {
            return false;
        }
        if(memo[i][total]!=null)
        {
            return memo[i][total];
        }
        boolean take=false;;
        if(total>=nums[i]){
        take= solve(i+1,nums,total-nums[i]);
        }
       boolean nottake= solve(i+1,nums,total);
       return memo[i][total]= take||nottake;
    }
    public boolean canPartition(int[] nums) {
       int total = 0;
for (int num : nums) total += num;
if(total%2!=0)
return false;
memo=new Boolean[201][20001];
for(int i=0;i<201;i++)
{
    Arrays.fill(memo[i],null);
}
return solve(0,nums,total/2);        
    }
}
