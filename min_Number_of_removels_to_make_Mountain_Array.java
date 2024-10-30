class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] lis = new int[n];
        int[] lds = new int[n];

        // Initialize LIS and LDS arrays to 1
        for (int i = 0; i < n; i++) {
            lis[i] = 1;
            lds[i] = 1;
        }

        // Calculate Longest Increasing Subsequence (LIS) for each index
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        // Calculate Longest Decreasing Subsequence (LDS) for each index
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > nums[j]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }

        int minRemovals = n;
        // Calculate minimum removals needed for a mountain array
        for (int i = 1; i < n - 1; i++) {
            if (lis[i] > 1 && lds[i] > 1) {
                minRemovals = Math.min(minRemovals, n - (lis[i] + lds[i] - 1));
            }
        }

        return minRemovals;
    }
}
