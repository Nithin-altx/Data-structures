class Solution {
    //Tc=((N+M)logM)
    int bsearch(int[][] items,int q)
    {
        int l=0,r=items.length-1;
        int mid;
        int maxvalue=0;
        while(l<=r)
        {
             mid=(l+r)/2;
            if(items[mid][0]>q)
            {
                r=mid-1;
            }
            else{
                maxvalue=Math.max(maxvalue,items[mid][1]);
                l=mid+1;
            }
        }
        return maxvalue;
    }
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int n=queries.length;
        int m=items.length;
        int result[]=new int[n];
         Arrays.sort(items, (a, b) -> Integer.compare(a[0], b[0]));
         int maxbeauty=items[0][1];
         for(int i=1;i<m;i++)
         {
            maxbeauty=Math.max(maxbeauty,items[i][1]);
            items[i][1]=maxbeauty;
         }
         for(int i=0;i<n;i++)
         {
            int q=queries[i];
            result[i]=bsearch(items,q);
         }
         return result;
        
    }
}
