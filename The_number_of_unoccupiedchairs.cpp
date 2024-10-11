class Solution {
public:
typedef pair<int,int>P;
    int smallestChair(vector<vector<int>>& times, int targetFriend) {
        int n=times.size();
        priority_queue<P,vector<P>,greater<P>>occupied;//{departTime, chairNo}
        priority_queue<int ,vector<int>,greater<int>>free;//min heap of unoccupied chairs
        int tgfrndavt=times[targetFriend][0];
        sort(times.begin(),times.end());
        int chairno=0;
        for(int i=0;i<n;i++)
        {
            int a=times[i][0];
            int d=times[i][1];
            while(!occupied.empty()&&occupied.top().first<=a)
            {
                free.push(occupied.top().second);
                occupied.pop();

            }
            if(free.empty())
            {
                occupied.push({d,chairno});
                if(a==tgfrndavt)
                return chairno;

                chairno++;
            }
            else
            {
                int leastnochiar=free.top();
                free.pop();
                if(a==tgfrndavt)
                {
                    return leastnochiar;
                }
                occupied.push({d,leastnochiar});

            }

        }
        return -1;
        
    }
};
