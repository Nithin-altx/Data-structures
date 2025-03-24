//Brute Force
class Solution {
    public int countDays(int days, int[][] meetings) {
        int res[]=new int[days+1];
        for(int m[]:meetings)
        {
            int a=m[0];
            int b=m[1];
            for(int i=a;i<=b;i++)
            {
                res[i]=1;
            }
        }
        int count=0;
        for(int i=0;i<res.length;i++)
        {
            if(res[i]==0)
            {
                count++;
            }
        }
        return count-1;
        
    }
}
//Optimal
class Solution {
    public int countDays(int days, int[][] meetings) {
        int res=0;
        int start=0;
        int end=0;
        Arrays.sort(meetings,(a, b) -> Integer.compare(a[0], b[0]));
        for(int m[]:meetings)
        {
            if(m[0]>end)
            {
                res+=m[0]-end-1;
            }
            end=Math.max(end,m[1]);
        }
        if(end<days)
        {
            res+=days-end;
        }
        return res;
        
    }
}

