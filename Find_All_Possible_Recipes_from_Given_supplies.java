//Brute Force
class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int count=recipes.length;
        Set<String> st=new HashSet<>();
        for(String x:supplies)
        {
            st.add(x);
        }
        List<String> res=new ArrayList<>();
        boolean cooked[]=new boolean[count];
        int n=count;
        while(count-->0)
        {
            for(int i=0;i<n;i++)
            {
                if(cooked[i]==true)
                continue;

                boolean wemake=true;
                for(int j=0;j<ingredients.get(i).size();j++)
                {
                    if(!st.contains(ingredients.get(i).get(j)))
                    {
                        wemake=false;
                    }
                }
                if(wemake==true)
                {
                    res.add(recipes[i]);
                    st.add(recipes[i]);
                    cooked[i]=true;
                }
            }
            
        }
        return res;
        
    }
}
// Approach-2 - Using Topological Sorting
// T.C : (n + m + S)
// S.C : O(n+S)
class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int n=recipes.length;
        Set<String> st=new HashSet<>();
        Map<String,List<Integer>> adj=new HashMap<>();
        int indegree[]=new int[n];
        for(String x:supplies)
        {
            st.add(x);
        }
        List<String> res=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            for(String ing:ingredients.get(i))
            {
                if(!st.contains(ing))
                {
                    adj.putIfAbsent(ing,new ArrayList<>());
                    adj.get(ing).add(i);
                    indegree[i]++;
                }
            }
        }
        Queue<Integer> pq=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            if(indegree[i]==0)
            {
                pq.add(i);
            }
        }
        while(!pq.isEmpty())
        {
            int i=pq.poll();
            String r=recipes[i];
            res.add(r);
            if(adj.containsKey(r))
            {
                for(int idx:adj.get(r))
                {
                    indegree[idx]--;
                    if(indegree[idx]==0)
                    {
                        pq.add(idx);
                    }
                }
            }
        }
        return res;
        
    }
}
