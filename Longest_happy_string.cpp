class Solution {
public:
//Tc=O(a+b+c)  ..log(3)
//sc=O(1)
typedef pair<int,char> P;
    string longestDiverseString(int a, int b, int c) {
       priority_queue<P,vector<P>> pq;
       if(a>0)
       {
        pq.push({a,'a'});
       }
       if(b>0)
       {
        pq.push({b,'b'});
       }
       if(c>0)
       {
        pq.push({c,'c'});
       }
       string res="";
       while(!pq.empty())
       {
        int count=pq.top().first;
        char ch=pq.top().second;
        pq.pop();
        if(res.length()>1&&res[res.length()-1]==ch&&res[res.length()-2]==ch)
        {
            if(pq.empty())
            {
                break;
            }
            int nextcount=pq.top().first;
            char nexc=pq.top().second;
           res+=nexc;
            nextcount--;
            pq.pop();
            if(nextcount>0)
            {
                pq.push({nextcount,nexc});
            }
        }
        else{
      res+=ch;
        count--;
        }
        if(count>0){
            pq.push({count,ch});
        }
       }
       return res;

     

        
    }
};
