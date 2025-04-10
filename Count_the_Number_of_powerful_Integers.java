class Solution {
    long solve(String s,int limit,String ip)
    {
        if(s.length()<ip.length())
        return 0;

        long count=0;


        String trail=s.substring(s.length()-ip.length());
        int remainl=s.length()-ip.length();
        for(int i=0;i<remainl;i++)
        {
            int digit=s.charAt(i)-'0';
            if(digit<=limit)
            {
                count+=digit*Math.pow(limit+1,remainl-i-1);
            }
            else{
                count+=Math.pow(limit+1,remainl-i);
                return count;
            }
        }
        if(trail.compareTo(ip)>=0)
        count+=1;

        return count;

    }
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        String startt=String.valueOf(start-1);
        String fin=String.valueOf(finish);
        return solve(fin,limit,s)-solve(startt,limit,s);
}
}
