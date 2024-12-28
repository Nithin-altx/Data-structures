class Solution {
    int t[][];
    //Sc=O(n*m)
    //Tc=O(N)
    int helper(int count,int i,int k, List<Integer> subarray)
    {
        if(count==0)
        return 0;
        if(i>=subarray.size())
        {
            return Integer.MIN_VALUE;
        }
        if(t[i][count]!=-1)
        {
            return t[i][count];
        }
        int take=subarray.get(i)+helper(count-1,i+k,k,subarray);
        int nottake=helper(count,i+1,k,subarray);
        return t[i][count]=Math.max(take,nottake);
    }
    void solve(int count,int i,int k, List<Integer> subarray,List<Integer> res)
    {
        if(count==0)
        return;
        if(i>=subarray.size())
        return;
        int take_i=subarray.get(i)+helper(count-1,i+k,k,subarray);
        int nottake=helper(count,i+1,k,subarray);
        if(take_i>=nottake)
        {
            res.add(i);
            solve(count-1,i+k,k,subarray,res);
        }
        else{
            solve(count,i+1,k,subarray,res);
        }
    }
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        List<Integer> subarray=new ArrayList<>();
       List<Integer> res=new ArrayList<>();
        int n=nums.length;
        int i=0,j=0,windowsum=0;
        while(j<n)
        {
            windowsum+=nums[j];
            if(j-i+1==k)
            {
                subarray.add(windowsum);
                windowsum-=nums[i];
                i++;
            }
            j++;
        }
        t=new int[20001][4];
        for(int s=0;s<20001;s++)
        {
            Arrays.fill(t[s],-1);
        }
        solve(3,0,k,subarray,res);
        int []res1=new int[3];
        for(int l=0;l<res.size();l++)
        {
            res1[l]=res.get(l);
        }
        return res1;
        
    }
}
