
// class Solution {
// public:
//     int maximumSwap(int num) {
//         string temp=to_string(num);
//         int n=temp.size();
//      vector<int>maxrightidx(n);
//      maxrightidx[n-1]=n-1;
//      for(int i=n-2;i>=0;i--)
//      {
//         int rightidx=maxrightidx[i+1];
//         int maxele=temp[rightidx];
//         maxrightidx[i]=(temp[i]>maxele)?i:rightidx;
//      }
//      for(int i=0;i<n;i++)
//      {
//         int idx=maxrightidx[i];
//         int maxele=temp[idx];
//         if(temp[i]<maxele)
//         {
//             swap(temp[i],temp[idx]);
//             return stoi(temp);
//         }

//      }
//      return num;
     
//     }
// };
class Solution {
public:
//Tc=O(n)
//SC=O(1)
    int maximumSwap(int num) {
        string temp=to_string(num);
        int n=temp.size();
     vector<int>maxrightidx(10,-1);
     for(int i=0;i<n;i++)
     {
        maxrightidx[temp[i]-'0']=i;
     }
     for(int i=0;i<n;i++)
     {
        for(int j=9;j>temp[i]-'0';j--)
        {
            if(maxrightidx[j]>i)
            {
                swap(temp[i],temp[maxrightidx[j]]);
                return stoi(temp);
            }

        }

     }
     return num;
  
     
    }
};
