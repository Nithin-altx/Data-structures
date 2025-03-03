//Approach 1
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n=nums.length;
        int res[]=new int[n];
      int i=0,j=n-1;
      int i_=0,j_=n-1;
    while(i<n&&j>=0)
    {
        if(nums[i]<pivot)
        {
            res[i_]=nums[i];
            i_++;
        }
     if(nums[j]>pivot)
        {
            res[j_]=nums[j];
            j_--;
        }
        i++;
        j--;
    }
    while(i_<=j_)
    {
        res[i_]=pivot;
        i_++;
    }
    return res;
        
    }
}
//Approach 2
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n=nums.length;
        int res[]=new int[n];
        int lessp=0;
        int equalp=0;
        for(int x:nums)
        {
            if(x<pivot)
            {
                lessp++;
            }
            else if(x==pivot)
            {
                equalp++;
            }
        }
        int i=0;
        int j=lessp;
        int k=lessp+equalp;
        for(int x:nums)
        {
            if(x<pivot)
            {
                res[i]=x;
                i++;
            }
            else if(x==pivot)
            {
                res[j]=x;
                j++;
            }
            else{
                res[k]=x;
                k++;
            }
        }
        return res;
        
    }
}
