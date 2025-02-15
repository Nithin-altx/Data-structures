//Approach 1
class Solution {
    
    boolean check(int sq,int num,int currsum)
    {
        if(sq==0)
        return currsum==num;
        if(currsum>num)
        return false;
        return check(sq/10,num,currsum+sq%10)||
               check(sq/100,num,currsum+sq%100)||
               check(sq/1000,num,currsum+sq%1000)||
               check(sq/10000,num,currsum+sq%10000);
    }
    public int punishmentNumber(int n) {
        int result=0;
     
        for(int num=1;num<=n;num++)
        {
            int sq=num*num;
            if(check(sq,num,0))
            {
                result+=sq;
            }
        }
        return result;
        
    }
}
//Approach 2
class Solution {
    
    boolean check(String sq,int num,int i,int currsum)
    {
        if(i==sq.length())
        return currsum==num;
        if(currsum>num)
        return false;
        for(int j=i;j<sq.length();j++)
        {
            String s=sq.substring(i,j+1);
            int sum=Integer.parseInt(s);
            if(check(sq,num,j+1,sum+currsum))
            {
                return true;
            }
        }
        return false;
    }
    public int punishmentNumber(int n) {
        int result=0;
     
        for(int num=1;num<=n;num++)
        {
            int sq=num*num;
            String sq2=String.valueOf(sq);
            if(check(sq2,num,0,0))
            {
                result+=sq;
            }
        }
        return result;
        
    }
}
