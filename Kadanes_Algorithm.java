class Solution {

    // arr: input array
    // Function to find the sum of contiguous subarray with maximum sum.
    int maxSubarraySum(int[] arr) {

        // Your code here
        int n=arr.length;
        int i=0,j=0;
        int sum1=arr[0];
        int sum2=0;
        while(j<n)
        {
            sum2+=arr[j];
            sum1=Math.max(sum1,sum2);
          if(sum2<0)
          {
              sum2=0;
          }
          j++;
            
        }
        return sum1;
    }
}
