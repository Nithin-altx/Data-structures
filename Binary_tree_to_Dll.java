class Solution
{
    //Function to convert binary tree to doubly linked list and return it.
    void inorder(Node root, List<Integer> ls)
    {
        if(root==null)
        return;
        inorder(root.left,ls);
        ls.add(root.data);
        inorder(root.right,ls);
    }
    Node bToDLL(Node root)
    {
        List<Integer> ls=new ArrayList<>();
        inorder(root,ls);
        Node head=new Node(ls.get(0));
        Node prev=head;
        for(int i=1;i<ls.size();i++)
        {
            Node n=new Node(ls.get(i));
            prev.right=n;
            n.left=prev;
            prev=n;
        }
        return head;
	
    }
}
