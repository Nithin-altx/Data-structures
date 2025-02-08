class Solution {
    boolean isLeaf(Node node)
    {
        return node.left==null&&node.right==null;
    }
    void addleftboundary(Node node,ArrayList<Integer> res)
    {
        Node curr=node.left;
        while(curr!=null)
        {
            if(!isLeaf(curr)){
            res.add(curr.data);
            }
            if(curr.left!=null)
            curr=curr.left;
            
            else{
                curr=curr.right;
            }
        }
        
    }
    void addleafnodes(Node node, ArrayList<Integer> res)
    {
        if(isLeaf(node))
        {
            res.add(node.data);
            return;
        }
       if(node.left!=null)
       addleafnodes(node.left,res);
       if(node.right!=null)
        addleafnodes(node.right,res);
    }
    void addrightboundary(Node node, ArrayList<Integer> res)
    {
        Node curr=node.right;
        List<Integer> temp=new ArrayList<>();
        while(curr!=null)
        {
            if(!isLeaf(curr))
            temp.add(curr.data);
            if(curr.right!=null)
            curr=curr.right;
            else{
                curr=curr.left;
            }
        }
        for(int i=temp.size()-1;i>=0;i--)
        {
            res.add(temp.get(i));
        }
    }
    
    ArrayList<Integer> boundaryTraversal(Node node) {
        // code here
        ArrayList<Integer> res=new ArrayList<>();
        if(node==null)
        return res;
        if(!isLeaf(node))
        res.add(node.data);
        addleftboundary(node,res);
        addleafnodes(node,res);
        addrightboundary(node,res);
        return res;
        
    }
}
