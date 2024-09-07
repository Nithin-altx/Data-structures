class Solution {
    public int[] insertionSort(int[] a) {
        int n=a.length;//Pick up an Element an place it the Correct Order Tc=O(N^2)
        for(int i=0;i<n;i++)
        {
            int j=i;
            while(j>0&&a[j-1]>a[j])
            {
                int temp=a[j];
                a[j]=a[j-1];
                a[j-1]=temp;
                j--;
            }
        }
        return a;

    }
}
