class Solution {
    //Tc=O(N)
    //SC=o(Number of digits(logn)) stack space
    void solve(int start,int limit,  List<Integer> result)
    {
        if(start>limit)
        return;
        result.add(start);
        for(int append=0;append<=9;append++)
        {
            int newnum=(start*10)+append;
            if(newnum>limit)
            return;
            solve(newnum,limit,result);
        }
    }
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result=new ArrayList<>();
        for(int i=1;i<=9;i++)
        {
            solve(i,n,result);
        }
        return result;
    }
}
