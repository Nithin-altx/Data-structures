class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> st=new HashSet<>();
        //Tc=O(N)
        //Sc=O(N)
        for(int x:banned)
        {
            st.add(x);
        }
        int temp[]=new int[n];
        for(int i=1;i<=n;i++)
        {
            temp[i-1]=i;
        }
        int count=0;
        int sum=0;
        for(int i=0;i<n;i++)
        {
            if(!st.contains(temp[i]))
            {
                sum+=temp[i];
                if(sum<=maxSum)
                {
                    count++;
                }
            }
        }
        return count;
    }
}
