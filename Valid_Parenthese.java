class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        int n=s.length();
        //Tc=O(N)
        //Sc=O(N);
        if(n%2!=0)
        return false;
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='[')
            {
                st.push(s.charAt(i));
            }
            else if(!st.isEmpty()&&(s.charAt(i)==')'&&st.peek()=='('
            ||s.charAt(i)=='}'&&st.peek()=='{'
            ||s.charAt(i)==']'&&st.peek()=='[')
            )
            {
                st.pop();
            }
            else
            return false;
        }
        return st.isEmpty();
    }
}
