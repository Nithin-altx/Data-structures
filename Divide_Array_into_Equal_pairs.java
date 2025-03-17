class Solution {
    public boolean divideArray(int[] nums) {
        int n=nums.length;
        int arr[]=new int[5001];
        for(int i=0;i<n;i++)
        {
            arr[nums[i]]++;
        }
        for(int i=0;i<5001;i++)
        {
            if(arr[i]%2!=0)
            return false;
        }
        return true;

        
    }
}
