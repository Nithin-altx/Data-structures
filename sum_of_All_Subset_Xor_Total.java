class Solution {
    void solve(int i,int[]nums, List<Integer> ls,List<List<Integer>> res)
    {
        if(i>=nums.length)
        {
            res.add(new ArrayList<>(ls));
            return;
        }
        ls.add(nums[i]);
        solve(i+1,nums,ls,res);
        ls.remove(ls.size()-1);
        solve(i+1,nums,ls,res);
        
    }
    public int subsetXORSum(int[] nums) {
         List<Integer> ls=new ArrayList<>();
         List<List<Integer>> res=new ArrayList<>();
        solve(0,nums,ls,res);
        int sum=0;
        for(List<Integer> r:res)
        {
            int xor=0;
            for(int num:r)
            {
                xor=xor^num;
            }
            sum+=xor;
        }
        return sum;
        
    }
}
