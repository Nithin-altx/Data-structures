class Solution {
    public int lengthOfLIS(int[] nums) {
    int n=nums.length;
      int[] lis = new int[n];
      for (int i = 0; i < n; i++) {
            lis[i] = 1;
        }
        int maxlen=lis[0];
         for (int i = 0; i < n; i++) {
            for (int j = i-1; j>=0; j--) {
                if (nums[i] > nums[j]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
            maxlen=Math.max(maxlen,lis[i]);
        }
        return maxlen;


    }
}
