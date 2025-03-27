class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n=nums.size();
        Map<Integer,Integer> mp=new HashMap<>();
        Map<Integer,Integer> mp1=new HashMap<>();
        for(int x:nums)
        {
            mp1.put(x,mp1.getOrDefault(x,0)+1);
        }
        for(int i=0;i<n;i++)
        {
            int num=nums.get(i);
            int n1=i+1;
            int n2=n-i-1;
            mp.put(num,mp.getOrDefault(num,0)+1);
            mp1.put(num,mp1.getOrDefault(num,0)-1);
            if(mp.get(num)>n1/2&&mp1.get(num)>n2/2)
            {
                return i;
            }
        }
        return -1;
        
    }
}
