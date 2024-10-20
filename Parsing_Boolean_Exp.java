class Solution {
    char solve(List<Character> ls,int op)
    {
        if(op=='!')
        return (ls.get(0)=='t')?'f':'t';
        if(op=='&')
        {
            for(int i=0;i<ls.size();i++)
            {
                if(ls.get(i)=='f')
                return 'f';
            }
            return 't';
        }
        if(op=='|')
        {
             for(int i=0;i<ls.size();i++)
            {
                if(ls.get(i)=='t')
                return 't';
            }
            return 'f';

        }
        return 't';
    }
    public boolean parseBoolExpr(String s) {
        Stack<Character> st=new Stack<>();
       for(int i=0;i<s.length();i++)
       {
        if(s.charAt(i)==',')
        continue;
        if(s.charAt(i)==')')
        {
            List<Character> ls=new ArrayList<>();
            while(!st.isEmpty()&&st.peek()!='(')
            {
                ls.add(st.peek());
                st.pop();
            }
            st.pop();
            char operator=st.peek();
            st.push(solve(ls,operator));

        }
        else{
            st.push(s.charAt(i));
        }

       }
       return st.peek()=='t'?true:false;
        
    }
}
