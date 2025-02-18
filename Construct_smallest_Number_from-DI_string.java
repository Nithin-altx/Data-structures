//Using string as Stack
class Solution {
    public String smallestNumber(String pat) {
        //Sc=O(N+1)
        //Tc=O(N)
       StringBuilder st=new StringBuilder();
        int n=pat.length();
        int count=1;
        StringBuilder res=new StringBuilder();
        for(int i=0;i<=n;i++)
        {
            st.append(count);
            count++;
            if(i==n||pat.charAt(i)=='I')
            {
                while(st.length()>0){
                res.append(st.charAt(st.length()-1));
                st.deleteCharAt(st.length()-1);
                }
            }
        }
         return res.toString();
}

}
//Using stack
class Solution {
    public String smallestNumber(String pat) {
        //Sc=O(N+1)
        //Tc=O(N)
        Stack<Integer> st=new Stack<>();
        int n=pat.length();
        int count=1;
        StringBuilder res=new StringBuilder();
        for(int i=0;i<=n;i++)
        {
            st.push(count);
            count++;
            if(i==n||pat.charAt(i)=='I')
            {
                while(!st.isEmpty()){
                int ele=st.peek();
                res.append(ele);
                st.pop();
                }
            }
        }
         return res.toString();
}

}
