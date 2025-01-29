class Solution {
    boolean dfs(Map<Integer,List<Integer>> adj,int u,int v,boolean[]vis)
    {
        vis[u]=true;
        if(u==v)
        return true;
        for(int ngbr:adj.getOrDefault(u,new ArrayList<>()))
        {
            if(vis[ngbr])
            continue;
            if(dfs(adj,ngbr,v,vis))
            return true;
        }
        return false;

    }
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        Map<Integer,List<Integer>> adj=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            int u=edges[i][0];
            int v=edges[i][1];
            boolean vis[]=new boolean[n+1];
            if(adj.containsKey(u)&&adj.containsKey(v)&&dfs(adj,u,v,vis))
            {
                return edges[i];
            }
            adj.computeIfAbsent(u,k->new ArrayList<>()).add(v);
            adj.computeIfAbsent(v,k->new ArrayList<>()).add(u);
        }
        return new int[]{};
        
    }
}
