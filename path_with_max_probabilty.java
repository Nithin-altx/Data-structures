class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double prob[]=new double[n];
        prob[start_node]=1;
        //Applying Bellmanford Algorithm
        for(int i=0;i<n;i++)
        {
            int j=0;
            for(int edge[]:edges)
            {
                int u=edge[0];
                int v=edge[1];
                double sp=succProb[j];
                if(prob[u]*sp>prob[v])
                {
                    prob[v]=prob[u]*sp;
                }
                 if(prob[v]*sp>prob[u])
                {
                    prob[u]=prob[v]*sp;
                }
                j++;
            }
          
        }
        return prob[end_node];
        
    }
}
