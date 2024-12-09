class Solution {
    //Tc=O(N+Q)
    //Sc=O(N)
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean []res=new boolean[queries.length];
        boolean isspecial[]=new boolean[nums.length-1];
        int []prefix=new int[nums.length];
        for(int i=0;i<nums.length-1;i++)
        {
            isspecial[i]=(nums[i]%2==0&&nums[i+1]%2!=0||
            nums[i]%2!=0&&nums[i+1]%2==0);
            prefix[i+1]=prefix[i]+(isspecial[i]?1:0);
        }
        for(int i=0;i<queries.length;i++)
        {
            int a=queries[i][0];
            int b=queries[i][1];
            if(a==b)
            {
                res[i]=true;
            }
            else{
                int validpair=prefix[b]-prefix[a];
                res[i]=(validpair==(b-a));
            }
        }
        return res;
    }
}
