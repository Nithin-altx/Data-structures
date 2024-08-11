class Solution {
public:
void dfs(vector<vector<int>>&matrix,int i,int j)
{
    if(i<0||i>=matrix.size()||j<0||j>=matrix[0].size()||matrix[i][j]==1)
    return;
    matrix[i][j]=1;
    dfs(matrix,i+1,j);
     dfs(matrix,i-1,j);
      dfs(matrix,i,j+1);
       dfs(matrix,i,j-1);

}
    int regionsBySlashes(vector<string>& grid) {
        int rows=grid.size();
        int col=grid[0].size();
        int regions=0;
        vector<vector<int>>matrix(rows*3,vector<int>(col*3,0));//grid matrix of size row*3&col*3
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(grid[i][j]=='/')//filling the matrix according to the backslash
                {
                    matrix[i*3][j*3+2]=1;
                    matrix[i*3+1][j*3+1]=1;
                    matrix[i*3+2][j*3]=1;
                }
                else if(grid[i][j]=='\\')//filling the matrix according to the forwardslash
                {
                    matrix[i*3][j*3]=1;
                    matrix[i*3+1][j*3+1]=1;
                    matrix[i*3+2][j*3+2]=1;
                }
            }
        }
        for(int i=0;i<matrix.size();i++)
        {
            for(int j=0;j<matrix[0].size();j++)
            {
                if(matrix[i][j]==0)
                {
                    dfs(matrix,i,j);//hitting dfs and checking the adjacent sides of the 0,i.e top,bottom,left,right.
                     regions++;
                }
            }
           
        }
        return regions;
        
    }
};
