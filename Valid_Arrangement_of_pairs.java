//Using stack
//Tc=O(V+E)
//Approach-1 (DFS Using Stack) - Hierholzer's Algorithm to find Euler Path
class Solution {
    public int[][] validArrangement(int[][] pairs) {
        Stack<Integer> st=new Stack<>();
        Map<Integer,List<Integer> >adj=new HashMap<>();
         Map<Integer,Integer> indegree=new HashMap<>();
        Map<Integer,Integer> outdegree=new HashMap<>();
        for(int ele[]:pairs)
        {
            int x=ele[0];
            int y=ele[1];
            adj.computeIfAbsent(x,k->new ArrayList<>()).add(y);
            indegree.put(y,indegree.getOrDefault(y,0)+1);
            outdegree.put(x,outdegree.getOrDefault(x,0)+1); 
        }
        int start=pairs[0][0];
        for(int node:adj.keySet())
        {
            if(outdegree.getOrDefault(node,0)-indegree.getOrDefault(node,0)==1)
            {
                start=node;
                break;
            }
        }
        List<Integer> path=new ArrayList<>();
        st.push(start);
        while(!st.isEmpty())
        {
            int curr=st.peek();
            if(adj.containsKey(curr)&&!adj.get(curr).isEmpty())
            {
                int nibr=adj.get(curr).remove(adj.get(curr).size()-1);
                st.push(nibr);
            }
            else{
                path.add(curr);
                st.pop();    
            }
        }
        Collections.reverse(path);
        int [][]result=new int[path.size()-1][2];
        for(int i=0;i<path.size()-1;i++)
        {
            result[i][0]=path.get(i);
            result[i][1]=path.get(i+1);
        }
        return result;
    

    }
}
//using dfs
class Solution {
    Map<Integer,List<Integer> >adj=new HashMap<>();
    List<Integer> path=new ArrayList<>();
    void dfs(int node)
    {
        while(adj.containsKey(node)&&!adj.get(node).isEmpty())
        {
            int nextnode=adj.get(node).remove(adj.get(node).size()-1);
            dfs(nextnode);
        }
        path.add(node);
    }
    public int[][] validArrangement(int[][] pairs) {
        Map<Integer,Integer> indegree=new HashMap<>();
        Map<Integer,Integer> outdegree=new HashMap<>();
        for(int []ele:pairs)
        {
            int x=ele[0];
            int y=ele[1];
            adj.computeIfAbsent(x,k->new ArrayList<>()).add(y);
            indegree.put(y,indegree.getOrDefault(y,0)+1);
            outdegree.put(x,outdegree.getOrDefault(x,0)+1);
        }
        int start=pairs[0][0];
        for(int node:adj.keySet())
        {
            if(outdegree.getOrDefault(node,0)-indegree.getOrDefault(node,0)==1)
            {
                start=node;
                break;
            }
        }
        dfs(start);
        Collections.reverse(path);
        int [][]res=new int[path.size()-1][2];
        for(int i=0;i<path.size()-1;i++)
        {
            res[i][0]=path.get(i);
            res[i][1]=path.get(i+1);
        }
        return res;

    }
}

