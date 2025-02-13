class Solution {
    void solve(Node root,List<Integer> ls)
    {
        if(root==null)
        return ;
        solve(root.left,ls);
        ls.add(root.data);
        solve(root.right,ls);
    }
    boolean findTarget(Node root, int target) {
        // Write your code here
        List<Integer> ls=new ArrayList<>();
        solve(root,ls);
        if(ls.size()==1)
        return false;
        int i=0,j=ls.size()-1;
        while(i<=j&&j>=i)
        {
            if(ls.get(i)+ls.get(j)==target)
            {
                return true;
            }
            else if(ls.get(i)+ls.get(j)>target)
            {
                j--;
            }
            else{
                i++;
            }
        }
        return false;
    }
}
