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
