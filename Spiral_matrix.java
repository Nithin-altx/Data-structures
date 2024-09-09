class Solution {
    //Tc=O(m*n)
    //SC=O(m*n)

    public List<Integer> spiralOrder(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int top=0,down=m-1;
        int left=0,right=n-1;
        int dir=0;
        List<Integer> l=new ArrayList<>();
        while(top<=down&&left<=right)
        {
            if(dir==0)//Left->right
            {
                for(int i=left;i<=right;i++)
                {
                    l.add(matrix[top][i]);
                }
                top++;

            }
            if(dir==1)//Top->down
            {
                for(int i=top;i<=down;i++)
                {
                    l.add(matrix[i][right]);
                }
                right--;
                
            }
            if(dir==2)//Right->left
            {
                for(int i=right;i>=left;i--)
                {
                    l.add(matrix[down][i]);
                }
                down--;
                
            }
            if(dir==3)//Down->top
            {
                for(int i=down;i>=top;i--)
                {
                    l.add(matrix[i][left]);
                }
                left++;
                
            }
            dir=(dir+1)%4;
        }
        return l;
        
    }
}
