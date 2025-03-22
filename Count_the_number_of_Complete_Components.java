//Approach 1 Using dfs
class Solution {
    void dfs(int i,int ve[],boolean vis[], Map<Integer,List< Integer > > adj)
    {
        vis[i]=true;
        ve[0]++;
        ve[1]+=adj.get(i).size();
        for(int ngbr:adj.get(i))
        {
            if(!vis[ngbr])
            {
                dfs(ngbr,ve,vis,adj);
            }
        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        Map<Integer,List< Integer > > adj=new HashMap<>();
        int result=0;
          for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for(int x[]:edges)
        {
            int u=x[0];
            int v=x[1];
            adj.putIfAbsent(u,new ArrayList<>());
            adj.get(u).add(v);
            adj.putIfAbsent(v,new ArrayList<>());
            adj.get(v).add(u);
        }
        boolean vis[]=new boolean[n];
        for(int i=0;i<n;i++)
        {
            if(vis[i]==true)
            continue;
            int ve[]=new int[2];
            dfs(i,ve,vis,adj);
            if((ve[0]*(ve[0]-1))==ve[1])
            {
                result++;
            }
        }
        return result;
        
    }
}
//Approach 2 Using Bfs
class Solution {
    void bfs(int i,int ve[],boolean vis[], Map<Integer,List< Integer > > adj)
    {
        Queue<Integer> pq=new LinkedList<>();
        pq.offer(i);
        vis[i]=true;
        while(!pq.isEmpty())
        {
            int node=pq.poll();
            ve[0]++;
            ve[1]+=adj.get(node).size();
            for(int ngbr:adj.get(node))
            {
                if(!vis[ngbr])
                {
                    pq.offer(ngbr);
                     vis[ngbr]=true;
                }
            }
        }
        
    }
    public int countCompleteComponents(int n, int[][] edges) {
        Map<Integer,List< Integer > > adj=new HashMap<>();
        int result=0;
          for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for(int x[]:edges)
        {
            int u=x[0];
            int v=x[1];
            adj.putIfAbsent(u,new ArrayList<>());
            adj.get(u).add(v);
            adj.putIfAbsent(v,new ArrayList<>());
            adj.get(v).add(u);
        }
        boolean vis[]=new boolean[n];
        for(int i=0;i<n;i++)
        {
            if(vis[i]==true)
            continue;
            int ve[]=new int[2];
            bfs(i,ve,vis,adj);
            if((ve[0]*(ve[0]-1))==ve[1])
            {
                result++;
            }
        }
        return result;
        
    }
}
