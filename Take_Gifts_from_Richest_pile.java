class Solution {
    public long pickGifts(int[] gifts, int k) {
        //Tc=O(NlogN)
        //Sc=O(N)
         PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
         for(int x:gifts)
         {
            pq.offer(x);
         }
         while(!pq.isEmpty()&&k>0)
         {
            int el=pq.poll();
            int res=(int)(el/Math.sqrt(el));
            pq.offer(res);
            k--;
         }
         long sum=0;
         while(!pq.isEmpty())
         {
            int e=pq.poll();
            sum+=e;
         }
         return sum;

    }
}
