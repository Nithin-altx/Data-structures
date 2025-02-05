class Solution {
    // Function to convert a binary tree into its mirror tree.
    void mirror(Node node) {
        // Your code here
        Queue<Node> pq=new LinkedList<>();
        pq.offer(node);
        while(!pq.isEmpty())
        {
            int N=pq.size();
            while(N-->0){
            Node node1=pq.poll();
            if(node1.left!=null&&node1.right!=null)
            {
                Node temp=node1.left;
                node1.left=node1.right;
                node1.right=temp;
                pq.offer(node1.left);
                pq.offer(node1.right);
            }
            else if(node1.left!=null&&node1.right==null)
            {
                node1.right=node1.left;
                node1.left=null;
                pq.offer(node1.right);
            }
            else if(node1.left==null&&node1.right!=null)
            {
                node1.left=node1.right;
                node1.right=null;
                pq.offer(node1.left);
            }
            }
        }
        
    }
}
//Using Recursion
class Solution {
    // Function to convert a binary tree into its mirror tree.
    void mirror(Node node) {
        // Your code here
        if(node.left==null&&node.right==null)
        return;
        
        if(node.left!=null&&node.right!=null)
        {
            Node temp=node.left;
            node.left=node.right;
            node.right=temp;
            mirror(node.left);
            mirror(node.right);
        }
        else if(node.left!=null&&node.right==null)
        {
            node.right=node.left;
            node.left=null;
            mirror(node.right);
        }
        else if(node.right!=null&&node.left==null)
        {
            node.left=node.right;
            node.right=null;
            mirror(node.left);
        }
    }
}
