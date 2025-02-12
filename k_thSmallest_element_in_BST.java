class Solution {
   
    // Return the Kth smallest element in the given BST
    void solve(Node root, List<Integer> ls)
    {
        if(root==null)
        return;
        solve(root.left,ls);
        ls.add(root.data);
        solve(root.right,ls);
    }
    public int kthSmallest(Node root, int k) {
        // Write your code here
        List<Integer> ls=new ArrayList<>();
        solve(root,ls);
        if(k>ls.size())
        return -1;
        return ls.get(k-1);
        
       
    }
}
