class Solution {
//Tc=O(N)
//sc=O(LogN)
      static int ans=0;
   static void preorder(Node root,int sum)
    {
       
        if(root==null)
        {
          
            return;
        }
        sum=(sum*10)+root.data;
        if(root.left==null&&root.right==null)
        {
            ans+=sum;
            return;
        }
        preorder(root.left,sum);
        preorder(root.right,sum);
    }
    public static int treePathsSum(Node root) {
        // add code here.
        ans=0;
        preorder(root,0);
        
    return ans;
        
    }
}
