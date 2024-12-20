class Solution {
//Tc&sc=o(N)
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> pq=new LinkedList<>();
        pq.add(root);
        int level=0;
        while(!pq.isEmpty())
        {
            int n=pq.size();
            List<TreeNode> currln=new ArrayList<>();
            while(n>0)
            {
                TreeNode node=pq.poll();
                currln.add(node);
                if(node.left!=null&&node.right!=null){
                pq.add(node.left);
                pq.add(node.right);
                }
                n--;
            }
            if(level%2!=0)
            {
                int left=0,right=currln.size()-1;
                while(left<right)
                {
                    int temp=currln.get(left).val;
                    currln.get(left).val=currln.get(right).val;
                    currln.get(right).val=temp;
                    left++;
                    right--;
                }
            }
            level++;
        }
        return root;
    }
}
//Using DFS
class Solution {
    void solve(TreeNode l,TreeNode r,int level)
    {
     
        if(level%2!=0)
        {
            int temp=r.val;
            r.val=l.val;
            l.val=temp;
        }
        if(l.left==null&&l.right==null)
        {
            return;
        }
        solve(l.left,r.right,level+1);
        solve(l.right,r.left,level+1);
    }
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root.left==null&&root.right==null)
        {
            return root;
        }
        solve(root.left,root.right,1);
        return root;
    }
}
