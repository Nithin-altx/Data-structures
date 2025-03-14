//Brute Force
class Solution {
    public int maximumCandies(int[] candies, long k) {
        int maxC=0;
        int total=0;
        for(int x:candies)
        {
            maxC=Math.max(maxC,x);
            total+=x;
        }
        if(total<k)
        return 0;
        for(int c=maxC;c>=1;c--)
        {
            long count=0;
            for(int i=0;i<candies.length;i++)
            {
                count+=candies[i]/c;
            }
            if(count>=k)
            return c;
        }
        return 0;
       
        
    }
}
//Optimal Tc=O(n*logn)
//sc=O(1)
class Solution {
    public int maximumCandies(int[] candies, long k) {
        int maxC=0;
        long total=0;
        for(int x:candies)
        {
            maxC=Math.max(maxC,x);
            total+=x;
        }
        if(total<k)
        return 0;
        int l=1,r=maxC;
        int res=0;
        while(l<=r){
            long count=0;
            int mid=l+(r-l)/2;
            for(int i=0;i<candies.length;i++)
            {
                count+=candies[i]/mid;
            }
            if(count>=k)
            {
                res=mid;
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return res;
       
        
    }
}
