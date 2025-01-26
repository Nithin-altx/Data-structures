class Solution {
    int Bfs(boolean visited[],Map<Integer,List<Integer>> adj,int start)
    {
        Queue<int[]> pq=new LinkedList<>();
        pq.add(new int[]{start,0});
        int maxDis=0;
        while(!pq.isEmpty())
        {
            int curr[]=pq.poll();
            int currnode=curr[0];
            int dis=curr[1];
            for(int nibr:adj.getOrDefault(currnode,new ArrayList<>())){
                if(visited[nibr]==false)
                {
                    visited[nibr]=true;
                    pq.add(new int[]{nibr,dis+1});
                    maxDis=Math.max(maxDis,dis+1);
                }
            }
        }
        return maxDis;

    }
    public int maximumInvitations(int[] favorite) {
        int n=favorite.length;
        Map<Integer,List<Integer>> adj=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            int u=i;
            int v=favorite[i];
            adj.computeIfAbsent(v,k->new ArrayList<>()).add(u);
        }
        int longestCycleEmpcount=0;
        int happyCycleEmpcount=0;
        boolean visited[]=new boolean[n];
        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            {
                Map<Integer,Integer > mp=new HashMap<>();
                int currnode=i;
                int currnodecount=0;
                while(!visited[currnode])
                {
                    visited[currnode]=true;
                    mp.put(currnode,currnodecount);
                    int nextnode=favorite[currnode];
                    currnodecount++;
                    if(mp.containsKey(nextnode))
                    {
                        int cyclelength=currnodecount-mp.get(nextnode);
                        longestCycleEmpcount=Math.max(cyclelength,longestCycleEmpcount);
                        if(cyclelength==2)
                        {
                            boolean visitednode[]=new boolean[n];
                            visitednode[currnode]=true;
                            visitednode[nextnode]=true;
                            happyCycleEmpcount+=2+Bfs(visitednode,adj,currnode)+Bfs(visitednode,adj,nextnode);

                        }
                        break;

                    }
                    currnode=nextnode;
                }
            }
        }
        return Math.max(longestCycleEmpcount, happyCycleEmpcount);
        
    }
}
