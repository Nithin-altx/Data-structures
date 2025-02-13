class Solution {
//Tc=O(NLogN)
//Sc=O(N)
    public int minOperations(int[] nums, int k) {
        int n=nums.length;
        int minop=0;
       
                PriorityQueue<Long> pq = new PriorityQueue<Long>(
            Arrays.stream(nums)
                .mapToLong(i -> (long) i)
                .boxed()
                .collect(Collectors.toList())
        );
        while(pq.size()>=2)
        {
            // if(pq.peek()>=k)
            // return minop;
            long a=pq.poll();
            long b=pq.poll();
            if(a>=k&&b>=k)
            continue;
            long result=(a*2)+b;
             minop++;
            pq.offer(result);     
        }
        return minop;
    }
}
