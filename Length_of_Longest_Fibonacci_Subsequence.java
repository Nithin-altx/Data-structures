//Recursion
class Solution {
    Map<Integer,Integer> mp=new HashMap<>();
    int solve(int j,int k,int[]arr)
    {
        int target=arr[k]-arr[j];
        if(mp.containsKey(target)&&mp.get(target)<j)
        {
            return 1+solve(mp.get(target),j,arr);
        }
        return 2;
    }
    public int lenLongestFibSubseq(int[] arr) {
        int n=arr.length;
        //Tc=O(N^3)
        //SC=O(N)
        for(int i=0;i<n;i++)
        {
            mp.put(arr[i],i);
        }
        int result=Integer.MIN_VALUE;
        for(int j=1;j<n;j++)
        {
            for(int k=j+1;k<n;k++)
            {
                int len=solve(j,k,arr);
                result=Math.max(len,result);
            }
        }
        return result<3?0:result;
        
    }
}
//Memo
class Solution {
    Map<Integer,Integer> mp=new HashMap<>();
    int t[][];
    int solve(int j,int k,int[]arr)
    {
        if(t[j][k]!=-1)
        return t[j][k];
        int target=arr[k]-arr[j];
        if(mp.containsKey(target)&&mp.get(target)<j)
        {
            return t[j][k]=1+solve(mp.get(target),j,arr);
        }
        return t[j][k]=2;
    }
    public int lenLongestFibSubseq(int[] arr) {
        int n=arr.length;
        //Tc=O(N^3)
        //SC=O(N)
        t=new int[n+1][n+1];
        for(int i=0;i<n+1;i++)
        {
            Arrays.fill(t[i],-1);
        }
        for(int i=0;i<n;i++)
        {
            mp.put(arr[i],i);
        }
        int result=Integer.MIN_VALUE;
        for(int j=1;j<n;j++)
        {
            for(int k=j+1;k<n;k++)
            {
                int len=solve(j,k,arr);
                result=Math.max(len,result);
            }
        }
        return result<3?0:result;
        
    }
}
