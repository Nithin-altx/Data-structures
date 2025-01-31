class Solution {
    int m,n;
//optimal Approach
//Tc=Sc=O(M*N)
int dir[][]={{0,1},{1,0},{0,-1},{-1,0}};
    public int dfs(int i, int j, int[][] grid,int id) {
    if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) 
        return 0;

     grid[i][j]=id;
     int count=1;
     for(int d[]:dir)
     {
        int i_=i+d[0];
        int j_=j+d[1];
        count+=dfs(i_,j_,grid,id);
     }   
    return count;
}

    public int largestIsland(int[][] grid) {
         m=grid.length;
         n=grid[0].length;
        int count=0;
        Map<Integer,Integer> mp=new HashMap<>();
        int id=2;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                {
                   int size=dfs(i,j,grid,id);
                 //count=Math.max(count,size);
                   mp.put(id,size);
                   id++;
                }
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==0)
                {
                    Set<Integer> st=new HashSet<>();
                    for(int d[]:dir )
                    {
                        int i_=i+d[0];
                        int j_=j+d[1];
                        if(i_>=0&&i_<m&&j_>=0&&j_<n&&grid[i_][j_]!=0)
                        {
                            st.add(grid[i_][j_]);
                        }
                    }
                      int maxarea=1;
                    for(int ids:st)
                    {
                        maxarea+=mp.get(ids);
                    }
                    count=Math.max(count,maxarea);
                }
                
            }
        } 
        return count==0?m*n:count;


    }
}
//Brute Force Approach
class Solution {
    int m,n;
//Brute Force
//Tc=O(m*n)^2
//sc=O(m*n)
    public int dfs(int i, int j, int[][] grid, boolean[][] vis, int count) {
    int m = grid.length;
    int n = grid[0].length;

    // Correct boundary conditions
    if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0 || vis[i][j]) 
        return 0;

    vis[i][j] = true;
    count = 1;  // Count the current cell

    // Recursive calls in all 4 directions
    count += dfs(i + 1, j, grid, vis, count);
    count += dfs(i - 1, j, grid, vis, count);
    count += dfs(i, j + 1, grid, vis, count);
    count += dfs(i, j - 1, grid, vis, count);

    return count;
}

    public int largestIsland(int[][] grid) {
         m=grid.length;
         n=grid[0].length;
        int count=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                boolean vis[][]=new boolean[m][n];
                if(grid[i][j]==0)
                {
                    grid[i][j]=1;
                   count=Math.max(dfs(i,j,grid,vis,0),count);
                   grid[i][j]=0;
                }
                else{
                    count=Math.max(dfs(i,j,grid,vis,0),count);
                }
            }
        }
        
        return count;


    }
}
