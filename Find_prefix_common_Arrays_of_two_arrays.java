//Brute Force
class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n=A.length;
        int res[]=new int[n];
        for(int i=0;i<n;i++)
        {
            int count=0;
            for(int j=0;j<=i;j++)
            {
                for(int k=0;k<=i;k++)
                {
                    if(A[j]==B[k])
                    {
                        count++;
                        break;
                    }
                }
            }
            res[i]=count;
        }
        return res;
    }
}
//Better
class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n=A.length;
        boolean a[]=new boolean[n+1];
        boolean b[]=new boolean[n+1];
        int res[]=new int[n];
        for(int j=0;j<n;j++)
        {
            a[A[j]]=true;
            b[B[j]]=true;
            int count=0;
            for(int i=1;i<=n;i++)
            {
                if(a[i]==true&&b[i]==true)
                {
                    count++;
                }
            }
            res[j]=count;
        }
        return res;
    }
}
//Optimal
class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int freq[]=new int[B.length+1];
        int n=B.length;
        int count=0;
        int res[]=new int[n];
        for(int i=0;i<n;i++)
        {
            freq[A[i]]++;
            if(freq[A[i]]==2)
            {
                count++;
            }
            freq[B[i]]++;
            if(freq[B[i]]==2)
            {
                count++;
            }
            res[i]=count;

        }
        return res;
        
    }
}

