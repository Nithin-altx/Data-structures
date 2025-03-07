//Approach 1
class Solution {
     boolean isPrime(int x)
    {
        for(int i=2;i*i<=x;i++)
        {
            if(i%x==0)
            return false;
        }
        return true;
    }
    public int[] closestPrimes(int left, int right) {
        boolean b[]=new boolean[right+1];
        b[0]=false;
        b[1]=false;
        for(int i=2;i<=right;i++)
        {
            b[i]=true;
        }
        for(int i=2;i*i<=right;i++)
        {
            if(isPrime(i)==true)
            {
                for(int j=2;j*i<=right;j++)
                {
                    b[j*i]=false;
                }
            }
        }
        List<Integer> ls=new ArrayList<>();
        for(int i=left;i<=right;i++)
        {
            if(b[i]==true)
            {
                ls.add(i);
            }
        }
        int res[]=new int[2];
        for(int i=0;i<2;i++)
        {
            res[i]=-1;
        }
        int min=Integer.MAX_VALUE;
        for(int i=1;i<ls.size();i++)
        {
            int diff=ls.get(i)-ls.get(i-1);
            if(diff<=2)
            return new int[]{ls.get(i-1),ls.get(i)};
            if(diff<min)
            {
                min=Math.min(min,diff);
                res[0]=ls.get(i-1);
                res[1]=ls.get(i);
            }

        }
        return res;

        
        
    }
}
//Approach 2
class Solution {
     boolean isPrime(int x)
    {
        if(x==1)
        return false;
        for(int i=2;i*i<=x;i++)
        {
            if(x%i==0)
            return false;
        }
        return true;
    }
    public int[] closestPrimes(int left, int right) {
       List<Integer> prime=new ArrayList<>();
        for(int i=left;i<=right;i++)
        {
            if(isPrime(i)==true)
            {
                if(prime.size()!=0&&(i-prime.get(prime.size()-1))<=2)
                {
                    return new int[]{prime.get(prime.size()-1),i};

                }
                prime.add(i);
            }
            
        }
       
        int res[]=new int[2];
        for(int i=0;i<2;i++)
        {
            res[i]=-1;
        }
        int min=Integer.MAX_VALUE;
        for(int i=1;i<prime.size();i++)
        {
            int diff=prime.get(i)-prime.get(i-1);
            if(diff<min)
            {
                min=Math.min(min,diff);
                res[0]=prime.get(i-1);
                res[1]=prime.get(i);
            }

        }
        return res;

        
        
    }
}
