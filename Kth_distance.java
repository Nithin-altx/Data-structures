class Solution {
    public boolean checkDuplicatesWithinK(int[] arr, int k) {
        // your code
        HashSet<Integer> st=new HashSet<>();
        for(int i=0;i<arr.length;i++)
        {
            if(st.contains(arr[i]))
            return true;
            
            st.add(arr[i]);
            if(i>=k)
            {
                st.remove(arr[i-k]);
            }
        }
        return false;
    }
}
