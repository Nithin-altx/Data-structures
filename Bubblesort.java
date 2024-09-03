class Solution {
    public int[] bubbleSort(int[] nums) {
        int n=nums.length;
        for(int i=n-1;i>=1;i--)
        {
            int ds=0;
            for(int j=0;j<=i-1;j++)//Pushing the max to the last by adjacent swaps
            {
                if(nums[j]>nums[j+1])
                {
                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                    ds=1;
                }
            }
            if(ds==0)
            break;//Break the loop if there is no swaping in first iteration ,means the array is in ascending order
        }
        return nums;

    }
}
