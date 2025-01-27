//Approach 1
class Solution {
//Tc=O(V+E)
//sc=O(V)
 boolean Dfs(int start, int end, Map<Integer, List<Integer>> adj,  boolean[] visited) {
    if (start == end) {
        return true;
    }
    visited[start]=true;
    boolean isreach=false;
    for (int nibr : adj.getOrDefault(start, new ArrayList<>())) {
        if (!visited[nibr]) { // Skip already visited nodes
            isreach=isreach||Dfs(nibr, end, adj, visited);
            }
        }

    return isreach; // No path found
}

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Map<Integer,List<Integer>> adj=new HashMap<>();
        for(int x[]:prerequisites)
        {
            int u=x[0];
            int v=x[1];
            adj.computeIfAbsent(u,k->new ArrayList<>()).add(v);
        }
         List<Boolean> res=new ArrayList<>();
        for(int []q: queries)
        {
            int x=q[0];
            int y=q[1];
            boolean visited[]=new boolean[numCourses];
            if(Dfs(x,y,adj,visited))
            {
                res.add(true);
            }
            else{
                res.add(false);
            }
        }
        return res;
        
    }
}
	//Approach2
	class Solution {
     boolean Dfs(int start, int end, Map<Integer, List<Integer>> adj,  boolean[] visited) {
    if (start == end) {
        return true;
    }
    visited[start]=true;
    boolean isreach=false;
    for (int nibr : adj.getOrDefault(start, new ArrayList<>())) {
        if (!visited[nibr]) { // Skip already visited nodes
            isreach=isreach||Dfs(nibr, end, adj, visited);
            }
        }

    return isreach; // No path found
}
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
         Map<Integer,List<Integer>> adj=new HashMap<>();
        for(int x[]:prerequisites)
        {
            int u=x[0];
            int v=x[1];
            adj.computeIfAbsent(u,k->new ArrayList<>()).add(v);
        }
         List<Boolean> res=new ArrayList<>();
         boolean [][]pre=new boolean[numCourses][numCourses];
         for(int i=0;i<numCourses;i++)
         {
            for(int j=0;j<numCourses;j++)
            {
                  boolean visited[]=new boolean[numCourses];
                if(i==j)
                continue;
                if(Dfs(i,j,adj,visited))
                {
                    pre[i][j]=true;
                }
            }
         }
         for(int []q:queries)
         {
            int x=q[0];
            int y=q[1];
            res.add(pre[x][y]);
         }
         return res;

        
    }
}
