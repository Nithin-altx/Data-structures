class Solution{
    static int maxLength(String s){
        Stack<Integer> st=new Stack<>();
        int n=s.length();
        st.push(-1);
        int max=0;
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)=='(')
            {
                st.push(i);
            }
            else
            {
             st.pop();
                if(st.isEmpty())
                {
                    st.push(i);
                }
                else{
                    max=Math.max(max,i-st.peek());
                }
            }
        }
        return max;
        
       
    }
}
