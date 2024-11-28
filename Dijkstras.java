class Solution {
    // Function to find the shortest distance of all the vertices
    // from the source vertex src.
    ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        // Write your code here
        PriorityQueue<int[]>pq=new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        int n=adj.size();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            res.add(Integer.MAX_VALUE);
        }
        res.set(src,0);
        pq.offer(new int[]{0,src});
        while(!pq.isEmpty())
        {
            int curr[]=pq.poll();
            int wt=curr[0];
            int node=curr[1];
            for(iPair temp:adj.get(node))
            {
                int adjnode=temp.first;
                int weight=temp.second;
                if(wt+weight<res.get(adjnode))
                {
                    res.set(adjnode,wt+weight);
                    pq.offer(new int[]{wt+weight,adjnode});
                }
            }
        }
        return res;
       
    }
}
