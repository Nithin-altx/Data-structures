/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public void traversal(Node root,List<Integer>res)
    {
        if(root==null)
        return;
        res.add(root.val);
        for(Node node:root.children)
        {
            traversal(node,res);
            
        }
    }
    public List<Integer> preorder(Node root) {
        List<Integer> res=new ArrayList<>();
        traversal(root,res);
        return res;
     

        
    }
}
