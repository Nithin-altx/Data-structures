class Solution {
    public List<List<Integer>> findTriplets(int[] arr) {
        // Your code here
        List<List<Integer>> res = new ArrayList<>();

        // Loop through each triplet combination of indices
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    int sum = arr[i] + arr[j] + arr[k];
                    
                    if (sum == 0) {
                        // Add the indices (not values) to the result list
                        List<Integer> triplet = Arrays.asList(i, j, k);
                        res.add(triplet);
                    }
                }
            }
        }

        return res;

    }
}
