class Solution {
//Tc=O(N)
//SC=O(N)
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n=nums.length;
        int vec[]=nums.clone();
        Arrays.sort(vec);
        int groupnum=0;
        Map<Integer,Integer> numtogrp=new HashMap<>();
        Map<Integer,LinkedList<Integer>> grptolist=new HashMap<>();
        numtogrp.put(vec[0],groupnum);
        grptolist.putIfAbsent(groupnum,new LinkedList<>());
        grptolist.get(groupnum).add(vec[0]);
        for(int i=1;i<n;i++)
        {
            if(Math.abs(vec[i]-vec[i-1])>limit)
            {
                groupnum++;
            }
            numtogrp.put(vec[i],groupnum);
            grptolist.putIfAbsent(groupnum,new LinkedList<>());
             grptolist.get(groupnum).add(vec[i]);

        }
        for(int i=0;i<n;i++)
        {
            int num=nums[i];
            int grp=numtogrp.get(num);
            nums[i]=grptolist.get(grp).pollFirst();
        }
        return nums;
    }
}
