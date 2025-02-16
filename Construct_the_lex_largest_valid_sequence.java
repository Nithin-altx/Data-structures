class Solution {
    boolean solve(int i,int n,int result[],boolean used[])
    {
        if(i>=result.length)
        return true;

        if(result[i]!=-1)
        return solve(i+1,n,result,used);

        for(int num=n;num>=1;num--)
        {
            if(used[num])
            continue;

             used[num]=true;
            result[i]=num;
            

            if(num==1)
            {
                if(solve(i+1,n,result,used)==true)
                return true;
            }
            else{
                int j=result[i]+i;
                if(j<result.length&&result[j]==-1)
                {
                    result[j]=num;
                    if(solve(i+1,n,result,used)==true)
                    return true;

                    result[j]=-1;
                }

            }
            result[i]=-1;
            used[num]=false;
        }
        return false;
    }
    public int[] constructDistancedSequence(int n) {
        int result[]=new int[2*n-1];
        for(int i=0;i<2*n-1;i++)
        {
            result[i]=-1;
        }
        boolean used[]=new boolean[n+1];
        solve(0,n,result,used);
        return result;
        
    }
}
