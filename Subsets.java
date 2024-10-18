class Solution {
//Tc=O(2^N)
//Sc=O(2^N*N)
    List<List<Integer>>res=new ArrayList<>();
    void solve(int idx,List<Integer> temp,int []nums)
    {
        if(idx>=nums.length)
        {
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[idx]);
        solve(idx+1,temp,nums);
        temp.remove(temp.size()-1);
        solve(idx+1,temp,nums);
    }
  
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp=new ArrayList<>();
        solve(0,temp,nums);
        return res;
  
     
        
    }
}
