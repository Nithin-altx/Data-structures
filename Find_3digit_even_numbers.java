class Solution {
   
    void solve(int n,int[] digits,Set<String> ls,StringBuilder s,boolean u[])
    {
        if(s.length()==n)
        {
            ls.add(s.toString());
            return;
        }
        for(int  i=0;i<digits.length;i++)
        {
            if(u[i])
            continue;

            if(s.length()==0&&digits[i]==0)
            continue;

            u[i]=true;
            s.append(String.valueOf(digits[i]));
            solve(n,digits,ls,s,u);
            s.deleteCharAt(s.length() - 1);
            u[i]=false;
        }
    }
    public int[] findEvenNumbers(int[] digits) {
        Set<String> ls=new HashSet<>();
        int n=digits.length;
        StringBuilder s=new StringBuilder();
        boolean u[]=new boolean[n];
        solve(3,digits,ls,s,u);
        List<Integer> res=new ArrayList<>();
        for(String x:ls)
        {
            if(x.charAt(0)=='0'||(Integer.parseInt(x)%2!=0))
            {
                continue;
            }
            else{
                int num=Integer.parseInt(x);
                res.add(num);

            }
        }
        int r[]=new int[res.size()];
        for(int i=0;i<res.size();i++)
        {
            r[i]=res.get(i);
        }
        Arrays.sort(r);
        return r;
    }
}
