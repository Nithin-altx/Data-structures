//Recursion Brute Force TLE
class Solution {
    int result=Integer.MAX_VALUE;
    void solve(String s,int k,int []count,int i,int j,int minutes)
    {
        if(count[0]>=k&&count[1]>=k&&count[2]>=k)
        {
            result=Math.min(result,minutes);
            return;
        }
        if(i>j)
        return;
        int left[]=count.clone();
        left[s.charAt(i)-'a']++;
        solve(s,k,left,i+1,j,minutes+1);
         int right[]=count.clone();
        right[s.charAt(j)-'a']++;
        solve(s,k,right,i,j-1,minutes+1);  

    }
    public int takeCharacters(String s, int k) {
        int count[]=new int[3];
        int i=0,j=s.length()-1;
        int minutes=0;
         solve(s,k,count,i,j,minutes);
         return result==Integer.MAX_VALUE?-1:result;
    }
}
//Sliding window Tc=O(N)
class Solution {
    public int takeCharacters(String s, int k) {
        int n=s.length();
        int count_a=0;
        int count_b=0;
        int count_c=0;
        int notdeletedwindowsize=0;
        for(int i=0;i<n;i++)
        {
            char x=s.charAt(i);
            if(x=='a')
            {
                count_a++;
            }
            else if(x=='b')
            {
                count_b++;
            }
            else{
                count_c++;
            }
        }
        if(count_a<k||count_b<k||count_c<k)
        {
            return -1;
        }
        int i=0,j=0;
        while(j<n)
        {
            if(s.charAt(j)=='a')
            {
                count_a--;
            }
             else if(s.charAt(j)=='b')
            {
                count_b--;
            }
             else if(s.charAt(j)=='c')
            {
                count_c--;
            }
            while(i<=j&&count_a<k||count_b<k||count_c<k)
            {
                if(s.charAt(i)=='a')
                {
                    count_a++;
                }
                else if(s.charAt(i)=='b')
                {
                    count_b++;
                }
                else{
                    count_c++;
                }
                i++;
            }
            notdeletedwindowsize=Math.max(notdeletedwindowsize,j-i+1);
            j++;
        }
        return n-notdeletedwindowsize;
    }
}
