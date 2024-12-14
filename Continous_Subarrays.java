class Solution {
//Using map
    public long continuousSubarrays(int[] nums) {
        //Tc=O(n*log(3))
        //sc=O(3)
        int n=nums.length;
        int i=0;
        int j=0;
        TreeMap<Integer,Integer> mp=new TreeMap<>();
        long count=0;
        while(j<n)
        {
            mp.put(nums[j],mp.getOrDefault(nums[j],0)+1);
//Every time finding the diff between max and min element
            while(Math.abs(mp.lastKey()-mp.firstKey())>2)
            {
                mp.put(nums[i],mp.get(nums[i])-1);
                if(mp.get(nums[i])==0)
                {
                    mp.remove(nums[i]);
                }
                i++;
            }
            count+=j-i+1;
            j++;
        }
        return count;
    }
}
//Using heap
class Solution {
    public long continuousSubarrays(int[] nums) {
        //Tc=O(NLogN)
        //Sc=O(N)
        int n=nums.length;
        int i=0,j=0;
        PriorityQueue<int[]> min=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        PriorityQueue<int[]> max=new PriorityQueue<>((a,b)->Integer.compare(b[0],a[0]));
        long count=0;
        while(j<n)
        {
            min.offer(new int[]{nums[j],j});
            max.offer(new int[]{nums[j],j});
            while(Math.abs(max.peek()[0]-min.peek()[0])>2)
            {
                i++;
                while(!max.isEmpty()&&max.peek()[1]<i)
                {
                    max.poll();
                }
                 while(!min.isEmpty()&&min.peek()[1]<i)
                {
                    min.poll();
                }
            }
            count+=j-i+1;
            j++;
        }
        return count;
    }
}
