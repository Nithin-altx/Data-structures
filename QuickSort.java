class Solution {
    //Pick a Pivot element
    //Place the Pivot in Correct Position
    //smaller values on the left of Pivot
    //Larger values on the right side of pivot
    //TC=O(NlogN)
    //Sc=O(1)
    int partition(int nums[],int l,int h)
    {
        int i=l,j=h;
        int pivot=nums[l];
        while(i<j)
        {
            while(nums[i]<=pivot&&i<h)
            {
                i++;
            }
            while(nums[j]>pivot&&j>l)
            {
                j--;
            }
            if(i<j)
            {
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
            }
        }
        int temp=nums[l];
        nums[l]=nums[j];
        nums[j]=temp;
        return j;
    }
    public void Sort(int []nums,int l,int h)
    {
        if(l<h)
        {
            int p=partition(nums,l,h);
            Sort(nums,l,p-1);
            Sort(nums,p+1,h);
        }
    }
    public int[] quickSort(int[] nums) {
        int n=nums.length;
        Sort(nums,0,n-1);
        return nums;

    }
}
