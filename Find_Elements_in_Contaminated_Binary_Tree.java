class FindElements {
    //Tc=O(NLogn)
    //SC=O(N)
    PriorityQueue<TreeNode> pq;
    Set<Integer> st;
    public FindElements(TreeNode root) {
        pq= new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        st=new HashSet<>();
        root.val=0;
        pq.offer(root);
        while(!pq.isEmpty())
        {
            int N=pq.size();
            while(N-->0)
            {
                TreeNode node=pq.poll();
                 int x=node.val;
                 st.add(x);
                if(node.left!=null)
                { 
                    node.left.val=2*x+1;
                    st.add(node.left.val);
                    pq.offer(node.left);
                }
                if(node.right!=null)
                {
                    node.right.val=2*x+2;
                    st.add(node.right.val);
                    pq.offer(node.right);
                }
            }
        }
        
    }
    
    public boolean find(int target) {
        for(int it:st)
        {
            if(it==target)
            return true;
        } 
        return false;

        
    }
}
//Using BFS
class FindElements {
    Set<Integer> st;
void dfs(TreeNode root)
{
    if(root==null)
    return;
    st.add(root.val);
    if(root.left!=null)
    {
        root.left.val=2*root.val+1;
        st.add(root.left.val);
        dfs(root.left);
    }
    if(root.right!=null)
    {
        root.right.val=2*root.val+2;
        st.add(root.right.val);
        dfs(root.right);
    }
}
    public FindElements(TreeNode root) {
        st=new HashSet<>();
        root.val=0;
        dfs(root);
    }
    
    public boolean find(int target) {
        if(st.contains(target))
        return true;
        else
        return false;
        
    }
}
