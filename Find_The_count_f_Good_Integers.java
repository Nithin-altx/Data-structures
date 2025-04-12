class Solution {
    public long countGoodIntegers(int n, int k) {
        Set<String> st=new HashSet<>();
        int d=(n+1)/2;
        int start=(int)Math.pow(10,d-1);
        int end=(int)Math.pow(10,d)-1;
        for(int i=start;i<=end;i++)
        {
            String LH=String.valueOf(i);
            String full;
            if(n%2==0)
            {
            StringBuilder RH=new StringBuilder(LH).reverse();
            full=LH+RH.toString();
            }else{
                String RH=LH.substring(0,d-1);
                StringBuilder rev=new StringBuilder(RH).reverse();
                full=LH+rev.toString();
            }
            long num=Long.parseLong(full);
            if(num%k!=0)
            continue;

            char[] ch= full.toCharArray();
            Arrays.sort(ch);
            st.add( new String(ch));
        }
        long fact[]=new long[11];
        fact[0]=1;
        for(int i=1;i<11;i++)
        {
            fact[i]=i*fact[i-1];
        }
        long res=0;
        for(String s:st)
        {
             int len=s.length();
            int count[]=new int[10];
            for(int i=0;i<len;i++)
            {
                count[s.charAt(i)-'0']++;
            }
            int  Zero=count[0];
            int nonZero=len-Zero;
            long prem=nonZero*fact[len-1];
            for(int i=0;i<10;i++)
            {
                prem/=fact[count[i]];
            }
            res+=prem;
        }
        return res;
        
    }
}
