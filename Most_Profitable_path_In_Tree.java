class Solution {
    //Tc=O(N)
    //SC=O(N)
    Map<Integer,List<Integer>> adj=new HashMap<>();
    Map<Integer,Integer> bob=new HashMap<>();
    int aliceinc;
    boolean Dfsbob(int curr,int time,boolean[]visited)
    {
        visited[curr]=true;
        bob.put(curr,time);
        if(curr==0)
        {
            return true;
        }
        for(int ngbr:adj.getOrDefault(curr,new ArrayList<>()))
        {
            if(!visited[ngbr])
            {
                if(Dfsbob(ngbr,time+1,visited)){
                    return true;
                }
            }
        }
        bob.remove(curr);
        return false;
        
    }
    void DfsAlice(int curr,int time,int inc,boolean visited[],int amt[])
    {
        visited[curr]=true;
        if(!bob.containsKey(curr)||time<bob.get(curr))
        {
            inc+=amt[curr];
        }
        else if(time==bob.get(curr))
        {
            inc+=(amt[curr]/2);
        }

        if(adj.getOrDefault(curr,new ArrayList<>()).size()==1&&curr!=0)
        {
            aliceinc=Math.max(aliceinc,inc);
        }
        for(int nbgr:adj.getOrDefault(curr,new ArrayList<>()))
        {
            if(!visited[nbgr])
            {
                DfsAlice(nbgr,time+1,inc,visited,amt);
            }
        }
    }

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n=amount.length;
        aliceinc=Integer.MIN_VALUE;
        for(int edg[]:edges)
        {
            int u=edg[0];
            int v=edg[1];
           adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
         adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        int time=0;
        boolean visited[]=new boolean[n];
        Dfsbob(bob,time,visited);
        int income=0;
        Arrays.fill(visited,false);
        DfsAlice(0,0,income,visited,amount); 
        return aliceinc;
    }
}
//Using BFS
class Solution {
    //Tc=O(N)
    //SC=O(N)
    Map<Integer,List<Integer>> adj=new HashMap<>();
    Map<Integer,Integer> Bob=new HashMap<>();
    int aliceinc;
    boolean Dfsbob(int curr,int time,boolean[]visited)
    {
        visited[curr]=true;
        Bob.put(curr,time);
        if(curr==0)
        {
            return true;
        }
        for(int ngbr:adj.getOrDefault(curr,new ArrayList<>()))
        {
            if(!visited[ngbr])
            {
                if(Dfsbob(ngbr,time+1,visited)){
                    return true;
                }
            }
        }
        Bob.remove(curr);
        return false;
        
    }
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n=amount.length;
        aliceinc=Integer.MIN_VALUE;
        for(int edg[]:edges)
        {
            int u=edg[0];
            int v=edg[1];
           adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
         adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        int time=0;
        boolean visited[]=new boolean[n];
        Dfsbob(bob,time,visited);
        int income=0;
        Arrays.fill(visited,false);
       Queue<int[]> pq=new LinkedList<>();
       pq.add(new int[]{0,0,0});
       while(!pq.isEmpty())
       {
        int front[]=pq.poll();
        int curr=front[0];
        int t=front[1];
        int inc=front[2];
        if(!Bob.containsKey(curr)||Bob.get(curr)>t)
        {
            inc+=amount[curr];
        }
        else if(t==Bob.get(curr))
        {
            inc+=(amount[curr]/2);
        }
        if(adj.getOrDefault(curr,new ArrayList<>()).size()==1&&curr!=0)
        {
              aliceinc=Math.max(  aliceinc,inc);
        }
        for(int nbgr:adj.getOrDefault(curr,new ArrayList<>()))
        {
            if(!visited[nbgr])
            {
                pq.add(new int[]{nbgr,t+1,inc});
            }
        }
        visited[curr]=true;
       }

        return aliceinc;
    }
}
