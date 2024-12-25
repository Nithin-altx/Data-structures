class Solution {
    public List<Integer> largestValues(TreeNode root) {
        //Tc=O(N)
        //Sc=O(N)
        List<Integer> res=new ArrayList<>();
        if(root==null)
        return res;
        Queue<TreeNode> pq=new LinkedList<>();
        pq.add(root);
        while(!pq.isEmpty())
        {
            int n=pq.size();
            int maxele=Integer.MIN_VALUE;
            while(n>0)
            {
                TreeNode node=pq.poll();
                maxele=Math.max(node.val,maxele);
                if(node.left!=null)
                {
                    pq.add(node.left);
                }
                if(node.right!=null)
                {
                    pq.add(node.right);
                }
                n--;
            }
            res.add(maxele);

        }
        return res;
    }
}
