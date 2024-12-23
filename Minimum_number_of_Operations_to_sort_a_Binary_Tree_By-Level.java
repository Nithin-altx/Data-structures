/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minimumOperations(TreeNode root) {
        //Tc=O(N*Nlogn)
        //sc=O(N)
        int count=0;
        Map<Integer,Integer> mp=new HashMap<>();
        Queue<TreeNode> pq=new LinkedList<>();
        pq.add(root);
        while(!pq.isEmpty())
        {
            int n=pq.size();
            List<Integer> ls=new ArrayList<>();
            while(n>0)
            {
                TreeNode node=pq.poll();
                 ls.add(node.val);
                if(node.left!=null)
                {
                    pq.add(node.left);
                }
                 if(node.right!=null)
                {
                    pq.add(node.right);
                }
              n--;  
            }
            List<Integer> sls= new ArrayList<>(ls);
            int swaps=0;
            Collections.sort(sls);
            for(int i=0;i<ls.size();i++)
            {
                mp.put(ls.get(i),i);
            }
            for(int j=0;j<sls.size();j++)
            {
                if(sls.get(j).equals(ls.get(j)))
                {
                    continue;
                }
                   int temp = ls.get(j);   
                     int idx = mp.get(sls.get(j));                   
                mp.put(ls.get(j), idx);         
                mp.put(ls.get(idx), j);   
                  ls.set(j, ls.get(idx));          
                  ls.set(idx, temp);   
                    swaps++;
            }
            count+=swaps;
        
        }
        return count;

    }
}
