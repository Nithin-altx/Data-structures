class Solution {
    public boolean solve(String start, String target,int n,Map<String,Boolean> memo)
    {
        if(start.equals(target))
        return true;
        if(memo.containsKey(start))
        {
            return memo.get(start);
        }
        for(int i=0;i<n;i++)
        {
            if(i>0&&start.charAt(i)=='L'&&start.charAt(i-1)=='_')
            {
                String swaped=swap(start,i,i-1);
                if(solve(swaped,target,n,memo))
                {
                    return true;
                }

            }
            else if(i<n-1&&start.charAt(i)=='R'&&start.charAt(i+1)=='_')
            {
                String swaped=swap(start,i,i+1);
                 if(solve(swaped,target,n,memo))
                {
                    return true;
                }
            }
           
        }
         memo.put(start,false);
            return false;
    }
    String swap(String start,int i,int j)
    {
        char chars[]=start.toCharArray();
        char temp=chars[i];
        chars[i]=chars[j];
        chars[j]=temp;
        return new String(chars);

    }

    public boolean canChange(String start, String target) {
        int n=start.length();
        Map<String,Boolean> memo=new HashMap<>();
        return solve(start,target,n,memo);
    }
}
//Two Pointer
class Solution {
    public boolean canChange(String start, String target) {
        int n=start.length();
        int i=0,j=0;
        //Tc=O(N)
        //Sc=O(1)
        while(i<n||j<n)
        {
            while(i<n&&start.charAt(i)=='_')
            {
                i++;
            }
            while(j<n&&target.charAt(j)=='_')
            {
                j++;
            }
            if(i==n||j==n)
            {
                return i==n&&j==n;
            }
             if(start.charAt(i)!=target.charAt(j))
            return false;
            if(start.charAt(i)=='R'&&i>j)
            return false;
            if(start.charAt(i)=='L'&&i<j)
            {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
}
