class Solution {
public:
int m,n;
void dfs(vector<vector<int>>& grid,int i,int j,vector<vector<bool>>& vis)
{
    if(i<0||i>=m||j<0||j>=n||vis[i][j]==true||grid[i][j]==0){
    return;
    }
    vis[i][j]=true;
    dfs(grid,i+1,j,vis);
    dfs(grid,i-1,j,vis);
    dfs(grid,i,j+1,vis);
     dfs(grid,i,j-1,vis);
}
int numberofislands(vector<vector<int>>& grid)
{
    int islands=0;
    vector<vector<bool>>vis(m,vector<bool>(n,false));
    for(int i=0;i<m;i++)
    {
        for(int j=0;j<n;j++)
        {
            if(grid[i][j]==1&&!vis[i][j])
            {
                dfs(grid,i,j,vis);
                islands++;
            }
        }
    }
    return islands;
}
    int minDays(vector<vector<int>>& grid) {
        m=grid.size();
        n=grid[0].size();
        int islands=numberofislands(grid);
        if(islands>1||islands==0)
        return 0;
        else
        {//we have only one island
//check if we disconnect the island in one day
            for(int i=0;i<m;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(grid[i][j]==1)
                    {
                        grid[i][j]=0;//convert to water
                        islands=numberofislands(grid);
                           grid[i][j]=1;//make again land try another cell
                          if(islands>1||islands==0)
                         return 1;
                    }
                 
                    
                }
            }
        }
        return 2;
    }
};
