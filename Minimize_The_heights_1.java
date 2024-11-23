// User function Template for Java
class Solution {
    public int getMinDiff(int k, int[] arr) {
        // code here
        Arrays.sort(arr);
        int n=arr.length;
       int ans=arr[n-1]-arr[0];
        for(int i=1;i<n;i++)
        {
            int mini=Math.min(arr[0]+k,arr[i]-k);
            int max=Math.max(arr[i-1]+k,arr[n-1]-k);
            ans=Math.min(ans,max-mini);
        }
        return ans;
        
        
    }
}
