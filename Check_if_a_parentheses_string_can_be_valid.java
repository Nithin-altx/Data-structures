class Solution {
    public boolean canBeValid(String s, String locked) {
        int n=s.length();
        if(n%2!=0)
        return false;
        Stack<Integer> open=new Stack<>();
        Stack<Integer> openClose=new Stack<>();
        for(int i=0;i<n;i++)
        {
            if(locked.charAt(i)=='0')
            {
                openClose.push(i);
            }
            else if(s.charAt(i)=='(')
            {
                open.push(i);
            }
            else if(s.charAt(i)==')')
            {
                if(!open.isEmpty())
                {
                    open.pop();
                }
                else if(!openClose.isEmpty())
                {
                    openClose.pop();
                }
                else
                return false;
            }
        }
        while(!open.isEmpty()&&!openClose.isEmpty()&&open.peek()<openClose.peek())
        {
            open.pop();
            openClose.pop();
        }
        return open.isEmpty();
    }
}
//Approach two 
class Solution {
    public boolean canBeValid(String s, String locked) {
        int n=s.length();
        if(n%2!=0)
        return false;
       int open=0;
       for(int i=0;i<n;i++)
       {
        if(s.charAt(i)=='('||locked.charAt(i)=='0')
        {
            open++;
        }
        else{
            open--;
        }
        if(open<0)
        return false;
       }
       int close=0;
       for(int i=n-1;i>=0;i--)
       {
        if(s.charAt(i)==')'||locked.charAt(i)=='0')
        {
            close++;
        }
        else{
            close--;
        }
        if(close<0)
        return false;
       }
       return true;
    }
}
