class Solution {
    //Tc=O(N*N!)
    //Sc=O(N)
    int n;
    List<List<Integer>> res=new ArrayList<>();
    boolean notpresent(int ele,List<Integer> ls)
    {
        for(int j=0;j<ls.size();j++)
        {
            if(ls.get(j)==ele)
            return false;
        }
        return true;
    }
    void solve(int[]nums,List<Integer> ls)
    {
        if(ls.size()==n)
        {
            res.add(new ArrayList<>(ls));
            return;
        }
        for(int i=0;i<n;i++)
        {
            if(notpresent(nums[i],ls))
            {
                ls.add(nums[i]);
                solve(nums,ls);
                ls.remove(ls.size()-1);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        n=nums.length;
        List<Integer> ls=new ArrayList<>();
        solve(nums,ls);
        return res;

        
    }
}
