class Solution {
   public void merge(int []nums,int l,int mid,int h)
    {
        int i=l,j=mid+1;
        List<Integer> list=new ArrayList<>();
        while(i<=mid&&j<=h)
        {
            if(nums[i]<=nums[j])
            {
                list.add(nums[i]);
                i++;
            }
            else{
                list.add(nums[j]);
                j++;
            }
        }
            while(i<=mid)
            {
                list.add(nums[i]);
                i++;
            }
            while(j<=h)
            {
                list.add(nums[j]);
                j++;
            }
        for(int k=l;k<=h;k++)
        {
            nums[k]=list.get(k-l);
        }
    }
    public void Sort(int []nums,int l,int h)
    {
        if(l>=h)
        return;
        int mid=(l+h)/2;
        Sort(nums,l,mid);
        Sort(nums,mid+1,h);
        merge(nums,l,mid,h);

    }
    public int[] mergeSort(int[] nums) {
        int n=nums.length;
        Sort(nums,0,n-1);
        return nums;

    }
}
