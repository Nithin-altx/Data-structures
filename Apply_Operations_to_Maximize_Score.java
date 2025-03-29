class Solution {
    int Mod=(int) 1e9+7;
    private long findpower(long a, long b) {
        if (b == 0) return 1;
        long half = findpower(a, b / 2);
        long result = (half * half) % Mod;
        if (b % 2 == 1) {
            result = (result * a) % Mod;
        }
        return result;
    }
    public List<Integer> getprimes(int limit)
    {
        boolean isprime[]=new boolean[limit+1];
        List<Integer> primes=new ArrayList<>();
        Arrays.fill(isprime, true);
        isprime[0] = false;
        isprime[1] = false;
        for(int i=2;i*i<=limit;i++)
        {
            if(isprime[i])
            {
                for(int j=i*i;j<=limit;j+=i)
                {
                    isprime[j]=false;
                }
            }
        }
        for(int i=2;i<=limit;i++)
        {
            if(isprime[i])
            {
                primes.add(i);
            }
        }
        return primes;
    }
    public int[] findps(List<Integer> nums)
    {
        int n=nums.size();
        int ps[]=new int[n];
        int maxe=Collections.max(nums);
        List<Integer> primes=getprimes(maxe);
        for(int i=0;i<n;i++)
        {
            int num =nums.get(i);
            for(int prime:primes)
            {
                if(prime*prime>num)
                break;

                if(num%prime!=0)
                continue;

                ps[i]++;
                while(num%prime==0)
                {
                    num/=prime;
                }
            }
            if(num>1)
            {
                ps[i]++;
            }
        }
        return ps;

    }
    public int[] findng(int[]ps)
    {

        int n=ps.length;
        int ng[]=new int[n];
          Arrays.fill(ng, n);
          Deque<Integer> stack = new ArrayDeque<>();
        for(int i=n-1;i>=0;i--)
        {
            while(!stack.isEmpty()&&ps[stack.peek()]<=ps[i])
            {
                stack.pop();
            }
            ng[i]=stack.isEmpty()?n:stack.peek();
            stack.push(i);
        }
        return ng;
    }
    public int[] findpg(int ps[])
    {
        int n=ps.length;
        int pg[]=new int[n];
        Arrays.fill(pg, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i<n;i++)
        {
              while(!stack.isEmpty()&&ps[stack.peek()]<ps[i])
            {
                stack.pop();
            }
            pg[i]=stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        return pg;
    }
    public int maximumScore(List<Integer> nums, int k) {
        int n=nums.size();
        int []ps=findps(nums);
        int ng[]=findng(ps);
        int pg[]=findpg(ps);
        long subarrays[]=new long[n];
        for(int i=0;i<n;i++)
        {
            subarrays[i]=(long)(ng[i]-i)*(i-pg[i]);
        }
        List<int[]> sortednums=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            sortednums.add(new int[]{nums.get(i),i});
        }
        sortednums.sort((a,b)->b[0]-a[0]);
        long score=1;
        int idx=0;
        while(k>0)
        {
            int num=sortednums.get(idx)[0];
            int i=sortednums.get(idx)[1];
            long op=Math.min((long)k,subarrays[i]);
            score=(score*findpower(num,op))%Mod;
            k-=op;
            idx++;
        }
        return (int)score;
        
    }
}
