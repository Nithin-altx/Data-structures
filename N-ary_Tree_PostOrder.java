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
    public void traverse(Node root,List<Integer> list)
    {
        if(root==null)
        return ;
        for(Node x:root.children)
        {
            traverse(x,list);
        }
        list.add(root.val);
    }
    public List<Integer> postorder(Node root) {
        List<Integer> list=new ArrayList<>();
        traverse(root,list);
        return list;

        
    }
}
