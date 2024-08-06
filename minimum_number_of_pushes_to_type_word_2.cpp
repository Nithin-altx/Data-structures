class Solution {
public:
    int minimumPushes(string word) {
        vector<int>hash(26,0);
        for(int i=0;i<word.length();i++)
        {
            hash[word[i]-'a']++;//finding the frquency of the character
        }
        sort(hash.begin(),hash.end(),greater<int>());//sorting tha hash array in descending order
        int result=0;
        for(int i=0;i<26;i++)
        {
            int frq=hash[i];//storing the frequency
            int presses=(i/8+1);//finding the number of pushes to type a charcter
            result+=frq*presses;//storing  frqequency*number of pushes in result

        }
        return result;

        

    }
};
