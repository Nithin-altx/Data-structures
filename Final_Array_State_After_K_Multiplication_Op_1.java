class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        //Tc=O(NlogN)
        //Sc=O(N)
       PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]); // Compare keys (primary comparison)
            } else {
                return Integer.compare(a[1], b[1]); // Compare indices (secondary comparison)
            }
        });
        for(int i=0;i<nums.length;i++)
        {
            pq.offer(new int[]{nums[i],i});
        }
        int res[]=new int[nums.length];
        while(!pq.isEmpty()&&k>0)
        {
            int e[]=pq.poll();
            int ele=e[0];
            int idx=e[1];
            ele=ele*multiplier;
            pq.offer(new int[]{ele,idx});
            k--;
        }
        while(!pq.isEmpty())
        {
            int r[]=pq.poll();
            int num=r[0];
            int id=r[1];
            res[id]=num;
        }
        return res;
    }
}
