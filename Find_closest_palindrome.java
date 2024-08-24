class Solution {
    public long copyhalf(long firsthalf,boolean isodd)
    {
        long res=firsthalf;
        if(isodd)
        {
            firsthalf/=10;
        }
        while(firsthalf>0)
        {
            res=(res*10)+(firsthalf%10);
            firsthalf/=10;
        }
        return res;
    }
    public String nearestPalindromic(String n) {
        int len=n.length();
        ArrayList<Long> list=new ArrayList<Long>();
        boolean isodd=(len%2!=0);
        int mid=(len%2==0)?(len/2):(len/2+1);
        long firsthalf=Long.parseLong(n.substring(0,mid));
        list.add(copyhalf(firsthalf,isodd));
        list.add(copyhalf(firsthalf+1,isodd));
        list.add(copyhalf(firsthalf-1,isodd));
        list.add((long)(Math.pow(10,len-1)-1));
        list.add((long)(Math.pow(10,len)+1));
        long num=Long.parseLong(n);
        long mindiff=Long.MAX_VALUE;
        long res=Long.MAX_VALUE;
       
        for(Long element:list)
        {
            if(element==num) continue;
            long currdiff=Math.abs(element-num);
            if(currdiff<mindiff)
            {
                res=element;
                  mindiff=currdiff;
            }
            else if(currdiff==mindiff)
            {
                res=Math.min(element,res);
            }
        }
        return String.valueOf(res);

        
    }
}
