class Solution {
public:
    vector<int> arrayRankTransform(vector<int>& arr) {
        vector<int>temp=arr;
        map<int,int>mp;
        sort(temp.begin(),temp.end());
        int rank=1;
        for(int i=0;i<temp.size();i++)
        {
            if(i>0&&temp[i]>temp[i-1])
            {
                rank++;
            }
            mp[temp[i]]=rank;
        }
        for(int i=0;i<arr.size();i++)
        {
            arr[i]=mp[arr[i]];
        }
        return arr;
    }
};
