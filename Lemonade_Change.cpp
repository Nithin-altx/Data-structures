class Solution {
public:
    bool lemonadeChange(vector<int>& bills) {
        int f=0;
        int ten=0;
        bool b=false;
        for(int i=0;i<bills.size();i++)
        {
            if(bills[i]==5)
            f++;
            else if(bills[i]==10&&f>=1)
            {
                 ten++;
                   f--;
               
             
            }
            else if(bills[i]==20&&f>=1&&ten>=1)
            {
              
                   
                    ten--;
                    f--;
                   
               
            }
            else if(bills[i]==20&&f>=3&&ten==0)
            {
                f-=3;
            }
            else
            return false;
           
           
       }
       return true;
    }
  
};
