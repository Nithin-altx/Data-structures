class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        int dist[]=new int[V];
        for(int i=0;i<V;i++)
        {
            dist[i]=Integer.MAX_VALUE;
        }
        dist[S]=0;
        PriorityQueue<int[]>pq=new PriorityQueue<>(Comparator.comparing(a->a[0]));
        pq.offer(new int[]{S,0});
        while(!pq.isEmpty())
        {
            int ele[]=pq.poll();
            int node=ele[0];
            int distance=ele[1];
            for(ArrayList<Integer> ngbr:adj.get(node))
            {
                int ndist=distance+ngbr.get(1);
                if(ndist<dist[ngbr.get(0)])
                {
                    dist[ngbr.get(0)]=ndist;
                    pq.offer(new int[]{ngbr.get(0),ndist});
                    
                }
            }
        }
        return dist;
    }
}
