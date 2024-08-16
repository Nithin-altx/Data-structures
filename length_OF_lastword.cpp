class Solution {
public:
    int lengthOfLastWord(string s) {
    int idx=s.find_last_not_of(' ')+1;
    s.erase(idx);
    int c=0;
  for(int i=s.length()-1;i>=0;i--)
  {
    if(s[i]==' ')
    break;
    else
    c++;
  }
  return c;
 
    }
};
