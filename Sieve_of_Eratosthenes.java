class Solution{
   static boolean isPrime(int x)
    {
        for(int i=2;i*i<=x;i++)
        {
            if(i%x==0)
            return false;
        }
        return true;
    }
    static ArrayList<Integer> sieveOfEratosthenes(int N){
        // code here
        boolean a[]=new boolean[N+1];
        for(int i=0;i<=N;i++)
        {
            a[i]=true;
        }
        a[0]=false;
        a[1]=false;
        for(int i=2;i*i<=N;i++)
        {
            if(isPrime(i))
            {
                for(int j=2;j*i<=N;j++)
                {
                    a[j*i]=false;
                }
            }
        }
        ArrayList<Integer> ls=new ArrayList<>();
        for(int i=0;i<=N;i++)
        {
            if(a[i]==true)
            {
                ls.add(i);
            }
        }
        return ls;
    }
}
