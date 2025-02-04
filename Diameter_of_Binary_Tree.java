//Tc=O(N)
//Sc=O(H)
class Solution {
    int maxd=0;
    int solve(Node root)
    {
        if(root==null)
        return 0;
        int left=0;
        if(root.left!=null)
        {
            left=1+solve(root.left);
        }
        int right=0;
        if(root.right!=null)
        {
            right=1+solve(root.right);
        }
        maxd=Math.max(maxd,left+right);
        return Math.max(left,right);
    }
    int diameter(Node root) {
        // Your code here
        int d=solve(root);
        return maxd;
        
    }
}
