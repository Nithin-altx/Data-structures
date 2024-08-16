class Solution {
public:
bool Allzeros(vector<int>&freq)
{
    //checking  all values in the freq  array is zero or not.
    for(int i=0;i<freq.size();i++)
    {
        if(freq[i]!=0)
        return false;
    }
    return true;
}
    vector<int> findAnagrams(string s, string p) {
        int n=s.length();
        int k=p.length();
        vector<int>freq(26,0);
        //finding the frequency of letter of string p
        for(int i=0;i<k;i++)
        {
             char c=p[i];
            freq[c-'a']++;
        }
        int i=0,j=0;
        vector<int>index;
        while(j<n)
        {
          
            freq[s[j]-'a']--;//making the freq to 0
        
            if(j-i+1==k)  
            {
                if(Allzeros(freq))
                {
                    index.push_back(i);
                }
                freq[s[i]-'a']++;//again making the freq to 1 if we found the anagram
                i++;
            }
            j++;

        }
        return index;
        
    }
};
