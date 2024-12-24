class Solution {
    //Tc=O(V+E)
    //sc=O(N+M)
    int findd(Map<Integer,List<Integer>> mp1)
    {
        List<Integer> farnode=Bfs(mp1,0);
        farnode=Bfs(mp1,farnode.get(0));
        return farnode.get(1);
        
    }
    List<Integer> Bfs(Map<Integer,List<Integer>> mp1,int sourcenode)
    {
        Queue<Integer> pq=new LinkedList<>();
        pq.offer(sourcenode);
        Map<Integer,Boolean> mp=new HashMap<>();
        int maxdistance=0,farnode=sourcenode;
        mp.put(sourcenode,true);
        while(!pq.isEmpty())
        {
            int n=pq.size();
            while(n>0)
            {
                int currnode=pq.poll();
                farnode=currnode;
                for(int ngbr:mp1.getOrDefault(currnode,new ArrayList<>()))
                {
                    if(!mp.getOrDefault(ngbr,false))
                    {
                         pq.add(ngbr);
                         mp.put(ngbr,true);
                    }
                }
                n--;
            }
            if(!pq.isEmpty())
            {
                maxdistance++;
            }
        }
        return Arrays.asList(farnode,maxdistance);
    }
     Map<Integer,List<Integer>> buildadj(int[][] edges1)
     {
        Map<Integer,List<Integer>> mp1=new HashMap<>();
          for(int []edge:edges1)
        {
            int x=edge[0];
            int y=edge[1];
           List<Integer> ls1=mp1.getOrDefault(x,new ArrayList<>());
           ls1.add(y);
           mp1.put(x,ls1);
            List<Integer> ls2=mp1.getOrDefault(y,new ArrayList<>());
            ls2.add(x);
           mp1.put(y,ls2);
        }
        return mp1;

     }
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        Map<Integer,List<Integer>> mp1=buildadj(edges1);
         Map<Integer,List<Integer>> mp2=buildadj(edges2);
        int d1=findd(mp1);
        int d2=findd(mp2);
        int combine=(d1+1)/2+(d2+1)/2+1;
        return Math.max(Math.max(d1,d2),combine);
    }
}
