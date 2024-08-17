class Solution {
public:
    long long maxPoints(vector<vector<int>>& points) {
        int m=points.size();
        int n=points[0].size();
        vector<long long>pre(n);
        for(int col=0;col<n;col++)
        {
            pre[col]=points[0][col];
        }
        for(int row=1;row<m;row++)
        {
            vector<long long>curr(n);
            for(int col=0;col<n;col++)
            {
                for(int k=0;k<n;k++)
                {
                    curr[col]=max(curr[col],pre[k]+points[row][col]-abs(col-k));
                }
            }
            pre=curr;
        }
        return *max_element(pre.begin(),pre.end());
        
    }
};
