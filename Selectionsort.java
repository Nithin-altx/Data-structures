class Solution {
    public int[] selectionSort(int[] nums) {
        int n=nums.length;
        for(int i=0;i<=n-2;i++)
        {
            int min=i;//Finding the minimum in the array
            for(int j=i;j<=n-1;j++)
            {
                if(nums[j]<nums[min])
                {
                    min=j;
                }
               
            }
            if(min!=i){//swaping the minimum with array[i]
             int temp=nums[i];
            nums[i]=nums[min];
            nums[min]=temp;
            }
            
        }

    return nums;

    }
}
