class Solution {
    public boolean checkIfExist(int[] arr) {
        int n=arr.length;
        //Tc=O(N)
        //Sc=O(N)
        Map<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            mp.put(arr[i],i);
        }
        for(int i=0;i<n;i++)
        {
            if(mp.containsKey(2*arr[i])&&mp.get(2*arr[i])!=i)
            {
                return true;
            }
        }
        return false;
    }
}
