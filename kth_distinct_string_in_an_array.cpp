class Solution {
Input: arr = ["d","b","c","b","c","a"], k = 2
Output: "a"
public:
    string kthDistinct(vector<string>& arr, int k) {
     map<string,int>mp;
     for(auto &v:arr)
     {
        mp[v]++;//mapping the string to unique d->1,b->2,c->2,a->1
     }
     for(auto &it:arr)
     {
        if(mp[it]==1)//iterating through the array and finding the kth unique string
        k--;
        if(k==0)
        return it;returning the kth unique string
     }
     return "";
        
    }
};
