class Solution {
public:
string binary(int n)
{
    string res="";
    while(n>0)
    {
        res+='0'+n%2;
        n/=2;
    }
    reverse(res.begin(),res.end());
    return res;

}
int decimal(string s)
{
    int res=0;
    for(int i=0;i<s.length();i++)
    {
        res=res*2+(s[i]-'0');
    }
    return res;

}
    int maxGoodNumber(vector<int>& nums) {
        string a=binary(nums[0]),b=binary(nums[1]),c=binary(nums[2]);
       return max({decimal(a+b+c),
       decimal(b+c+a),
       decimal(c+a+b),
       decimal(a+c+b),
       decimal(c+b+a),
       decimal(b+a+c)});

        
    }
};
//Tc=O(logn)+n
