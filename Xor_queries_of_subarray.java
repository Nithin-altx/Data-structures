class Solution {
//Tc=O(N*q)
//Sc=O(1)
    public int[] xorQueries(int[] arr, int[][] queries) {
        int xor[]=new int[arr.length];
        xor[0]=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            xor[i]=xor[i-1]^arr[i];
        }
        int res[]=new int [queries.length];
        for(int i=0;i<queries.length;i++)
        {
            int a[]=queries[i];
            int l=a[0];
            int r=a[1];
            res[i]=xor[r]^((l==0)?0:xor[l-1]);
        }
        return res;
        
    }
}
